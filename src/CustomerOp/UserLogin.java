package CustomerOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import DBConnection.dbmysql;

public class UserLogin {
	public String username; 
	public String password; 
	public int choice = -1; 
	public void login() {
//		Scanner input = new Scanner(System.in); 
//		do {
//		
//		System.out.println("Enter your username");
//		username = input.nextLine(); 
//		System.out.println("Enter your password");
//		password = input.nextLine(); 
//		
//		if(username.equals("vish") && password.equals("123")) {
//			System.out.println("login successfull");
//			userInterface u = new userInterface(); 
//			u.menu(); 
//		}else {
//			System.out.println("Please Enter valid credential ");
//			 
//			
//		}
//		System.out.println("Enter '0' for exit otherwise another key ");
//	     try {
//		 choice = input.nextInt();
//	     } catch(InputMismatchException e) {
//	    	 e.printStackTrace();
//	     }
//		}while(choice !=0 );
		
		
		 Scanner input = new Scanner(System.in);

	        try {
//	            // Connect to the MySQL database
//	            String url = "jdbc:mysql://localhost:3306/your_database_name";
//	            String user = "your_username";
//	            String password = "your_password";
	        	Connection connection = dbmysql.getConnection();

	            do {
	                System.out.println("Enter your username");
	                username = input.nextLine();
	                System.out.println("Enter your password");
	                password = input.nextLine();

	                
	                String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";
	                PreparedStatement preparedStatement = connection.prepareStatement(query);
	                preparedStatement.setString(1, username);
	                preparedStatement.setString(2, password);
	                
	                ResultSet resultSet = preparedStatement.executeQuery();

	                if (resultSet.next()) {
	                	int customerId = resultSet.getInt("customer_id");
	                    System.out.println("Login successful");
	                    userInterface u = new userInterface();
	                    u.menu(customerId);
	                } else {
	                    System.out.println("Please enter valid credentials");
	                }

	                System.out.println("Enter '0' to exit, otherwise enter another key");
	                try {
	           		 choice = input.nextInt();
	           	     } catch(InputMismatchException e) {
	           	    	 e.printStackTrace();
	           	     }
	                
//	                choice = input.nextInt();
	            } while (choice != 0);

	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		
	}
	
	
	
	
}
