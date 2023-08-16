package CustomerOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DBConnection.dbmysql; // Import your DBConnection class here or wherever it's located

public class Appointment {
    public void bookAppointment(int beauticianId, int customerId, int serviceId) {
        Connection connection = dbmysql.getConnection(); // Get the database connection
        
        try {
            String insertQuery = "INSERT INTO Appointments (beautician_id1, customer_id1, appointment_date, service_id1, status) VALUES (?, ?, NOW(), ?, 'Scheduled')";
            
            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, beauticianId);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, serviceId);
            
            // Execute the query
            preparedStatement.executeUpdate();
            
            System.out.println("Appointment booked successfully!");
            
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

