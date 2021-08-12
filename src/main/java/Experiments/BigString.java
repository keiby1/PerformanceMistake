package Experiments;

public class BigString {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String oneMillionHello = "";
        for (int i = 0; i < 120000 ; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }

        System.out.println(System.currentTimeMillis()-start);

        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < 120000 ; i++) {
            sb.append("Hello!");
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
