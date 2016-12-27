package ui;

/**
 * Created by pendragon on 16-12-18.
 */
public class Test {

    /**
     * 通过这个demo 可以明显区分 Editor 调用 Io 接口的效率跟 这里明显不一样
     * @param args
     */
    public static void main(String[] args) {
        IOWindow ioWindow = new IOWindow(null, "Console");
        for (int i = 0; i < 10000; i++){
            ioWindow.stdout(i + "\n");
        }
    }
}
