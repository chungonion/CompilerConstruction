package pp.block2.cc.ll;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

public class MyLLCalc implements LLCalc{

	private Grammar grammar;
	
	public MyLLCalc(Grammar grammar){
		this.grammar = grammar;
	}
	
	
	@Override
	public Map<Symbol, Set<Term>> getFirst() {
		
		Map<Symbol, Set<Term>> first = new HashMap<Symbol, Set<Term>>();
		
		for(Rule r : grammar.getRules()){
			getFirst();
		}
		
		
		return null;
	}
	
	private Set<Term> getFirst(Map<Symbol, Set<Term>> first, Rule rule){
		Set<Term> rhs = first.get(rule.getRHS().get(0));
		int i = 0;
		int k = rule.getRHS().size();
		
		if(!rule.getRHS().contains(Symbol.EMPTY)){
			rhs.remove(Symbol.EMPTY);
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
		
		return rhs; 
	}
	

	@Override
	public Map<NonTerm, Set<Term>> getFollow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Rule, Set<Term>> getFirstp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLL1() {
		// TODO Auto-generated method stub
		return false;
	}

}
