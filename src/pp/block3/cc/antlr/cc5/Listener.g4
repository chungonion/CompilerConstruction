grammar Listener;

import Vocab;

t    : t1=t HAT t2=t        # hat 
     | t1=t PLUS t2=t       # plus
     | t1=t EQUALS t2=t     # equals
     | LPAR t1=t RPAR       # parenthesis
     | NUM                  # num
     | BOOL                 # bool
     | STR                  # str
     ;