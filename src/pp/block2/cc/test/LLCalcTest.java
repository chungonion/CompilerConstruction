package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.Grammars;
import pp.block2.cc.ll.If;
import pp.block2.cc.ll.LLCalc;
import pp.block2.cc.ll.MyIf;
import pp.block2.cc.ll.MyLLCalc;
import pp.block2.cc.ll.Rule;
import pp.block2.cc.ll.Sentence;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrig() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
	}

	@Test
	public void testSentenceExtended() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
		// Now add the last rule, causing the grammar to fail
		// Define the non-terminals
		NonTerm subj = g.getNonterminal("Subject");
		NonTerm obj = g.getNonterminal("Object");
		NonTerm sent = g.getNonterminal("Sentence");
		NonTerm mod = g.getNonterminal("Modifier");
		g.addRule(mod, mod, mod);
		// Define the terminals
		Term adj = g.getTerminal(Sentence.ADJECTIVE);
		Term noun = g.getTerminal(Sentence.NOUN);
		Term verb = g.getTerminal(Sentence.VERB);
		Term end = g.getTerminal(Sentence.ENDMARK);
		LLCalc calc = createCalc(g);
		// FIRST sets
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
		// FIRST+ sets: test per rule
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
		List<Rule> subjRules = g.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
		// is-LL1-test
		assertFalse(calc.isLL1());
	}
	
	@Test
	public void testIF() {
		Grammar g = Grammars.makeIF();
		// Define the non-terminals
		NonTerm stat = g.getNonterminal("Stat");
		NonTerm elsePart = g.getNonterminal("ElsePart");
		// Define the terminals
		Term assignT = g.getTerminal(MyIf.ASSIGN);
		Term ifT = g.getTerminal(MyIf.IF);
		Term thenT = g.getTerminal(MyIf.THEN);
		Term elseT = g.getTerminal(MyIf.ELSE);
		Term exprT = g.getTerminal(MyIf.EXPR);
		
		LLCalc calc = createCalc(g);
		// FIRST sets
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(assignT), first.get(assignT));
		assertEquals(set(ifT), first.get(ifT));
		assertEquals(set(thenT), first.get(thenT));
		assertEquals(set(elseT), first.get(elseT));
		assertEquals(set(exprT), first.get(exprT));
		assertEquals(set(assignT, ifT), first.get(stat));
		assertEquals(set(elseT, Symbol.EMPTY), first.get(elsePart));
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
		assertEquals(set(elseT, Symbol.EOF), follow.get(stat));
		assertEquals(set(elseT, Symbol.EOF), follow.get(elsePart));
		// FIRST+ sets: test per rule
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
		List<Rule> subjRules = g.getRules();
		assertEquals(set(assignT), firstp.get(subjRules.get(0)));
		assertEquals(set(ifT), firstp.get(subjRules.get(1)));
		assertEquals(set(elseT), firstp.get(subjRules.get(2)));
		assertEquals(set(elseT, Symbol.EMPTY,Symbol.EOF), firstp.get(subjRules.get(3)));;
		
		// is-LL1-test
		assertFalse(calc.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return new MyLLCalc(g); // your implementation of LLCalc (Ex. 2-CC.5)
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
