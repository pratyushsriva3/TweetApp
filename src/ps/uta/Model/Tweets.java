package ps.uta.Model;

public class Tweets {
	
	private int id;
	private String emailId;
	private String tweet;
	
	public Tweets() {
		super();
	}
	
	public Tweets(int id, String emailId, String tweet) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.tweet = tweet;
	}
	
	@Override
	public String toString() {
		return "Tweets [id=" + id + ", emailId=" + emailId + ", tweet=" + tweet + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	

}
