package com.pluralsight;

public class Employee {

    // Introducing the variables as private
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    // Making a constructor with parameters for all variables
    public Employee (int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Making getters and setters for all variables (only some are used but can change if the user wants to modify)
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public double getPayRate() { return payRate; }
    public void setPayRate(double payRate) { this.payRate = payRate; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    // Adding a gross pay getter that returns hours worked * pay rate
    public double getGrossPay() { return hoursWorked * payRate; }

}
