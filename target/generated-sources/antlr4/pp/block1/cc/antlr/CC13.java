// Generated from CC13.g4 by ANTLR 4.4
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC13 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'"
	};
	public static final String[] ruleNames = {
		"STRING"
	};


	public CC13(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC13.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\3\21\b\1\4\2\t\2"+
		"\3\2\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\6\2\16\n\2\r\2\16\2\17\3\t\2\3"+
		"\3\3\3\2\3\3\2$$\22\2\3\3\2\2\2\3\r\3\2\2\2\5\t\7$\2\2\6\b\n\2\2\2\7\6"+
		"\3\2\2\2\b\13\3\2\2\2\t\n\3\2\2\2\t\7\3\2\2\2\n\f\3\2\2\2\13\t\3\2\2\2"+
		"\f\16\7$\2\2\r\5\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\4"+
		"\3\2\2\2\5\2\t\17\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}