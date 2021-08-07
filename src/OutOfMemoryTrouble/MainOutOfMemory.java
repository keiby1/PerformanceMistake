package OutOfMemoryTrouble;

import java.util.LinkedList;
import java.util.Scanner;

public class MainOutOfMemory {
    public static void main(String[] args) {
        new Scanner(System.in).next();
        System.out.println("started");
        LinkedList<MyObj> list=new LinkedList<>();;
        while (true){
            for (int j = 0; j < 1000000; j++) {
                MyObj obj = new MyObj();
                for (int k = 0; k < 1000000; k++) {
                    obj.list.add("asdasdasdsadasdsadsadsada");
                }
                list.add(obj);
            }
        }
    }
}

