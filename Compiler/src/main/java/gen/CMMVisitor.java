package gen;// Generated from C:/Users/kelei/Desktop/newest/CMM_Interpreter/CMM_Interpreter/Compiler/src/main\CMM.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CMMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CMMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CMMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CMMParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CMMParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#stmtBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBlock(CMMParser.StmtBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(CMMParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(CMMParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDouble(CMMParser.TypeDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(CMMParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link CMMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(CMMParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(CMMParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(CMMParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#elseiflist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseiflist(CMMParser.ElseiflistContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#elseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseif(CMMParser.ElseifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ONLYIF}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitONLYIF(CMMParser.ONLYIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFELSE(CMMParser.IFELSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFELSELIST}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFELSELIST(CMMParser.IFELSELISTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFELSELISTELSE}
	 * labeled alternative in {@link CMMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFELSELISTELSE(CMMParser.IFELSELISTELSEContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(CMMParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(CMMParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#readStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(CMMParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(CMMParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(CMMParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#delassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelassign(CMMParser.DelassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CMMParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMMParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CMMParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTExpr(CMMParser.STExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEExpr(CMMParser.GEExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEExpr(CMMParser.EExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSEExpr(CMMParser.SEExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GTExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGTExpr(CMMParser.GTExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEExpr(CMMParser.NEExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAddminExpr}
	 * labeled alternative in {@link CMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAddminExpr(CMMParser.ToAddminExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TomulDiv}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTomulDiv(CMMParser.TomulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(CMMParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CMMParser#addMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(CMMParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TounaryMinus}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTounaryMinus(CMMParser.TounaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(CMMParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CMMParser#mulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(CMMParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeSign(CMMParser.ChangeSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CMMParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(CMMParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CMMParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToConstant}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToConstant(CMMParser.ToConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToArray}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToArray(CMMParser.ToArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link CMMParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExpr(CMMParser.ToExprContext ctx);
}