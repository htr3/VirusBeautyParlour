package AdminOp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Connection;

import BeauticianOp.BeauticianInterface;
import DBConnection.dbmysql;

public class Login {


	public String username; 
	public String password; 
	public int choice = -1; 
	public void login() {



		
		
		 Scanner input = new Scanner(System.in);

	        try {
	            do {
	                System.out.println("Enter your username");
	                username = input.nextLine();
	                System.out.println("Enter your password");
	                password = input.nextLine();

	                
	                String query = "SELECT * FROM Admins WHERE username = ? AND password = ?";
	                Connection connection = dbmysql.getConnection();
	                PreparedStatement preparedStatement = connection.prepareStatement(query);
	                preparedStatement.setString(1, username);
	                preparedStatement.setString(2, password);
	                
	                ResultSet resultSet = preparedStatement.executeQuery();

	                if (resultSet.next()) {
	                	int adminId = resultSet.getInt("admin_id");
	                    System.out.println("Login successful");
	                    AdminInterface b = new AdminInterface(); 
	                    b.menu(adminId); 
	                } else {
	                    System.out.println("Please enter valid credentials");
	                }

	                System.out.println("Enter '0' to exit, otherwise enter another key");
	                try {
	           		 choice = input.nextInt();
	           	     } catch(InputMismatchException e) {
	           	    	 e.printStackTrace();
	           	     }
	                
	                connection.close();
	            } while (choice != 0);

	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		
	}



}
