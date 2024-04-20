package playground;

import java.util.Date;

public class SetDateAsLongExample {
    public static void main(String[] args) {
        // Create a new Date object representing 30 June 2024
        Date date = new Date(9223372036854775807L);

        // Print out the date and time
        System.out.println(date);
    }
}

