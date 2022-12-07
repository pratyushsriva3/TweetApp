package ps.uta.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ps.uta.Exception.TweetException;
import ps.uta.Model.Tweets;
import ps.uta.Model.User;
import ps.uta.config.DBProp;
import ps.uta.repository.Tweet;

public class TweetImplementation implements Tweet {

	@Override
	public String createTweet(Tweets tweets) throws TweetException {
		
		String message = "Failed!";

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into tweets(emailId,tweet) values(?,?)");

			ps.setString(1, tweets.getEmailId());
			ps.setString(2, tweets.getTweet());

			int res = ps.executeUpdate();

			if (res > 0) {
				message = "Tweet posted successfully!";
			}

		} catch (SQLException e) {
			throw new TweetException(e.getMessage());
		}

		return message;
	}
	
	@Override
	public List<Tweets> viewMyTweets(String emailId) throws TweetException {
		
		List<Tweets> myTweetList = new ArrayList<Tweets>();

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from tweets where emailId=?");
			
			ps.setString(1, emailId);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String tweet = rs.getString("tweet");

				Tweets tw = new Tweets();

				tw.setTweet(tweet);

				myTweetList.add(tw);
			}

		} catch (SQLException e) {
			throw new TweetException(e.getMessage());
		}

		if (myTweetList.size() == 0)
		throw new TweetException("Empty!");

		return myTweetList;
	}

	@Override
	public List<Tweets> viewAllTweets() throws TweetException {
		
		List<Tweets> tweetList = new ArrayList<Tweets>();

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from tweets");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				//String email = rs.getString("emailId");
				String tweet = rs.getString("tweet");

				Tweets tw = new Tweets();

				tw.setTweet(tweet);

				tweetList.add(tw);
			}

		} catch (SQLException e) {
			throw new TweetException(e.getMessage());
		}

		if (tweetList.size() == 0)
		throw new TweetException("Empty!");

		return tweetList;
		
	}

	@Override
	public List<User> viewAllUsers() throws TweetException {
		
		List<User> userList = new ArrayList<User>();

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String fname = rs.getString("firstName");

				User u = new User();

				u.setFirstName(fname);

				userList.add(u);
			}

		} catch (SQLException e) {
			throw new TweetException(e.getMessage());
		}

		if (userList.size() == 0)
		throw new TweetException("Empty!");

		return userList;
		
	}

}
