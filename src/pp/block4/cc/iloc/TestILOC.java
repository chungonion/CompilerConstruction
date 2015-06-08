package pp.block4.cc.iloc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class TestILOC {
    @Test
    public void testIloc() throws FormatException, IOException {
        Program p = Assembler.instance().assemble(new File("src/pp/block4/cc/iloc/max.iloc"));        
        Program pp = Assembler.instance().assemble(p.prettyPrint());

        assertEquals(p.prettyPrint(), pp.prettyPrint());
    }
    
    @Test
    public void testRun() throws Exception {
        Program p = Assembler.instance().assemble(new File("src/pp/block4/cc/iloc/max.iloc"));
        
        Machine m = new Machine();
        m.init("a", 3, 2, 1);
        m.setNum("alength", 3);
        m.declare("r_arp");
        
        
        Simulator s = new Simulator(p, m);
        s.run();
        
        assertEquals(3, m.getReg("r_max"));
    }
    
    @Test
    public void testFib() throws Exception {
        assertEquals(testFibReg(1), testFibMem(1));
        assertEquals(testFibReg(15), testFibMem(15));
        assertEquals(testFibReg(2000), testFibMem(2000));
    }
    
    @Test
    public void testOverflow() throws Exception {
        for (int i = 0; i < 2000; i++) {
            if (testFibReg(i) < 0) {
                System.out.println(i);
                break;
            };
        }
    }
    
    private int testFibReg(int n) throws Exception {
        Program p = Assembler.instance().assemble(new File("src/pp/block4/cc/iloc/fibreg.iloc"));
        
        Machine m = new Machine();
        m.declare("r_cmp");
        m.setReg("r_n", n);
        
        Simulator s = new Simulator(p, m);
        s.run();
        
        return m.getReg("r_z");
    }
    
    private int testFibMem(int n) throws Exception {
        Program p = Assembler.instance().assemble(new File("src/pp/block4/cc/iloc/fibmem.iloc"));
        
        Machine m = new Machine();
        m.declare("r_cmp");
        m.declare("r_arp");
        
        m.init("r_arp", 0, 1, 1, n);

        m.setNum("x", 0);
        m.setNum("y", 4);
        m.setNum("z", 8);
        m.setNum("n", 12);
        
        Simulator s = new Simulator(p, m);
        s.run();
        
        return m.getReg("r_z");
    }
}
