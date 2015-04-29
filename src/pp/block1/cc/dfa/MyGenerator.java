package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyGenerator implements Generator {

	@Override
	public List<String> scan(State dfa, String text) {

		int index = 0;
		State state = dfa;
		List<String> words = new ArrayList<String>();

		while (index < text.length()) {
			String lexeme = "";
			Stack<State> stack = new Stack<State>();

			while (state != null && index < text.length()) {
				char nextChar = text.charAt(index);
				index++;
				lexeme = lexeme + nextChar;
				if (state.isAccepting()) {
					stack.clear();
				}
				stack.push(state);
				state = state.getNext(nextChar);
			}

			while (!stack.isEmpty() && (state == null || !state.isAccepting())) {
				state = stack.pop();
				lexeme = lexeme.substring(0, lexeme.length() - 1);
				index--;
			}

			if (state != null && state.isAccepting()) {
				words.add(lexeme);
				state = dfa;
			}
		}
		return words;
	}

}
