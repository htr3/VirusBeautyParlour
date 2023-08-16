package AdminManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBConnection.dbmysql;

import java.util.Scanner;

public class AppointmentManagement {
		public void appointmentManagement(int adminId) {
			
			Scanner input = new Scanner(System.in);	
			
			int choice = -1; 
			
			do{
				
				System.out.println("1. edit appointment"); 
				System.out.println("2. view appointment"); 
				System.out.println("3. delete appointment"); 
				System.out.println("0. exti"); 
				
				choice = input.nextInt(); 
				
				switch(choice) {
				case 1:
					viewAllAppointments();
					break; 
				case 2: 
					editAppointment(20,"active", "updated" ); 
					break; 
				case 3: 
					deleteAppointment(1); 
					break; 
				case 0:
					return; 
					
				default: 
					System.out.println("Please Enter a Valid option"); 
				}
				
				
				
			}while(choice != 0); 
			
		}
		
		
		
		
	    public void viewAllAppointments() {
	        Connection connection = dbmysql.getConnection(); // Get the database connection
	        
	        try {
	            String query = "SELECT * FROM Appointments";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            System.out.println("All Appointments:");
	            System.out.println("-----------------");
	            
	            while (resultSet.next()) {
	                int appointmentId = resultSet.getInt("appointment_id");
	                int beauticianId = resultSet.getInt("beautician_id1");
	                int customerId = resultSet.getInt("customer_id1");
	                // ... other appointment details
	                
	                System.out.println("Appointment ID: " + appointmentId);
	                System.out.println("Beautician ID: " + beauticianId);
	                System.out.println("Customer ID: " + customerId);
	                // ... print other details
	                System.out.println("-----------------");
	            }
	            
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		
	    public void editAppointment(int appointmentId, String newStatus, String newNotes) {
	        Connection connection = dbmysql.getConnection(); // Get the database connection
	        
	        try {
	            String query = "UPDATE Appointments SET status = ?, notes = ? WHERE appointment_id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, newStatus);
	            preparedStatement.setString(2, newNotes);
	            preparedStatement.setInt(3, appointmentId);
	            
	            int rowsUpdated = preparedStatement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Appointment updated successfully.");
	            } else {
	                System.out.println("No appointment found with ID " + appointmentId);
	            }
	            
	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	        
	        	e.printStackTrace();
	        }
	    }
		
	    public void deleteAppointment(int appointmentId) {
	        Connection connection = dbmysql.getConnection(); // Get the database connection
	        
	        try {
	            String query = "DELETE FROM Appointments WHERE appointment_id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, appointmentId);
	            
	            int rowsDeleted = preparedStatement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Appointment deleted successfully.");
	            } else {
	                System.out.println("No appointment found with ID " + appointmentId);
	            }
	            
	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		
		
}
