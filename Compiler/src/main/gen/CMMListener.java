// Generated from C:/Users/kelei/Desktop/newest/CMM_Interpreter/CMM_Interpreter/Compiler/src/main\CMM.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CMMParser}.
 */
public interface CMMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CMMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CMMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CMMParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CMMParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CMMParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void enterStmtBlock(CMMParser.StmtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void exitStmtBlock(CMMParser.StmtBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(CMMParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(CMMParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(CMMParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(CMMParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeDouble(CMMParser.TypeDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeDouble(CMMParser.TypeDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeString(CMMParser.TypeStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeString(CMMParser.TypeStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(CMMParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(CMMParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(CMMParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(CMMParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(CMMParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(CMMParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#elseiflist}.
	 * @param ctx the parse tree
	 */
	void enterElseiflist(CMMParser.ElseiflistContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#elseiflist}.
	 * @param ctx the parse tree
	 */
	void exitElseiflist(CMMParser.ElseiflistContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(CMMParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(CMMParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ONLYIF}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterONLYIF(CMMParser.ONLYIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ONLYIF}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitONLYIF(CMMParser.ONLYIFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIFELSE(CMMParser.IFELSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIFELSE(CMMParser.IFELSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFELSELIST}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIFELSELIST(CMMParser.IFELSELISTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFELSELIST}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIFELSELIST(CMMParser.IFELSELISTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFELSELISTELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIFELSELISTELSE(CMMParser.IFELSELISTELSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFELSELISTELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIFELSELISTELSE(CMMParser.IFELSELISTELSEContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(CMMParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(CMMParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(CMMParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(CMMParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(CMMParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(CMMParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(CMMParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(CMMParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CMMParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CMMParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#delassign}.
	 * @param ctx the parse tree
	 */
	void enterDelassign(CMMParser.DelassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#delassign}.
	 * @param ctx the parse tree
	 */
	void exitDelassign(CMMParser.DelassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CMMParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CMMParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMMParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CMMParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMMParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CMMParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSTExpr(CMMParser.STExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSTExpr(CMMParser.STExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGEExpr(CMMParser.GEExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGEExpr(CMMParser.GEExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEExpr(CMMParser.EExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEExpr(CMMParser.EExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSEExpr(CMMParser.SEExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSEExpr(CMMParser.SEExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GTExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGTExpr(CMMParser.GTExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GTExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGTExpr(CMMParser.GTExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNEExpr(CMMParser.NEExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNEExpr(CMMParser.NEExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAddminExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterToAddminExpr(CMMParser.ToAddminExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAddminExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitToAddminExpr(CMMParser.ToAddminExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TomulDiv}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void enterTomulDiv(CMMParser.TomulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TomulDiv}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void exitTomulDiv(CMMParser.TomulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void enterPlus(CMMParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void exitPlus(CMMParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void enterMinus(CMMParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 */
	void exitMinus(CMMParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TounaryMinus}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void enterTounaryMinus(CMMParser.TounaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TounaryMinus}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void exitTounaryMinus(CMMParser.TounaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(CMMParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(CMMParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void enterDivision(CMMParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void exitDivision(CMMParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterChangeSign(CMMParser.ChangeSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitChangeSign(CMMParser.ChangeSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterToAtom(CMMParser.ToAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitToAtom(CMMParser.ToAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CMMParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CMMParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConstant}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterToConstant(CMMParser.ToConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConstant}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitToConstant(CMMParser.ToConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToArray}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterToArray(CMMParser.ToArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToArray}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitToArray(CMMParser.ToArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterToExpr(CMMParser.ToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitToExpr(CMMParser.ToExprContext ctx);
}