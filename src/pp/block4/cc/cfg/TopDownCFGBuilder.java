package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.AssignStatContext;
import pp.block4.cc.cfg.FragmentParser.BlockStatContext;
import pp.block4.cc.cfg.FragmentParser.DeclContext;
import pp.block4.cc.cfg.FragmentParser.IfStatContext;
import pp.block4.cc.cfg.FragmentParser.PrintStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;
import pp.block4.cc.cfg.FragmentParser.StatContext;
import pp.block4.cc.cfg.FragmentParser.WhileStatContext;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;
	
    private ParseTreeProperty<Node> entry;
    private ParseTreeProperty<Node> exit;

	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
        Graph result = null;
        ErrorListener listener = new ErrorListener();
        entry = new ParseTreeProperty<>();
        exit = new ParseTreeProperty<>();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ProgramContext tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ProgramContext tree) {
        this.graph = new Graph();
        new ParseTreeWalker().walk(this, tree);
        return graph;
	}

	@Override
    public void enterBlockStat(BlockStatContext ctx) {
        Node ourEntry = entry.get(ctx);
        Node ourExit = exit.get(ctx);
        
        for (int i = 0; i < ctx.stat().size(); i++) {
            Node statEntry = addNode(ctx.stat(i), "");
            Node statExit = addNode(ctx.stat(i), "");
            
            entry.put(ctx.stat(i), statEntry);
            exit.put(ctx.stat(i), statExit);
            
            if (i > 0) {
                exit.get(ctx.stat(i-1)).addEdge(statEntry);
            }
        }
        
        if (ctx.stat().size() > 0) {
            ourEntry.addEdge(entry.get(ctx.stat(0)));
            exit.get(ctx.stat(ctx.stat().size()-1)).addEdge(ourExit);
        } else {
            ourEntry.addEdge(ourExit);
        }
    }

    @Override
    public void enterDecl(DeclContext ctx) {
        entry.get(ctx).addEdge(exit.get(ctx));
    }

    @Override
    public void enterPrintStat(PrintStatContext ctx) {
        entry.get(ctx).addEdge(exit.get(ctx));
    }

    @Override
    public void enterProgram(ProgramContext ctx) {
        for (int i = 0; i < ctx.stat().size(); i++) {
            Node statEntry = addNode(ctx.stat(i), "");
            Node statExit = addNode(ctx.stat(i), "");
            
            entry.put(ctx.stat(i), statEntry);
            exit.put(ctx.stat(i), statExit);
            
            if (i > 0) {
                exit.get(ctx.stat(i-1)).addEdge(statEntry);
            }
        }
    }

    @Override
    public void enterWhileStat(WhileStatContext ctx) {
        Node ourEntry = entry.get(ctx);
        Node ourExit = exit.get(ctx);
        
        Node condEntry = addNode(ctx.expr(), "cond");
        Node bodyEntry = addNode(ctx.stat(), "body");
        
        Node condExit = addNode(ctx.expr(), "cond");
        Node bodyExit = addNode(ctx.stat(), "body");
        
        ourEntry.addEdge(condEntry);
        
        condExit.addEdge(bodyEntry);
        condExit.addEdge(ourExit);
        
        bodyExit.addEdge(condEntry);
        
        condEntry.addEdge(condExit);
        
        entry.put(ctx.expr(), condEntry);
        entry.put(ctx.stat(), bodyEntry);
        exit.put(ctx.expr(), condExit);
        exit.put(ctx.stat(), bodyExit);
    }

    @Override
    public void enterIfStat(IfStatContext ctx) {
        Node ourEntry = entry.get(ctx);
        Node ourExit = exit.get(ctx);
        
        Node condEntry = addNode(ctx.expr(), "cond");
        Node condExit = addNode(ctx.expr(), "cond");
        
        Node tEntry = addNode(ctx.stat(0), "t");
        Node tExit = addNode(ctx.stat(0), "t");
        
        if (ctx.stat().size() > 1) {
            Node fEntry = addNode(ctx.stat(1), "f");
            Node fExit = addNode(ctx.stat(1), "f");
            entry.put(ctx.stat(1), fEntry);
            exit.put(ctx.stat(1), fExit);
            condExit.addEdge(fEntry);
            fExit.addEdge(ourExit);
        } else {
            condExit.addEdge(ourExit);
        }
        
        entry.put(ctx.expr(), condEntry);
        entry.put(ctx.stat(0), tEntry);
        
        exit.put(ctx.expr(), condExit);
        exit.put(ctx.stat(0), tExit);
        
        ourEntry.addEdge(condEntry);
        condExit.addEdge(tEntry);
        
        tExit.addEdge(ourExit);
        
        condEntry.addEdge(condExit);
        
        //TODO: in een (terminaal) statement entry aan exit meteen doorlinken.
    }

    @Override
    public void enterAssignStat(AssignStatContext ctx) {
        entry.get(ctx).addEdge(exit.get(ctx));
    }

    /** Adds a node to he CFG, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(graph.size() + "");
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
