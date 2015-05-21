// Generated from SBN.g4 by ANTLR 4.4
package pp.s1299212.q1_4.gen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SBNParser}.
 */
public interface SBNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code listinit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListinit(@NotNull SBNParser.ListinitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listinit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListinit(@NotNull SBNParser.ListinitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterZero(@NotNull SBNParser.ZeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitZero(@NotNull SBNParser.ZeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negative}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterNegative(@NotNull SBNParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitNegative(@NotNull SBNParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterOne(@NotNull SBNParser.OneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitOne(@NotNull SBNParser.OneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positive}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterPositive(@NotNull SBNParser.PositiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positive}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitPositive(@NotNull SBNParser.PositiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listtail}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListtail(@NotNull SBNParser.ListtailContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listtail}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListtail(@NotNull SBNParser.ListtailContext ctx);
}