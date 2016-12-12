/*
编辑器方案：
RSyntaxTextArea
https://github.com/bobbylight/RText
 */

package com.vergil;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws Exception {
        try{
            UIManager.setLookAndFeel(UIManager.
                    getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.show();
    }
}
