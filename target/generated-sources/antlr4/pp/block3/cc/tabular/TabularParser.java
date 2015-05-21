// Generated from Tabular.g4 by ANTLR 4.4
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BACKSLASHES=1, BEGIN=2, END=3, LB=4, RB=5, ALIGNMENT=6, AMPERSAND=7, IDENT=8, 
		TEXT=9, NEWLINE=10, COMMENT=11;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\\\'", "'\\begin'", "'\\end'", "'{'", "'}'", "ALIGNMENT", 
		"'&'", "'tabular'", "TEXT", "NEWLINE", "COMMENT"
	};
	public static final int
		RULE_table = 0, RULE_columns = 1, RULE_lines = 2, RULE_line = 3, RULE_entry = 4, 
		RULE_text = 5;
	public static final String[] ruleNames = {
		"table", "columns", "lines", "line", "entry", "text"
	};

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TabularParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TableContext extends ParserRuleContext {
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public ColumnsContext columns() {
			return getRuleContext(ColumnsContext.class,0);
		}
		public TerminalNode IDENT(int i) {
			return getToken(TabularParser.IDENT, i);
		}
		public TerminalNode BEGIN() { return getToken(TabularParser.BEGIN, 0); }
		public TerminalNode RB(int i) {
			return getToken(TabularParser.RB, i);
		}
		public TerminalNode END() { return getToken(TabularParser.END, 0); }
		public TerminalNode LB(int i) {
			return getToken(TabularParser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(TabularParser.RB); }
		public List<TerminalNode> LB() { return getTokens(TabularParser.LB); }
		public List<TerminalNode> IDENT() { return getTokens(TabularParser.IDENT); }
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitTable(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); match(BEGIN);
			setState(13); match(LB);
			setState(14); match(IDENT);
			setState(15); match(RB);
			setState(16); columns();
			setState(17); lines();
			setState(18); match(END);
			setState(19); match(LB);
			setState(20); match(IDENT);
			setState(21); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnsContext extends ParserRuleContext {
		public TerminalNode ALIGNMENT() { return getToken(TabularParser.ALIGNMENT, 0); }
		public TerminalNode NEWLINE() { return getToken(TabularParser.NEWLINE, 0); }
		public TerminalNode RB() { return getToken(TabularParser.RB, 0); }
		public TerminalNode LB() { return getToken(TabularParser.LB, 0); }
		public ColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitColumns(this);
		}
	}

	public final ColumnsContext columns() throws RecognitionException {
		ColumnsContext _localctx = new ColumnsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_columns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(LB);
			setState(24); match(ALIGNMENT);
			setState(25); match(RB);
			setState(26); match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LinesContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitLines(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lines);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28); line();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BACKSLASHES) | (1L << AMPERSAND) | (1L << TEXT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(TabularParser.NEWLINE, 0); }
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33); entry();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BACKSLASHES) | (1L << AMPERSAND) | (1L << TEXT))) != 0) );
			setState(38); match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntryContext extends ParserRuleContext {
		public TerminalNode BACKSLASHES() { return getToken(TabularParser.BACKSLASHES, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode AMPERSAND() { return getToken(TabularParser.AMPERSAND, 0); }
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entry);
		try {
			setState(48);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); text();
				setState(41); match(AMPERSAND);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); text();
				setState(44); match(BACKSLASHES);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46); match(AMPERSAND);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47); match(BACKSLASHES);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TabularParser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\6\4 \n\4\r\4\16\4!\3\5\6\5%\n\5\r\5"+
		"\16\5&\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\63\n\6\3\7\3\7\3\7"+
		"\2\2\b\2\4\6\b\n\f\2\2\65\2\16\3\2\2\2\4\31\3\2\2\2\6\37\3\2\2\2\b$\3"+
		"\2\2\2\n\62\3\2\2\2\f\64\3\2\2\2\16\17\7\4\2\2\17\20\7\6\2\2\20\21\7\n"+
		"\2\2\21\22\7\7\2\2\22\23\5\4\3\2\23\24\5\6\4\2\24\25\7\5\2\2\25\26\7\6"+
		"\2\2\26\27\7\n\2\2\27\30\7\7\2\2\30\3\3\2\2\2\31\32\7\6\2\2\32\33\7\b"+
		"\2\2\33\34\7\7\2\2\34\35\7\f\2\2\35\5\3\2\2\2\36 \5\b\5\2\37\36\3\2\2"+
		"\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7\3\2\2\2#%\5\n\6\2$#\3\2\2\2%&"+
		"\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\f\2\2)\t\3\2\2\2*+\5\f\7"+
		"\2+,\7\t\2\2,\63\3\2\2\2-.\5\f\7\2./\7\3\2\2/\63\3\2\2\2\60\63\7\t\2\2"+
		"\61\63\7\3\2\2\62*\3\2\2\2\62-\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63"+
		"\13\3\2\2\2\64\65\7\13\2\2\65\r\3\2\2\2\5!&\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}