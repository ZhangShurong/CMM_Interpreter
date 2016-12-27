import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pendragon on 16-12-1.
 */
public class TextEditorDemo extends JFrame {

    public TextEditorDemo() {
        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);

        // 通过这里可以看到 RSTA 默认支持 括号补全 和 自动缩进
        // 估计内置的语法实现跟这块绑定了
        // 而在TokenMaker接口并没有暴露出这部分的相关操作
        // 导致语法变了,不能自动识别
        // TAT 我能怎么办,我也很绝望啊
        textArea.setAutoIndentEnabled(false);
        textArea.setCloseCurlyBraces(false);

        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        MenuBar menuBar = new MenuBar();
        menuBar.add(new Menu("Test"));
        setMenuBar(menuBar);
        setContentPane(cp);
        setTitle("Text Editor Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(() -> new TextEditorDemo().setVisible(true));
    }

}