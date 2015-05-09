grammar Expression;

@header{package pp.block2.cc.antlr.cc12;}

NUMBER 	: [1-9][0-9]*
		| '0'
		;
PLUS	: '+';
MINUS	: '-';
MULT	: '*';
POW		: '^';
LP		: '(';
RP		: ')';


expr	: LP expr RP								# parenthesis
		| MINUS expr								# negation
		| NUMBER									# number
		| <assoc=right> left=expr POW right=expr	# power
		| left=expr MULT right=expr					# multiplication
		| left=expr PLUS right=expr					# addition
		| left=expr MINUS right=expr				# subtraction
		;