package pp.block2.cc.antlr.cc12;

import java.math.BigInteger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.ParseException;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.antlr.SentenceLexer;
import pp.block2.cc.antlr.SentenceParser;
import pp.block2.cc.antlr.cc12.ExpressionParser.AdditionContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.MultiplicationContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.NegationContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.NumberContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.ParenthesisContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.PowerContext;
import pp.block2.cc.antlr.cc12.ExpressionParser.SubtractionContext;
import pp.block2.cc.ll.Sentence;

public class Calculator extends ExpressionBaseListener {

    ParseTreeProperty<BigInteger> psp;
    boolean encounteredError;

    public Calculator() {
    }

    public BigInteger calculate(String expression) throws ParseException {
        encounteredError = false;
        psp = new ParseTreeProperty<BigInteger>();

        // Convert the input text to a character stream
        CharStream stream = new ANTLRInputStream(expression);
        // Build a lexer on top of the character stream
        Lexer lexer = new ExpressionLexer(stream);
        // Extract a token stream from the lexer
        TokenStream tokens = new CommonTokenStream(lexer);
        // Build a parser instance on top of the token stream
        ExpressionParser parser = new ExpressionParser(tokens);
        // Get the parse tree by calling the start rule
        ParseTree tree = parser.expr();
        new ParseTreeWalker().walk(this, tree);

        if (encounteredError) {
            throw new ParseException();
        }
        // Print the (formatted) parse tree
        return psp.get(tree);
    }

    @Override
    public void exitNumber(NumberContext ctx) {
        psp.put(ctx, new BigInteger(ctx.getText()));
    }

    @Override
    public void exitNegation(NegationContext ctx) {
        BigInteger expr = psp.get(ctx.expr());
        psp.put(ctx, expr.negate());
    }

    @Override
    public void exitSubtraction(SubtractionContext ctx) {
        BigInteger left = psp.get(ctx.left);
        BigInteger right = psp.get(ctx.right);
        psp.put(ctx, left.subtract(right));
    }

    @Override
    public void exitPower(PowerContext ctx) {
        BigInteger left = psp.get(ctx.left);
        BigInteger right = psp.get(ctx.right);
        psp.put(ctx, left.pow(right.intValue()));
    }

    @Override
    public void exitMultiplication(MultiplicationContext ctx) {
        BigInteger left = psp.get(ctx.left);
        BigInteger right = psp.get(ctx.right);
        psp.put(ctx, left.multiply(right));
    }

    @Override
    public void exitParenthesis(ParenthesisContext ctx) {
        BigInteger expr = psp.get(ctx.expr());
        psp.put(ctx, expr);
    }

    @Override
    public void exitAddition(AdditionContext ctx) {
        BigInteger left = psp.get(ctx.left);
        BigInteger right = psp.get(ctx.right);
        psp.put(ctx, left.add(right));
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        encounteredError = true;
    }

}
