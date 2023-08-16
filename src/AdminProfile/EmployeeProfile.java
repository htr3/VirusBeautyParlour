package AdminProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import DBConnection.dbmysql;

public class EmployeeProfile {
			public void employeeProfile() {

				Scanner input = new Scanner(System.in); 
				
					Connection connection = dbmysql.getConnection();
					
					try {
						String query = "SELECT * FROM Beautician"; 
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						
						ResultSet resultSet = preparedStatement.executeQuery(); 
						
						System.out.println("All Beautician Details "); 
						System.out.println("-------------------"); 
						
						while(resultSet.next()) {
							 int beauticianId = resultSet.getInt("beautician_id");
			                String username = resultSet.getString("username");
			                String fullName = resultSet.getString("full_name");
			                String email = resultSet.getString("email");
			                int adminId = resultSet.getInt("admin_id");
			                String phoneNumber = resultSet.getString("phone_number");
			                String hireDate = resultSet.getString("hire_date");
			                
			                System.out.println("Beautician ID: " + beauticianId);
			                System.out.println("Username: " + username);
			                System.out.println("Full Name: " + fullName);
			                System.out.println("Email: " + email);
			                System.out.println("Admin ID: " + adminId);
			                System.out.println("Phone Number: " + phoneNumber);
			                System.out.println("Hire Date: " + hireDate);
			                System.out.println("-------------------");
						}
						resultSet.close(); 
						preparedStatement.close(); 
						connection.close(); 
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("Do you want to see a specific user"); 
					System.out.println("if yes the type 'y' otherowise enter any key"); 
//					Scanner input = new Scanner(System.in);
					if(input.next().charAt(0) == 'y') {
						System.out.println("Enter beauticianId"); 
						int userId = input.nextInt(); 
						try {
							String query = "select * from Customer where Customer_id = ?"; 
							PreparedStatement preparedStatement = connection.prepareStatement(query);
							preparedStatement.setInt(1, userId);
							ResultSet resultSet = preparedStatement.executeQuery(); 
							
							System.out.println(" Details "); 
							System.out.println("-------------------"); 
							
							while(resultSet.next()) {
								 int beauticianId = resultSet.getInt("beautician_id");
				                String username = resultSet.getString("username");
				                String fullName = resultSet.getString("full_name");
				                String email = resultSet.getString("email");
				                int adminId = resultSet.getInt("admin_id");
				                String phoneNumber = resultSet.getString("phone_number");
				                String hireDate = resultSet.getString("hire_date");
				                
				                System.out.println("Beautician ID: " + beauticianId);
				                System.out.println("Username: " + username);
				                System.out.println("Full Name: " + fullName);
				                System.out.println("Email: " + email);
				                System.out.println("Admin ID: " + adminId);
				                System.out.println("Phone Number: " + phoneNumber);
				                System.out.println("Hire Date: " + hireDate);
				                System.out.println("-------------------");   
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				

}
