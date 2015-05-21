package pp.s1299212.q1_3;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import pp.s1299212.q1_3.gen.ExpressionLexer;
import pp.s1299212.q1_3.gen.ExpressionParser;

public class ExpressionTreeTest {

    @Test
    public void checkParseTree1() {
        ParseTree tree = getParseTree("a[i+1] + b.field");
        ParseTree t = tree;
        // E
        t = tree.getChild(0).getChild(0).getChild(0);
        assertEquals("a", t.getChild(0).getChild(0).getChild(0).getText());
        assertEquals("[", t.getChild(1).getText());
        assertEquals("]", t.getChild(3).getText());
        t = t.getChild(2);
        assertEquals("i", t.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText());
        assertEquals("+", t.getChild(1).getText());
        assertEquals("1", t.getChild(2).getChild(0).getChild(0).getChild(0).getText());

        // F
        t = tree.getChild(2).getChild(0);
        assertEquals("b", t.getChild(0).getChild(0).getChild(0).getText());
        assertEquals(".", t.getChild(1).getText());
        assertEquals("field", t.getChild(2).getText());
    }

    @Test
    public void checkParseTree2() {
        ParseTree tree = getParseTree("((Type) x).i - 10 + y");
        ParseTree t = tree;

        assertEquals("y", t.getChild(2).getChild(0).getChild(0).getChild(0).getText());
        assertEquals("+", t.getChild(1).getText());
        t = tree.getChild(0);
        assertEquals("10", t.getChild(2).getChild(0).getChild(0).getChild(0).getText());
        assertEquals("-", t.getChild(1).getText());
        t = t.getChild(0).getChild(0).getChild(0);
        assertEquals("i", t.getChild(2).getText());
        assertEquals(".", t.getChild(1).getText());
        t = t.getChild(0).getChild(0);
        assertEquals("(", t.getChild(0).getText());
        assertEquals(")", t.getChild(2).getText());
        t = t.getChild(1).getChild(0);
        assertEquals("(", t.getChild(0).getText());
        assertEquals("Type", t.getChild(1).getText());
        assertEquals(")", t.getChild(2).getText());
        assertEquals("x", t.getChild(3).getChild(0).getChild(0).getChild(0).getText());
    }

    private ParseTree getParseTree(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new ExpressionLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        return parser.e();
    }
}
