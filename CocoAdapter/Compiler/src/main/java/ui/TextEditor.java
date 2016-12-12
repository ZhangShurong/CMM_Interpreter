package ui;

import io.IOInterface;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pendragon on 16-12-3.
 */
public class TextEditor extends JPanel implements IOInterface {
    RSyntaxTextArea textArea;

    public TextEditor(){
        setLayout(new BorderLayout());

        textArea = new RSyntaxTextArea(40, 120);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        add(sp);
    }


    @Override
    public String stdin() {
        return textArea.getText();
    }

    @Override
    public void stdout(Object out) {

    }

    @Override
    public void stderr(Object out) {

    }
}
