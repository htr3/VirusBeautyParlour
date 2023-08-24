package AdminOp;

import java.util.Scanner;

public class AdminInterface {
		public void menu(int adminId) {
			Scanner input = new Scanner(System.in);
			
			int choice = -1; 
			
			do {
				
				System.out.println("1. show profiles"); 
				System.out.println("2. Management"); 
//				System.out.println("3. Login"); 
				System.out.println("0. exit"); 
				
				
				choice = input.nextInt(); 
				
				switch(choice) {
				case 1: 
					Profile  ap = new Profile(); 
					ap.profile(adminId);
					// show profile. 
					break; 
				case 2: 
					// management
					Management m = new Management();
					m.management(adminId);
					break; 
//				case 3: 
//					Login l = new Login(); 
//					l.login();
//					break; 
				
				case 0: 
					return; 
//					break; 
				default: 
					System.out.println("Please Enter a Valid Option "); 
					break; 
				}
				
			}while(choice != 0); 
			
			
		}
}
