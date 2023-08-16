package AdminProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.dbmysql;

public class SelfProfile {
			public void selfProfile(int adminId) {
				Connection connection = dbmysql.getConnection(); 
				
				try {
					String query = "select * from Admins where admin_id = ?"; 
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, adminId);
					ResultSet resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
						int admin_id = resultSet.getInt("admin_id");
						String username = resultSet.getString("username");
						String full_name = resultSet.getString("full_name");
						String email = resultSet.getString("email");
						String phone_number = resultSet.getString("phone_number");
						
						System.out.println("Admin id " + admin_id);
						System.out.println("Admin id " + username);
						System.out.println("Admin id " + full_name);
						System.out.println("Admin id " + email);
						System.out.println("Admin id " + phone_number);
						
					}
					resultSet.close(); 
					preparedStatement.close(); 
					connection.close(); 
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	
	
	
}
