


import interpreter.Interpreter;
import io.EditorIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;


/**
 * Created by vergil on 2016/11/12.
 */
public class MainWindow extends JFrame {

    JToolBar toolBar;

    JPanel codePanel;
    JPanel infoPanel;

    JTextArea codeArea;
    JTextPane infoArea;

    JScrollPane codeScrollPane;
    JScrollPane infoScrollPane;

    JFileChooser fileChooser;
    public MainWindow()
    {
        super("CMM");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Action [] actions = {
                new OpenAction(),
                new StartAction(),
                new ShowTreeAction()
        };
        toolBar = new JToolBar();
        for(int i = 0; i < actions.length; i++) {
            JButton bt = new JButton(actions[i]);
            bt.setRequestFocusEnabled(false);
            toolBar.add(bt);
        }
        toolBar.setFloatable(false);
        add(toolBar,BorderLayout.NORTH);

        codePanel = new JPanel();
        codePanel.setLayout(new BorderLayout());
        codeArea = new JTextArea();
        codeArea.setFont(new Font("Source Code Pro",0,14));
        codeArea.setLineWrap(true);
        codeScrollPane = new JScrollPane(codeArea);
        codePanel.add(codeScrollPane, BorderLayout.CENTER);
        add(codePanel,BorderLayout.CENTER);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoArea = new JTextPane();
        //infoArea.setLineWrap(true);
        infoScrollPane = new JScrollPane(infoArea);
        infoPanel.add(infoScrollPane, BorderLayout.CENTER);
        infoPanel.setSize(800,200);

        infoPanel.setPreferredSize(new Dimension(800, 150));
        add(infoPanel,BorderLayout.SOUTH);
        fileChooser = new JFileChooser();
    }


    class OpenAction extends AbstractAction {
        public OpenAction() {
            super("文件");
        }
        public void actionPerformed(ActionEvent e)
        {
            int i = fileChooser.showOpenDialog(MainWindow.this);
                File f = fileChooser.getSelectedFile();
                try {
                    InputStream is = new FileInputStream(f);
                    Scanner scanner = new Scanner(is, "UTF-8");
                    String text = scanner.useDelimiter("\\A").next();
                    codeArea.setText(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
    }
    class StartAction extends  AbstractAction {
        public StartAction() {
            super("运行");
        }
        public void actionPerformed(ActionEvent e)
        {
            try {
                infoArea.setText("");
                Interpreter interpreter = new Interpreter(codeArea.getText(), new EditorIO(infoArea), new EditorIO(null));
                interpreter.run();

            } catch (Exception ex) {
                infoArea.setText(ex.getMessage());
            }
        }
    }
    class ShowTreeAction extends  AbstractAction {
        public ShowTreeAction() {
            super("语法树");
        }
        public void actionPerformed(ActionEvent e) {
            try {
                Interpreter interpreter = new Interpreter(codeArea.getText(), new EditorIO(infoArea), new EditorIO(null));
                interpreter.showtree();
            }
            catch (Exception ex) {
                //infoArea.append(ex.getMessage());
            }
        }
    }
}
