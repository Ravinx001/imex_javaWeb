package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import utils.DBConnect;

public class userService {
	private Connection con = DBConnect.getConnection();

	public void regCustomer(User user) {
		try {

			String query = "insert into users values('" + user.getEmail() + "','" + user.getName() + "', '"
					+ user.getPassword() + "')";

			Statement statement = DBConnect.getConnection().createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");

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

	public ArrayList<User> getAllCustomers() {
		try {

			ArrayList<User> listcus = new ArrayList<User>();

			String query = "select * from users";

			Statement statement = DBConnect.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				User cus = new User();

				cus.setName(rs.getString("name"));
				cus.setEmail(rs.getString("email"));
				cus.setPassword(rs.getString("password"));

				listcus.add(cus);
			}

			return listcus;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public User singleDataButton(User user) {
		try {

			String query = "select * from users where email = '" + user.getEmail() + "'";

			Statement statement = DBConnect.getConnection().createStatement();

			ResultSet rs = statement.executeQuery(query);

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

}
