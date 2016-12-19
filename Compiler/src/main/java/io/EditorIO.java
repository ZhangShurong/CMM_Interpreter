package io;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Created by vergil on 2016/12/11.
 */
public class EditorIO implements IOInterface {

    private JTextPane outputArea;

    public EditorIO(JTextPane outputArea) {
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
        Document docs = outputArea.getDocument();//获得文本对象
        try {
            docs.insertString(docs.getLength(), out.toString(),null);//对文本进行追加
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        //outputArea.insertC(out.toString());
        outputArea.repaint();
        System.out.print(out.toString());
        System.out.flush();
    }
    public void stderr(Object out)
    {

        //outputArea.append(out.toString());
        Document docs = outputArea.getDocument();//获得文本对象
        try {
            docs.insertString(docs.getLength(), out.toString(),null);//对文本进行追加
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}
