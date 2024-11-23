package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Transmission;
import utils.DBConnect;

public class transmissionService {

	public ArrayList<Transmission> getAllTansmissions() {
		try {
			ArrayList<Transmission> listtransmission = new ArrayList<Transmission>();
			String query = "select * from transmission";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Transmission transmission = new Transmission();
				transmission.setTransmissionId(rs.getInt("transmissionId"));
				transmission.setTransmission(rs.getString("transmission"));
				listtransmission.add(transmission);
			}

			return listtransmission;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
