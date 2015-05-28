Program gauss;

Var i: Integer;
    limit: Integer;
    sum: Integer;

Begin
    In("Limit? ", limit);
    While i<limit Do
    Begin
        i := i + 1;
        sum := sum + i;
    End;
    Out("Sum: ", sum);
 End.