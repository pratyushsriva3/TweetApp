package ps.uta.usecase;

import ps.uta.Exception.UserLoginException;
import ps.uta.Service.UserLoginLogoutImplementation;

public class Logout {

	public static void logout(String emailId) {
		
		try {
			String res = new UserLoginLogoutImplementation().logoutUpdateStatus(emailId);
			
		} catch (UserLoginException e) {
			System.out.println(e.getMessage());
			IntroMenu.userOnboardingAndLogin();
		}
		IntroMenu.userOnboardingAndLogin();
	}

}
