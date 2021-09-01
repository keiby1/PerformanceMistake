package OtherLoggerTrouble;

import LoggerTrouble.LogThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LoggerTrouble2 {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTrouble2.class);

    public static void main(String[] args) {
        logger.error("Some error");

        System.out.println("Enter anyone for start");
        new Scanner(System.in).next();
        System.out.println("started");

        for (int i = 0; i < 300; i++) {
            new LogThread2().start();
        }
    }
}
