package AdminOp;

import java.util.Scanner;

import AdminProfile.CustomerProfile;
import AdminProfile.EmployeeProfile;
import AdminProfile.SelfProfile;

public class Profile {
		public void profile(int adminId) {

		    
			Scanner input = new Scanner(System.in);
			
			int choice = input.nextInt(); 
			do {
			System.out.println("1. Customer Profile");
			System.out.println("2. Employee Profile");
			System.out.println("3. Self Profile");
			System.out.println("0. Exit");
			
			switch(choice) {
			case 1: 
				CustomerProfile cp = new CustomerProfile(); 
				break; 
			case 2: 
				EmployeeProfile ep = new EmployeeProfile(); 
				break; 
			case 3: 
				SelfProfile sp = new SelfProfile(); 
				break; 
			case 0: 
				return; 
			default: 
				System.out.println("Please Enter a valid option");
				
			}
			
			} while(choice != 0); 
		
		}
}
