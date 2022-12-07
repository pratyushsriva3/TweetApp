package ps.uta.usecase;

import java.util.Scanner;

import ps.uta.Model.User;

public class MainMenu {

	public static void menuList(String emailId) {
		
		//System.out.println("in main menu");
		System.out.println("\nChoose an options - ");
		System.out.println("1. Post a tweet\n" 
		                 + "2. View My Tweet\n" 
				         + "3. View all Tweet\r\n" 
		                 + "4. View all Users\r\n"
				         + "5. Reset Password\r\n" 
		                 + "6. Logout\r\n");

		System.out.println("\nEnter any number from above :");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			MainMenuUsecase.postNewTweet(emailId);
			break; 
		}
		case 2: {
			MainMenuUsecase.viewMyTweet(emailId);
			break;
		}
		case 3: {
			MainMenuUsecase.viewAllTweet(emailId);
			break;
		}
		case 4: {
			MainMenuUsecase.displayAllUsers(emailId);
			break;
		}
		case 5: {
			Password.resetPassword(emailId);
			break;
		}
		case 6: {
			Logout.logout(emailId);
			break;
		}
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			MainMenu.menuList(emailId);
		}
	}

}
