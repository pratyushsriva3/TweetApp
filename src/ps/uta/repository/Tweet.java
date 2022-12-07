package ps.uta.repository;

import java.util.List;

import ps.uta.Exception.TweetException;
import ps.uta.Model.Tweets;
import ps.uta.Model.User;

public interface Tweet {
	
	public String createTweet(Tweets tweets) throws TweetException;
	
	public List<Tweets> viewMyTweets(String emailId) throws TweetException;
	
	public List<Tweets> viewAllTweets() throws TweetException;
	
	public List<User> viewAllUsers() throws TweetException;

}
