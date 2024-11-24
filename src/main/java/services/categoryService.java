package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Category;
import utils.DBConnect;

public class categoryService {

	private Connection con = DBConnect.getConnection();

	public boolean createCategory(Category category) {

		try {
			PreparedStatement pst = con.prepareStatement("insert into category values(0,?)");

			pst.setString(1, category.getCategoryName());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateCategory(String categoryName) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from category where category = ?");

			pst.setString(1, categoryName);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Category getOne(int categoryId) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from category where categoryId = ?");

			pst.setInt(1, categoryId);

			ResultSet rs = pst.executeQuery();

			Category category = new Category();

			if (rs.next()) {
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("category"));

				return category;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getOneName(int categoryId) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from category where categoryId = ?");

			pst.setInt(1, categoryId);

			ResultSet rs = pst.executeQuery();

			Category category = new Category();

			if (rs.next()) {
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("category"));

				return category.getCategoryName();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Category category) {

		try {
			PreparedStatement pst = con.prepareStatement("update category set category = ? where categoryId = ?");

			pst.setString(1, category.getCategoryName());
			pst.setInt(2, category.getCategoryId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(Category category) {

		try {
			PreparedStatement pst = con.prepareStatement("delete from category where categoryId = ?");

			pst.setInt(1, category.getCategoryId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Category> getAllCategories() {
		try {
			ArrayList<Category> listcategory = new ArrayList<Category>();
			String query = "select * from category";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("category"));
				listcategory.add(category);
			}
			return listcategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Category> getAllTopCategories() {
		try {
			ArrayList<Category> listcategory = new ArrayList<Category>();
			String query = "select * from category limit 4";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("category"));
				listcategory.add(category);
			}
			return listcategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
