package pp.s1299212.q1_3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testExpressionLL() {
	    MyLLCalc calc = new MyLLCalc(Grammars.expressionGrammar());
	    assertTrue(calc.isLL1());
	}
}
