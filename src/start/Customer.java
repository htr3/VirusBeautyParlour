package start;

import java.util.Scanner;

import CustomerOp.UserLogin;
import CustomerOp.UserRegistration;

public class Customer {
		Scanner input = new Scanner(System.in); 
		
		public void customer() {
			  int choice = input.nextInt();
			  
				do { 
				 System.out.println("........................"); 
				  System.out.println("1. Registration"); 
				  System.out.println("2. Login "); 
				  System.out.println("0. Exit"); 
				  System.out.println("........................."); 
				  
				 
				  
				  
					  
					  switch(choice) {
					  case 1: 
						  // Registration
						  System.out.println("you are selected Registration"); 
						  UserRegistration ur = new UserRegistration(); 
						   ur.registration();
						  break; 
					  case 2: 
						  // Customer
						  System.out.println("you selected Login Option"); 
						  UserLogin ul = new UserLogin(); 
						  ul.login();
						  break; 
//					  case 3: 
//						  // Beauticain 
//						  System.out.println("you selected Beautician "); 
//						  Beautician b = new Beautician(); 
//						  break; 
					  case 0:
						  System.out.println("Thank you for Visiting........"); 
						  choice = 0; 
					  default : 
						  System.out.println("Please enter a valid option. "); 
					  }
					  
				  }while(choice != 0); 
				  
				  
				  
		}
		
	       
}
