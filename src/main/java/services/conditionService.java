package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Condition;
import utils.DBConnect;

public class conditionService {

	public ArrayList<Condition> getAllConditions() {
		try {
			ArrayList<Condition> listcondition = new ArrayList<Condition>();
			String query = "select * from conditions";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Condition condition = new Condition();

				condition.setConditionId(rs.getInt("conditionId"));
				condition.setCondition(rs.getString("condition"));

				listcondition.add(condition);
			}

			return listcondition;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
