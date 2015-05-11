package pp.block2.cc.antlr.cc12;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import pp.block2.cc.ParseException;

public class CalculatorTest {
	@Test
	public void testExpr() throws ParseException {
		Calculator calc = new Calculator();
		
		assertEquals(calc.calculate("1"),bi(1));
		assertEquals(calc.calculate("0"),bi(0));
		try{
		    assertEquals(calc.calculate("012"),bi(0));
		    fail();
		}catch(ParseException e){}
		
		assertEquals(calc.calculate("118923789"),bi(118923789));
		assertEquals(calc.calculate("999999999999999999999999999999999999999999999999999999"),new BigInteger("999999999999999999999999999999999999999999999999999999"));
		
		assertEquals(calc.calculate("3+5"),bi(8));
		assertEquals(calc.calculate("3*5"),bi(15));
		assertEquals(calc.calculate("3^5"),bi(243));
		assertEquals(calc.calculate("3-5"),bi(-2));
        assertEquals(calc.calculate("-5"),bi(-5));
        assertEquals(calc.calculate("--5"),bi(5));
        assertEquals(calc.calculate("----5"),bi(5));
        
        assertEquals(calc.calculate("3+4*5"),bi(23));
        assertEquals(calc.calculate("(3+4)*5"),bi(35));
        assertEquals(calc.calculate("1--(3+4)*5"),bi(36));
        assertEquals(calc.calculate("4^2^3"),bi(65536));
        assertEquals(calc.calculate("4^(3-1)^3"),bi(65536));
        assertEquals(calc.calculate("4^2^3*3-4^2^3*2"),bi(65536));
        assertEquals(calc.calculate("1---1"),bi(0));
	}
	
	private BigInteger bi(int value){
	    return new BigInteger(""+value);
	}
}
