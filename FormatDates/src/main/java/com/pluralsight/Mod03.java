package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mod03 {

    public static void main(String[] args) {

        //Current Date,Time, and their format
        //E, MMM dd, yyyy HH:mm:ss

        LocalDateTime currentTimeDate = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMMM d,yyyy");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE MMM d,yyyy HH:mm");

        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");

        //Display the result of the combination

        System.out.println(currentTimeDate.format(formatter1));
        System.out.println(currentTimeDate.format(formatter2));
        System.out.println(currentTimeDate.format(formatter3));
        System.out.println(currentTimeDate.format(formatter4));
        System.out.println(currentTimeDate.format(formatter5));

    }
}
