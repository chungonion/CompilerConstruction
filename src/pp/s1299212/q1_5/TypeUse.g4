grammar TypeUse;

program : '(' series ')' ;
series  : unit* ;
unit    : decl | assign | '(' series ')' ;
decl    : ID ':' ID ';' ;
assign  : ID ':=' ID ';' ;

ID : [a-zA-Z]+;
WS : [ \t\n\r]+ -> skip;
