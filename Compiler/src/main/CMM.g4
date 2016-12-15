grammar CMM;

program : (stmt)+ ;


stmt : varDecl |
    ifStmt |
    whileStmt |
    breakStmt |
    assignStmt |
    readStmt |
    writeStmt |
    stmtBlock ;

stmtBlock : LBBRACKET (stmt)+ RBBRACKET ;

varDecl : type varList SEMICOLON;
//int a; int[3] a;int a,b,c;

type : INT #TypeInt
    |DOUBLE #TypeDouble
    ;
//    |array #ToArray
//    ;

//array : (DOUBLE|INT) LMBRACKET INTCONSTANT RMBRACKET ;
array : IDENT LMBRACKET (INTCONSTANT| expr) RMBRACKET ;

varList : (IDENT | delassign | array)(COMMA (IDENT | delassign | array))* ;


elseiflist : elseif+  ;

elseif : ELSEIF LSBRACKET expr RSBRACKET stmtBlock ;

ifStmt : IF LSBRACKET expr RSBRACKET stmtBlock #ONLYIF
    | IF LSBRACKET expr RSBRACKET stmtBlock ELSE stmtBlock #IFELSE
    | IF LSBRACKET expr RSBRACKET stmtBlock elseiflist #IFELSELIST
    | IF LSBRACKET expr RSBRACKET stmtBlock elseiflist ELSE stmtBlock #IFELSELISTELSE
    ;

whileStmt : WHILE LSBRACKET expr RSBRACKET  (stmtBlock | stmt)  ;
breakStmt : BREAK SEMICOLON ;

readStmt : READ ((IDENT) | (array) ) SEMICOLON;
writeStmt : WRITE LSBRACKET expr RSBRACKET SEMICOLON;
assignStmt : value EQUAL expr SEMICOLON;
delassign: IDENT EQUAL expr ;
value : (IDENT)|(array) ;
constant : (INTCONSTANT | DOUBLECONSTANT) //#NUM
         | (TRUE | FALSE) //#BOOL
        ;


//优先级： Comp < addMin < mulDiv < unaryMinus < Atom

expr : expr SEQUAL addMin #SEExpr
    | expr GEQUAL addMin  #GEExpr
    | expr GREATER addMin #GTExpr
    | expr SMALLER addMin #STExpr
    | expr DEQUAL addMin  #EExpr
    | expr NEQUAL addMin  #NEExpr
    | addMin              #ToAddminExpr
    ;

addMin :
    addMin PLUS mulDiv #Plus
    | addMin MINUS mulDiv  #Minus
    | mulDiv              #TomulDiv
    ;

mulDiv :
    mulDiv MULT unaryMinus #Multiplication
    | mulDiv DIV unaryMinus #Division
    | unaryMinus  #TounaryMinus
    ;

unaryMinus : MINUS unaryMinus #ChangeSign
    | atom  #ToAtom
    ;

atom : IDENT #Identifier
    | constant #ToConstant
    | array #ToArray
    | LSBRACKET expr RSBRACKET #ToExpr
    ;


READ : 'read' ;
WRITE : 'write' ;

IF : 'if' ;
ELSE : 'else' ;
ELSEIF : 'else if' ;

WHILE : 'while' ;
BREAK : 'break' ;

INT : 'int' ;
DOUBLE : 'double' ;

COMMA : ',' ;

//----------------------------
SEMICOLON : ';' ;

IDENT : [A-Za-z_][A-Za-z0-9_]* ;

INTCONSTANT : '0' | [1-9][0-9]* ;
DOUBLECONSTANT : INTCONSTANT('.'([0-9]+))? ;
TRUE : 'true' ;
FALSE : 'false' ;

//----------------------------
LBBRACKET : '{' ;
RBBRACKET : '}' ;
LMBRACKET : '[' ;
RMBRACKET : ']' ;
LSBRACKET : '(' ;
RSBRACKET : ')' ;

SEQUAL : '<=' ;
SMALLER : '<' ;
GEQUAL : '>=' ;
GREATER : '>' ;
DEQUAL : '==' ;
NEQUAL :'!=';

//----------------------------
EQUAL : '=' ;
PLUS  : '+' ;
MINUS : '-' ;
MULT  : '*' ;
DIV   : '/' ;
MOD   : '%' ;

WS : [' '\t\r\n]+ -> skip ;
SL_COMMENT :   '//' ~[\r\n]* -> channel(HIDDEN);
MUL_COMMENT :   '/*' .*? '*/' ->  channel(HIDDEN);
