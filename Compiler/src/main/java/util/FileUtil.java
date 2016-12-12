package util;

import java.io.File;

/**
 * Created by pendragon on 16-12-3.
 */
public class FileUtil {

    @SuppressWarnings("all")
    public static boolean isDuplicate(File newFile, File dir){
        if (dir != null){
            for (File file : dir.listFiles()) {
                if (file.getName().equals(newFile.getName())){
                    System.out.println(file.getName() + " " + newFile.getName());
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException();
    }
}
