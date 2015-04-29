// Generated from CC12.g4 by ANTLR 4.4
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
public class CC12 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENT=1;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'"
	};
	public static final String[] ruleNames = {
		"IDENT", "ALPHABET", "NUMERIC", "ALPHANUM"
	};


	public CC12(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC12.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\3\32\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\5\5\31\n\5\2\2\6\3\3\5\2\7\2\t\2\3\2\4\4\2C\\c|\3\2\62;\27\2\3"+
		"\3\2\2\2\3\13\3\2\2\2\5\22\3\2\2\2\7\24\3\2\2\2\t\30\3\2\2\2\13\f\5\5"+
		"\3\2\f\r\5\t\5\2\r\16\5\t\5\2\16\17\5\t\5\2\17\20\5\t\5\2\20\21\5\t\5"+
		"\2\21\4\3\2\2\2\22\23\t\2\2\2\23\6\3\2\2\2\24\25\t\3\2\2\25\b\3\2\2\2"+
		"\26\31\5\5\3\2\27\31\5\7\4\2\30\26\3\2\2\2\30\27\3\2\2\2\31\n\3\2\2\2"+
		"\4\2\30\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}