package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {

    public static void main(String[] args) {

        // Saying dateTime is the same as the current time right now
        LocalDateTime dateTime = LocalDateTime.now();

        // Reformatting the time to a different style and printing that out multiple times
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(format1));
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dateTime.format(format2));
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(dateTime.format(format3));
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(dateTime.format(format4));

//        System.out.println(dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth() + "/" + dateTime.getYear());
//        System.out.println(dateTime.getYear() + "-" + dateTime.getMonthValue() + "-" + dateTime.getDayOfMonth());
    }
}
