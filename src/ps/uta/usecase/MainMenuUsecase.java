package ps.uta.usecase;

import java.util.List;
import java.util.Scanner;

import ps.uta.Exception.TweetException;
import ps.uta.Model.Tweets;
import ps.uta.Model.User;
import ps.uta.Service.TweetImplementation;

public class MainMenuUsecase {

	public static void postNewTweet(String emailId) {
		
		//System.out.println("in Post My Tweet");
		
		System.out.println("\n====================================");
		System.out.println("         Post new tweet      ");
		System.out.println("====================================");
		
		Tweets tweet = new Tweets();
		Scanner sc = new Scanner(System.in);

		System.out.println("\nType new Tweet :");
		String newTweet = sc.nextLine();
		
		tweet.setEmailId(emailId);
		tweet.setTweet(newTweet);
		
		try {
			String res = new TweetImplementation().createTweet(tweet);		
		
			System.out.println(res);
			MainMenu.menuList(emailId);		

		} catch (TweetException e) {
			System.out.println(e.getMessage());			
		
			System.out.println("\nTry again...");
			MainMenuUsecase.postNewTweet(emailId);
		}
	}

	public static void viewMyTweet(String emailId) {
		try {

			List<Tweets> tweet = new TweetImplementation().viewMyTweets(emailId);

			tweet.forEach(t -> {

				System.out.println(t.getTweet());

				System.out.println("==================================");
			});

		} catch (TweetException e) {
			System.out.println(e.getMessage());

			System.out.println();
			System.out.println("We are waiting for you to post something");
			MainMenu.menuList(emailId);

		}

		MainMenu.menuList(emailId);

		
	}

	public static void viewAllTweet(String emailId) {
		
		try {

			List<Tweets> tweet = new TweetImplementation().viewAllTweets();

			tweet.forEach(t -> {

				System.out.println(t.getTweet());

				System.out.println("==================================");
			});

		} catch (TweetException e) {
			System.out.println(e.getMessage());

			System.out.println();
			System.out.println("Try again...");
			MainMenu.menuList(emailId);

		}

		MainMenu.menuList(emailId);
		
	}

	public static void displayAllUsers(String emailId) {
		
		try {

			List<User> allUser = new TweetImplementation().viewAllUsers();

			allUser.forEach(u -> {

				System.out.println(u.getFirstName());

				System.out.println("==================================");
			});

		} catch (TweetException e) {
			System.out.println(e.getMessage());

			System.out.println();
			System.out.println("Try again...");
			MainMenu.menuList(emailId);

		}

		MainMenu.menuList(emailId);
		
	}

}
