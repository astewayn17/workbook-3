package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    // Starting up the date/time formatter and the scanner. The date time formatter is being considered in the
    // format pattern shown
    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Calling the logActions method that will "launch" when the search engine is running
        logActions("Launch");

        // Starting up the while loop that will work as long as the user searches up something. It will end
        // once the user selects x to exit
        boolean isRunning = true;
        while(isRunning) {

            System.out.println("Enter a search term (X to exit): ");
            String searchTerm = input.nextLine();
            if (searchTerm.equalsIgnoreCase("x")) {
                System.out.println("Have a nice life!");
                logActions("Exit");
                isRunning = false;
            } else {
                logActions("search: " + searchTerm);
            }
        }
    }

    // Making the logActions method that will be working in a try/catch.
    private static void logActions(String theAction) {
        try {

            // This will start up the file writer that will write the logs.txt and append over and over
            FileWriter fileOutBoi = new FileWriter("src/main/resources/logs.txt", true);
            // This will make the writing efficient by using the created txt file
            BufferedWriter buffOutBoi = new BufferedWriter(fileOutBoi);

            // Saying that timeStamp will be called as the current date and time
            LocalDateTime timeStamp = LocalDateTime.now();
            // Will write the formatted time and the action to the txt file
            buffOutBoi.write(timeStamp.format(timeStampFormatter) + " " + theAction);

            // Skips to a new line and closes out of the buffered writer
            buffOutBoi.newLine();
            buffOutBoi.close();

        // Catch that will tell you the error reason with e.getMessage
        } catch (Exception e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
