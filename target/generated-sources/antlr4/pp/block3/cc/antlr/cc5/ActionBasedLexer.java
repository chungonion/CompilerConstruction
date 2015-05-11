// Generated from ActionBased.g4 by ANTLR 4.4
package pp.block3.cc.antlr.cc5;
import pp.block3.cc.antlr.Type;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActionBasedLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HAT=1, PLUS=2, EQUALS=3, LPAR=4, RPAR=5, NUM=6, BOOL=7, STR=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'"
	};
	public static final String[] ruleNames = {
		"HAT", "PLUS", "EQUALS", "LPAR", "RPAR", "NUM", "BOOL", "STR", "WS"
	};


	    private int getValue(String text) {
	        return Integer.parseInt(text);
	    }
	    
	    private Type fHat(Type t1, Type t2) {
	        if (t1.equals(t2) && (t1.equals(Type.NUM) || t1.equals(Type.STR))) {
	            return t1;
	        } else {
	            return Type.ERR;
	        }
	    }
	    
	    private Type fPlus(Type t1, Type t2) {
	        if (t1.equals(t2)) {
	            return t1;
	        } else {
	            return Type.ERR;
	        }
	    }
	    
	    private Type fEquals(Type t1, Type t2) {
	        return Type.BOOL;
	    }


	public ActionBasedLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ActionBased.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13\60\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\3\2\3\5\2\13\f\17\17\"\"/\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\31\3\2\2\2\t\33\3\2\2\2\13\35"+
		"\3\2\2\2\r\37\3\2\2\2\17#\3\2\2\2\21(\3\2\2\2\23,\3\2\2\2\25\26\7`\2\2"+
		"\26\4\3\2\2\2\27\30\7-\2\2\30\6\3\2\2\2\31\32\7?\2\2\32\b\3\2\2\2\33\34"+
		"\7*\2\2\34\n\3\2\2\2\35\36\7+\2\2\36\f\3\2\2\2\37 \7p\2\2 !\7w\2\2!\""+
		"\7o\2\2\"\16\3\2\2\2#$\7d\2\2$%\7q\2\2%&\7q\2\2&\'\7n\2\2\'\20\3\2\2\2"+
		"()\7u\2\2)*\7v\2\2*+\7t\2\2+\22\3\2\2\2,-\t\2\2\2-.\3\2\2\2./\b\n\2\2"+
		"/\24\3\2\2\2\3\2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}