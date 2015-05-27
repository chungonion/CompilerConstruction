// Generated from Expression.g4 by ANTLR 4.4
package pp.s1299212.q1_3.gen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#a}.
	 * @param ctx the parse tree
	 */
	void enterA(@NotNull ExpressionParser.AContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#a}.
	 * @param ctx the parse tree
	 */
	void exitA(@NotNull ExpressionParser.AContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(@NotNull ExpressionParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(@NotNull ExpressionParser.EContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(@NotNull ExpressionParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(@NotNull ExpressionParser.FContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#g}.
	 * @param ctx the parse tree
	 */
	void enterG(@NotNull ExpressionParser.GContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#g}.
	 * @param ctx the parse tree
	 */
	void exitG(@NotNull ExpressionParser.GContext ctx);
}