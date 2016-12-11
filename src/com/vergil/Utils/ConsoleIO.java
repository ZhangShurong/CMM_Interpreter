package com.vergil.Utils;

import java.util.Scanner;

/**
 * Created by vergil on 2016/12/11.
 */
public class ConsoleIO implements IOInterface {
    @Override
    public String input() {
        System.out.print("input here > ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            return scanner.nextLine();
        }
        return null;
    }

    @Override
    public void output(Object obj) {
        System.out.println(obj);
    }
}
