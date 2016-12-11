package com.vergil.Utils;

import javax.swing.*;

/**
 * Created by vergil on 2016/12/11.
 */
public class EditorIO implements IOInterface {

    private JTextArea outputArea;

    public EditorIO(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    @Override
    public String input() {
        return JOptionPane.showInputDialog(null, "Please Input Here!");
    }

    @Override
    public void output(Object out) {
        outputArea.append(out.toString()+"\n");
    }
}
