package ps.uta.Model;

public class User {
	
	private String emailId;
	private String firstName;
	private String password;
	private int status;
	
	public User() {
		super();
	}
	
	public User(String emailId, String firstName, String password, int status) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.password = password;
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", firstName=" + firstName + ", password=" + password + ", status=" + status + "]";
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
