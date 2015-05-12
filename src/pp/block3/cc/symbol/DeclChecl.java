package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.List;

import pp.block3.cc.symbol.DeclUseParser.DeclContext;
import pp.block3.cc.symbol.DeclUseParser.SeriesContext;
import pp.block3.cc.symbol.DeclUseParser.UseContext;

public class DeclChecl extends DeclUseBaseListener {

    private SymbolTable table;
    private List<String> errors;
    
    public DeclChecl() {
        table = new MySymbolTable();
        errors = new ArrayList<String>();
    }
    
    @Override
    public void enterDecl(DeclContext ctx) {
        String name = ctx.ID().getText();
        if (!table.add(name)) {
            int line = ctx.ID().getSymbol().getLine();
            int offset = ctx.ID().getSymbol().getCharPositionInLine();
            String error = String.format(
                    "ERROR: variable %s was already declared at %d:%d",
                    name, line, offset);
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
    public void enterUse(UseContext ctx) {
        String name = ctx.ID().getText();
        if (!table.contains(name)) {
            int line = ctx.ID().getSymbol().getLine();
            int offset = ctx.ID().getSymbol().getCharPositionInLine();
            String error = String.format(
                    "ERROR: variable %s is used without being declared first at %d:%d",
                    name, line, offset);
            errors.add(error);
            System.err.println(error);
        }
    }

    public List<String> getErrors() {
        return errors;
    }

}
