package com.corejava.jdbc.project.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Employees {
	
	public static Connection createConnection () throws ClassNotFoundException, SQLException {
		
		//Load and Register Driver Class
		Class.forName("com.mysql.jdbc.Driver");
		
		//Establish Connection Between Java Application and Database
		String url = "jdbc:mysql://localhost:3306/tcs";
		String password = "root";
		String username = "root";
		
		Connection con = DriverManager.getConnection(url, password, username);
		return con;
	}
	
	public static void createTable () throws ClassNotFoundException, SQLException {
		String query = "create table employee (sr_no int not null, emp_id int, emp_name text, emp_age int, emp_city text, emp_post text, emp_salary double, primary key (sr_no))";
		
		Connection con = createConnection();
		
		//Create Statement object
		Statement stm = con.createStatement();
		int num = stm.executeUpdate(query);
		
		System.out.println(num + " rows are affected");
		System.out.println("Table created successfully");
		
		con.close();
	}
	
	public static void insertRecord () throws ClassNotFoundException, SQLException {
		String query = "insert into employee values (?,?,?,?,?,?,?)";
		
		Connection con= createConnection();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Sr No");
		int srNo=sc.nextInt();
		System.out.println("Enter Employee ID");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc.next();
		System.out.println("Enter Age of Employee");
		int age=sc.nextInt();
		System.out.println("Enter City");
		String city=sc.next();
		System.out.println("Enter Employee Post");
		String post=sc.next();
		System.out.println("Enter Employee Salary");
		double salary=sc.nextDouble();
		
		//Creating PreparedStatement object
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, srNo);
		ps.setInt(2, id);
		ps.setString(3, name);
		ps.setInt(4, age);
		ps.setString(5, city);
		ps.setString(6, post);
		ps.setDouble(7, salary);
		
		int num = ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record added successfully");
		con.close();
		ps.close();
	}
	
	public static void updateEmployeeCity () throws ClassNotFoundException, SQLException {
		String query = "update employee set emp_city=? where emp_name=?";
		
		Connection con = createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Updated Employee city");
		String city=sc.next();
		System.out.println("Enter Employee Name Whos wanted to change");
		String name=sc.next();
		
		//creating preparedStatement object
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, city);
		ps.setString(2, name);
		int num = ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record updated successfully");
		con.close();
		ps.close();
	}
	
	public static void updateEmployeeAge () throws ClassNotFoundException, SQLException {
        String query = "update employee set emp_age=? where emp_name=?";
		
		Connection con = createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Updated Employee age");
		int age=sc.nextInt();
		System.out.println("Enter Employee Name Whos wanted to change");
		String name=sc.next();
		
		//creating preparedStatement object
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, age);
		ps.setString(2, name);
		int num = ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record updated successfully");
		con.close();
		ps.close();
	}
	
	public static void updateEmployeePost () throws ClassNotFoundException, SQLException {
        String query = "update employee set emp_post=? where emp_name=?";
		
		Connection con = createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Updated Employee Post");
		String post=sc.next();
		System.out.println("Enter Employee Name Whos wanted to change");
		String name=sc.next();
		
		//creating preparedStatement object
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, post);
		ps.setString(2, name);
		int num = ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record updated successfully");
		con.close();
		ps.close();
	}
	
	public static void updateEmployeeSalary () throws ClassNotFoundException, SQLException {
        String query = "update employee set emp_salary=? where emp_name=?";
		
		Connection con = createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Updated Employee Salary");
		double salary=sc.nextDouble();
		System.out.println("Enter Employee Name Whos wanted to change");
		String name=sc.next();
		
		//creating preparedStatement object
		PreparedStatement ps = con.prepareStatement(query);
		ps.setDouble(1, salary);
		ps.setString(2, name);
		int num = ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record updated successfully");
		con.close();
		ps.close();
	}
	
	public static void deleteRecord () throws ClassNotFoundException, SQLException {
		String query = "delete from employee where emp_name=?";
		
		Connection con = createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name Whos record want to delete");
		String name=sc.next();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		int num=ps.executeUpdate();
		System.out.println(num + " rows are affected");
		System.out.println("Record deleted successfully");
		con.close();
		ps.close();
	}
	
	public static void fletchPerticulatEmpRecord () throws SQLException, ClassNotFoundException {
		String query = "select * from employee where emp_name=?";
		
		Connection con = createConnection();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emploee Name Whos Record You Want");
		String name=sc.next();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		
		ResultSet res = ps.executeQuery();
		
		while (res.next()) {
			System.out.println("Sr. No: " + res.getInt("sr_no"));
			System.out.println("Employee ID: " + res.getInt("emp_id"));
			System.out.println("Employee Name: " + res.getString("emp_name"));
			System.out.println("Employee Age: " + res.getInt("emp_age"));
			System.out.println("Employee City: " + res.getString("emp_city"));
			System.out.println("Employee Post: " + res.getString("emp_post"));
			System.out.println("Employee Salary: " + res.getDouble("emp_salary"));
			System.out.println();
		}
		
		con.close();
		ps.close();
	}
	
	public static void fletchEmpNameWithEmpID () throws ClassNotFoundException, SQLException {
		String query = "select emp_name, emp_id from employee";
		
		Connection con = createConnection();
		
		Statement stm = con.createStatement();
		ResultSet res = stm.executeQuery(query);
		
		while (res.next()) {
			System.out.println("Employee name: "+ res.getString("emp_name"));
			System.out.println("Employee ID: "+ res.getInt("emp_id"));
			System.out.println();
		}
		con.close();
		stm.close();
	}
	
	public static void fletchAllEmploeeRecord () throws ClassNotFoundException, SQLException {
		String query = "select * from employee";
		
		Connection con = createConnection();
		
		Statement stm = con.createStatement();
		ResultSet res = stm.executeQuery(query);
		
		while (res.next()) {
			System.out.println("Sr. No: " + res.getInt("sr_no"));
			System.out.println("Employee ID: " + res.getInt("emp_id"));
			System.out.println("Employee Name: " + res.getString("emp_name"));
			System.out.println("Employee Age: " + res.getInt("emp_age"));
			System.out.println("Employee City: " + res.getString("emp_city"));
			System.out.println("Employee Post: " + res.getString("emp_post"));
			System.out.println("Employee Salary: " + res.getDouble("emp_salary"));
			System.out.println("*************************************************************");
			System.out.println();
		}
		con.close();
		stm.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
