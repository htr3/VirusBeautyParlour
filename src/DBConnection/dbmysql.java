//package DBConnection;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MySqlConnectionExample {
//    public static void main(String[] args) {
//        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
//        String username = "vishalth115";
//        String password = "1234";
//
//        try {
//            // Register the JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // Establish the connection
//            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//
//            // Now you can work with the database using the connection
//
//            // Don't forget to close the connection when you're done
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
////	public static Connection getConnection() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}


package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbmysql {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/beautyparlour";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection getConnection() {
    //public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            //System.out.println("Connection done"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}




