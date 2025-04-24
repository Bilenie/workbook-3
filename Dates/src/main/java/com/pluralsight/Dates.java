package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("Today is: " + today);

        LocalTime currentTime = LocalTime.now();
        System.out.println("The current time is:\n " + currentTime);


        LocalDateTime todayTimeDate = LocalDateTime.now();
        System.out.println("Today is: \n"  + todayTimeDate + "\n");

//        LocalDateTime.now();

        System.out.println("Day of Week: " + todayTimeDate.getDayOfWeek());
        System.out.println("Day of Month: " + todayTimeDate.getDayOfMonth());
        System.out.println("Day of Year: " + todayTimeDate.getDayOfYear());
        System.out.println("Month Name: " + todayTimeDate.getMonth());
        System.out.println("Month Value: " + todayTimeDate.getMonthValue());
        System.out.println("Year: " +todayTimeDate.getYear());
        System.out.println("Year: " +todayTimeDate.getSecond());

        //SPLIT IT AND STORE IT IN STRING BUILDER

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("The format1: " + todayTimeDate.format(formatter1));

        String date1 = "2025-10-17";//must align with the default format
        LocalDate  actualDate = LocalDate.parse(date1);//change the string to actual date
        LocalDate  actualDateFormat = LocalDate.parse(date1,formatter1);//if we want to create our own format
        //pass the format we want to the date we convert.


    }


}
