package ThreadTrouble;

public class MyThread extends Thread{
    @Override
    public void run(){
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
