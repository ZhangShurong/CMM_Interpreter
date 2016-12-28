package io;

import javax.swing.*;

/**
 * Created by pendragon on 16-12-14.
 */
public class ConsoleIO implements IOInterface {

    @Override
    public void close() {

    }

    @Override
    public String stdin(String tips) {
        return null;
    }

    @Override
    public String stdin() {
        return JOptionPane.showInputDialog("请输入");
    }

    @Override
    public void stdout(Object out) {
        System.out.println(out.toString());
    }

    @Override
    public void stderr(Object out) {
        System.out.println("Error\n--------------------------------");
        System.out.println(out.toString());
        System.out.println("-------------------------------------");
    }
}
