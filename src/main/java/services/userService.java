package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utils.DBConnect;

public class userService {
	private Connection con = DBConnect.getConnection();

	public boolean validate(User user) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateEmail(String email) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from users where email = ?");

			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public User getOne(User user) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? or password = ?");

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public User getUserById(User user) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from users where userId = ?");

			pst.setInt(1, user.getUserId());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateUserAll(User user) {

		try {
			PreparedStatement pst = con
					.prepareStatement("update users set name = ?, email = ?, password = ? where userId = ?");

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setInt(4, user.getUserId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateUserWithoutPassword(User user) {

		try {
			PreparedStatement pst = con.prepareStatement("update users set name = ?, email = ? where userId = ?");

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setInt(3, user.getUserId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
