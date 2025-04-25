package com.pluralsight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {

        // Simply running the static method
        readingWriting();
    }

    // Making a static method
    public static void readingWriting() {
        try {

            // Will begin making the file and then reading every line
            FileReader fileBoi = new FileReader("src/main/resources/inventory.csv");
            BufferedReader buffReadBoi = new BufferedReader(fileBoi);
            // Then it will create a new file and prepare to write into it using the buffer reader
            FileWriter fileWriteBoi = new FileWriter("src/main/resources/inventory2.csv");
            BufferedWriter buffWriteBoi = new BufferedWriter(fileWriteBoi);
            // Made an array of the product class
            ArrayList<Product> productList = new ArrayList<>();
            // Using a while loop that will store every line that the buffer reader reads and splits it
            String yesLine;
            while ((yesLine = buffReadBoi.readLine()) != null) {

                String [] parts = yesLine.split("\\|");
                // This will then use an if statement that will verify if what it reads is equal to 3 in length
                // and then will parse it
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    // Creating a new object using the product class and then adding that to the list
                    Product product = new Product(id, name, price);
                    productList.add(product);
                }
            } // For each loop that will write a list of information based on the product list
            for (Product p : productList) {
                buffWriteBoi.write(p.getId() + "|" + p.getName() + "|" + p.getPrice());
                buffWriteBoi.newLine();
            }
            // Closing out the buffers
            buffWriteBoi.newLine();
            buffWriteBoi.close();
        // Getting the catch exceptions and getting it printed out
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

//    public static void main(String[] args) {
//        // Call the get inventory method to get our products
//        ArrayList<Product> inventory = getInventory();
//
//        // Starting up the scanner
//        Scanner scanner = new Scanner(System.in);
//
//        // Start user messaging
//        System.out.println("We carry the following inventory: ");
//        for (int i = 0; i < inventory.size(); i++) {
//            Product p = inventory.get(i);
//            System.out.printf("id: %d %s - Price: $%.2f\n",
//                    p.getId(), p.getName(), p.getPrice());
//        }
//    }
//
//    // Our getInventory method that create an array list of products and returns it
//    public static ArrayList<Product> getInventory() {
//
//
//        ArrayList<Product> inventory = new ArrayList<Product>();
//
//        // this method loads product objects into inventory // and its details are not shown
//        inventory.add(new Product(1,"cheese", 3.99f));
//        inventory.add(new Product(2,"hammer", 15.99f));
//        inventory.add(new Product(3,"camera", 55.99f));
//        inventory.add(new Product(4,"compooper", 399.99f));
//        inventory.add(new Product(5,"game", 69.99f));
//
//        return inventory;
//    }
//}
