package pp.block3.cc.symbol;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.block3.cc.antlr.CalcLexer;
import pp.block3.cc.antlr.CalcParser;

public class DeclCheclChecl {

    @Test
    public void testFile1() throws IOException {
        List<String> errors = getErrors("src/pp/block3/cc/symbol/program1.txt");
        assertTrue(errors.isEmpty());
    }
    
    @Test
    public void testFile2() throws IOException {
        List<String> errors = getErrors("src/pp/block3/cc/symbol/program2.txt");
        assertTrue(!errors.isEmpty());
    }
    
    @Test
    public void testFile3() throws IOException {
        List<String> errors = getErrors("src/pp/block3/cc/symbol/program3.txt");
        assertTrue(!errors.isEmpty());
    }
    
    @Test
    public void testFile4() throws IOException {
        List<String> errors = getErrors("src/pp/block3/cc/symbol/program4.txt");
        assertTrue(!errors.isEmpty());
    }
    
    public List<String> getErrors(String filename) throws IOException {
        ParseTree tree = getTree(filename);
        DeclChecl declChecl = new DeclChecl();
        new ParseTreeWalker().walk(declChecl,tree);
        return declChecl.getErrors();
    }
    
    private ParseTree getTree(String filename) throws IOException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        CharStream chars = new ANTLRInputStream(fileInputStream);
        Lexer lexer = new DeclUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        DeclUseParser parser = new DeclUseParser(tokens);
        return parser.program();
    }

}
