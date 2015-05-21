grammar Tabular;

BACKSLASHES : '\\\\';
BEGIN       : '\\begin';
END         : '\\end';
LB          : '{';
RB          : '}';
ALIGNMENT   : [lcr]*;
AMPERSAND   : '&';
IDENT       : 'tabular';
TEXT        : [a-zA-Z0-9 ]*;
NEWLINE     : [\r\n]+;

COMMENT     : '%'.*?'\n' -> skip;

table           : BEGIN LB IDENT RB columns lines END LB IDENT RB;
columns         : LB ALIGNMENT RB NEWLINE;
lines           : line+;
line            : entry+ NEWLINE;
entry           : text AMPERSAND
                | text BACKSLASHES
                | AMPERSAND
                | BACKSLASHES;
text            : TEXT ;


