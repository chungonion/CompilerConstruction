grammar Expression;

NUM : [0-9]+;
ID	: [a-zA-Z0-9]+;

e	: e ('+' | '-') f
	| f;
f	: '(' ID ')' f
	| g;
g	: g ('[' e ']' | '.' ID)
	| a;
a	: '(' e ')'
	| NUM
	| ID;

// ignore whitespace
WS : [ \t\n\r] -> skip;