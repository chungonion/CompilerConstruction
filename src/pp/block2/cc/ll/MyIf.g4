lexer grammar MyIf;

@header{package pp.block2.cc.ll;}

IF : 'if' ;
THEN : 'then' ;
EXPR : 'expr' ;
ELSE : 'else' ;
ASSIGN : 'assign' ;

// ignore whitespace
WS : [ \t\n\r] -> skip;
