package ps.uta.repository;

import ps.uta.Exception.PasswordException;

public interface ForgotPassword {
	
	// before update password check is it valid or not
		public boolean checkEmailIdPassword(String emailId, String old_password) throws PasswordException;

		// update emailId password
		public String updateUserPassword(String emailId, String new_password) throws PasswordException;

}
