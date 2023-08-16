package BeauticianOp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBConnection.dbmysql; 

public class Appointments {
    public void viewUpcomingAppointments(int beauticianId) {
        Connection connection = dbmysql.getConnection(); 
        
        try {
            String query = "SELECT * FROM Appointments WHERE beautician_id1 = ? AND status = 'Scheduled'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, beauticianId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            System.out.println("Upcoming Appointments:");
            System.out.println("----------------------");
            
            while (resultSet.next()) {
                int appointmentId = resultSet.getInt("appointment_id");
                int customerId = resultSet.getInt("customer_id1");
                String appointmentDate = resultSet.getString("appointment_date");
                int serviceId = resultSet.getInt("service_id1");
                String notes = resultSet.getString("notes");
                
                System.out.println("Appointment ID: " + appointmentId);
                System.out.println("Customer ID: " + customerId);
                System.out.println("Appointment Date: " + appointmentDate);
                System.out.println("Service ID: " + serviceId);
                System.out.println("Notes: " + notes);
                System.out.println("----------------------");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
