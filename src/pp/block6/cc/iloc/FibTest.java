package pp.block6.cc.iloc;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.block5.cc.ParseException;
import pp.block5.cc.SimplePascalCompiler;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;

public class FibTest {
    @Test
    public void test() throws Exception {
        testNumber(0,1);
        testNumber(1,1);
        testNumber(2,2);
        testNumber(3,3);
        testNumber(10,89);
        testNumber(20,10946);
        testNumber(30,1346269);
    }
    
    public void testNumber(int input, int output) throws Exception {
        Program p = Assembler.instance().assemble(new File("src/pp/block6/cc/iloc/fib.iloc"));
        
        Machine m = new Machine();
        m.declare("r_arp");
        
        
        
        Simulator s = new Simulator(p, m);
        s.setIn(new ByteArrayInputStream((input+"\n").getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        s.setOut(out);
        
        s.run();
        
        assertEquals("Result: "+output, out.toString().trim());
    }
}
