package pp.s1299212.q1_5;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
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

import pp.s1299212.q1_5.gen.TypeUseLexer;
import pp.s1299212.q1_5.gen.TypeUseParser;

public class TypeCheckerTest {

    @Test
    public void testFile1() throws IOException {
        List<String> errors = getErrors("src/pp/s1299212/q1_5/typeuse-1.txt");
        assertTrue(errors.isEmpty());
    }
    public List<String> getErrors(String filename) throws IOException {
        ParseTree tree = getTree(filename);
        TypeChecker checker = new TypeChecker();
        new ParseTreeWalker().walk(checker,tree);
        return checker.getErrors();
    }
    
    private ParseTree getTree(String filename) throws IOException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        CharStream chars = new ANTLRInputStream(fileInputStream);
        Lexer lexer = new TypeUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        TypeUseParser parser = new TypeUseParser(tokens);
        return parser.program();
    }


}
