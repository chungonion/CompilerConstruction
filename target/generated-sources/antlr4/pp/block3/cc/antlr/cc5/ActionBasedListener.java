// Generated from ActionBased.g4 by ANTLR 4.4
package pp.block3.cc.antlr.cc5;
import pp.block3.cc.antlr.Type;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ActionBasedParser}.
 */
public interface ActionBasedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ActionBasedParser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(@NotNull ActionBasedParser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActionBasedParser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(@NotNull ActionBasedParser.TContext ctx);
}