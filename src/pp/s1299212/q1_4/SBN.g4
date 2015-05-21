grammar SBN;

ZERO	: '0';
ONE		: '1';
PLUS	: '+';
MINUS	: '-';

number	: sign list;
sign	: PLUS		# positive
		| MINUS		# negative;
list	: list bit	# listinit
		| bit		# listtail;
bit		: ZERO		# zero
		| ONE		# one;