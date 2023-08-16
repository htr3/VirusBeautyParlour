package start;

import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in); 
	
	public static void main(String[] args) {
		  int choice = -1; 
		  
		do { 
		 System.out.println("........................"); 
		  System.out.println("1. Admin"); 
		  System.out.println("2. Customer"); 
		  System.out.println("3. Beautician"); 
		  System.out.println("........................."); 
		  
		 
		  choice = input.nextInt();
		  
			  
			  switch(choice) {
			  case 1: 
				  // Admin 
				  System.out.println("you selected Admin"); 
				  Admin a = new Admin(); 
				  
				  break; 
			  case 2: 
				  // Customer
				  System.out.println("you selected Customer"); 
				  Customer c = new Customer(); 
				  c.customer();
				  break; 
			  case 3: 
				  // Beauticain 
				  System.out.println("you selected Beautician "); 
				  Beautician b = new Beautician(); 
				  break; 
			  case 0:
				  System.out.println("Thank you for Visiting........"); 
				  System.exit(0);
			  default : 
				  System.out.println("Please enter a valid option. "); 
			  }
			  
		  }while(choice != 0); 
		  
		  
		  
		
	}
	
}
