grammar Calc;

import CalcVocab;

expr : MINUS expr	   # negate
	 | expr TIMES expr # times
     | expr PLUS expr  # plus
     | LPAR expr RPAR  # par
     | NUMBER          # number
     ;
