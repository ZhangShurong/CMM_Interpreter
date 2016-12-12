package ui;

import util.FileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by pendragon on 16-12-3.
 */
public class Compiler extends JFrame {
    public static final String APP_NAME = "Text Editor Demo";

    private TextEditor textEditor;
    private JFileChooser fileChooser = new JFileChooser();

    public Compiler(){
        CompilerMenu menuBar = new CompilerMenu();

        textEditor = new TextEditor();

        //file operation
        menuBar.addMenuFileListener(new MenuInterface.MenuFileListener() {
            @Override
            public void setNewFileListener(ActionEvent event) {
                textEditor.textArea.setText(null);
            }

            @Override
            public void setOpenFileListener(ActionEvent event) {
                int i = fileChooser.showOpenDialog(Compiler.this);
                if (i == JFileChooser.APPROVE_OPTION) {
                    File f = fileChooser.getSelectedFile();
                    try {
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

            }

            @Override
            public void setDebugListener(ActionEvent event) {

            }
        });

        //about info
        menuBar.addMenuHelpListener(new MenuInterface.MenuHelpListener() {
            @Override
            public void setAboutListener(ActionEvent event) {

            }
        });

        //ui relative
        setMenuBar(menuBar);
        setContentPane(textEditor);
        setTitle("Text Editor Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(() -> new Compiler().setVisible(true));
    }
}
