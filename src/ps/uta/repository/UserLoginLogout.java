package ps.uta.repository;

import ps.uta.Exception.UserLoginException;
import ps.uta.Model.User;

public interface UserLoginLogout {
	
	public User userLogin(String emailId,String password) throws UserLoginException;
	
	public String loginUpdateStatus(String emailId) throws UserLoginException;
	
	public String logoutUpdateStatus(String emailId) throws UserLoginException;
	
}
