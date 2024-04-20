package playground;

import java.util.Calendar;
import java.util.Date;

public class SetDateExample {
    public static void main(String[] args) {
        // Create a new Calendar object and set the date to 30 June 2024
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.MONTH, Calendar.JUNE);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        Date date = cal.getTime();
        System.out.println(date.getTime());

        // Print out the date
        System.out.println(cal.getTime());
    }
}
