package pp.block3.cc.tabular;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.block2.cc.Parser;
import pp.block3.cc.antlr.CalcAttrLexer;

public class TabularTest {

    @Test
    public void testNormalErrorListener() {
        CharStream chars = new ANTLRInputStream("This is probably not a correct table");
        Lexer lexer = new TabularLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        TabularParser parser = new TabularParser(tokens);
        
        parser.table();
        //line 1:0 mismatched input 'This is probably not a correct table' expecting '\begin'
    }
    

    
    @Test
    public void testCustomErrorListener() {
        MyErrorListener errorListener = new MyErrorListener();
        
        CharStream chars = new ANTLRInputStream("Blah");
        Lexer lexer = new TabularLexer(chars);
        
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        
        TokenStream tokens = new CommonTokenStream(lexer);
        TabularParser parser = new TabularParser(tokens);
        
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        
        parser.table();
        
        assertEquals("line 1:0 mismatched input 'Blah' expecting '\\begin'", errorListener.getErrors().get(0));
    }
    
    @Test
    public void testCorrect() throws Exception {
        CharStream chars = new ANTLRInputStream(new FileInputStream(new File("src/pp/block3/cc/tabular/tabular-3.tex")));
        Lexer lexer = new TabularLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        TabularParser parser = new TabularParser(tokens);
        
        ParseTree tree = parser.table();
        new ParseTreeWalker().walk(new HTMLTableListener(new FileOutputStream(new File("src/pp/block3/cc/tabular/tabular-3.html"))), tree);
    }

}
