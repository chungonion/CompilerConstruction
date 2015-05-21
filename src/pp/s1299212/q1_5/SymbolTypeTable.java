package pp.s1299212.q1_5;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SymbolTypeTable {

    private Stack<Set<Tuple>> stack;

    public SymbolTypeTable() {
        stack = new Stack<>();
        openScope();
    }

    public void openScope() {
        Set<Tuple> set = new HashSet<>();
        stack.push(set);
    }

    public void closeScope() {
        if (stack.size() > 1) {
            stack.pop();
        } else {
            throw new RuntimeException();
        }
    }

    public boolean add(String id, String type) {
        Set<Tuple> topSet = stack.peek();
        Tuple t = new Tuple(id, type);
        return topSet.add(t);
    }

    public Tuple getTuple(String id) {
        Tuple found = null;
        // For better efficiency the for each loop should be reserved, but this
        // is cumbersome in java, so this suffices for now
        for (Set<Tuple> set : stack) {
            for (Tuple t : set) {
                if (t.getId().equals(id)) {
                    found = t;
                }
            }
        }
        return found;
    }

    public boolean matches(String id1, String id2) {
        boolean matches = false;

        Tuple type1 = getTuple(id1);
        Tuple type2 = getTuple(id2);

        if (type1 != null && type2 != null) {
            matches = type1.typesMatch(type2);
        }

        return matches;
    }

    class Tuple {
        private String id;
        private String type;

        public Tuple(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {
            boolean equal = false;

            if (obj != null && obj instanceof Tuple) {
                Tuple t = (Tuple) obj;
                // Only equal ID is required to be considered equal, type is
                // ignored.
                equal = this.id.equals(t.id);
            }

            return equal;
        }

        public boolean typesMatch(Tuple t) {
            return this.type.equals(t.type);
        }

        @Override
        public String toString() {
            return type + " " + id;
        }
    }
}
