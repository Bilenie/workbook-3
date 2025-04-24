package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateLogApp {
    //Create formatter we need for the date=> tells it how it need to look for the date and time
    static DateTimeFormatter myTimeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM - dd  HH:mm:ss");

    //Create the scanner outside main and can be used by all method
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        //invoke the log action that take the actual value argument
        logAction("  Launch");

        // Variable for setting the condition of the loop for the questions til decided to exit.
        boolean appRunning = true;
        while (appRunning) {
            //display the question to the user
            System.out.println("Enter a search term (X to exit) :");

            //store the input from the user in a variable
            String inputSearchTerm = myScanner.nextLine();

            //do the negative thing first(you might not need an else) - to do the least amount of work first to make it simple for the mind
            if (inputSearchTerm.equalsIgnoreCase("X")) {
                System.out.println("Have a nice life");
                logAction("exit");
                appRunning = false;
            } else {
                //log the search term to the log file=> we did without the else but
                logAction("search :" + inputSearchTerm);
            }

        }

    }

    //Method that will create and maintain our log file => open a file, put something on the file,  produce a date stamp and take value and append.
    public static void logAction(String theAction) {

        //control statement when writing file we need try and catch/try and write to the file

        //allow us to try and write to the file
        try {
            //we need this to write to file
            //path where I want my file to be and ture is to append(make sure the previous instance stay) to the file not to overwrite to the file
            FileWriter myLogFile = new FileWriter("src/main/resources/logs.txt", true);//working with the file that doesn't exist
            //buffer gives us the ability to write to the myLogfile and more efficient
            BufferedWriter myBufferFile = new BufferedWriter(myLogFile);//allow us to pass content

            //create the current date and time
            LocalDateTime myTimeStamp = LocalDateTime.now();
            //creating /write our file/to the file and passed the format to our local date with space and passed the placeholder / parameter).
            myBufferFile.write(myTimeStamp.format(myTimeStampFormatter) + "" + theAction);

            //log it from top to bottom not left to right and need to close the buffer.If we want to write to the file we need to close the file
            myBufferFile.newLine();//make sure we have a new line in our file
            myBufferFile.close();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }
}
