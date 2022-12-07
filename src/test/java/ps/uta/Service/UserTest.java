package test.java.ps.uta.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.mysql.cj.MysqlConnection;

import ps.uta.Exception.TweetException;
import ps.uta.Exception.UserRegisterException;
import ps.uta.Model.Tweets;
import ps.uta.Model.User;
import ps.uta.Service.TweetImplementation;
import ps.uta.Service.UserRegistrationImplementation;
import ps.uta.config.DBProp;

class UserTest {
	
	static MysqlConnection conn = null;
	
	private UserRegistrationImplementation uri;

	private TweetImplementation ti;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	User userCreate = new User("sam@gmail.com", "sam", "9999", 1);
	Tweets createTweet = new Tweets(1, "messi@gmail.com", "Goal!");
	
	@BeforeEach
	void setUp() {
		conn = (MysqlConnection) DBProp.provideConnection();
		System.out.println("test started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("test ended");
	}
	
	@Test()
	public void testConnection() {
		assertNotNull("Connection is succesful", conn);
	}

	
	
	@Test
    public void testCreateTweet(){
		Tweets tweet = new Tweets();
		tweet.setEmailId("da@gmail.com");
		tweet.setTweet("Happy!");
		String expected = "Tweet posted successfully!";
        TweetImplementation tweetImplementation = new TweetImplementation();
        try {
			String act = tweetImplementation.createTweet(tweet);
			assertEquals("Tweet posted successfully!", expected, act);
		} catch (TweetException e) {
			System.out.println("Exception caught is Unit Testing : testCreateTweet");
			e.printStackTrace();
		}
    }
	
	@Test()
	void exceptiontest() {
		assertThrows(NullPointerException.class, () -> uri.userRegistration(userCreate));
	}
	
	@Test()
	void exceptiontest2() {
		assertThrows(NullPointerException.class, () -> ti.createTweet(createTweet));
	}
	
	@Test
    public void testViewMyTweets(){
        String emailId = "as@gmail.com";
		try {
			List<Tweets>  tweet = (new TweetImplementation()).viewMyTweets(emailId);
            int size = tweet.size();
		    assertTrue("list size greater than 0", size!=0);
		} catch (TweetException e) {
			System.out.println("Exception caught is Unit Testing : testViewMyTweet");
			e.printStackTrace();
		}
    }
	
	@Test
    public void testViewAllTweets(){
		try {
			List<Tweets>  tweet = (new TweetImplementation()).viewAllTweets();
			int size = tweet.size();
		    assertTrue("list size greater than 0", size!=0);
		} catch (TweetException e) {
			System.out.println("Exception caught is Unit Testing : testViewAllTweet");
			e.printStackTrace();
		}
        
    }

	@Test()
	void userRegistrationTest() {
		User user = new User();
		user.setEmailId("john@gmail.com");
		user.setFirstName("John");
        user.setPassword("1111");
        user.setStatus(1);
        String expected = "User successfully registeres";
        try {
			String actResult =  (new UserRegistrationImplementation()).userRegistration(user);
			assertEquals("User successfully registeres", expected, actResult);
		} catch (UserRegisterException e) {
			System.out.println("Exception caught is Unit Testing : testViewAllTweet");
			e.printStackTrace();
		}
	}
	
	@Test
    public void testViewAllUsers() {
		try {
			List<User> allUser = (new TweetImplementation()).viewAllUsers();
			int size = allUser.size();
		    assertTrue("list size greater than 0", size!=0);
		} catch (TweetException e) {
			System.out.println("Exception Caught in testViewAllUser");
			e.printStackTrace();
		}
			
    }
	

}
