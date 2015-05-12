// Generated from Tabular.g4 by ANTLR 4.4
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BACKSLASHES=1, BEGIN=2, END=3, LB=4, RB=5, ALIGNMENT=6, AMPERSAND=7, IDENT=8, 
		TEXT=9, COMMENT=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"BACKSLASHES", "BEGIN", "END", "LB", "RB", "ALIGNMENT", "AMPERSAND", "IDENT", 
		"TEXT", "COMMENT", "WS"
	};


	public TabularLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rO\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\6\n:\n\n\r\n\16\n;\3\13\3\13\7\13@\n\13\f\13\16\13C\13\13\3\13\3\13\3"+
		"\13\3\13\3\f\6\fJ\n\f\r\f\16\fK\3\f\3\f\3A\2\r\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\3\2\5\5\2eenntt\b\2\13\f\17\17\"\"\62;C\\"+
		"c|\5\2\13\f\17\17\"\"Q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\34\3\2\2\2\7#\3\2\2\2\t(\3\2\2\2"+
		"\13*\3\2\2\2\r,\3\2\2\2\17.\3\2\2\2\21\60\3\2\2\2\239\3\2\2\2\25=\3\2"+
		"\2\2\27I\3\2\2\2\31\32\7^\2\2\32\33\7^\2\2\33\4\3\2\2\2\34\35\7^\2\2\35"+
		"\36\7d\2\2\36\37\7g\2\2\37 \7i\2\2 !\7k\2\2!\"\7p\2\2\"\6\3\2\2\2#$\7"+
		"^\2\2$%\7g\2\2%&\7p\2\2&\'\7f\2\2\'\b\3\2\2\2()\7}\2\2)\n\3\2\2\2*+\7"+
		"\177\2\2+\f\3\2\2\2,-\t\2\2\2-\16\3\2\2\2./\7(\2\2/\20\3\2\2\2\60\61\7"+
		"v\2\2\61\62\7c\2\2\62\63\7d\2\2\63\64\7w\2\2\64\65\7n\2\2\65\66\7c\2\2"+
		"\66\67\7t\2\2\67\22\3\2\2\28:\t\3\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<"+
		"\3\2\2\2<\24\3\2\2\2=A\7\'\2\2>@\13\2\2\2?>\3\2\2\2@C\3\2\2\2AB\3\2\2"+
		"\2A?\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\f\2\2EF\3\2\2\2FG\b\13\2\2G\26\3"+
		"\2\2\2HJ\t\4\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\b"+
		"\f\2\2N\30\3\2\2\2\6\2;AK\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}