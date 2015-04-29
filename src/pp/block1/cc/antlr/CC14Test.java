package pp.block1.cc.antlr;

import static org.junit.Assert.*;

import org.junit.Test;

public class CC14Test {
	private static LexerTester tester = new LexerTester(CC14.class);

	@Test
	public void succeedingTest() {

		//tester.wrong("");
		tester.wrong("ABC");
		tester.wrong("Li");
		tester.yields("La", CC14.LA);
		tester.yields("La       ", CC14.LA);
		tester.yields("LaLa", CC14.LALA);
		tester.yields("La La", CC14.LALA);
		tester.yields("Laaaaaa La", CC14.LALA);
		tester.yields("La La La Li", CC14.LALALALI);
		
		tester.yields("La La La",CC14.LALA,CC14.LA);
		tester.yields("La La La Li La",CC14.LALALALI,CC14.LA);
		
		tester.yields("La La La Li La La La Li", CC14.LALALALI,CC14.LALALALI);
		tester.yields("La La La Li La La La", CC14.LALALALI,CC14.LALA,CC14.LA);
	}
	
	/**
	 * 	lexer grammar CC14;

		@header{package pp.block1.cc.antlr;}
		
		LALALALI : LA LA LA LI;
		LALA : LA LA;
		LA : 'L' 'a'+;
		
		
		fragment LI : 'Li';
		
		WS : ' '+ -> skip;
	 */
}
