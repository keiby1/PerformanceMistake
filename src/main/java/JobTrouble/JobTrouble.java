package JobTrouble;

import Utils.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JobTrouble {
    public static void main(String[] args) {
        int hour = 0, minutes = 43;
        int hour2 = 0, minutes2 = 44;
        TimerTask fetchMail = new JobThread();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(fetchMail, getTomorrowMorning4am(hour, minutes), fONCE_PER_DAY);
        TimerTask fetchMail2 = new JobThread();
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(fetchMail2, getTomorrowMorning4am(hour2, minutes2), fONCE_PER_DAY);
    }


    private final static long fONCE_PER_DAY = 1000 * 60 * 60 * 24;
    private final static int fONE_DAY = 0; //today

    private static Date getTomorrowMorning4am(int hour, int minutes) {
        Calendar tomorrow = new GregorianCalendar();
        tomorrow.add(Calendar.DATE, fONE_DAY);
        Calendar result = new GregorianCalendar(
                tomorrow.get(Calendar.YEAR),
                tomorrow.get(Calendar.MONTH),
                tomorrow.get(Calendar.DATE),
                hour,
                minutes
        );
        return result.getTime();
    }
}