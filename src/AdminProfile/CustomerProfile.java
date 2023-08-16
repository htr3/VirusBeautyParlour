package AdminProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import DBConnection.dbmysql;

public class CustomerProfile {
	Scanner input = new Scanner(System.in); 
	public void displayCustomerDetail() {
		Connection connection = dbmysql.getConnection();
		
		try {
			String query = "select * from Customer"; 
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			System.out.println("All Customer Details "); 
			System.out.println("-------------------"); 
			
			while(resultSet.next()) {
//				int customerId = resultSet.getInt("CustomerId"); 
				 int customerId = resultSet.getInt("CustomerId");
	                String username = resultSet.getString("username");
	                String name = resultSet.getString("name");
	                String dob = resultSet.getString("DOB");
	                int adminId = resultSet.getInt("admin_id");
	                String contact = resultSet.getString("contact");
	                String gender = resultSet.getString("gender");
	                int age = resultSet.getInt("age");
	                
	                System.out.println("Customer ID: " + customerId);
	                System.out.println("Username: " + username);
	                System.out.println("Name: " + name);
	                System.out.println("DOB: " + dob);
	                System.out.println("Admin ID: " + adminId);
	                System.out.println("Contact: " + contact);
	                System.out.println("Gender: " + gender);
	                System.out.println("Age: " + age);
	                System.out.println("---------------------");    
			}
			resultSet.close(); 
			preparedStatement.close(); 
			connection.close(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Do you want to see a specific user"); 
		System.out.println("if yes the type 'y' otherowise enter any key"); 
		Scanner input = new Scanner(System.in);
		if(input.next().charAt(0) == 'y') {
			System.out.println("Enter userId"); 
			int userId = input.nextInt(); 
			try {
				String query = "select * from Customer where Customer_id = userId"; 
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery(); 
				
				System.out.println("All Customer Details "); 
				System.out.println("-------------------"); 
				
				while(resultSet.next()) {
//					int customerId = resultSet.getInt("CustomerId"); 
					 int customerId = resultSet.getInt("CustomerId");
		                String username = resultSet.getString("username");
		                String name = resultSet.getString("name");
		                String dob = resultSet.getString("DOB");
		                int adminId = resultSet.getInt("admin_id");
		                String contact = resultSet.getString("contact");
		                String gender = resultSet.getString("gender");
		                int age = resultSet.getInt("age");
		                
		                System.out.println("Customer ID: " + customerId);
		                System.out.println("Username: " + username);
		                System.out.println("Name: " + name);
		                System.out.println("DOB: " + dob);
		                System.out.println("Admin ID: " + adminId);
		                System.out.println("Contact: " + contact);
		                System.out.println("Gender: " + gender);
		                System.out.println("Age: " + age);
		                System.out.println("---------------------");    
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
