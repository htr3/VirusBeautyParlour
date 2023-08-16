package BeauticianOp;

import java.util.Scanner;

import CustomerOp.userInterface;

public class Login {

	public String username; 
	public String password; 
	public int choice = -1; 
	public void login() {
		Scanner input = new Scanner(System.in); 
		do {
		
		System.out.println("Enter your username");
		username = input.nextLine(); 
		System.out.println("Enter your password");
		password = input.nextLine(); 
		
		if(username.equals("vish") && password.equals("123")) {
			System.out.println("login successfull");
			BeauticianInterface b = new BeauticianInterface(); 
			b.menu(); 
		}else {
			System.out.println("Please Enter valid credential ");
			 
			
		}
		System.out.println("Enter '0' for exit otherwise another key ");
		 choice = input.nextInt(); 
		}while(choice !=0 ); 
	}

}
