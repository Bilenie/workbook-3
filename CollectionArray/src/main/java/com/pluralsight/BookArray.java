package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class BookArray {
    public static void main(String[] args) {
        Book[] theBooks = {
                new Book(1, "12345", "Ready Player 1"),
                new Book(2, "23456", "Jurassic Park"),
                new Book(3, "789254", "Alice in Wonderland"),
                new Book(4, "633578", "To Kill a Mocking Bird"),
                new Book(5, "99955585", "Ready Player 2")
        };
//books as an array list not a string but book
        ArrayList<Book> theBooksAgain = new ArrayList<Book>();//created empty list and add below

        theBooksAgain.add(new Book(1, "12345", "Ready Player 1"));
        theBooksAgain.add(new Book(2, "23456", "Jurassic Park"));
        theBooksAgain.add(new Book(3, "789254", "Alice in Wonderland"));
        theBooksAgain.add(new Book(4, "633578", "To Kill a Mocking Bird"));

        for(int i=0; i< theBooksAgain.size(); i++){
            System.out.println((i+1)+ ":" + theBooksAgain.get(i).getTitle());
        }
// Using ArrayList instead of regular array
        ArrayList<String> kids = new ArrayList<String>();
        //hey list add this to the list.
        kids.add("Billu");
        kids.add("Booye");
        kids.add("bee");

        System.out.println(kids);
        System.out.println(kids);
        //arrayName.sort,add,remove,get,set,size all the method to manipulate our ArrayList.
         Collections.sort(kids);//capitalization prioritize first


        for(int i=0; i< kids.size(); i++){
            System.out.println(kids.get(i));
             }

    }
}
