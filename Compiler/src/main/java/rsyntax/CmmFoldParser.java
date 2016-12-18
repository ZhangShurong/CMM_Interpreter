package rsyntax;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.folding.Fold;
import org.fife.ui.rsyntaxtextarea.folding.FoldParser;
import org.fife.ui.rsyntaxtextarea.folding.FoldType;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pendragon on 16-12-18.
 */
public class CmmFoldParser implements FoldParser {

    /**
     * Ending of a multi-line comment in C, C++, Java, etc.
     */
    protected static final char[] C_MLC_END = "*/".toCharArray();


    /**
     * Creates a fold parser that identifies foldable regions via curly braces
     * as well as C-style multi-line comments.
     */
    public CmmFoldParser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fold> getFolds(RSyntaxTextArea textArea) {

        List<Fold> folds = new ArrayList<>();
        Fold currentFold = null; //当前fold对象
        int lineCount = textArea.getLineCount(); //总行数
        boolean inMLC = false; //
        int mlcStart = 0;
        int lastRightCurlyLine = -1;
        Fold prevFold = null; //之前fold对象

        try {
            for (int line = 0; line < lineCount; line++) {
                Token t = textArea.getTokenListForLine(line); //返回该行的Token LinkedList 的头结点
                while (t != null && t.isPaintable()) {
                    if (t.isComment()) {
                        if (inMLC) {
                            // If we found the end of an MLC that started
                            // on a previous line...
                            if (t.endsWith(C_MLC_END)) {
                                int mlcEnd = t.getEndOffset() - 1;
                                if (currentFold == null) {
                                    currentFold = new Fold(FoldType.COMMENT, textArea, mlcStart);
                                    currentFold.setEndOffset(mlcEnd);
                                    folds.add(currentFold);
                                    currentFold = null;
                                } else {
                                    currentFold = currentFold.createChild(FoldType.COMMENT, mlcStart);
                                    currentFold.setEndOffset(mlcEnd);
                                    currentFold = currentFold.getParent();
                                }
                                //System.out.println("Ending MLC at: " + mlcEnd + ", parent==" + currentFold);
                                inMLC = false;
                                mlcStart = 0;
                            }
                            // Otherwise, this MLC is continuing on to yet
                            // another line.
                        } else {
                            // If we're an MLC that ends on a later line...
                            if (t.getType() != Token.COMMENT_EOL && !t.endsWith(C_MLC_END)) {
                                //System.out.println("Starting MLC at: " + t.offset);
                                inMLC = true;
                                mlcStart = t.getOffset();
                            }
                        }

                    } else if (isLeftCurly(t)) {
                        // If a new fold block starts on the same line as the
                        // previous one ends, we treat it as one big block
                        // (e.g. K&R-style "} else {")
                        if (prevFold != null && line == lastRightCurlyLine) {
                            currentFold = prevFold;
                            // Keep currentFold.endOffset where it was, so that
                            // unclosed folds at end of the file work as well
                            // as possible
                            prevFold = null;
                            lastRightCurlyLine = -1;
                        } else if (currentFold == null) { // A top-level fold
                            currentFold = new Fold(FoldType.CODE, textArea, t.getOffset());
                            folds.add(currentFold);
                        } else { // A nested fold
                            currentFold = currentFold.createChild(FoldType.CODE, t.getOffset());
                        }

                    } else if (isRightCurly(t)) {

                        if (currentFold != null) {
                            currentFold.setEndOffset(t.getOffset());
                            Fold parentFold = currentFold.getParent();
                            //System.out.println("... Adding regular fold at " + t.offset + ", parent==" + parentFold);
                            // Don't add fold markers for single-line blocks
                            if (currentFold.isOnSingleLine()) {
                                if (!currentFold.removeFromParent()) {
                                    folds.remove(folds.size() - 1);
                                }
                            } else {
                                // Remember the end of the last completed fold,
                                // in case it needs to get merged with the next
                                // one (e.g. K&R "} else {" style)
                                lastRightCurlyLine = line;
                                prevFold = currentFold;
                            }
                            currentFold = parentFold;
                        }

                    }

                    t = t.getNextToken();

                }

            }

        } catch (BadLocationException ble) { // Should never happen
            ble.printStackTrace();
        }

        return folds;

    }

    /**
     * Returns whether the token is a left curly brace.  This method exists
     * so subclasses can provide their own curly brace definition.
     *
     * @param t The token.
     * @return Whether it is a left curly brace.
     * @see #isRightCurly(Token)
     */
    public boolean isLeftCurly(Token t) {
        return t.isLeftCurly();
    }

    /**
     * Returns whether the token is a right curly brace.  This method exists
     * so subclasses can provide their own curly brace definition.
     *
     * @param t The token.
     * @return Whether it is a right curly brace.
     * @see #isLeftCurly(Token)
     */
    public boolean isRightCurly(Token t) {
        return t.isRightCurly();
    }


}