package pp.s1299212.q1_4;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import pp.s1299212.q1_4.gen.SBNBaseListener;
import pp.s1299212.q1_4.gen.SBNParser.ListinitContext;
import pp.s1299212.q1_4.gen.SBNParser.ListtailContext;
import pp.s1299212.q1_4.gen.SBNParser.NegativeContext;
import pp.s1299212.q1_4.gen.SBNParser.NumberContext;
import pp.s1299212.q1_4.gen.SBNParser.OneContext;
import pp.s1299212.q1_4.gen.SBNParser.PositiveContext;

public class MySBNListener extends SBNBaseListener {

    ParseTreeProperty<Tuple> ptp;

    public MySBNListener() {
        ptp = new ParseTreeProperty<Tuple>();
    }
    
    public int getValue(ParseTree ctx) {
        return ptp.get(ctx).getValue();
    }

    @Override
    public void enterNumber(NumberContext ctx) {
        Tuple t = new Tuple(false, 0, 0);
        ptp.put(ctx.list(), t);
    }

    @Override
    public void exitNumber(NumberContext ctx) {
        boolean isNegative = ptp.get(ctx.sign()).isNegative();
        int listValue = ptp.get(ctx.list()).getValue();
        int numberValue = listValue * (isNegative ? -1 : 1);
        Tuple t = new Tuple(isNegative, 0, numberValue);
        ptp.put(ctx, t);
    }

    @Override
    public void exitPositive(PositiveContext ctx) {
        Tuple t = new Tuple(false, 0, 0);
        ptp.put(ctx, t);
    }

    @Override
    public void exitNegative(NegativeContext ctx) {
        Tuple t = new Tuple(true, 0, 0);
        ptp.put(ctx, t);
    }

    @Override
    public void enterListinit(ListinitContext ctx) {
        int position = ptp.get(ctx).getPosition();
        Tuple t1 = new Tuple(false, position + 1, 0);
        ptp.put(ctx.list(), t1);
        Tuple t2 = new Tuple(false, position, 0);
        ptp.put(ctx.bit(), t2);
    }

    @Override
    public void exitListinit(ListinitContext ctx) {
        Tuple t = ptp.get(ctx);
        int listValue = ptp.get(ctx.list()).getValue();
        int bitValue = ptp.get(ctx.bit()).getValue();
        t.setValue(listValue + bitValue);
        ptp.removeFrom(ctx);
        ptp.put(ctx, t);
    }

    @Override
    public void enterListtail(ListtailContext ctx) {
        int position = ptp.get(ctx).getPosition();
        Tuple t2 = new Tuple(false, position, 0);
        ptp.put(ctx.bit(), t2);
    }

    @Override
    public void exitListtail(ListtailContext ctx) {
        Tuple t = ptp.get(ctx);
        int bitValue = ptp.get(ctx.bit()).getValue();
        t.setValue(bitValue);
        ptp.removeFrom(ctx);
        ptp.put(ctx, t);
    }

    @Override
    public void exitOne(OneContext ctx) {
        Tuple t = ptp.get(ctx);
        int value = (int) Math.pow(2, t.getPosition());
        t.setValue(value);
        ptp.removeFrom(ctx);
        ptp.put(ctx, t);
    }

    public class Tuple {

        private boolean negative;
        private int position;
        private int value;

        public Tuple(boolean negative, int position, int value) {
            super();
            this.negative = negative;
            this.position = position;
            this.value = value;
        }

        public boolean isNegative() {
            return negative;
        }

        public void setNegative(boolean negative) {
            this.negative = negative;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
