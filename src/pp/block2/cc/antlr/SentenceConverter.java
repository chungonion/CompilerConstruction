package pp.block2.cc.antlr;

import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Sentence;

public class SentenceConverter extends SentenceBaseListener implements Parser {
	
	ParseTreeProperty<AST> psp;
	boolean encounteredError;
	
	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	/**
	 * Factory needed to create terminals of the {@link Sentence} grammar. See
	 * {@link pp.block2.cc.ll.SentenceParser} for example usage.
	 */
	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		encounteredError = false;
		psp = new ParseTreeProperty<AST>();
		
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		SentenceParser parser = new SentenceParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		if(encounteredError){
			throw new ParseException();
		}
		// Print the (formatted) parse tree
		return psp.get(tree);
	}
	

	@Override
	public void visitErrorNode(ErrorNode node) {
		encounteredError = true;
	}


	@Override
	public void exitEveryRule(ParserRuleContext ctx) {		
		String ruleName = SentenceParser.ruleNames[ctx.getRuleIndex()];
		String fancyRuleName = ruleName.substring(0, 1).toUpperCase() + ruleName.substring(1);
		NonTerm symbol = new NonTerm(fancyRuleName);
		AST ast = new AST(symbol);
		
		for (int i = 0; i < ctx.getChildCount(); i++) {
			AST child = psp.get(ctx.getChild(i));
			ast.addChild(child);
		}
		
		psp.put(ctx, ast);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		Token token = node.getSymbol();
		int tokenType = token.getType();
		String tokenName = fact.get(tokenType);
		Term symbol = new Term(tokenType,tokenName);
		
		psp.put(node,new AST(symbol,token));
	}
}
