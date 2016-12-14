package io;

/**
 * Created by pendragon on 16-12-14.
 */
public class ConsoleIO implements IOInterface {

    @Override
    public String stdin() {
        return null;
    }

    @Override
    public void stdout(Object out) {
        System.out.println((String) out);
    }

    @Override
    public void stderr(Object out) {
        System.out.println("Error\n--------------------------------");
        System.out.println((String) out);
        System.out.println("-------------------------------------");
    }
}
