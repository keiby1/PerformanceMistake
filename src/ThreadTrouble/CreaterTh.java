package ThreadTrouble;

import java.util.LinkedList;

public class CreaterTh extends Thread {

    @Override
    public void run(){
        LinkedList<Thread> list = new LinkedList<>();
        while(true){
            MyThread th = new MyThread();
            th.start();
            list.add(th);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
