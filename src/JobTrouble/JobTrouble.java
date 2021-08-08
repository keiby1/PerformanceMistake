package JobTrouble;

import Utils.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JobTrouble {
    public static void main(String[] args) {
//        System.out.println("Enter anyone for start");
//        new Scanner(System.in).next();
//        System.out.println("started");
//
//        Calendar c = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c.set(Calendar.HOUR_OF_DAY, 0);
//        c.set(Calendar.MINUTE, 0);
//        c2.set(Calendar.HOUR_OF_DAY, 0);
//        c2.set(Calendar.MINUTE, 37);
//        Date d = c.getTime();
//        Date d2 = c2.getTime();
//
//
//        while (true) {
//
//            if (System.currentTimeMillis() > d.getTime() && System.currentTimeMillis() < d2.getTime()) {
//                System.out.println("now");
//            }
//
//            Util.sleep(1000);
//        }
        TimerTask fetchMail = new JobThread();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(fetchMail, getTomorrowMorning4am(), fONCE_PER_DAY);


    }



    private final static long fONCE_PER_DAY = 1000*60*60*24;

    private final static int fONE_DAY = 0; //today
    private final static int fFOUR_AM = 1;
    private final static int fZERO_MINUTES = 9;

    private static Date getTomorrowMorning4am(){
        Calendar tomorrow = new GregorianCalendar();
        tomorrow.add(Calendar.DATE, fONE_DAY);
        Calendar result = new GregorianCalendar(
                tomorrow.get(Calendar.YEAR),
                tomorrow.get(Calendar.MONTH),
                tomorrow.get(Calendar.DATE),
                fFOUR_AM,
                fZERO_MINUTES
        );
        return result.getTime();

    }



}