package com.pluralsight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class PayrollCalculator {

    public static void main(String[] args) {

        try {
            // Starting up the scanner
            Scanner input = new Scanner(System.in);

            // Requesting the user to input the employee file name that they want to view
            System.out.print("Enter the name of the employee file to process: ");
            String fileName = input.nextLine();

            // Requesting the user to input the file name of the one they want to create
            System.out.print("Enter the name of the payroll file to create: ");
            String outputFile = input.nextLine();

            // Making the file name into a variable
            // String fileName = "employees.csv";
            // String outputFile = "payroll-sept-2023.csv";

            // File reader named fileBoi will open the file and buffered reader named bufferBoi will read the file
            FileReader fileBoi = new FileReader("src/main/resources/" + fileName);
            BufferedReader bufferReaderBoi = new BufferedReader(fileBoi);

            // File writer named fileWriterBoi will create the output file and the bufferWriterBoi will write text into it
            FileWriter fileWriterBoi = new FileWriter("src/main/resources/" + outputFile);
            BufferedWriter bufferWriterBoi = new BufferedWriter(fileWriterBoi);

            // This will skip the first line
            bufferReaderBoi.readLine();

            // Printing out the first line format before the loop
            bufferWriterBoi.write("id|name|gross pay\n");

            // String theLine will record every line from the loop while also splitting the line by the pipe. Then I
            // created an employee object called theEmployee that will call to the constructor's parameters to make new
            // employee from the values read from the file.
            String theLine;
            while((theLine = bufferReaderBoi.readLine()) != null) {
                String[] employeeInfo = theLine.split("\\|");

                Employee theEmployee = new Employee(Integer.parseInt(employeeInfo[0]), employeeInfo[1],
                        Double.parseDouble(employeeInfo[2]),Double.parseDouble(employeeInfo[3]));

                System.out.printf("The employee ID is: %d, their name is: %s, and they earned a gross pay of $%.2f\n",
                        theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

                // The string lineForOutputFile will be the concatenated values and that will be written by the writer
                String lineForOutputFile = theEmployee.getEmployeeId() + "|" + theEmployee.getName() + "|" +
                        String.format("%.2f", theEmployee.getGrossPay()) +"\n";
                bufferWriterBoi.write(lineForOutputFile);
            }
            // Closing the buffered reader and writer
            bufferReaderBoi.close();
            bufferWriterBoi.close();
            input.close();

            // Catch method to print out errors in a built-in way
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
