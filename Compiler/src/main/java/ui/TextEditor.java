package ui;

import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.folding.FoldParserManager;
import org.fife.ui.rtextarea.RTextScrollPane;
import rsyntax.CmmFoldParser;
import rsyntax.CmmTokenMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by pendragon on 16-12-3.
 */
public class TextEditor extends JPanel {
    RSyntaxTextArea textArea;
    private static final String SYNTAX_STYLE = "text/cmm";

    TextEditor(){
        setLayout(new BorderLayout());
        //注册代码折叠
        FoldParserManager.get().addFoldParserMapping(SYNTAX_STYLE, new CmmFoldParser());
        textArea = new RSyntaxTextArea(40, 120);
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        //传入class全名，内部是反射
        atmf.putMapping(SYNTAX_STYLE, CmmTokenMaker.class.getName());
        textArea.setSyntaxEditingStyle(SYNTAX_STYLE);
        textArea.setCodeFoldingEnabled(true);

        RTextScrollPane sp = new RTextScrollPane(textArea);
        add(sp);

        CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        //设置自动补全的组合键
        ac.setTriggerKey(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK));
        ac.install(textArea);
    }

    private CompletionProvider createCompletionProvider() {
        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        provider.addCompletion(new BasicCompletion(provider, "read"));
        provider.addCompletion(new BasicCompletion(provider, "write"));
        provider.addCompletion(new BasicCompletion(provider, "if"));
        provider.addCompletion(new BasicCompletion(provider, "else"));
        provider.addCompletion(new BasicCompletion(provider, "while"));
        provider.addCompletion(new BasicCompletion(provider, "break"));
        provider.addCompletion(new BasicCompletion(provider, "int"));
        provider.addCompletion(new BasicCompletion(provider, "string"));
        provider.addCompletion(new BasicCompletion(provider, "double"));
        provider.addCompletion(new BasicCompletion(provider, "true"));
        provider.addCompletion(new BasicCompletion(provider, "false"));

        // Add a couple of "shorthand" completions. These completions don't
        // require the input text to be the same thing as the replacement text.
        provider.addCompletion(new ShorthandCompletion(provider, "{", "{\n\t\n}"));
        provider.addCompletion(new ShorthandCompletion(provider, "/*", "/*\n *\n */"));
        return provider;

    }
}
