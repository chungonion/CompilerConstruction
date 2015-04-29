package pp.block1.cc.antlr;

import static org.junit.Assert.*;

import org.junit.Test;

public class CC13Test {
	private static LexerTester tester = new LexerTester(CC13.class);

	@Test
	public void succeedingTest() {
		tester.correct("\"asdjlljasdf\"");
		tester.correct("\"asdjlljasdf\"\"asdjlljasdf\"");
		tester.yields("\"The quoation mark \"\" should be typeset in italics\"",CC13.STRING);
		tester.wrong("\"asdjlljasdf\"asdjlljasdf\"");
		tester.wrong("s12a4g");
	}
}
