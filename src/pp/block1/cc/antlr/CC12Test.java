package pp.block1.cc.antlr;

import static org.junit.Assert.*;

import org.junit.Test;

public class CC12Test {
	private static LexerTester tester = new LexerTester(CC12.class);

	@Test
	public void succeedingTest() {
		tester.correct("s12345");
		tester.correct("s12a4g");
		tester.correct("sACA4g");
		tester.yields("s12345", CC12.IDENT);
		tester.wrong("s123");
		tester.wrong("012345");
		tester.wrong("s123456");
		tester.wrong("s1234!!");
	}
}
