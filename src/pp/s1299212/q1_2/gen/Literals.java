// Generated from Literals.g4 by ANTLR 4.4
package pp.s1299212.q1_2.gen;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Literals extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BINARYINT=1, OCTALINT=2, DECIMALINT=3, HEXINT=4, BINARYLONG=5, OCTALLONG=6, 
		DECIMALLONG=7, HEXLONG=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"BINARYINT", "OCTALINT", "DECIMALINT", "HEXINT", "BINARYLONG", "OCTALLONG", 
		"DECIMALLONG", "HEXLONG", "BINARY", "OCTAL", "DECIMAL", "HEX", "LONGIFIER"
	};


	public Literals(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Literals.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nX\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\6\2\"\n\2\r\2\16\2#\3\3"+
		"\3\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\6\4/\n\4\r\4\16\4\60\5\4\63\n\4\3"+
		"\5\3\5\3\5\3\5\6\59\n\5\r\5\16\5:\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\5\13M\n\13\3\f\3\f\5\fQ\n\f\3\r\3\r\5\r"+
		"U\n\r\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27"+
		"\2\31\2\33\2\3\2\7\3\2\63;\3\2\649\3\2:;\4\2CHch\4\2NNnnZ\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\3\35\3\2\2\2\5%\3\2\2\2\7\62\3\2\2\2\t\64\3\2\2\2\13"+
		"<\3\2\2\2\r?\3\2\2\2\17B\3\2\2\2\21E\3\2\2\2\23H\3\2\2\2\25L\3\2\2\2\27"+
		"P\3\2\2\2\31T\3\2\2\2\33V\3\2\2\2\35\36\7\62\2\2\36\37\7d\2\2\37!\3\2"+
		"\2\2 \"\5\23\n\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\4\3\2\2\2%"+
		"\'\7\62\2\2&(\5\25\13\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\6\3"+
		"\2\2\2+\63\7\62\2\2,.\t\2\2\2-/\5\27\f\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2"+
		"\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62+\3\2\2\2\62,\3\2\2\2\63\b\3\2\2\2"+
		"\64\65\7\62\2\2\65\66\7z\2\2\668\3\2\2\2\679\5\31\r\28\67\3\2\2\29:\3"+
		"\2\2\2:8\3\2\2\2:;\3\2\2\2;\n\3\2\2\2<=\5\3\2\2=>\5\33\16\2>\f\3\2\2\2"+
		"?@\5\5\3\2@A\5\33\16\2A\16\3\2\2\2BC\5\7\4\2CD\5\33\16\2D\20\3\2\2\2E"+
		"F\5\t\5\2FG\5\33\16\2G\22\3\2\2\2HI\4\62\63\2I\24\3\2\2\2JM\5\23\n\2K"+
		"M\t\3\2\2LJ\3\2\2\2LK\3\2\2\2M\26\3\2\2\2NQ\5\25\13\2OQ\t\4\2\2PN\3\2"+
		"\2\2PO\3\2\2\2Q\30\3\2\2\2RU\5\27\f\2SU\t\5\2\2TR\3\2\2\2TS\3\2\2\2U\32"+
		"\3\2\2\2VW\t\6\2\2W\34\3\2\2\2\13\2#)\60\62:LPT\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}