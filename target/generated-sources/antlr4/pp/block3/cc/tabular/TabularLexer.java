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
		TEXT=9, NEWLINE=10, COMMENT=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"BACKSLASHES", "BEGIN", "END", "LB", "RB", "ALIGNMENT", "AMPERSAND", "IDENT", 
		"TEXT", "NEWLINE", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rR\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\7\7.\n\7\f\7\16\7\61\13\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\7\n>\n\n\f\n\16\nA\13\n\3\13\6\13D\n\13\r\13\16"+
		"\13E\3\f\3\f\7\fJ\n\f\f\f\16\fM\13\f\3\f\3\f\3\f\3\f\3K\2\r\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\5\5\2eenntt\6\2\"\"\62;"+
		"C\\c|\4\2\f\f\17\17U\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\34\3\2\2\2\7#\3\2\2\2\t(\3\2\2\2\13"+
		"*\3\2\2\2\r/\3\2\2\2\17\62\3\2\2\2\21\64\3\2\2\2\23?\3\2\2\2\25C\3\2\2"+
		"\2\27G\3\2\2\2\31\32\7^\2\2\32\33\7^\2\2\33\4\3\2\2\2\34\35\7^\2\2\35"+
		"\36\7d\2\2\36\37\7g\2\2\37 \7i\2\2 !\7k\2\2!\"\7p\2\2\"\6\3\2\2\2#$\7"+
		"^\2\2$%\7g\2\2%&\7p\2\2&\'\7f\2\2\'\b\3\2\2\2()\7}\2\2)\n\3\2\2\2*+\7"+
		"\177\2\2+\f\3\2\2\2,.\t\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\60\16\3\2\2\2\61/\3\2\2\2\62\63\7(\2\2\63\20\3\2\2\2\64\65\7v\2\2"+
		"\65\66\7c\2\2\66\67\7d\2\2\678\7w\2\289\7n\2\29:\7c\2\2:;\7t\2\2;\22\3"+
		"\2\2\2<>\t\3\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\24\3\2\2\2A"+
		"?\3\2\2\2BD\t\4\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\26\3\2\2"+
		"\2GK\7\'\2\2HJ\13\2\2\2IH\3\2\2\2JM\3\2\2\2KL\3\2\2\2KI\3\2\2\2LN\3\2"+
		"\2\2MK\3\2\2\2NO\7\f\2\2OP\3\2\2\2PQ\b\f\2\2Q\30\3\2\2\2\7\2/?EK\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}