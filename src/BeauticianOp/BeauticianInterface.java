package BeauticianOp;

import java.util.Scanner;

import start.Main;

public class BeauticianInterface {
	
	public void serviceDetail() {
		System.out.println("What are the services you handle"); 
	}
	 
	public void menu() {
		Scanner input = new Scanner(System.in);
		int choice = -1; 
		do{
			System.out.println("1. Show Profile");
			System.out.println("2. Customer Appointment");
			System.out.println("3. Service Details");
			System.out.println("0. exit"); 
			
			choice = input.nextInt(); 
			
			switch(choice) {
			case 1: 
				ShowProfile sp = new ShowProfile(); 
				sp.showProfile(1);
				break; 
			case 2: 
				Appointments appointments = new Appointments();
		        appointments.viewUpcomingAppointments(1);
				break; 
			case 3: 
				this.serviceDetail();
				break; 
			case 0:
			    return; 
			default : 
				System.out.println("Enter a valid option"); 
			}
		}while(choice !=0); 
	}
	


}
