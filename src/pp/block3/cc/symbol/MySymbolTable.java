package pp.block3.cc.symbol;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MySymbolTable implements SymbolTable {

    private Stack<Set<String>> stack;
    
    public MySymbolTable() {
        stack = new Stack<>();
        openScope();
    }
    
    @Override
    public void openScope() {
        Set<String> set = new HashSet<>();
        stack.push(set);
    }

    @Override
    public void closeScope() {
        if (stack.size() > 1) {
            stack.pop();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean add(String id) {
        Set<String> topSet = stack.peek();
        return topSet.add(id);
    }

    @Override
    public boolean contains(String id) {
        for (Set<String> set : stack) {
            if (set.contains(id)) {
                return true;
            }
        }
        return false;
    }
}
