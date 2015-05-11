grammar ActionBased;

import Vocab;

@header{import pp.block3.cc.antlr.Type;}

@members {
    private int getValue(String text) {
        return Integer.parseInt(text);
    }
    
    private Type fHat(Type t1, Type t2) {
        if (t1.equals(t2) && (t1.equals(Type.NUM) || t1.equals(Type.STR))) {
            return t1;
        } else {
            return Type.ERR;
        }
    }
    
    private Type fPlus(Type t1, Type t2) {
        if (t1.equals(t2)) {
            return t1;
        } else {
            return Type.ERR;
        }
    }
    
    private Type fEquals(Type t1, Type t2) {
        return Type.BOOL;
    }
}

t returns [ Type type ]
     : t1=t HAT t2=t 
       { $type = fHat($t1.type, $t2.type);}
     | t1=t PLUS t2=t 
       { $type = fPlus($t1.type, $t2.type);}
     | t1=t EQUALS t2=t 
       { $type = fEquals($t1.type, $t2.type);}
     | LPAR t1=t RPAR
       { $type = $t1.type;}
     | NUM
       { $type = Type.NUM;}
     | BOOL
       { $type = Type.BOOL;}
     | STR
       { $type = Type.STR;}
     ;