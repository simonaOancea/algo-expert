package playground;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToLong {
    public static void main(String[] args) {
        String dateString = "9999-12-31";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long milliseconds = date.getTime();
        System.out.println("Date string: " + dateString);
        System.out.println("Milliseconds since June 30, 2024: " + milliseconds);
        System.out.println(milliseconds);
    }
}
