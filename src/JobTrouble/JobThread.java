package JobTrouble;

import java.util.TimerTask;

public class JobThread extends TimerTask {
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    for (int l = 0; l < 100; l++) {
                        Long lon = (long) (i * j * k * l);
                        System.out.println("i = " + i + " j = " + j + " k = " + k + " l = " + l);
                    }
                }
            }
        }
        System.out.println("end!");
    }
}
