package pp.block1.cc.dfa;

import static pp.block1.cc.dfa.State.ID6_DFA;
import static pp.block1.cc.dfa.State.DFA_LALA;

import org.junit.Assert;
import org.junit.Test;

/** Test class for Checker implementation. */
public class CheckerTest {
	private Checker myChecker = new MyChecker(); // instantiate your Checker implementation

	@Test
	public void testID6() {
		dfa = ID6_DFA;
		accepts("a12345");
		rejects("");
		rejects("a12 45");
		rejects("a12 456");
		rejects("a123456");
		rejects("123456");
	}
	
	@Test
	public void testLaLa() {
		dfa = DFA_LALA;
		accepts("La");
		accepts("La       ");
		accepts("La La");
		accepts("La         La ");
		accepts("Laaaaaa La");
		accepts("LaaaaaaLaaaaaa ");
		accepts("La La La Li");
		accepts("Laaaa   Laaa    LaaLi");
		
		rejects("");
		rejects("Do Re Mi");
		rejects("Lai");
		rejects("La La La");
		rejects("LaLL");
		rejects("La aaa La");
		rejects("La La La La Li");
		rejects("La La La Lii");
	}


	private void accepts(String word) {
		if (!myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, dfa));
		}
	}

	private void rejects(String word) {
		if (myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously accepted by %s", word, dfa));
		}
	}

	private State dfa;
}
