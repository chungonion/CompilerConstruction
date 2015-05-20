package pp.block3.cc.tabular;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block3.cc.tabular.TabularParser.EntryContext;
import pp.block3.cc.tabular.TabularParser.LineContext;
import pp.block3.cc.tabular.TabularParser.TableContext;
import pp.block3.cc.tabular.TabularParser.TextContext;

public class HTMLTableListener extends TabularBaseListener {
    private PrintWriter out;

    public HTMLTableListener(OutputStream out) {
        super();
        this.out = new PrintWriter(out, true);
    }

    @Override
    public void enterEntry(EntryContext ctx) {
        out.print("<td>");
    }

    @Override
    public void exitEntry(EntryContext ctx) {
        out.println("</td>");
    }

    @Override
    public void enterLine(LineContext ctx) {
        out.println("<tr>");
    }

    @Override
    public void exitLine(LineContext ctx) {
        out.println("</tr>");
    }

    @Override
    public void enterTable(TableContext ctx) {
        out.println("<html>");
        out.println("<body>");
        out.println("<marquee>");
        out.println("<table border='1' style='font-family: monospace; border-collapse: collapse; font-weight: bold; background-image: -webkit-gradient(linear,  left top,  left bottom,         color-stop(0.00, red), color-stop(16%, orange),color-stop(32%, yellow),color-stop(48%, green),color-stop(60%, blue),color-stop(76%, indigo),color-stop(1.00, violet));'>");
    }

    @Override
    public void exitTable(TableContext ctx) {
        out.println("</table>");
        out.println("</marquee>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void enterText(TextContext ctx) {
        out.print(ctx.getText().trim());
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length - 1; i += 2) {
            File inFile = new File(args[i+0]);
            File outFile = new File(args[i+1]);
            
            MyErrorListener errorListener = new MyErrorListener();
            
            CharStream chars = new ANTLRInputStream(new FileInputStream(inFile));
            Lexer lexer = new TabularLexer(chars);
            
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            
            TokenStream tokens = new CommonTokenStream(lexer);
            TabularParser parser = new TabularParser(tokens);
           
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            
            ParseTree tree = parser.table();
            
            if (errorListener.getErrors().isEmpty()) {
                new ParseTreeWalker().walk(new HTMLTableListener(new FileOutputStream(outFile)), tree);
                Desktop.getDesktop().browse(outFile.toURI());
            } else {
                System.err.println(Arrays.toString(errorListener.getErrors().toArray()));
            }
        }
    }
}
