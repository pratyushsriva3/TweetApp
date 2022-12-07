package ps.uta.usecase;

import java.util.Scanner;

import ps.uta.Exception.PasswordException;
import ps.uta.Service.ForgotPasswordImplementation;

public class Password {
	
	Scanner sc = new Scanner(System.in);

	public static void forgotPassword() {
		
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter your Email ID");
			String emailId = sc.next();

			System.out.println("Enter your Old Password");
			String old_password = sc.next();

			Boolean result = new ForgotPasswordImplementation().checkEmailIdPassword(emailId, old_password);

			if (result == false) {
				System.out.println("\nInvalid Email Id Or Password");

				System.out.println("\nTry again... ");
				IntroMenu.userOnboardingAndLogin();
			}

			System.out.println("Enter your new password");
			String new_password = sc.next();
			
			System.out.println("Re-enter your new password");
			String re_enter_new_password = sc.next();
			
			if ( !new_password.equals(re_enter_new_password) ) {
				
				System.out.println("\n Password Don't match. Try Again..");

				System.out.println("\n Redirecting to introduction menu/ ");
				IntroMenu.userOnboardingAndLogin();
			}

			try {
				String res = new ForgotPasswordImplementation().updateUserPassword(emailId, new_password);
				System.out.println("\n" + res);

			} catch (PasswordException e) {
				// TODO Auto-generated catch block

				System.out.println(e.getMessage());

				System.out.println("\nTry again...");
				IntroMenu.userOnboardingAndLogin();
			}

			IntroMenu.userOnboardingAndLogin();

		} catch (PasswordException e) {

			System.out.println(e.getMessage());

			System.out.println("\nTry again...");
			IntroMenu.userOnboardingAndLogin();
		}
		IntroMenu.userOnboardingAndLogin();
		
	}
	
public static void resetPassword(String emailId) {
		
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter your Old Password");
			String old_password = sc.next();

			Boolean result = new ForgotPasswordImplementation().checkEmailIdPassword(emailId, old_password);

			if (result == false) {
				System.out.println("\nInvalid Password");

				System.out.println("\nTry again... ");
				MainMenu.menuList(emailId);
			}

			System.out.println("Enter your new password");
			String new_password = sc.next();
			
			System.out.println("Re-enter your new password");
			String re_enter_new_password = sc.next();
			
			if ( !new_password.equals(re_enter_new_password) ) {
				
				System.out.println("\n Password Don't match. Try Again..");

				System.out.println("\n Redirecting to main menu ");
				MainMenu.menuList(emailId);
			}

			try {
				String res = new ForgotPasswordImplementation().updateUserPassword(emailId, new_password);
				System.out.println("\n" + res);

			} catch (PasswordException e) {

				System.out.println(e.getMessage());

				System.out.println("\nTry again...");
				MainMenu.menuList(emailId);
			}

			MainMenu.menuList(emailId);

		} catch (PasswordException e) {

			System.out.println(e.getMessage());

			System.out.println("\nTry again...");
			MainMenu.menuList(emailId);
		}
		MainMenu.menuList(emailId);
		
	}

}
