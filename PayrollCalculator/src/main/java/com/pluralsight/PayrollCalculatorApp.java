package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculatorApp {
    public static void main(String[] args) {
        //we need to read .csv file
        //generate payroll info for each employee
        //use BufferedReader
        try {
            //we create a file reader to be able to read from the employees file
//            String theEmployeesFile = "employees.csv";
            FileReader employeesFile = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedFile = new BufferedReader(employeesFile);

            //create a loop
            String theLine;
            while((theLine = bufferedFile.readLine())!= null){
                String[] employeeDetailInfo = theLine.split("\\|");
                if(employeeDetailInfo[0].equals("id")){
                    continue;
                }
                int id = Integer.parseInt(employeeDetailInfo[0]);
                String name = employeeDetailInfo[1];
                double hoursWorked = Double.parseDouble(employeeDetailInfo[2]);
                double payRate = Double.parseDouble(employeeDetailInfo[3]);

                //instantiate the payroll object
                PayrollBlueprint payrollCalculator = new PayrollBlueprint(id,name,hoursWorked,payRate);
                System.out.printf("The employee ID: %d\nThe employee name is: %s\nThe hours worked: %.2f\nThe pay rate is: $%.2f\n\n",
                        payrollCalculator.getId(),
                        payrollCalculator.getName(),
                        payrollCalculator.getHoursWorked(),
                        payrollCalculator.getPayRate());
            }
            bufferedFile.close();
        } catch (Exception e) {
            System.out.println("File don't exist!!!"+ e.getMessage());
        }
    }
}
