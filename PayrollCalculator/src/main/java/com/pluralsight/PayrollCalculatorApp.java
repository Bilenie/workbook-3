package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculatorApp {
    static Scanner myScanner = new Scanner (System.in);
    public static void main(String[] args) {
        //we need to read .csv file
        //generate payroll info for each employee.
        //use BufferedReader
        try {
            //we create a file reader to be able to read from the employees file= the scanner add
//            String theEmployeesFile = "employees.csv";
//            String outputFile = "payroll-April-2025.csv";

            //Prompt the user for input file name
            System.out.println("Enter the name of the file employee file to process (e.g., employees.csv):");
            String theEmployeesFile = myScanner.nextLine().trim();
            //if(theEmployeesFile.isEmpty())will do condition to create a validation
            //And to ask again by loop instead exiting the app.

            // Prompt the user for output file name
            System.out.print("Enter the name of the payroll file to create (e.g., payroll-April-2025.csv):\n ");
            String outputFile = myScanner.nextLine().trim();

            FileReader employeesFile = new FileReader("src/main/resources/" + theEmployeesFile);
            BufferedReader bufferedFile = new BufferedReader(employeesFile);

            // create a BufferedWrite
            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFile);
            BufferedWriter newWrittenFile = new BufferedWriter(fileWriter);

            //  Write the header once =>got this from ChatGpt
            newWrittenFile.write("id|name|pay-rate\n");

            //create a loop
            String theLine;
            while ((theLine = bufferedFile.readLine()) != null) {
                String[] employeeDetailInfo = theLine.split("\\|");
                //the same as using Reader.Readline
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
