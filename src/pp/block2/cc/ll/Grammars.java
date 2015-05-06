/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}
	
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeIF() {
		// Define the non-terminals
		NonTerm stat = new NonTerm("Stat");
		NonTerm elsePart = new NonTerm("ElsePart");

		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(MyIf.class);
		Term assignT = fact.getTerminal(MyIf.ASSIGN);
		Term ifT = fact.getTerminal(MyIf.IF);
		Term thenT = fact.getTerminal(MyIf.THEN);
		Term elseT = fact.getTerminal(MyIf.ELSE);
		Term exprT = fact.getTerminal(MyIf.EXPR);
		// Build the context free grammar
		Grammar g = new Grammar(stat);
		g.addRule(stat, assignT);
		g.addRule(stat, ifT, exprT, thenT, stat, elsePart);
		g.addRule(elsePart, elseT, stat);
		g.addRule(elsePart, Symbol.EMPTY);
		return g;
	}
	
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeABC() {
		// Define the non-terminals
		NonTerm q = new NonTerm("Q");
		NonTerm r = new NonTerm("R");
		NonTerm v = new NonTerm("V");
		NonTerm t = new NonTerm("T");
		NonTerm l = new NonTerm("L");

		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Exc4.class);
		Term a = fact.getTerminal(Exc4.A);
		Term b = fact.getTerminal(Exc4.B);
		Term c = fact.getTerminal(Exc4.C);
		// Build the context free grammar
		Grammar g = new Grammar(l);
		g.addRule(q, b, v);
		g.addRule(v, b, c);
		g.addRule(v, c);
		g.addRule(r, a, b, a, t);
		g.addRule(r, c, a, b, a, t);
		g.addRule(t, b, c, t);
		g.addRule(t, Symbol.EMPTY);
		g.addRule(l, r, a);
		g.addRule(l, q, b, a);
		return g;
	}
}
