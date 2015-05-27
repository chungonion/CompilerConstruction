package pp.s1299212.q1_2;

import org.junit.Test;

import pp.block1.cc.antlr.LexerTester;
import pp.s1299212.q1_2.gen.Literals;

public class LiteralsTest {
    private static LexerTester tester = new LexerTester(Literals.class);

    @Test
    public void testBinary() {
        tester.yields("0b01", Literals.BINARYINT);
        tester.yields("0b0000", Literals.BINARYINT);
        tester.yields("0b0100000111", Literals.BINARYINT);
        tester.yields("0b0100000111L", Literals.BINARYLONG);
        tester.wrong("0b");
        tester.wrong("0b23456");
        tester.wrong("0b23456i");
        // The exercise did not mention contextual behavior (whitespace or
        // semicolons), so I assumed this is intended behavior.
        tester.yields("0b0123456", Literals.BINARYINT, Literals.DECIMALINT);
    }

    @Test
    public void testOctal() {
        tester.yields("01234567", Literals.OCTALINT);
        tester.yields("00000", Literals.OCTALINT);
        tester.yields("01234567L", Literals.OCTALLONG);
        tester.wrong("0ABCDEF");
        // The exercise did not mention contextual behavior (whitespace or
        // semicolons), so I assumed this is intended behavior.
        tester.yields("00123456789", Literals.OCTALINT, Literals.DECIMALINT);
    }

    @Test
    public void testDecimal() {
        tester.yields("123456789", Literals.DECIMALINT);
        tester.yields("0", Literals.DECIMALINT);
        tester.yields("1234567L", Literals.DECIMALLONG);
    }

    @Test
    public void testHexadecimal() {
        tester.yields("0x0123456789ABCDEF", Literals.HEXINT);
        tester.yields("0x0123456789abcdef", Literals.HEXINT);
        tester.yields("0x0000", Literals.HEXINT);
        tester.yields("0x0123456789ABCDEFL", Literals.HEXLONG);
        tester.wrong("0xGHIJKLMNOP");
        tester.wrong("0x");
    }
}
