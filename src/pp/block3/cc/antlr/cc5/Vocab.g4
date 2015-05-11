lexer grammar Vocab;

HAT  : '^';
PLUS   : '+';
EQUALS  : '=';
LPAR   : '(';
RPAR   : ')';

NUM : 'num';
BOOL : 'bool';
STR : 'str';

// ignore whitespace
WS : [ \t\n\r] -> skip;
