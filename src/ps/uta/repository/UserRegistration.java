package ps.uta.repository;

import ps.uta.Exception.UserRegisterException;
import ps.uta.Model.User;

public interface UserRegistration {
	
	public String userRegistration(User user) throws UserRegisterException;

}
