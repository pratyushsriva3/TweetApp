package ps.uta.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ps.uta.Exception.PasswordException;
import ps.uta.config.DBProp;
import ps.uta.repository.ForgotPassword;

public class ForgotPasswordImplementation implements ForgotPassword {

	@Override
	public boolean checkEmailIdPassword(String emailId, String old_password) throws PasswordException {
		
		boolean result = false;

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from user where emailId=? AND password=?");

			ps.setString(1, emailId);
			ps.setString(2, old_password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} catch (SQLException e) {
			throw new PasswordException(e.getMessage());
		}

		return result;
	}

	@Override
	public String updateUserPassword(String emailId, String new_password) throws PasswordException {
		
		String result = "Failed!";

		try (Connection conn = DBProp.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update user set password=? where emailId=?");

			ps.setString(1, new_password);
			ps.setString(2, emailId);

			int rs = ps.executeUpdate();

			if (rs > 0) {
				result = "Password update successfully!";
			}

		} catch (SQLException e) {
			throw new PasswordException(e.getMessage());
		}

		return result;
	}

}
