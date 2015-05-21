/**
 * 
 */
package pp.s1299212.q1_3;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.Sentence;

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
        System.out.println(noun.getTokenType());
        Term verb = fact.getTerminal(Sentence.VERB);
        System.out.println(verb.getTokenType());
        Term adj = fact.getTerminal(Sentence.ADJECTIVE);
        System.out.println(adj.getTokenType());
        Term end = fact.getTerminal(Sentence.ENDMARK);
        System.out.println(end.getTokenType());
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
	public static Grammar expressionGrammar() {
	    NonTerm e = new NonTerm("E");
	    NonTerm e0 = new NonTerm("E0");
	    NonTerm e1 = new NonTerm("E1");
	    NonTerm f = new NonTerm("F");
	    NonTerm f1 = new NonTerm("F1");
	    NonTerm f2 = new NonTerm("F2");
	    NonTerm g = new NonTerm("G");
	    
        Term plus = new Term(1,"PLUS");
        Term minus = new Term(2,"MINUS");
        Term lp = new Term(3,"(");
        Term rp = new Term(4,")");
        Term lb = new Term(5,"[");
        Term rb = new Term(6,"]");
        Term dot = new Term(7,".");
        Term num = new Term(8,"NUM");
        Term id = new Term(9,"ID");
        
        Grammar grammar = new Grammar(e);
        grammar.addRule(e,f,e0);
        grammar.addRule(e0,plus,e);
        grammar.addRule(e0,minus,e);
        grammar.addRule(e0,Symbol.EMPTY);
        grammar.addRule(e1,lp,f1,e0);
        grammar.addRule(e1,num, e0);
        grammar.addRule(f,lp, f1);
        grammar.addRule(f,num,g);
        grammar.addRule(f,id,g);
        grammar.addRule(f1, id, f2);
        grammar.addRule(f1, e1, rp,g);
        grammar.addRule(f2, rp, f);
        grammar.addRule(f2, plus,e, rp,g);
        grammar.addRule(f2, minus,e, rp,g);
        grammar.addRule(g,lb,e,rb,g);
        grammar.addRule(g,dot,id,g);
        grammar.addRule(g,Symbol.EMPTY);
        
        return grammar;
	}
}
