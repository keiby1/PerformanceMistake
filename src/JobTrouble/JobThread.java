package JobTrouble;

import java.util.TimerTask;

public class JobThread extends TimerTask {
    @Override
    public void run() {
        System.out.println("runned!");
    }
}
