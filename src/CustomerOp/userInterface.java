package CustomerOp;

import java.util.Scanner;

public class userInterface {
		 
	public void menu() {
		Scanner input = new Scanner(System.in);
		int choice = -1; 
		do{
			System.out.println("1. Edit User Profile ");
			System.out.println("2. services and Appointment ");
			System.out.println("3. Appointment history");
			System.out.println("0. exit"); 
			 
			choice = input.nextInt(); 
			
			switch(choice) {
			case 1: 
				EditUserProfile eup = new EditUserProfile(); 
				eup.editProfile(1);
				break; 
			case 2: 
				ServiceAppointment sa = new ServiceAppointment(); 
				sa.service(1);
				break; 
			case 3: 
				AppointmentHistory ah = new AppointmentHistory(); 
				ah.displayAppointmentHistory(1);
				break; 
			case 0:
			    break; 
			default : 
				System.out.println("Enter a valid option"); 
			}
			
			
		}while(choice !=0); 
	}
	
}
