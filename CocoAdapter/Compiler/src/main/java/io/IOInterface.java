package io;

/**
 * Created by pendragon on 16-12-3.
 */
public interface IOInterface {

    String stdin();
    void stdout(Object out);
    void stderr(Object out);
}