package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Featuring;
import utils.DBConnect;

public class featuringService {

	public ArrayList<Featuring> getAllFeaturings() {
		try {
			ArrayList<Featuring> listfeaturing = new ArrayList<Featuring>();
			String query = "select * from featuring";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Featuring featuring = new Featuring();
				featuring.setFeaturingId(rs.getInt("featuringId"));
				featuring.setFeaturing(rs.getString("featuring"));
				listfeaturing.add(featuring);
			}

			return listfeaturing;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
