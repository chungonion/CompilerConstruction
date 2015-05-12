grammar Tabular;

BACKSLASHES : '\\\\';
BEGIN       : '\\begin';
END         : '\\end';
LB          : '{';
RB          : '}';
ALIGNMENT   : [lcr];
AMPERSAND   : '&';
IDENT       : 'tabular';
TEXT        : [a-zA-Z0-9 \t\n\r]+;

COMMENT     : '%'.*?'\n' -> skip;

table           : BEGIN LB IDENT RB columns lines END LB IDENT RB;
columns         : LB columnAlignment RB;
columnAlignment : ALIGNMENT*;
lines           : line+;
line            : entry+ BACKSLASHES;
entry           : TEXT AMPERSAND
                | TEXT;


WS          : [ \t\n\r]+ -> skip;
