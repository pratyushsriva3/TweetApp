package ps.uta.usecase;

import java.util.Scanner;

import ps.uta.Exception.UserLoginException;
import ps.uta.Model.User;
import ps.uta.Service.UserLoginLogoutImplementation;

public class Login {

	public static void userLogin() {
		
		//System.out.println("In Login");
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter User details -");
		System.out.println("Enter EmailId: ");
		String emailId = sc.next();

		System.out.println("Enter Password: ");
		String password = sc.next();	
		
		
		try {
			
			new UserLoginLogoutImplementation().userLogin(emailId, password);	
			
			System.out.println("\nWelcome! Login Successful...");
			MainMenu.menuList(emailId);
			

		} catch (UserLoginException e) {
			System.out.println(e.getMessage());			
			
			System.out.println("\nTry again...");
			IntroMenu.userOnboardingAndLogin();
		}
		
	}

}
