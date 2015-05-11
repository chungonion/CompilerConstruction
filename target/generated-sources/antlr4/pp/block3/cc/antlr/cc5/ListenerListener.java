// Generated from Listener.g4 by ANTLR 4.4
package pp.block3.cc.antlr.cc5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ListenerParser}.
 */
public interface ListenerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull ListenerParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull ListenerParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull ListenerParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull ListenerParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterNum(@NotNull ListenerParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitNum(@NotNull ListenerParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterEquals(@NotNull ListenerParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitEquals(@NotNull ListenerParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterHat(@NotNull ListenerParser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitHat(@NotNull ListenerParser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull ListenerParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull ListenerParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull ListenerParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link ListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull ListenerParser.PlusContext ctx);
}