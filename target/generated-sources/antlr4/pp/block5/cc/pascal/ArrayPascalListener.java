// Generated from ArrayPascal.g4 by ANTLR 4.4
package pp.block5.cc.pascal;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArrayPascalParser}.
 */
public interface ArrayPascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssStat(@NotNull ArrayPascalParser.AssStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssStat(@NotNull ArrayPascalParser.AssStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull ArrayPascalParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull ArrayPascalParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(@NotNull ArrayPascalParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(@NotNull ArrayPascalParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterOutStat(@NotNull ArrayPascalParser.OutStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitOutStat(@NotNull ArrayPascalParser.OutStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ArrayPascalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ArrayPascalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ArrayPascalParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ArrayPascalParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull ArrayPascalParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull ArrayPascalParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull ArrayPascalParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull ArrayPascalParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(@NotNull ArrayPascalParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(@NotNull ArrayPascalParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(@NotNull ArrayPascalParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(@NotNull ArrayPascalParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull ArrayPascalParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull ArrayPascalParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ArrayPascalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ArrayPascalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(@NotNull ArrayPascalParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(@NotNull ArrayPascalParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(@NotNull ArrayPascalParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(@NotNull ArrayPascalParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull ArrayPascalParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull ArrayPascalParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull ArrayPascalParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull ArrayPascalParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(@NotNull ArrayPascalParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(@NotNull ArrayPascalParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(@NotNull ArrayPascalParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(@NotNull ArrayPascalParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(@NotNull ArrayPascalParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(@NotNull ArrayPascalParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(@NotNull ArrayPascalParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(@NotNull ArrayPascalParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ArrayPascalParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ArrayPascalParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull ArrayPascalParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull ArrayPascalParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#bound}.
	 * @param ctx the parse tree
	 */
	void enterBound(@NotNull ArrayPascalParser.BoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#bound}.
	 * @param ctx the parse tree
	 */
	void exitBound(@NotNull ArrayPascalParser.BoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(@NotNull ArrayPascalParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(@NotNull ArrayPascalParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull ArrayPascalParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull ArrayPascalParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(@NotNull ArrayPascalParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(@NotNull ArrayPascalParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(@NotNull ArrayPascalParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(@NotNull ArrayPascalParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrfExpr(@NotNull ArrayPascalParser.PrfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrfExpr(@NotNull ArrayPascalParser.PrfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayPascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(@NotNull ArrayPascalParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayPascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(@NotNull ArrayPascalParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterInStat(@NotNull ArrayPascalParser.InStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitInStat(@NotNull ArrayPascalParser.InStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull ArrayPascalParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull ArrayPascalParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ArrayPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull ArrayPascalParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ArrayPascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull ArrayPascalParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(@NotNull ArrayPascalParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(@NotNull ArrayPascalParser.IdExprContext ctx);
}