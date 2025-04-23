package com.pluralsight;

import java.io.FileInputStream;       // Imported the file input stream to read the text
import java.io.FileNotFoundException; // Imported to add to the catch in case the file isn't found
import java.util.Scanner;             // Imported the scanner to receive input

public class BedtimeStories {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        try { // Using a try since it is required for file validation
            System.out.print("\nWhat bedtime story would you like?" +
                    " \n(1) Goldilocks\n(2) Hansel & Gretel\n(3) Marry had a Little Lamb\nChoose 1,2 or 3. ");
            int storyPicked = input.nextInt(); // Storing the input as an integer

            String fileName = switch (storyPicked) { // Using the modern switch method to name
                case 1 -> "goldilocks.txt";          // the file based on the integer input
                case 2 -> "hansel_and_gretel.txt";
                case 3 -> "mary_had_a_little_lamb.txt";
                default -> null;
            };
            if (fileName == null) { // This is in case something else is entered and null will output a message
                System.out.println("Invalid input!");
            }
            System.out.println(); // Makes an extra space between the input and bedtime story

            FileInputStream fis = new FileInputStream("src/main/resources/" + fileName); // Opens the file
            Scanner fileScanner = new Scanner(fis); // The scanner inputs the files individual lines

            int lineNumber = 1; // Beginning the line number counter for the loop
            while (fileScanner.hasNextLine()) {  // Using .hasNextLine to confirm there is a next line
                System.out.println(lineNumber + ". " + fileScanner.nextLine());
                lineNumber++; // Adds one line every loop to keep going down
            }

        } catch (FileNotFoundException e) { // Failsafe method in case the file isn't found
            System.out.println("Bedtime story not found.");
        } catch (Exception e) { // In case anything else goes wrong this will catch it
            System.out.println("Invalid input!");
        }
    }
}
