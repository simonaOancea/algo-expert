package playground;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StringToDate {
    public static void main(String[] args) throws ParseException {
        Date creationDate = convertStringToDate("yyyy-MM-dd'T'HH", "2022_10_14T05:56:02.126972Z");
        //getTimeDifferenceInHours(creationDate);
        System.out.println(creationDate.toString());
        //System.out.println(getTimeDifferenceInHours(creationDate));

}

    public static Date convertStringToDate(final String dateFormat, final String stringDate) throws ParseException, ParseException {
        Date date = new SimpleDateFormat(dateFormat).parse(stringDate);

        return date;
    }

    public static long getTimeDifferenceInHours(final Date date) {
        Date currentDate = new Date(System.currentTimeMillis());
        long millisecondsDiff = currentDate.getTime() - date.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(millisecondsDiff);

        return hours;
    }



}
