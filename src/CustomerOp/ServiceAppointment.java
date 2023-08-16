package CustomerOp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import DBConnection.dbmysql; // Import your DBConnection class here or wherever it's located

public class ServiceAppointment {
	Scanner input = new Scanner(System.in); 
    public void service(int userId) {
        Connection connection = dbmysql.getConnection(); // Assuming you have a getConnection() method in your DBConnection class
        
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Services";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                String description = resultSet.getString("description");
                int duration = resultSet.getInt("duration_minutes");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                boolean availability = resultSet.getBoolean("availability");

                System.out.println("Service ID: " + serviceId);
                System.out.println("Service Name: " + serviceName);
                System.out.println("Description: " + description);
                System.out.println("Duration: " + duration + " minutes");
                System.out.println("Price: $" + price);
                System.out.println("Category: " + category);
                System.out.println("Availability: " + availability);
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Please Enter the ServiceID for appointment"); 
        int serviceId = input.nextInt(); 
        
        Appointment a = new Appointment(); 
        a.bookAppointment(1,1,1);
    }
    
    
   
    
    
    
}
