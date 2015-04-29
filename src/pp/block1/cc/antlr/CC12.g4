lexer grammar CC12;

@header{package pp.block1.cc.antlr;}

IDENT : ALPHABET ALPHANUM ALPHANUM ALPHANUM ALPHANUM ALPHANUM;
fragment ALPHABET : [A-Za-z];
fragment NUMERIC : [0-9];
fragment ALPHANUM : ALPHABET | NUMERIC;