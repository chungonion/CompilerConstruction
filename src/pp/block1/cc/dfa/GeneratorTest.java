package pp.block1.cc.dfa;

import static pp.block1.cc.dfa.State.ID6_DFA;
import static pp.block1.cc.dfa.State.DFA_LALA;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/** Test class for Checker implementation. */
public class GeneratorTest {
	private Generator myGen = new MyGenerator();// instantiate your Generator implementation

	@Test
	public void testID6() {
		dfa = ID6_DFA;
		yields("");
		yields("a12345", "a12345");
		yields("a12345AaBbCc", "a12345", "AaBbCc");
	}
	
	@Test
	public void testLaLa() {
		dfa = DFA_LALA;
		yields("");
		yields("La", "La");
		yields("La       ", "La       ");
		yields("La La", "La La");
		yields("Laaaaaa La", "Laaaaaa La");
		yields("La La La Li", "La La La Li");
		// yields("La La La La Li", "La ","La La La Li");
		// Infinite loop
		
		yields("La La La","La La ","La");
		yields("La La La Li La","La La La Li ","La");
		
		yields("La La La Li La La La Li", "La La La Li ","La La La Li");
		yields("La La La Li La La La", "La La La Li ","La La ","La");
	}

	private void yields(String word, String... tokens) {
		List<String> result = myGen.scan(dfa, word);
		if (result == null) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, dfa));
		}
		Assert.assertEquals(tokens.length, result.size());
		for (int i = 0; i < tokens.length; i++) {
			Assert.assertEquals(tokens[i], result.get(i));
		}
	}

	private State dfa;
}
