package CustomerOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import DBConnection.dbmysql;

public class UserRegistration {
	private String username; 
	private String password; 
	private String name; 
	private String DOB; 
	private String contact; 
	private String gender; 
	private int age;
	
	Scanner input = new Scanner(System.in);
	public void registration() {
		
		System.out.println("Enter you Full name "); 
		this.name = input.nextLine(); 
		
		System.out.println("Enter your date of birth"); 
		this.DOB = input.nextLine(); 
		
		System.out.println("Enter your contact no. "); 
		this.contact = input.nextLine(); 
		
		System.out.println("Enter you age ");
		this.age = input.nextInt(); 
		
		System.out.println("Enter your gender"); 
		this.gender = input.nextLine(); 
		
		
		System.out.println("Create Username"); 
		this.username = input.nextLine(); 
		
		System.out.println("Enter your password"); 
		String temp = input.nextLine(); 
		
		System.out.println("Confurm your password"); 
		String temp1 = input.nextLine(); 
		
		if(temp1.equals(temp)) 
		{
			password = temp;  
		} else {
			System.out.println("password is not matched \n please try again"); 
			
		}
		// store this information into the db 
		
		 Connection connection = dbmysql.getConnection(); // Assuming you have a method to get the connection

	        // Prepare the SQL insert statement
	        String insertQuery = "INSERT INTO Customer (username, password, name, DOB, contact, gender, age) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try {
	            // Create a prepared statement
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            preparedStatement.setString(3, name);
	            preparedStatement.setString(4, DOB);
	            preparedStatement.setString(5, contact);
	            preparedStatement.setString(6, gender);
	            preparedStatement.setInt(7, age);

	            // Execute the insert statement
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("User registered successfully!");
	            } else {
	                System.out.println("User registration failed.");
	            }

	            // Close resources
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		System.out.println("You are successfully Registered"); 
		
		UserLogin user = new UserLogin(); 
		user.login(); 
		
		
	}
	
	
	

	
	
	
}
