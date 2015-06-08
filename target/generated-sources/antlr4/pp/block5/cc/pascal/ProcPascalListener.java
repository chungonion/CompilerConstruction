// Generated from ProcPascal.g4 by ANTLR 4.4
package pp.block5.cc.pascal;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProcPascalParser}.
 */
public interface ProcPascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssStat(@NotNull ProcPascalParser.AssStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssStat(@NotNull ProcPascalParser.AssStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull ProcPascalParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull ProcPascalParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(@NotNull ProcPascalParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(@NotNull ProcPascalParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#pars}.
	 * @param ctx the parse tree
	 */
	void enterPars(@NotNull ProcPascalParser.ParsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#pars}.
	 * @param ctx the parse tree
	 */
	void exitPars(@NotNull ProcPascalParser.ParsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterOutStat(@NotNull ProcPascalParser.OutStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitOutStat(@NotNull ProcPascalParser.OutStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ProcPascalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ProcPascalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ProcPascalParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ProcPascalParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull ProcPascalParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull ProcPascalParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull ProcPascalParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull ProcPascalParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(@NotNull ProcPascalParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(@NotNull ProcPascalParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull ProcPascalParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull ProcPascalParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ProcPascalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ProcPascalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(@NotNull ProcPascalParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(@NotNull ProcPascalParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(@NotNull ProcPascalParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(@NotNull ProcPascalParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(@NotNull ProcPascalParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(@NotNull ProcPascalParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull ProcPascalParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull ProcPascalParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull ProcPascalParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull ProcPascalParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(@NotNull ProcPascalParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(@NotNull ProcPascalParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ProcPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(@NotNull ProcPascalParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ProcPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(@NotNull ProcPascalParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ProcPascalParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ProcPascalParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code procDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(@NotNull ProcPascalParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code procDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(@NotNull ProcPascalParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterCallStat(@NotNull ProcPascalParser.CallStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitCallStat(@NotNull ProcPascalParser.CallStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull ProcPascalParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull ProcPascalParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exitStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExitStat(@NotNull ProcPascalParser.ExitStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exitStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExitStat(@NotNull ProcPascalParser.ExitStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(@NotNull ProcPascalParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(@NotNull ProcPascalParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull ProcPascalParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull ProcPascalParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(@NotNull ProcPascalParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(@NotNull ProcPascalParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull ProcPascalParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull ProcPascalParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(@NotNull ProcPascalParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(@NotNull ProcPascalParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrfExpr(@NotNull ProcPascalParser.PrfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrfExpr(@NotNull ProcPascalParser.PrfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProcPascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(@NotNull ProcPascalParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProcPascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(@NotNull ProcPascalParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterInStat(@NotNull ProcPascalParser.InStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitInStat(@NotNull ProcPascalParser.InStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull ProcPascalParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull ProcPascalParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull ProcPascalParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull ProcPascalParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(@NotNull ProcPascalParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(@NotNull ProcPascalParser.IdExprContext ctx);
}