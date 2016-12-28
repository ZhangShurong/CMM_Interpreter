package ui;

import io.IOInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pendragon on 16-12-21.
 */
public class TokenWindow extends JPanel implements IOInterface {

    private JTextArea jTextArea;

    TokenWindow() {
        setLayout(new BorderLayout(0, 0));
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
//        jTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void clear(){
        jTextArea.setText(null);
    }

    @Override
    public void close() {

    }

    @Override
    public String stdin(String tips) {
        return null;
    }

    @Override
    public String stdin() {
        return null;
    }

    @Override
    public void stdout(Object out) {
        jTextArea.append(out.toString());
    }

    @Override
    public void stderr(Object out) {

    }
}
