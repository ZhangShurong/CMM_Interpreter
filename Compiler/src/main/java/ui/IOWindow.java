package ui;

import io.IOInterface;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * Created by pendragon on 16-12-18.
 */
public class IOWindow extends JFrame implements IOInterface {

    private IOPanel ioPanel;

    IOWindow(Component parent, String title){
        ioPanel = new IOPanel();
        setSize(400, 400);
        setVisible(true);
        setContentPane(ioPanel);
        setTitle(title);
        if (parent != null)
            setLocationRelativeTo(parent);
    }

    @Override
    public void close(){
        this.dispose();
    }

    @Override
    public String stdin() {
        return JOptionPane.showInputDialog("请输入");
    }

    @Override
    public void stdout(Object out) {
        ioPanel.print(out.toString());
    }

    @Override
    public void stderr(Object out) {
        ioPanel.error(out.toString());
    }

    @Override
    public String stdin(String tips) {
        return JOptionPane.showInputDialog(tips);
    }

    private static class IOPanel extends JPanel {
        private JTextPane jTextPane;

        IOPanel() {
            setLayout(new BorderLayout(0, 0));
            jTextPane = new JTextPane();
            jTextPane.setEditable(false);
            jTextPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(jTextPane);
            add(scrollPane, BorderLayout.CENTER);
        }
        void print(String s){
            StyledDocument styledDocument = jTextPane.getStyledDocument();
            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setForeground(attr, Color.BLACK);
            try {
                styledDocument.insertString(styledDocument.getLength(), s, attr);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        void error(String s){
            StyledDocument styledDocument = jTextPane.getStyledDocument();
            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setForeground(attr, Color.RED);
            try {
                styledDocument.insertString(styledDocument.getLength(), s, attr);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        void clear(){
            jTextPane.setText(null);
        }
    }
}
