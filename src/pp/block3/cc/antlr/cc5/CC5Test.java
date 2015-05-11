package pp.block3.cc.antlr.cc5;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.block3.cc.antlr.CalcAttrLexer;
import pp.block3.cc.antlr.CalcAttrParser;
import pp.block3.cc.antlr.CalcLexer;
import pp.block3.cc.antlr.CalcParser;
import pp.block3.cc.antlr.Calculator;
import pp.block3.cc.antlr.CalcAttrParser.ExprContext;
import pp.block3.cc.antlr.Type;
import pp.block3.cc.antlr.cc5.ActionBasedParser.TContext;

public class CC5Test {
	private final ParseTreeWalker walker;
	private final CC5Listener listener;
	
	public CC5Test() { 
		walker = new ParseTreeWalker();
		listener = new CC5Listener();
	}
	
	@Test
	public void test() {
		test(Type.NUM, "num");
		test(Type.BOOL, "bool");
		test(Type.STR, "str");
	}
	@Test
	public void testPlus() {
		test(Type.NUM, "num+num");
		test(Type.STR, "str+str");
		test(Type.BOOL, "bool+bool");
		test(Type.ERR, "str+num");
	}
	
	@Test
	public void testHat() {
		test(Type.NUM, "num^num");
		test(Type.STR, "str^str");
		test(Type.ERR, "bool^bool");
		test(Type.ERR, "str^num");
	}
	@Test
	public void testEquals() {
		test(Type.BOOL, "num=num");
		test(Type.BOOL, "str=str");
		test(Type.BOOL, "bool=bool");
		test(Type.BOOL, "str=num");
		test(Type.BOOL, "(str+num)=num");
	}

	private void test(Type expected, String expr) {
		assertEquals(expected, parseActionBased(expr).type);
		ParseTree tree = parseListener(expr);
		walker.walk(listener, tree);
		assertEquals(expected, listener.getType(tree));
	}

	private ParseTree parseListener(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new ListenerLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		ListenerParser parser = new ListenerParser(tokens);
		return parser.t();
	}

	private TContext parseActionBased(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new ActionBasedLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		ActionBasedParser parser = new ActionBasedParser(tokens);
		return parser.t();
	}
}
