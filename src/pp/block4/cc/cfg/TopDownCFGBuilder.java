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
    }

    @Override
    public void enterDecl(DeclContext ctx) {
    }

    @Override
    public void enterPrintStat(PrintStatContext ctx) {
    }

    @Override
    public void enterProgram(ProgramContext ctx) {
    }

    @Override
    public void enterWhileStat(WhileStatContext ctx) {
    }

    @Override
    public void enterIfStat(IfStatContext ctx) {
        Node ourEntry = entry.get(ctx);
        Node ourExit = exit.get(ctx);
        
        Node condEntry = addNode(ctx.expr(), "cond");
        Node tEntry = addNode(ctx.stat(0), "t");
        Node fEntry = addNode(ctx.stat(1), "f");
        
        Node condExit = addNode(ctx.expr(), "cond");
        Node tExit = addNode(ctx.stat(0), "t");
        Node fExit = addNode(ctx.stat(1), "f");
        
        entry.put(ctx.expr(), condEntry);
        entry.put(ctx.stat(0), tEntry);
        entry.put(ctx.stat(1), fEntry);
        
        exit.put(ctx.expr(), condExit);
        exit.put(ctx.stat(0), tExit);
        exit.put(ctx.stat(1), fExit);
        
        ourEntry.addEdge(condEntry);
        condExit.addEdge(tEntry);
        condExit.addEdge(fEntry);
        
        tExit.addEdge(ourExit);
        fExit.addEdge(ourExit);
        
        //TODO: in een (terminaal) statement entry aan exit meteen doorlinken.
    }

    @Override
    public void enterAssignStat(AssignStatContext ctx) {
    }

    /** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
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
