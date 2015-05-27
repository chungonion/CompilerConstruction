package pp.s1299212.q1_4;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.s1299212.q1_4.gen.SBNLexer;
import pp.s1299212.q1_4.gen.SBNParser;

public class SBNTest {

    @Test
    public void test() {
        assertEquals(0b00,calc("+00"));
        assertEquals(0b11,calc("+11"));
        assertEquals(0b11011101010011,calc("+11011101010011"));
        assertEquals(-0b00,calc("-00"));
        assertEquals(-0b11,calc("-11"));
        assertEquals(-0b0010101100011,calc("-0010101100011"));
    }
    
    private int calc(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new SBNLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        SBNParser parser = new SBNParser(tokens);
        ParseTree tree = parser.number();
        
        ParseTreeWalker walker = new ParseTreeWalker();
        MySBNListener listener = new MySBNListener();
        walker.walk(listener, tree);
        
        return listener.getValue(tree);
    }

}
