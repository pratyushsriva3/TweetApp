package ps.uta.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntroMenu {

	public static void userOnboardingAndLogin() {
		
		Scanner sc = new Scanner(System.in);		
		System.out
				.println("\nChoose an options - \n" + "1. Register\n" + "2. Login\n" + "3. Forgot Password\n" + "4. Exit ");

		System.out.println("\nEnter any number from above: ");

		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			IntroMenu.userOnboardingAndLogin();
		}

		switch (choice) {
		case 1:
			Registration.userRegisterion();
			break;
		case 2:
			Login.userLogin();
			break;
		case 3:
			Password.forgotPassword();
			break;	
		case 4 :
			System.out.println("Thank you!");
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			IntroMenu.userOnboardingAndLogin();
		}
	}

}
