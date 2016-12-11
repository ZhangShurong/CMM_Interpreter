package com.vergil;

import com.vergil.Interpreter.Interpreter;
import com.vergil.Utils.EditorIO;
import gen.CMMLexer;
import gen.CMMParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
    JScrollPane codeScrollPane;
    JScrollPane infoScrollPane;
    JTextArea infoArea;
    JFileChooser fileChooser;
    public MainWindow()
    {
        super("CMM");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Action [] actions = {
                new OpenAction(),
                new StartAction()
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
        infoArea = new JTextArea();
        infoArea.setLineWrap(true);
        infoScrollPane = new JScrollPane(infoArea);
        infoPanel.add(infoScrollPane, BorderLayout.CENTER);
        infoPanel.setSize(800,200);
        //add(infoPanel,BorderLayout.SOUTH);
        infoPanel.setPreferredSize(new Dimension(800, 150));
        add(infoPanel,BorderLayout.SOUTH);
        fileChooser = new JFileChooser();
    }


    class OpenAction extends AbstractAction {
        public OpenAction() {
            super("文件");
        }
        public void actionPerformed(ActionEvent e) {
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
        public void actionPerformed(ActionEvent e) {
            try {
                infoArea.setText("");
                ANTLRInputStream inputStream
                        = new ANTLRInputStream((codeArea.getText()));
                CMMLexer lexer = new CMMLexer(inputStream);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CMMParser parser = new CMMParser(tokens);
                ParseTree tree = parser.program();
                Trees.inspect(tree, parser);

                ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
                CMMBaseListenerIML cmmBaseListenerIML= new CMMBaseListenerIML(parser);
                cmmBaseListenerIML.setArea(infoArea);
                parseTreeWalker.walk(cmmBaseListenerIML,tree);

                Interpreter interpreter = new Interpreter(codeArea.getText(), new EditorIO(codeArea), new EditorIO(infoArea));
                interpreter.run();

            }
            catch (Exception ex) {
                infoArea.append(ex.getMessage());
            }
        }
    }
}
