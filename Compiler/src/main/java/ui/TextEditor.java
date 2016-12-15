package ui;

import io.IOInterface;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import rsyntax.CmmTokenMaker;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pendragon on 16-12-3.
 */
public class TextEditor extends JPanel implements IOInterface {
    RSyntaxTextArea textArea;
    private static final String SYNTAX_STYLE = "text/myLanguage";

    TextEditor(){
        setLayout(new BorderLayout());

        textArea = new RSyntaxTextArea(40, 120);
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        //传入class全名，内部是反射
        atmf.putMapping(SYNTAX_STYLE, CmmTokenMaker.class.getName());
        textArea.setSyntaxEditingStyle(SYNTAX_STYLE);
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
