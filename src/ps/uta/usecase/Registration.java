package ps.uta.usecase;

import java.util.Scanner;

import ps.uta.Exception.UserRegisterException;
import ps.uta.Model.User;
import ps.uta.Service.UserRegistrationImplementation;

public class Registration {

	public static void userRegisterion() {
		
		System.out.println("\n=====================");
		System.out.println("  User Registration");
		System.out.println("=======================");
		
		UserRegistrationImplementation URegIrepo = new UserRegistrationImplementation();
		User userCreate = new User();
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter First name :");
		String firstname = sc.next();
		
		System.out.println("Enter Email ID : ");
		String email = sc.next();

		System.out.println("Enter Password : ");
		String password = sc.next();
		
		int status = 0;
		
		userCreate.setEmailId(email);
		userCreate.setFirstName(firstname);
		userCreate.setPassword(password);
		userCreate.setStatus(status);
		
		/*String result = URegIrepo.userRegistration(userCreate);
		System.out.println("\n" + result);
		System.out.println("Redirecting to Introduction menu for Login");
		IntroMenu.userOnboardingAndLogin();
		*/
		
		
		try {
			
			String result = URegIrepo.userRegistration(userCreate);
			
			System.out.println("\n" + result);
			System.out.println("Redirecting to Introduction menu for Login");
			IntroMenu.userOnboardingAndLogin();
			

		} catch (UserRegisterException e) {
			System.out.println(e.getMessage());			
			
			System.out.println("\nTry again...");
			IntroMenu.userOnboardingAndLogin();
		}
		
		
	}

}
