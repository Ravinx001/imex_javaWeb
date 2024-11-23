package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Location;
import utils.DBConnect;

public class locationService {

	public ArrayList<Location> getAllLocations() {
		try {
			ArrayList<Location> listlocation = new ArrayList<Location>();
			String query = "select * from location";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Location location = new Location();
				location.setLocationId(rs.getInt("locationId"));
				location.setLocation(rs.getString("location"));
				listlocation.add(location);
			}
			return listlocation;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
