package pp.s1299212.q1_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.LLCalc;
import pp.block2.cc.ll.Rule;

public class MyLLCalc implements LLCalc{

	private Grammar grammar;
	
	public MyLLCalc(Grammar grammar){
		this.grammar = grammar;
	}
	
	
	@Override
	public Map<Symbol, Set<Term>> getFirst() {
		Map<Symbol, Set<Term>> first = new HashMap<Symbol, Set<Term>>();
		for(Term t : grammar.getTerminals()){
			Set<Term> set = new HashSet<>();
			set.add(t);
			first.put(t, set);
		}
		
		for(NonTerm nt : grammar.getNonterminals()){
			Set<Term> set = new HashSet<>();
			first.put(nt, set);
		}
		boolean changed = true;
		while(changed){
			changed = false;
			for(Rule r : grammar.getRules()){
				changed = changed || updateFirst(first,r);
			}
		}
		return first;
	}
	
	private boolean updateFirst(Map<Symbol, Set<Term>> first, Rule rule){
		int rhsStartSize = first.get(rule.getLHS()).size();
		Set<Term> rhs = new HashSet<>(); 
		rhs.addAll(first.get(rule.getRHS().get(0)));
		rhs.remove(Symbol.EMPTY);
		
		int i = 0;
		int k = rule.getRHS().size();
		if(!rule.getRHS().contains(Symbol.EMPTY)){
			while(first.get(rule.getRHS().get(i)).contains(Symbol.EMPTY) && i<k-1){
				rhs.addAll(first.get(rule.getRHS().get(i+1)));
				rhs.remove(Symbol.EMPTY);
				i++;
			}
		}
		if(i==k-1 && first.get(rule.getRHS().get(i)).contains(Symbol.EMPTY)){
			rhs.add(Symbol.EMPTY);
		}
		rhs.addAll(first.get(rule.getLHS()));
		
		if(rhs.size()!=rhsStartSize){
			first.remove(rule.getLHS());
			first.put(rule.getLHS(),rhs);
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public Map<NonTerm, Set<Term>> getFollow() {
		//Initialization;
		Map<NonTerm, Set<Term>> follow = new HashMap<NonTerm, Set<Term>>();		
		for(NonTerm nt : grammar.getNonterminals()){
			Set<Term> set = new HashSet<>();
			follow.put(nt, set);
		}
		Set<Term> set = new HashSet<>();
		set.add(Symbol.EOF);
		follow.put(grammar.getStart(),set);
		
		boolean changed = true;
		while(changed){
			changed = false;
			for(Rule r : grammar.getRules()){
				changed = changed || updateFollow(getFirst(), follow,r);
			}
		}
		
		return follow;
	}

	private boolean updateFollow(Map<Symbol, Set<Term>> first, Map<NonTerm, Set<Term>> follow, Rule r) {
		boolean changed = false;
		Set<Term> trailer = new HashSet<>();
		trailer.addAll(follow.get(r.getLHS()));
		
		for(int i=r.getRHS().size()-1;i>=0;i--){
			Symbol bi = r.getRHS().get(i);
			
			if(bi instanceof NonTerm){
				int startSize = follow.get(bi).size();
				follow.get(bi).addAll(trailer);
				
				if(first.get(bi).contains(Symbol.EMPTY)){
					trailer.addAll(first.get(bi));
					trailer.remove(Symbol.EMPTY);
				}else{
					trailer.clear();
					trailer.addAll(first.get(bi));
				}
				changed = changed || startSize!=follow.get(bi).size();
			}else{
				trailer.clear();
				trailer.addAll(first.get(bi));
			}		
		}		
		return changed;
	}


	@Override
	public Map<Rule, Set<Term>> getFirstp() {
		Map<Symbol, Set<Term>> first = getFirst();
		Map<NonTerm, Set<Term>> follow = getFollow();
		Map<Rule, Set<Term>> firstp = new HashMap<>();
		
		for(Rule r : grammar.getRules()){
			Set<Term> b = first.get(r.getRHS().get(0));
			if(!b.contains(Symbol.EMPTY)){
				firstp.put(r, b);
			}else{
				Set<Term> set = new HashSet<>();
				set.addAll(follow.get(r.getLHS()));
				set.addAll(b);
				firstp.put(r, set);
			}
		}
		
		return firstp;
	}

	@Override
	public boolean isLL1() {
		boolean ll1 = true;
		
		Map<Rule, Set<Term>> firstp = getFirstp();
		for(NonTerm nt : grammar.getNonterminals()){
			Set<Term> all = new HashSet<>();
			int allSize = 0;
			for(Rule r : grammar.getRules(nt)){
				all.addAll(firstp.get(r));
				allSize = allSize + firstp.get(r).size();
			}
			ll1 = ll1 && allSize==all.size();
		}	
		return ll1;
	}

}
