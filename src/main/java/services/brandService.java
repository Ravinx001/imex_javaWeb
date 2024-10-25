package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Brand;
import utils.DBConnect;

public class brandService {

	private Connection con = DBConnect.getConnection();

	public boolean createBrand(Brand brand) {

		try {
			PreparedStatement pst = con.prepareStatement("insert into brand values(0,?)");

			pst.setString(1, brand.getBrandName());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateBrand(String brandName) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from brand where brand = ?");

			pst.setString(1, brandName);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Brand getOne(int brandId) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from brand where brandId = ?");

			pst.setInt(1, brandId);

			ResultSet rs = pst.executeQuery();

			Brand brand = new Brand();

			if (rs.next()) {
				brand.setBrandId(rs.getInt("brandId"));
				brand.setBrandName(rs.getString("brand"));

				return brand;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Brand brand) {

		try {
			PreparedStatement pst = con.prepareStatement("update brand set brand = ? where brandId = ?");

			pst.setString(1, brand.getBrandName());
			pst.setInt(2, brand.getBrandId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(Brand brand) {

		try {
			PreparedStatement pst = con.prepareStatement("delete from brand where brandId = ?");

			pst.setInt(1, brand.getBrandId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Brand> getAllBrands() {
		try {
			ArrayList<Brand> listbrand = new ArrayList<Brand>();
			String query = "select * from brand";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();
				brand.setBrandId(rs.getInt("brandId"));
				brand.setBrandName(rs.getString("brand"));
				listbrand.add(brand);
			}
			return listbrand;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
