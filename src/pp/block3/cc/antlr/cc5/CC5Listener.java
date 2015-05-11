package pp.block3.cc.antlr.cc5;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import pp.block3.cc.antlr.Type;
import pp.block3.cc.antlr.cc5.ListenerParser.BoolContext;
import pp.block3.cc.antlr.cc5.ListenerParser.EqualsContext;
import pp.block3.cc.antlr.cc5.ListenerParser.HatContext;
import pp.block3.cc.antlr.cc5.ListenerParser.NumContext;
import pp.block3.cc.antlr.cc5.ListenerParser.ParenthesisContext;
import pp.block3.cc.antlr.cc5.ListenerParser.PlusContext;
import pp.block3.cc.antlr.cc5.ListenerParser.StrContext;

public class CC5Listener extends ListenerBaseListener {
    /** Map storing the val attribute for all parse tree nodes. */
    private ParseTreeProperty<Type> vals;

    /** Initialises the calculator before using it to walk a tree. */
    public CC5Listener() {
        vals = new ParseTreeProperty<Type>();
    }

    public Type getType(ParseTree tree) {
        return vals.get(tree);
    }

    private Type fHat(Type t1, Type t2) {
        if (t1.equals(t2) && (t1.equals(Type.NUM) || t1.equals(Type.STR))) {
            return t1;
        } else {
            return Type.ERR;
        }
    }
    
    private Type fPlus(Type t1, Type t2) {
        if (t1.equals(t2)) {
            return t1;
        } else {
            return Type.ERR;
        }
    }
    
    private Type fEquals(Type t1, Type t2) {
        return Type.BOOL;
    }
    
    @Override
    public void exitStr(StrContext ctx) {
        vals.put(ctx, Type.STR);
    }

    @Override
    public void exitBool(BoolContext ctx) {
        vals.put(ctx, Type.BOOL);
    }

    @Override
    public void exitNum(NumContext ctx) {
        vals.put(ctx, Type.NUM);
    }

    @Override
    public void exitEquals(EqualsContext ctx) {
        vals.put(ctx, fEquals(vals.get(ctx.t1), vals.get(ctx.t2)));
    }

    @Override
    public void exitHat(HatContext ctx) {
        vals.put(ctx, fHat(vals.get(ctx.t1), vals.get(ctx.t2)));
    }

    @Override
    public void exitParenthesis(ParenthesisContext ctx) {
        vals.put(ctx, vals.get(ctx.t1));
    }

    @Override
    public void exitPlus(PlusContext ctx) {
        vals.put(ctx, fPlus(vals.get(ctx.t1), vals.get(ctx.t2)));
    }
    
    
}
