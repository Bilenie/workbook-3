package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    //Scanner to accept user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Create empty list called inventory to put our product.
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());

        }
    }

    public static ArrayList<Product> getInventory() {
        //we're creating a new object called inventory that will contain a list of products.
        ArrayList<Product> inventory = new ArrayList<Product>();

        // this method loads product objects into inventory
        // and its details are not shown= we're also instantiating an object called product.
        //we add these products to the inventory list.
        //add that product to the inventory array list using inventory.add


        try {
            //open csv file
            FileReader myInventoryFile = new FileReader("src/main/resources/inventory.csv");//opening the file
            BufferedReader myBufferInventoryFile = new BufferedReader(myInventoryFile);//reading the file

            //create a loop //%n USE THIS TO PUT NEXT LINE
            String theLine;
            while ((theLine = myBufferInventoryFile.readLine()) != null) {
                //create a product by splitting the line on the |

                //created a product using the product class and pieces of the string .split("\\|")
                String[] inventoryDetailInfo = theLine.split("\\|");

                if (inventoryDetailInfo[0].equalsIgnoreCase("id")) {
                    continue;
                }
                int id = Integer.parseInt(inventoryDetailInfo[0]);
                String name = inventoryDetailInfo[1];
                float price = Float.parseFloat(inventoryDetailInfo[2]);


                //instantiate the product object and pass in argument.

                Product inventoryProduct = new Product(id, name, price);
                inventory.add(inventoryProduct);

            }
            //Close the buffer.
            myBufferInventoryFile.close();

        } catch (Exception e) {
            System.out.println("Error reading inventory file." + e.getMessage());
        }

        return inventory;

    }
}