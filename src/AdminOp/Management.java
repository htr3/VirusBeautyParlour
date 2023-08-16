package AdminOp;

import java.util.Scanner;

import AdminManagement.AppointmentManagement;
import AdminManagement.EmployeeManagement;
import AdminManagement.ServiceManagement;

public class Management {
		public void management(int adminId) {
			    
			Scanner input = new Scanner(System.in);
			
			int choice = input.nextInt(); 
			do {
			System.out.println("1. AppointmentManagement");
			System.out.println("2. EmployeeManagement");
			System.out.println("3. ServiceManagement");
			System.out.println("0. Exit");
			
			switch(choice) {
			case 1: 
				AppointmentManagement am = new AppointmentManagement(); 
			    
				break; 
			case 2: 
				EmployeeManagement em = new EmployeeManagement(); 
				break; 
			case 3: 
				ServiceManagement sm = new ServiceManagement(); 
				break; 
			case 0: 
				return; 
			default: 
				System.out.println("Please Enter a valid option");
				
			}
			
			} while(choice != 0); 
		}
}
