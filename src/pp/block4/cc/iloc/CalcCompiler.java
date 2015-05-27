package pp.block4.cc.iloc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.ErrorListener;
import pp.block4.cc.iloc.CalcParser.MinusContext;
import pp.block4.cc.iloc.CalcParser.NumberContext;
import pp.block4.cc.iloc.CalcParser.ParContext;
import pp.block4.cc.iloc.CalcParser.PlusContext;
import pp.block4.cc.iloc.CalcParser.TimesContext;
import pp.iloc.Simulator;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;

public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
	private Program prog;
	// Attribute maps and other fields
	
	int numRegs = 0;
	
	private ParseTreeProperty<Reg> reg = new ParseTreeProperty();

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.expr();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
	    numRegs = 0;
	    prog = new Program();
		new ParseTreeWalker().walk(this, tree);
		emit(OpCode.out, new Str(""), reg.get(tree));
		return prog;
	}
	
	@Override
    public void exitPar(ParContext ctx) {
        Reg r = makeReg();
        reg.put(ctx, r);
        emit(OpCode.i2i, reg.get(ctx.expr()), r);
    }

    @Override
    public void exitMinus(MinusContext ctx) {
        Reg r = makeReg();
        reg.put(ctx, r);
        Reg m = makeReg();
        emit(OpCode.loadI, new Num(-1), m);
        emit(OpCode.mult, reg.get(ctx.expr()), m, r);
    }

    @Override
    public void exitNumber(NumberContext ctx) {
        Reg r = makeReg();
        reg.put(ctx, r);
        emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), r);
    }

    @Override
    public void exitTimes(TimesContext ctx) {
        Reg r = makeReg();
        reg.put(ctx, r);
        emit(OpCode.mult, reg.get(ctx.expr(0)), reg.get(ctx.expr(1)), r);
    }

    @Override
    public void exitPlus(PlusContext ctx) {
        Reg r = makeReg();
        reg.put(ctx, r);
        emit(OpCode.add, reg.get(ctx.expr(0)), reg.get(ctx.expr(1)), r);
    }

    /** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
		this.prog.addInstr(new Op(opCode, args));
	}
	
	private Reg makeReg() {
	    Reg r = new Reg("r_" + numRegs);
	    numRegs++;
	    return r;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}
}
