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
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.AssignStatContext;
import pp.block4.cc.cfg.FragmentParser.BlockStatContext;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;
import pp.block4.cc.cfg.FragmentParser.DeclContext;
import pp.block4.cc.cfg.FragmentParser.IfStatContext;
import pp.block4.cc.cfg.FragmentParser.PrintStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;
import pp.block4.cc.cfg.FragmentParser.StatContext;
import pp.block4.cc.cfg.FragmentParser.WhileStatContext;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
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
			ParseTree tree = parser.program();
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
	public Graph build(ParseTree tree) {
		this.graph = new Graph();
		new ParseTreeWalker().walk(this, tree);
		return graph;
	}
	
    @Override
    public void exitBlockStat(BlockStatContext ctx) {
        Node block = addNode(ctx, "block");
        entry.put(ctx, block);
        exit.put(ctx, block);
        
        if (ctx.stat().size() > 0) {
            for (int i = 1; i < ctx.stat().size(); i++) {
                exit.get(ctx.stat(i-1)).addEdge(entry.get(ctx.stat(i)));
            }
            
            block.addEdge(entry.get(ctx.stat(0)));
            exit.get(ctx.stat(ctx.stat().size() - 1)).addEdge(block);
        }
    }
    
    
    @Override
    public void exitDecl(DeclContext ctx) {
        Node decl = addNode(ctx, "decl");
        entry.put(ctx, decl);
        exit.put(ctx, decl);
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        for (int i = 1; i < ctx.stat().size(); i++) {
            exit.get(ctx.stat(i-1)).addEdge(entry.get(ctx.stat(i)));
        }
    }

    @Override
    public void exitPrintStat(PrintStatContext ctx) {
        Node stat = addNode(ctx, "print");
        entry.put(ctx, stat);
        exit.put(ctx, stat);
    }

    @Override
    public void exitWhileStat(WhileStatContext ctx) {
        Node cond = addNode(ctx, "cond");
        
        Node bodyEntry = entry.get(ctx.stat());
        Node bodyExit = exit.get(ctx.stat());
        
        entry.put(ctx, cond);
        exit.put(ctx, cond);
        
        cond.addEdge(bodyEntry);
        bodyExit.addEdge(cond);
    }

    @Override
    public void exitIfStat(IfStatContext ctx) {
        Node cond = addNode(ctx, "cond");
        Node after = addNode(ctx, "after");
        Node tBranchEntry = entry.get(ctx.stat(0));
        Node fBranchEntry = entry.get(ctx.stat(1));
        Node tBranchExit = exit.get(ctx.stat(0));
        Node fBranchExit = exit.get(ctx.stat(1));

        cond.addEdge(tBranchEntry);
        cond.addEdge(fBranchEntry);
        tBranchExit.addEdge(after);
        fBranchExit.addEdge(after);
        
        entry.put(ctx, cond);
        exit.put(ctx, after);
    }

    @Override
    public void exitAssignStat(AssignStatContext ctx) {
        Node assign = addNode(ctx, "assign");
        entry.put(ctx, assign);
        exit.put(ctx, assign);
    }

    /** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode((graph.size() + 1) + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
