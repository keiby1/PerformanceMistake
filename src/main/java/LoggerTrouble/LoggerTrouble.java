package LoggerTrouble;

import org.apache.log4j.Logger;

import java.util.Scanner;


public class LoggerTrouble {
    static final Logger logger = Logger.getLogger(LoggerTrouble.class);

    public static void main(String[] args) {
        System.out.println("Enter anyone for start");
        new Scanner(System.in).next();
        System.out.println("started");

        for (int i = 0; i < 300; i++) {
            new LogThread().start();
        }
    }
}
