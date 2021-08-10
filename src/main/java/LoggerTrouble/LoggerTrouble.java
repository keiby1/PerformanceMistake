package LoggerTrouble;

import org.apache.log4j.Logger;

import java.util.Scanner;


public class LoggerTrouble {
    static final Logger logger = Logger.getLogger(LoggerTrouble.class);
    public static void main(String[] args) {
        System.out.println("Enter anyone for start");
        new Scanner(System.in).next();
        System.out.println("started");

        while (true){
            for (int i = 0; i < 10000; i++) {
                logger.trace("It's a TRACE");
            }
            for (int i = 0; i < 1000; i++) {
                logger.debug("DEBUGGGG");
            }
            for (int i = 0; i < 1000; i++) {
                logger.info("INFO log");
            }
            for (int i = 0; i < 100; i++) {
                logger.error("Some error");
            }
        }
    }
}
