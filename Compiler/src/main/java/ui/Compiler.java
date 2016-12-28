package ui;

import interpreter.Interpreter;
import interpreter.StopException;
import util.FileUtil;
import util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Created by pendragon on 16-12-3.
 */
public class Compiler extends JFrame {
    public static final String APP_NAME = "Text Editor Demo";

    private TextEditor textEditor;
    private TokenWindow tokenInfo;
    private JFileChooser fileChooser;

    private IOWindow ioWindow;

    public Compiler(){
        CompilerMenu menuBar = new CompilerMenu();
        textEditor = new TextEditor();
        tokenInfo = new TokenWindow();
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        //file operation
        menuBar.addMenuFileListener(new MenuInterface.MenuFileListener() {
            @Override
            public void setNewFileListener(ActionEvent event) {
                textEditor.textArea.setText(null);

                tokenInfo.clear();
                if (tokenInfo.isVisible()){
                    tokenInfo.setVisible(false);
                    Compiler.this.pack();
                }

                if (ioWindow != null)
                    ioWindow.close();
            }

            @Override
            public void setOpenFileListener(ActionEvent event) {
                int i = fileChooser.showOpenDialog(Compiler.this);
                if (i == JFileChooser.APPROVE_OPTION) {
                    File f = fileChooser.getSelectedFile();
                    try {
                        tokenInfo.clear();
                        if (tokenInfo.isVisible()){
                            tokenInfo.setVisible(false);
                            Compiler.this.pack();
                        }

                        if (ioWindow != null)
                            ioWindow.close();

                        setTitle(APP_NAME + " : " + (f.getName().length() > 13 ? f.getName() : f.getName().substring(0, 10) + "..."));
                        FileReader fileReader = new FileReader(f);
                        textEditor.textArea.read(fileReader, null);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void setSaveFileListener(ActionEvent event) {
                //check if default name is duplicated
                File file = new File("untitled1.cmm");
                while (FileUtil.isDuplicate(file, fileChooser.getCurrentDirectory())){
                    String tem = file.getName().split("\\.")[0];
                    file = new File("untitled" + (Integer.parseInt(tem.substring(8, tem.length())) + 1) + ".cmm");
                }
                fileChooser.setSelectedFile(file);

                int i = fileChooser.showSaveDialog(Compiler.this);
                if (i == JFileChooser.APPROVE_OPTION) {
                    File f = fileChooser.getSelectedFile();
                    //check if the file is already existed
                    try {
                        FileOutputStream out = new FileOutputStream(f);
                        out.write(textEditor.textArea.getText().getBytes());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void setExitListener(ActionEvent event) {
                //check if the code is saved
                System.exit(0);
            }
        });

        //run control
        menuBar.addMenuRunListener(new MenuInterface.MenuRunListener() {
            @Override
            public void setRunListener(ActionEvent event) {
                String str = textEditor.textArea.getText();
                if (!StringUtil.isEmpty(str)){
                    if (ioWindow != null)
                        ioWindow.close();
                    ioWindow = new IOWindow(Compiler.this, "Console");
                    Interpreter interpreter = new Interpreter(str, ioWindow, ioWindow);
                    interpreter.run();
                }
            }

            @Override
            public void setDebugListener(ActionEvent event) {
                if (!tokenInfo.isVisible()){
                    tokenInfo.setVisible(true);
                    Compiler.this.pack();
                }

                String str = textEditor.textArea.getText();
                if (!StringUtil.isEmpty(str)){
                    if (ioWindow != null)
                        ioWindow.close();
                    ioWindow = new IOWindow(Compiler.this, "Console");
                    Interpreter interpreter = new Interpreter(str, ioWindow, tokenInfo);
                    interpreter.setShowtree(true);
                    interpreter.setShowtoken(true);
                    interpreter.run();
                }
            }
        });

        //about info
        menuBar.addMenuHelpListener(new MenuInterface.MenuHelpListener() {
            @Override
            public void setAboutListener(ActionEvent event) {
                JOptionPane.showMessageDialog(Compiler.this, "@Author 张树荣 何昊东 柯磊\n@Contact 卓越一班, ISS, WHU\n@Date 2016-12-21", "CMM Interpreter", INFORMATION_MESSAGE);
            }
        });

        //ui relative

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(textEditor, BorderLayout.EAST);
        tokenInfo.setSize(300, 800);
        tokenInfo.setVisible(false);
        contentPanel.add(tokenInfo, BorderLayout.WEST);

        setMenuBar(menuBar);
        setContentPane(contentPanel);
        setTitle("Cmm Interpreter");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        try{
            UIManager.setLookAndFeel(UIManager.
                    getSystemLookAndFeelClassName());
        }
        catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> new Compiler().setVisible(true));
    }
}
