package ps.uta.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ps.uta.Exception.UserLoginException;
import ps.uta.Model.User;
import ps.uta.config.DBProp;
import ps.uta.repository.UserLoginLogout;

public class UserLoginLogoutImplementation implements UserLoginLogout {

	@Override
	public User userLogin(String emailId, String password) throws UserLoginException {
		
		//initialize user object as null
		User user=null;		
				
		try(Connection conn=DBProp.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from user where emailId=? AND password=?");
					
			ps.setString(1, emailId);
			ps.setString(2, password);
					
			ResultSet rs=ps.executeQuery();
					
			if(rs.next()) {
				String email= rs.getString("emailId");
				String name = rs.getString("firstName");
				String pass= rs.getString("password");
				int status= rs.getInt("status");
				try {
					loginUpdateStatus(email);
					
				} catch (UserLoginException e) {
					System.out.println(e.getMessage());
				}		
				status = 1;
				user = new User(email, name, pass, status);
			}else {
				throw new UserLoginException("Invalid email ID  or password!");
			}
					
					
		} catch (SQLException e) {
			throw new UserLoginException(e.getMessage());
		}
				
				
		//return user object
		return user;

	}

	@Override
	public String loginUpdateStatus(String emailId) throws UserLoginException {
		// TODO Auto-generated method stub
		String message = "Failed!";

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update user set status=1 where emailId=?");

			ps.setString(1, emailId);
			int res = ps.executeUpdate();

			if (res > 0) {
				message = "Status updated successfully!";
			}

		} catch (SQLException e) {
			throw new UserLoginException(e.getMessage());
		}

		return message;
	}
	
	@Override
	public String logoutUpdateStatus(String emailId) throws UserLoginException {
		// TODO Auto-generated method stub
		String message = "Failed!";

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update user set status=0 where emailId=?");

			ps.setString(1, emailId);
			int res = ps.executeUpdate();

			if (res > 0) {
				message = "Status updated successfully!";
			}

		} catch (SQLException e) {
			throw new UserLoginException(e.getMessage());
		}

		return message;
	}
	

}
