package ps.uta.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ps.uta.Exception.UserRegisterException;
import ps.uta.Model.User;
import ps.uta.config.DBProp;
import ps.uta.repository.UserRegistration;

public class UserRegistrationImplementation implements UserRegistration {

	@Override
	public String userRegistration(User userCreate) throws UserRegisterException {
		String message = "Failed!";

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into user(emailId,firstName,password,status) values(?,?,?,?)");

			ps.setString(1, userCreate.getEmailId());
			ps.setString(2, userCreate.getFirstName());
			ps.setString(3, userCreate.getPassword());
			ps.setInt(4, userCreate.getStatus());

			int res = ps.executeUpdate();

			if (res > 0) {
				message = "Registration successful!";
			}

		} catch (SQLException e) {
			System.out.print("exception caught in UserRegistrationImplementation");
			throw new UserRegisterException(e.getMessage());
		}

		return message;
	}

}
