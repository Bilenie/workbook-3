package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedtimeStroriesApp {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //Create a variable to store the file
        String goldiLocks = "src/main/resources/goldilocks.txt";
        String hansel = "src/main/resources/hansel_and_gretel.txt";
        String mary = "src/main/resources/mary_had_a_little_lamb.txt";

        //Ask user to choose which book to read.
        boolean getStory = true;
        while (getStory) {
            try {
                System.out.println("Which book do you want to read?\nA) Goldilocks\nB) Hansel and Gretel\nC) Mary had a little Lamb\n(Choose => A ,B, or C )");//use printf

                //store the user choice in a variable.
                String storyFile = "";//Initializing the default story first is empty because nobody choose the option yet.
                String userStoryChoice = myScanner.nextLine().toUpperCase();
                //do switch to relate it to the user input and do something with the input.
                switch (userStoryChoice) {
                    case "A":
                        storyFile = goldiLocks;
                        break;
                    case "B":
                        storyFile = hansel;
                        break;
                    case "C":
                        storyFile = mary;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.\n");
                        continue;  // back to top of while
                }
                //Read the story file=>open the selected file
                FileInputStream storyStream = new FileInputStream(storyFile);//I was putting userChoice(which don't exist) here instead of story file creating error.
                Scanner fileScanner = new Scanner(storyStream);//since used the Scanner class as a static didn't need to mention Scanner here.But that was wrong need a separate Scanner for the file.

                //while loop to repeat reading from the file/Stories whenever there is a line =>borrowed the code from our instructor.
                //will print this statement
                System.out.println("\n--- Story Begins ---");

                int storyLine = 1;//Initializing where the line begin.
                while (fileScanner.hasNextLine()) {
                    //print out each line in the file
                    System.out.println(storyLine + ": " + fileScanner.nextLine());//change this code to fileScanner instead of myScanner.
                    storyLine++;
                }
                fileScanner.close();// Close file scanner only

                //Ask if user wants to read again
                System.out.println("\nDo you want to choose again? y/n");
                String readAnotherStory = myScanner.nextLine().trim();

                if (readAnotherStory.equalsIgnoreCase("n")) {
                    getStory = false;
                    System.out.println("Goodbye! see you next time!!!");
                }

            } catch (Exception e) {
                System.out.println("The file doesn't exist!!" + e.getMessage());
            }
        }

    }

}

// // Choose the file using if statement.
//                if (userStoryChoice.equals("A")) {
//                    storyFile = goldiLocks;
//                } else if (userStoryChoice.equals("B")) {
//                    storyFile = hansel;
//                } else if (userStoryChoice.equals("C")) {
//                    storyFile = mary;
//                } else {
//                    System.out.println("Invalid input, please enter A, B, or C!");
//                    continue; // go back to the top of the loop
//                }
