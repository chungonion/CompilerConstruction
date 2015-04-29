package pp.block1.cc.dfa;

public class MyChecker implements Checker {

	@Override
	public boolean accepts(State start, String word) {
		State state = start;
		for (int index = 0; index < word.length() && state != null; index++) {
			state = state.getNext(word.charAt(index));
			//Never accepts tokens shorter than the given word?
		}
		return state != null && state.isAccepting();
	}
}
