package CustomerOp;

import DBConnection.dbmysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.util.Scanner; 

public class EditUserProfile {
		public void editProfile(int userId) {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Select the field to update"); 
			System.out.println("1. name");
			System.out.println("2. DOB");
			System.out.println("3. contact");
			System.out.println("4. gender");
			System.out.println("5. age");
//			System.out.println("6. username");
//			System.out.println("7. password");
			
			int choice = input.nextInt(); 
			String UpdateColumn; 
			input.nextLine(); 
			
			switch(choice) {
			case 1: 
				UpdateColumn = "name"; 
				break; 
			case 2 :
				UpdateColumn = "DOB";
				break; 
			case 3:
				UpdateColumn = "contact";
				break; 
			case 4: 
				UpdateColumn = "gender";
				break; 
			case 5: 
				UpdateColumn = "age";
				break; 
			default: 
				System.out.println("Please Enter a valid option"); 
				return; 
			}
			
			System.out.println("Enter value for update "); 
			String newValue = input.nextLine(); 
			
			Connection connection = dbmysql.getConnection(); 
			String updateQuery = "Update customer set "  + UpdateColumn + "1"; 
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery); 
//				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, newValue); 
				preparedStatement.setInt(2, userId); 
				
				int rowAffected = preparedStatement.executeUpdate(); 
				
				if(rowAffected > 0) {
					System.out.println("User Update is successfull"); 
				} else {
					System.out.println("Failed to user Information Update "); 
				}
				preparedStatement.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
}
