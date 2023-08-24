package AdminManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import DBConnection.dbmysql; 

public class EmployeeManagement {

	private String username; 
	private String fullName; 
	private String email; 
	private String phoneNumber; 
	private String hireDate; 
	private String role; 
	private String password; 
	private int adminId; 
	int beauticianId; 
	Scanner input = new Scanner(System.in);	
	public void beauticianManagement() {
		
		
		int choice = -1; 
		
		do{
			
			System.out.println("1. add Beautician"); 
			System.out.println("2. edit Beautician"); 
			System.out.println("3. show beautician");
			System.out.println("4. delete beautician"); 
			System.out.println("0. exti"); 
			
			choice = input.nextInt(); 
			
			switch(choice) {
			case 1:
				
				addBeautician();
				break; 
			case 2: 
				editBeautician(20,"active", "updated","12-12-12" ); 
				break; 
			case 3: 
				showAllBeauticians(); 
				break; 
			case 4: 
				deleteBeautician(adminId); 
			case 0:
				return; 
				
			default: 
				System.out.println("Please Enter a Valid option"); 
			}
			
			
			
		}while(choice != 0); 
		
	}
		
	
    public void addBeautician() {


		System.out.println("Enter username");
		username = input.nextLine();  
		System.out.println("fullName");
		fullName = input.nextLine(); 
		System.out.println("email");
		email = input.nextLine(); 
		System.out.println("phoneNumber");
		phoneNumber = input.nextLine(); 
		System.out.println("hireDate");
		hireDate = input.nextLine(); 
		System.out.println("role");
		role = input.nextLine(); 
		System.out.println("password");
		password = input.nextLine();  
		    	
    	Connection connection = dbmysql.getConnection(); 
        
        try {
            String query = "INSERT INTO Beautician (username, password, full_name, email, phone_number, hire_date, role, admin_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, fullName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, hireDate);
            preparedStatement.setString(7, role);
            preparedStatement.setInt(8, adminId);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Beautician added successfully.");
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editBeautician(int beauticianId, String email, String phoneNumber, String hireDate) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "UPDATE Beautician SET email = ?, phone_number = ?, hire_date = ? WHERE beautician_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, hireDate);
            preparedStatement.setInt(4, beauticianId);
            
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Beautician details updated successfully.");
            } else {
                System.out.println("No beautician found with ID " + beauticianId);
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showAllBeauticians() {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "SELECT * FROM Beautician";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            System.out.println("All Beauticians:");
            System.out.println("-----------------");
            
            while (resultSet.next()) {
                int beauticianId = resultSet.getInt("beautician_id");
                String username = resultSet.getString("username");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String hireDate = resultSet.getString("hire_date");
                String role = resultSet.getString("role");
                
                System.out.println("Beautician ID: " + beauticianId);
                System.out.println("Username: " + username);
                System.out.println("Full Name: " + fullName);
                System.out.println("Email: " + email);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Hire Date: " + hireDate);
                System.out.println("Role: " + role);
                System.out.println("-----------------");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void deleteBeautician(int beauticianId) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "DELETE FROM Beautician WHERE beautician_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, beauticianId);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Beautician deleted successfully.");
            } else {
                System.out.println("No beautician found with ID " + beauticianId);
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    
