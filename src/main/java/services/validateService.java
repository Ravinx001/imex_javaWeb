package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DBConnect;

public class validateService {
	private Connection con = DBConnect.getConnection();

	public boolean validateCategoryWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from category where categoryId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateBrandWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from brand where brandId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateFeaturingWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from featuring where featuringId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateFueltypeWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from fueltype where fueltypeId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateTransmissionWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from transmission where transmissionId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateLocationWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from location where locationId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateConditionWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from conditions where conditionId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateUserWithId(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from users where userId = ?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
