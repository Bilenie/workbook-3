package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculatorApp {
    static Scanner myScanner = new Scanner (System.in);
    public static void main(String[] args) {
        String employeesFile = "src/main/resources/employees.csv";
        try {
            //Prompt the user for input file name and to ask again by loop instead exiting the app.
            // Keep asking for valid employee file until found
            String theEmployeesFile = "";
            while (true) {
                System.out.print("Enter the name of the employee file to process (e.g., employees.csv):\n ");
                theEmployeesFile = myScanner.nextLine().trim();

                if (theEmployeesFile.equalsIgnoreCase("employees.csv")) {
                    break;
                } else {
                    System.out.println("File not found! Please check the name and try again.\n");
                }
            }
            // Prompt the user for output file name
            // Keep asking for valid employee file until provided with the correct file name.
            String outputFile = "";
            while (true) {
                System.out.print("Enter the name of the payroll file to create (e.g., payroll-April-2025.csv): ");
                outputFile = myScanner.nextLine().trim();
                if (!outputFile.isEmpty() && outputFile.endsWith(".csv")) {
                    break;
                } else {
                    System.out.println("Invalid file name. Make sure it ends with '.csv' and isn't empty.\n");
                }
            }
            FileReader employeesFileRead = new FileReader(employeesFile);
            BufferedReader bufferedFile = new BufferedReader(employeesFileRead);

            // create a BufferedWrite
            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFile);
            BufferedWriter newWrittenFile = new BufferedWriter(fileWriter);

            //  Write the header once =>got this from ChatGpt
            newWrittenFile.write("id|name|pay-rate\n");

            //create a loop
            String theLine;
            //read the file line by line if not empty
            while ((theLine = bufferedFile.readLine()) != null) {
                String[] employeeDetailInfo = theLine.split("\\|");
            //if the line start with id skip
                if (employeeDetailInfo[0].equalsIgnoreCase("id")) {
                    continue;
                }
                int id = Integer.parseInt(employeeDetailInfo[0]);
                String name = employeeDetailInfo[1];
                double hoursWorked = Double.parseDouble(employeeDetailInfo[2]);
                double payRate = Double.parseDouble(employeeDetailInfo[3]);

                //instantiate the payroll object and pass in argument.
                PayrollBlueprint payrollCalculator = new PayrollBlueprint(id, name, hoursWorked, payRate);
                System.out.printf("\nThe employee ID: %d\nThe employee name is: %s\nThe hours worked: %.2f\nThe pay rate is: $%.2f\n\n",
                        payrollCalculator.getId(),
                        payrollCalculator.getName(),
                        payrollCalculator.getHoursWorked(),
                        payrollCalculator.getPayRate());

                String newWrittenDetails = payrollCalculator.getId() + "|" + payrollCalculator.getName() + "|" + payrollCalculator.getGrossPay() + "\n";
                newWrittenFile.write(newWrittenDetails);

            }
            //Close the buffer(file)
            newWrittenFile.close();
            bufferedFile.close();

        } catch (Exception e) {
            System.out.println("File don't exist!!!" + e.getMessage());
        }
    }
}
