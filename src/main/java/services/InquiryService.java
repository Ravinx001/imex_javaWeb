package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Inquiry;
import utils.DBConnect;

public class InquiryService {

	private Connection con = DBConnect.getConnection();

	public boolean createInquiry(Inquiry inquiry) {

		try {
			PreparedStatement pst = con.prepareStatement("insert into inquires values(0,?,?,?,?,?)");

			pst.setString(1, inquiry.getCustomerName());
			pst.setString(2, inquiry.getCustomerEmail());
			pst.setString(3, inquiry.getCustomerMobile());
			pst.setString(4, inquiry.getInquiry());
			pst.setInt(5, inquiry.getVehicleId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Inquiry> getAllInquires() {
		try {
			ArrayList<Inquiry> listinquiry = new ArrayList<Inquiry>();

			String query = "select * from inquires inner join vehicle on inquires.vehicleId = vehicle.vehicleId";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Inquiry inquiry = new Inquiry();

				inquiry.setVehicleId(rs.getInt("vehicleId"));
				inquiry.setInquiryId(rs.getInt("inquiryId"));
				inquiry.setCustomerName(rs.getString("customerName"));
				inquiry.setCustomerMobile(rs.getString("customerMobile"));
				inquiry.setCustomerEmail(rs.getString("customerEmail"));
				inquiry.setVehicleTitle(rs.getString("title"));
				inquiry.setVehiclePrice(rs.getString("price"));

				listinquiry.add(inquiry);
			}
			return listinquiry;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
