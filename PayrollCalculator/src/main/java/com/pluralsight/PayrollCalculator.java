package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {

    public static void main(String[] args) {

        try {
            // Making the file name into a variable
            String fileName = "employees.csv";

            // File reader named fileBoi will open the file and buffered reader named bufferBoi will read the file
            FileReader fileBoi = new FileReader("src/main/resources/" + fileName);
            BufferedReader bufferBoi = new BufferedReader(fileBoi);

            // This will skip the first line
            bufferBoi.readLine();

            // String theLine will record every line from the loop while also splitting the line by the pipe. Then I
            // created an employee object called theEmployee that will call to the constructor's parameters to make new
            // employee from the values read from the file.
            String theLine;
            while((theLine = bufferBoi.readLine()) != null) {
                String[] employeeInfo = theLine.split("\\|");

                Employee theEmployee = new Employee(Integer.parseInt(employeeInfo[0]), employeeInfo[1],
                        Double.parseDouble(employeeInfo[2]),Double.parseDouble(employeeInfo[3]));

                System.out.printf("The employee ID is: %d, their name is: %s, and they earned a gross pay of $%.2f\n",
                        theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());
            }
            // Catch method to print out errors in a built-in way
        } catch (Exception e) { e.printStackTrace(); }
    }
}
