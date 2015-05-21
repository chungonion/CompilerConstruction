package pp.s1299212.q1_5;

import java.util.ArrayList;
import java.util.List;

import pp.s1299212.q1_5.SymbolTypeTable.Tuple;
import pp.s1299212.q1_5.gen.TypeUseBaseListener;
import pp.s1299212.q1_5.gen.TypeUseParser.AssignContext;
import pp.s1299212.q1_5.gen.TypeUseParser.DeclContext;
import pp.s1299212.q1_5.gen.TypeUseParser.SeriesContext;

public class TypeChecker extends TypeUseBaseListener {
    private SymbolTypeTable table;
    private List<String> errors;

    public TypeChecker() {
        table = new SymbolTypeTable();
        errors = new ArrayList<String>();
    }

    @Override
    public void enterDecl(DeclContext ctx) {
        String id = ctx.ID().get(0).getText();
        String type = ctx.ID().get(1).getText();
        if (!table.add(id, type)) {
            int line = ctx.ID().get(0).getSymbol().getLine();
            int offset = ctx.ID().get(0).getSymbol().getCharPositionInLine();
            String error = String.format("ERROR: variable %s was already declared at %d:%d", id, line, offset);
            errors.add(error);
            System.err.println(error);
        }
    }

    @Override
    public void enterSeries(SeriesContext ctx) {
        table.openScope();
    }

    @Override
    public void exitSeries(SeriesContext ctx) {
        table.closeScope();
    }

    @Override
    public void enterAssign(AssignContext ctx) {
        String id1 = ctx.ID().get(0).getText();
        String id2 = ctx.ID().get(1).getText();

        Tuple tuple1 = table.getTuple(id1);
        Tuple tuple2 = table.getTuple(id2);

        String error = null;

        if (tuple1 != null) {
            if (tuple2 != null) {
                if (!tuple1.typesMatch(tuple2)) {
                    int line1 = ctx.ID(0).getSymbol().getLine();
                    int offset1 = ctx.ID(0).getSymbol().getCharPositionInLine();
                    int line2 = ctx.ID(1).getSymbol().getLine();
                    int offset2 = ctx.ID(1).getSymbol().getCharPositionInLine();
                    error = String.format("ERROR: %s's type (%s at %d:%d) does not match %s's type (%s at %d:%d) at ", id1, tuple1.getType(),
                            line1, offset1, id2, tuple2.getType(), line2, offset2);
                }
            } else {
                error = getAssignError(ctx, 1);
            }
        } else {
            error = getAssignError(ctx, 0);
        }

        if (error != null) {
            System.err.println(error);
            errors.add(error);
        }
    }

    private String getAssignError(AssignContext ctx, int index) {
        int line = ctx.ID(index).getSymbol().getLine();
        int offset = ctx.ID(index).getSymbol().getCharPositionInLine();
        String error = String.format("ERROR: variable %s is used without being declared first at %d:%d", ctx.ID().get(index).getText(),
                line, offset);
        return error;
    }

    public List<String> getErrors() {
        return errors;
    }
}
