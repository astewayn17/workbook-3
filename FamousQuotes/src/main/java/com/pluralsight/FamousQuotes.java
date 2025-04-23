package com.pluralsight;
import java.util.InputMismatchException;  // Imports the mismatch exception for the catch ------------------------------
import java.util.Scanner;
public class FamousQuotes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // String titles 'quotes' with 10 quotes in it -----------------------------------------------------------------
        String[] quotes = {
                "\"The unexamined life is not worth living.\" – Socrates",
                "\"Do what you can, with what you have, where you are.\" – Theodore Roosevelt",
                "\"Life is what happens when you're busy making other plans.\" – John Lennon",
                "\"Fall seven times, stand up eight.\" – Japanese Proverb",
                "\"What you do makes a difference.\" – Jane Goodall",
                "\"We are what we repeatedly do.\" – Aristotle",
                "\"Simplicity is the ultimate sophistication.\" – Leonardo da Vinci",
                "\"Knowing yourself is the beginning of all wisdom.\" – Aristotle",
                "\"In the middle of difficulty lies opportunity.\" – Albert Einstein",
                "\"To thine own self be true.\" – William Shakespeare"
        };

        // Using the boolean 'wisdom' as false and using that for the while loop argument ------------------------------
        boolean wisdom = false;
        while (!wisdom) {
            try {  // Introducing the try to attempt the following
                System.out.print("\nPlease enter a number from 1 to 10. ");
                int numberChosen = input.nextInt();
                input.nextLine(); // Consumes the next line
                System.out.println("\n" + quotes[numberChosen - 1]); // Taking the element vs number
                // into account when requesting the quote since elements are numbered starting with 0

                System.out.print("\nWould you like to see another quote? (Y/N) ");
                char answerForAnotherQuote = input.nextLine().trim().toUpperCase().charAt(0); // Stores the Y or N
                // answer and forces it uppercase and considers the first element along with removing outside spaces

                if (answerForAnotherQuote == 'Y') { // Needed to continue the operation. 'Continue' is redundant

                } else if (answerForAnotherQuote == 'N') {
                    wisdom = true; // If answer is N, closes the loop since wisdom is now true
                }
                else {  // Closes the loop. Must be run again
                    System.out.println("Invalid input.");
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                // Catches any improper inputs from the try phase and uses mismatch exception to print out a statement
                System.out.println("Invalid input. Try again.");
                input.nextLine();
            }
        }
        System.out.println("\nEnjoy your enlightenment!");  // Closing statement when the loop is exited
    }
}