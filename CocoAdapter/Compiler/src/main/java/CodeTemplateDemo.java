/**
 * Created by pendragon on 16-12-3.
 */

import org.fife.ui.rsyntaxtextarea.CodeTemplateManager;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * A simple example showing how to add and use Code Templates to an
 * RSyntaxTextArea.<p>
 *
 * A "code template" is a kind of macro for commonly-typed code. It associates a
 * short identifier with a longer code snippet. When code templates are enabled
 * and a short identifier is typed, it is replaced with the corresponding longer
 * code snippet. Type Ctrl+Shift+Space to insert the template.<p>
 *
 * This example uses RSyntaxTextArea 2.5.6.
 */
public class CodeTemplateDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    public CodeTemplateDemo() {

        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        // Whether templates are enabled is a global property affecting all
        // RSyntaxTextAreas, so this method is static.
        RSyntaxTextArea.setTemplatesEnabled(true);

        // Code templates are shared among all RSyntaxTextAreas. You add and
        // remove templates through the shared CodeTemplateManager instance.
        CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();

        // StaticCodeTemplates are templates that insert static text before and
        // after the current caret position. This template is basically shorthand
        // for "System.out.println(".
        CodeTemplate ct = new StaticCodeTemplate("sout", "System.out.println(", null);
        ctm.addTemplate(ct);

        // This template is for a for-loop. The caret is placed at the upper
        // bound of the loop.
        ct = new StaticCodeTemplate("fb", "for (int i=0; i<", "; i++) {\n\t\n}\n");
        ctm.addTemplate(ct);

        setContentPane(cp);
        setTitle("CodeTemplate Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CodeTemplateDemo().setVisible(true);
            }
        });
    }

}
