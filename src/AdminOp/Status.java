package AdminOp;

import java.util.Scanner;

public class Status {
	public void status(int adminId) {

	    
		Scanner input = new Scanner(System.in);
		
		int choice = input.nextInt(); 
		do {
		System.out.println("1. AppointmentManagement");
		System.out.println("2. EmployeeManagement");
		System.out.println("3. ServiceManagement");
		System.out.println("0. Exit");
		
		switch(choice) {
		case 1: 
			
			break; 
		case 2: 
			break; 
		case 3: 
			break; 
		case 0: 
			return; 
		default: 
			System.out.println("Please Enter a valid option");
			
		}
		
		} while(choice != 0); 
	
	}
}
