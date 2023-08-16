package AdminManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import DBConnection.dbmysql; // Import your DBConnection class here or wherever it's located

public class ServiceManagement {
	
	public void serviceManagement() {
		

		Scanner input = new Scanner(System.in);	
		
		int choice = -1; 
		
		do{
			
			System.out.println("1. add service"); 
			System.out.println("2. edit service"); 
			System.out.println("3. show service");
			System.out.println("4. delete delete"); 
			System.out.println("0. exti"); 
			
			choice = input.nextInt(); 
			
			switch(choice) {
			case 1:
				addService("sdf", "sdf", 2,2, 20.22, "asdf", true);
				break; 
			case 2: 
				editService(20,20.22, true); 
				break; 
			case 3: 
				showAllServices(); 
				break; 
			case 4: 
				deleteService(1); 
			case 0:
				return; 
				
			default: 
				System.out.println("Please Enter a Valid option"); 
			}
			
			
			
		}while(choice != 0); 
		
	
		
		
		
		
	}
	
	
	
    public void addService(String serviceName, String description, int adminId, int durationMinutes, double price, String category, boolean availability) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "INSERT INTO Services (service_name, description, admin_id, duration_minutes, price, category, availability) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, serviceName);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, adminId);
            preparedStatement.setInt(4, durationMinutes);
            preparedStatement.setDouble(5, price);
            preparedStatement.setString(6, category);
            preparedStatement.setBoolean(7, availability);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Service added successfully.");
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editService(int serviceId, double newPrice, boolean newAvailability) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "UPDATE Services SET price = ?, availability = ? WHERE service_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setBoolean(2, newAvailability);
            preparedStatement.setInt(3, serviceId);
            
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Service details updated successfully.");
            } else {
                System.out.println("No service found with ID " + serviceId);
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showAllServices() {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "SELECT * FROM Services";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            System.out.println("All Services:");
            System.out.println("--------------");
            
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                boolean availability = resultSet.getBoolean("availability");
                
                System.out.println("Service ID: " + serviceId);
                System.out.println("Service Name: " + serviceName);
                System.out.println("Description: " + description);
                System.out.println("Price: $" + price);
                System.out.println("Availability: " + availability);
                System.out.println("--------------");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteService(int serviceId) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "DELETE FROM Services WHERE service_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, serviceId);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Service deleted successfully.");
            } else {
                System.out.println("No service found with ID " + serviceId);
            }
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
