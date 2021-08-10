package Experiments;

public class BigString {
    public static void main(String[] args) {
        String oneMillionHello = "";
        for (int i = 0; i < 1000000; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }
    }
}
