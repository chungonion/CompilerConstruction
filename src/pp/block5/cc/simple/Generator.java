package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalLexer;
import pp.block5.cc.pascal.SimplePascalParser.*;
import pp.iloc.Simulator;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;

/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
	}
	
	@Override
    public Op visitAssStat(AssStatContext ctx) {
        visit(ctx.expr());
        return emit(OpCode.store, reg(ctx.expr()), reg(ctx.target()));
    }

    @Override
    public Op visitBlockStat(BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Op visitTrueExpr(TrueExprContext ctx) {
        Reg result = reg(ctx);
        return emit(OpCode.loadI, new Num(Simulator.TRUE), result);
    }
    @Override
    public Op visitOutStat(OutStatContext ctx) {
        visit(ctx.expr());
        return emit(OpCode.out, new Str(ctx.STR().getText()), reg(ctx.expr()));
    }

    @Override
    public Op visitProgram(ProgramContext ctx) {
        return visit(ctx.body());
    }

    @Override
    public Op visitBody(BodyContext ctx) {
        for (DeclContext decl : ctx.decl()) {
            visit(decl);
        }
        
        return visit(ctx.block());
    }


    @Override
    public Op visitParExpr(ParExprContext ctx) {
        return visit(ctx.expr());
    }
    
    @Override
    public Op visitCompExpr(CompExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        
        if (ctx.compOp().LE() != null) return emit(OpCode.cmp_LE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        if (ctx.compOp().LT() != null) return emit(OpCode.cmp_LT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        if (ctx.compOp().GE() != null) return emit(OpCode.cmp_GE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        if (ctx.compOp().GT() != null) return emit(OpCode.cmp_GT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        if (ctx.compOp().EQ() != null) return emit(OpCode.cmp_EQ, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        if (ctx.compOp().NE() != null) return emit(OpCode.cmp_NE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
        throw new RuntimeException("");
    }

    @Override
    public Op visitBlock(BlockContext ctx) {
        Op result = null;
        
        for (StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        
        return result;
    }

    @Override
    public Op visitFalseExpr(FalseExprContext ctx) {
        Reg result = reg(ctx);
        return emit(OpCode.loadI, new Num(Simulator.FALSE), result);
    }
    
    @Override
    public Op visitWhileStat(WhileStatContext ctx) {
        Label condLbl = createLabel(ctx, "cond");
        Label endLbl = createLabel(ctx, "end");
        Label bodyLbl = createLabel(ctx, "body");
        
        emit(condLbl, OpCode.nop);
        
        visit(ctx.expr());
        
        emit(OpCode.cbr, reg(ctx.expr()), bodyLbl, endLbl);
        
        emit(bodyLbl, OpCode.nop);
        
        visit(ctx.stat());
        
        emit(endLbl, OpCode.nop);
        
        return null;
    }

    @Override
    public Op visitIfStat(IfStatContext ctx) {
        Label condLbl = createLabel(ctx, "cond");
        Label tb = createLabel(ctx, "tb");
        Label fb = createLabel(ctx, "fb");
        
        emit(condLbl, OpCode.nop);
        
        visit(ctx.expr());
        
        emit(OpCode.cbr, reg(ctx.expr()), tb, fb);
        
        emit(tb, OpCode.nop);
        
        visit(ctx.stat(0));
        
        emit(fb, OpCode.nop);

        if (ctx.stat().size() > 1) {
            visit(ctx.stat(1));
        }
        
        return null;
    }

    @Override
    public Op visitIdTarget(IdTargetContext ctx) {
        return emit(OpCode.loadI, offset(ctx), reg(ctx));
    }


    @Override
    public Op visitMultExpr(MultExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        
        Reg result = reg(ctx);
        Reg left = reg(ctx.expr(0));
        Reg right = reg(ctx.expr(1));
        
        if (ctx.multOp().STAR() != null) {
            return emit(OpCode.mult, left, right, result);
        } else if (ctx.multOp().SLASH() != null) {
            return emit(OpCode.div, left, right, result);
        } else {
            throw new RuntimeException("Unknown mult op");
        }
    }

    @Override
    public Op visitNumExpr(NumExprContext ctx) {
        return emit(OpCode.loadI, new Num(ctx.toString()), reg(ctx));
    }

    @Override
    public Op visitPlusExpr(PlusExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        
        Reg result = reg(ctx);
        Reg left = reg(ctx.expr(0));
        Reg right = reg(ctx.expr(1));
        
        if (ctx.plusOp().PLUS() != null) {
            return emit(OpCode.add, left, right, result);
        } else if (ctx.plusOp().MINUS() != null) {
            return emit(OpCode.sub, left, right, result);
        } else {
            throw new RuntimeException("Unknown plus op");
        }
    }

    @Override
    public Op visitPrfExpr(PrfExprContext ctx) {
        visit(ctx.expr());
        
        if (ctx.prfOp().MINUS() != null) {
            return emit(OpCode.multI, reg(ctx.expr()), new Num(-1));
        } else if (ctx.prfOp().NOT() != null) {
            return emit(OpCode.xorI, reg(ctx.expr()), new Num(-1));
        } else {
            throw new RuntimeException("Unknown prefix op");    
        }
    }
    
    @Override
    public Op visitInStat(InStatContext ctx) {
        visit(ctx.target());
        return emit(OpCode.in, new Str(ctx.STR().getText()), reg(ctx.target()));
    }
    
    @Override
    public Op visitBoolExpr(BoolExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        
        if (ctx.boolOp().AND() != null) {
            return emit(OpCode.and, reg(ctx.expr(0)), reg(ctx.expr(1)));
        } else if (ctx.boolOp().OR() != null) {
            return emit(OpCode.or, reg(ctx.expr(0)), reg(ctx.expr(1)));
        } else {
            throw new RuntimeException("Unknown boolean op");    
        }
    }


    @Override
    public Op visitIdExpr(IdExprContext ctx) {
        // ofset(ctx) misschien reg(ctx.ID())
        return emit(OpCode.load, offset(ctx), reg(ctx));
    }


	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}
}
