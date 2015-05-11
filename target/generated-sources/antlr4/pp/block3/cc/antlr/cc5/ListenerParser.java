// Generated from Listener.g4 by ANTLR 4.4
package pp.block3.cc.antlr.cc5;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ListenerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HAT=1, PLUS=2, EQUALS=3, LPAR=4, RPAR=5, NUM=6, BOOL=7, STR=8, WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'^'", "'+'", "'='", "'('", "')'", "'num'", "'bool'", "'str'", 
		"WS"
	};
	public static final int
		RULE_t = 0;
	public static final String[] ruleNames = {
		"t"
	};

	@Override
	public String getGrammarFileName() { return "Listener.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ListenerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TContext extends ParserRuleContext {
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
	 
		public TContext() { }
		public void copyFrom(TContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends TContext {
		public TerminalNode STR() { return getToken(ListenerParser.STR, 0); }
		public StrContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitStr(this);
		}
	}
	public static class BoolContext extends TContext {
		public TerminalNode BOOL() { return getToken(ListenerParser.BOOL, 0); }
		public BoolContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitBool(this);
		}
	}
	public static class NumContext extends TContext {
		public TerminalNode NUM() { return getToken(ListenerParser.NUM, 0); }
		public NumContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitNum(this);
		}
	}
	public static class EqualsContext extends TContext {
		public TContext t1;
		public TContext t2;
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TerminalNode EQUALS() { return getToken(ListenerParser.EQUALS, 0); }
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public EqualsContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitEquals(this);
		}
	}
	public static class HatContext extends TContext {
		public TContext t1;
		public TContext t2;
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TerminalNode HAT() { return getToken(ListenerParser.HAT, 0); }
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public HatContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterHat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitHat(this);
		}
	}
	public static class ParenthesisContext extends TContext {
		public TContext t1;
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(ListenerParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ListenerParser.RPAR, 0); }
		public ParenthesisContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitParenthesis(this);
		}
	}
	public static class PlusContext extends TContext {
		public TContext t1;
		public TContext t2;
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ListenerParser.PLUS, 0); }
		public PlusContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ListenerListener ) ((ListenerListener)listener).exitPlus(this);
		}
	}

	public final TContext t() throws RecognitionException {
		return t(0);
	}

	private TContext t(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TContext _localctx = new TContext(_ctx, _parentState);
		TContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_t, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3); match(LPAR);
				setState(4); ((ParenthesisContext)_localctx).t1 = t(0);
				setState(5); match(RPAR);
				}
				break;
			case NUM:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7); match(NUM);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(8); match(BOOL);
				}
				break;
			case STR:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9); match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(21);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new HatContext(new TContext(_parentctx, _parentState));
						((HatContext)_localctx).t1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(12);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(13); match(HAT);
						setState(14); ((HatContext)_localctx).t2 = t(8);
						}
						break;
					case 2:
						{
						_localctx = new PlusContext(new TContext(_parentctx, _parentState));
						((PlusContext)_localctx).t1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(15);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(16); match(PLUS);
						setState(17); ((PlusContext)_localctx).t2 = t(7);
						}
						break;
					case 3:
						{
						_localctx = new EqualsContext(new TContext(_parentctx, _parentState));
						((EqualsContext)_localctx).t1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(18);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(19); match(EQUALS);
						setState(20); ((EqualsContext)_localctx).t2 = t(6);
						}
						break;
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return t_sempred((TContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean t_sempred(TContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\35\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\r\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\2\3\2\3\2\2\2!\2\f\3\2\2\2\4\5\b"+
		"\2\1\2\5\6\7\6\2\2\6\7\5\2\2\2\7\b\7\7\2\2\b\r\3\2\2\2\t\r\7\b\2\2\n\r"+
		"\7\t\2\2\13\r\7\n\2\2\f\4\3\2\2\2\f\t\3\2\2\2\f\n\3\2\2\2\f\13\3\2\2\2"+
		"\r\31\3\2\2\2\16\17\f\t\2\2\17\20\7\3\2\2\20\30\5\2\2\n\21\22\f\b\2\2"+
		"\22\23\7\4\2\2\23\30\5\2\2\t\24\25\f\7\2\2\25\26\7\5\2\2\26\30\5\2\2\b"+
		"\27\16\3\2\2\2\27\21\3\2\2\2\27\24\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2"+
		"\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\5\f\27\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}