package BeauticianOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBConnection.dbmysql; // Import your DBConnection class here or wherever it's located

public class ShowProfile {
    public void showProfile(int beauticianId) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "SELECT * FROM Beautician WHERE beautician_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, beauticianId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
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
            } else {
                System.out.println("Beautician not found.");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
