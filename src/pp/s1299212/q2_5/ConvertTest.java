package pp.s1299212.q2_5;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;

public class ConvertTest {
    
    @Test
    public void test() throws Exception {
        testCase(17,10);
        testCase(17,2);
        testCase(17,16);
    }
    
    public void testCase(int num, int base) throws Exception {
        Program p = Assembler.instance().assemble(new File("src/pp/s1299212/q2_5/convert.iloc"));
        Machine m = new Machine();
        
        Simulator s = new Simulator(p, m);
        s.setIn(new ByteArrayInputStream((num+"\n"+base+"\n").getBytes()));
        System.out.println(" Number ? "+num);
        System.out.println(" Base ? "+base);
        s.setOut(System.out);
        
        s.run();

        System.out.println();
    }
}
