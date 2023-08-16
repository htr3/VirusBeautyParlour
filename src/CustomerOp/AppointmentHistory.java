package CustomerOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import DBConnection.dbmysql; // Import your DBConnection class here or wherever it's located

public class AppointmentHistory {
    public void displayAppointmentHistory(int userId) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String query = "SELECT * FROM Appointments";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            System.out.println("Appointment History:");
            System.out.println("--------------------");
            
            while (resultSet.next()) {
                int appointmentId = resultSet.getInt("appointment_id");
                int beauticianId = resultSet.getInt("beautician_id1");
                int customerId = resultSet.getInt("customer_id1");
                Timestamp appointmentDate = resultSet.getTimestamp("appointment_date");
                int serviceId = resultSet.getInt("service_id1");
                String status = resultSet.getString("status");
                String notes = resultSet.getString("notes");
                
                System.out.println("Appointment ID: " + appointmentId);
                System.out.println("Beautician ID: " + beauticianId);
                System.out.println("Customer ID: " + customerId);
                System.out.println("Appointment Date: " + appointmentDate);
                System.out.println("Service ID: " + serviceId);
                System.out.println("Status: " + status);
                System.out.println("Notes: " + notes);
                System.out.println("--------------------");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
