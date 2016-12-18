package io;

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
    public String stdin(String tips) {
        return null;
    }

    public  String stdin()
    {
        return null;
    }

    public void stdout(Object out)
    {
        outputArea.append(out.toString());
    }
    public void stderr(Object out)
    {
        outputArea.append(out.toString());
    }

}
