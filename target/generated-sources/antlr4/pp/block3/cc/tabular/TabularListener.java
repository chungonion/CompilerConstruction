// Generated from Tabular.g4 by ANTLR 4.4
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TabularParser}.
 */
public interface TabularListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TabularParser#columnAlignment}.
	 * @param ctx the parse tree
	 */
	void enterColumnAlignment(@NotNull TabularParser.ColumnAlignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#columnAlignment}.
	 * @param ctx the parse tree
	 */
	void exitColumnAlignment(@NotNull TabularParser.ColumnAlignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull TabularParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull TabularParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#columns}.
	 * @param ctx the parse tree
	 */
	void enterColumns(@NotNull TabularParser.ColumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#columns}.
	 * @param ctx the parse tree
	 */
	void exitColumns(@NotNull TabularParser.ColumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull TabularParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull TabularParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#lines}.
	 * @param ctx the parse tree
	 */
	void enterLines(@NotNull TabularParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#lines}.
	 * @param ctx the parse tree
	 */
	void exitLines(@NotNull TabularParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull TabularParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull TabularParser.TableContext ctx);
}