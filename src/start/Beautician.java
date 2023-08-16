package start;

import java.util.Scanner;

import BeauticianOp.Appointments;
import BeauticianOp.ServiceDetails;
import BeauticianOp.ShowProfile;
import CustomerOp.UserLogin;
import CustomerOp.UserRegistration;

public class Beautician {
	
	Scanner input = new Scanner(System.in); 
	public void beautician() {

		   int choice = -1; 
		  
			do { 
			 System.out.println("........................"); 
			  System.out.println("1. Appointments"); 
			  System.out.println("2. Service Details");
			  System.out.println("3. Show profile "); 
			  System.out.println("0. Exit"); 
			  System.out.println("........................."); 
			  
			   choice = input.nextInt(); 
			  
			  
				  
				  switch(choice) {
				  case 1: 
					  // Registration
//					  System.out.println("you are selected Registration"); 
					  Appointments a = new Appointments(); 
					   a.viewUpcomingAppointments(1); 
					  break; 
				  case 2: 
					  // Customer
//					  System.out.println("you selected Login Option"); 
					  ServiceDetails ul = new ServiceDetails(); 
					  ul.serviceDetail(1);
					  break; 
				  case 3: 
					  // Beauticain 
//					  System.out.println("you selected Beautician "); 
					  ShowProfile b = new ShowProfile(); 
					  b.showProfile(1);
					  break; 
				  case 0:
					  System.out.println("Thank you for Visiting........"); 
					  choice = 0; 
					  return; 
				  default : 
					  System.out.println("Please enter a valid option. "); 
				  }
				  
			  }while(choice != 0); 
	}
	
	
}
