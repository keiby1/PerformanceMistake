package ThreadTrouble;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
//        List<Thread> list = new LinkedList<>();
        System.out.println("Enter anyone for start");
        new Scanner(System.in).next();
        System.out.println("started");

        for (int i = 0; i < 10000; i++) {
            new CreaterTh().start(); //перебор... лучше такое не запускать
        }
    }
}
