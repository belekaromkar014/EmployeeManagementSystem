package com.corejava.jdbc.project.employees;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try {
			while (true) {
				System.out.println("****************** Welcome To Employee Management System ******************");
				System.out.println("                   1. Add New Employee Record");
				System.out.println("                   2. Update Employee Record (City)");
				System.out.println("                   3. Update Employee Record (Age)");
				System.out.println("                   4. Update Employee Record (Post)");
				System.out.println("                   5. Update Employee Record (Salary)");
				System.out.println("                   6. Delete Employee Record");
				System.out.println("                   7. List of Employee with Their ID");
				System.out.println("                   8. Show Details of Perticular Employee");
				System.out.println("                   9. Show Details of All Employee");
				System.out.println("                   10. Exit");
				System.out.println();
				
				Scanner sc=new Scanner(System.in);
				System.out.print("Enter Your Choice: ");
				int choice = sc.nextInt();
				
				if (choice == 1) {
					Employees.insertRecord();
				}else if (choice == 2) {
					Employees.updateEmployeeCity();
				}else if (choice == 3) {
					Employees.updateEmployeeAge();
				}else if (choice == 4) {
					Employees.updateEmployeePost();
				}else if (choice == 5) {
					Employees.updateEmployeeSalary();
				}else if (choice == 6) {
					Employees.deleteRecord();
				}else if (choice == 7) {
					Employees.fletchEmpNameWithEmpID();
				}else if (choice == 8) {
					Employees.fletchPerticulatEmpRecord();
				}else if (choice == 9) {
					Employees.fletchAllEmploeeRecord();
				}else if (choice == 10) {
					System.out.println("Thank You for Visit");
					break;
				}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
