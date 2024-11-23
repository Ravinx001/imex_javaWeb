package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.FuelType;
import utils.DBConnect;

public class fuelTypeService {

	public ArrayList<FuelType> getAllfuelTypes() {
		try {
			ArrayList<FuelType> listfuelType = new ArrayList<FuelType>();
			String query = "select * from fueltype";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				FuelType fuelType = new FuelType();

				fuelType.setFuelTypeId(rs.getInt("fuelTypeId"));
				fuelType.setFuelType(rs.getString("fuelType"));

				listfuelType.add(fuelType);
			}

			return listfuelType;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
