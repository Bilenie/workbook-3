package com.pluralsight;

import java.util.Scanner;

public class FamousQuotesApp {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Create a list that contain bible verses/quotes
        String[] quotes = {
                "I can do all things through Christ who strengthens me=>Philippians 4:13",

                "For I know the plans I have for you, declares the Lord=>Jeremiah 29:11",

                "The Lord is my shepherd; I shall not want=>Psalm 23:1",

                "Be still, and know that I am God=>Psalm 46:10",

                "With God all things are possible=>Matthew 19:26",

                "Faith can move mountains=>Matthew 17:20",

                "The joy of the Lord is your strength=>Nehemiah 8:10",

                "Love never fails.=>1 Corinthians 13:8",

                "God is within her, she will not fall=>Psalm 46:5",

                "Let your light shine=>Matthew 5:16"
        };

        boolean repeatChoiceLoop = true;
        while (repeatChoiceLoop) {
            //prompt user to choose number
            System.out.println(" Select a number between 1 and 10");

            //wrap the response from the user in try and catch to validate the code and throw exception to prevent error.
            try {
                int numbChoice = myScanner.nextInt();

                String theQuotesChoice = quotes[numbChoice - 1];
                System.out.println(theQuotesChoice);

            } catch (Exception e) {
                System.out.println("Invalid input, Please Try again!!!");
                myScanner.nextLine(); // Clear the invalid input
                continue;
            }
            myScanner.nextLine();// eat the line because we are going to transition from int to str

            //this repeat every step if the user select y
            System.out.println("Do you want to choose again? y/n");
            String repeatChoice = myScanner.nextLine();

            if (repeatChoice.equalsIgnoreCase("n")) {
                repeatChoiceLoop = false;
                System.out.println("Goodbye! Stay inspired.");
            }
        }

    }
}
