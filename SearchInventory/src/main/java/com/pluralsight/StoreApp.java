package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    //Scanner to accept user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Create empty list called inventory to put our product and set it to our getInventory function.
        ArrayList<Product> inventory = getInventory();
        //Display this to the users
        System.out.println("We carry the following inventory: ");
        //list of product will be shown by using the loop to access each product from the arraylist.
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            //%n USE THIS TO PUT NEXT LINE=>display the product with its ID,Name, & price.
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
    //Create a method called getInventory.
    // this method loads product objects into inventory(new ArrayList)
    // and its details are not shown = we're also instantiating an object called inventoryProduct.
    //we add these products to the inventory list.
    public static ArrayList<Product> getInventory() {
        //we're creating a new object called inventory that will contain a list of products.
        ArrayList<Product> inventory = new ArrayList<>();
        try {
            //open csv file
            FileReader myInventoryFile = new FileReader("src/main/resources/inventory.csv");//opening the file
            BufferedReader myBufferInventoryFile = new BufferedReader(myInventoryFile);//reading the file

            //create a loop
            String theLine;
            while ((theLine = myBufferInventoryFile.readLine()) != null) {
                //created a product using the product class and pieces of the string .split("\\|")
                String[] inventoryDetailInfo = theLine.split("\\|");
                //If the line start with id skip it to read the next line.
                if (inventoryDetailInfo[0].equalsIgnoreCase("id")) {
                    continue;
                }
                int id = Integer.parseInt(inventoryDetailInfo[0]);
                String name = inventoryDetailInfo[1];
                float price = Float.parseFloat(inventoryDetailInfo[2]);

                //instantiate a new InventoryProduct object from product class and pass in argument.
                Product inventoryProduct = new Product(id, name, price);
                //add that product to the inventory array list using inventory.add
                inventory.add(inventoryProduct);
            }
            //Close the buffer.
            myBufferInventoryFile.close();
        } catch (Exception e) {
            System.out.print("Error reading inventory file." + e.getMessage());
        }
        return inventory;
    }
}