package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Vehicle;
import utils.DBConnect;

public class searchService {

	public ArrayList<Vehicle> getAllVehicles() {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId ORDER BY vehicle.vehicleId DESC limit 10";
			Connection con = DBConnect.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Vehicle vehicle = new Vehicle();

				vehicle.setVehicleId(rs.getInt("vehicleId"));
				vehicle.setUserId(rs.getInt("userId"));
				vehicle.setTitle(rs.getString("title"));
				vehicle.setPrice(rs.getDouble("price"));
				vehicle.setManufactureYear(rs.getInt("manufactureYear"));
				vehicle.setModel(rs.getString("model"));
				vehicle.setModelVariant(rs.getString("modelVariant"));
				vehicle.setMileage(rs.getString("mileage"));
				vehicle.setEngineCapacity(rs.getString("engineCapacity"));
				vehicle.setDescription(rs.getString("description"));
				vehicle.setCategotry(rs.getInt("categoryId"));
				vehicle.setBrand(rs.getInt("brandId"));
				vehicle.setFueltype(rs.getInt("fuelTypeId"));
				vehicle.setTransmission(rs.getInt("transmissionId"));
				vehicle.setFeaturing(rs.getInt("featuringId"));
				vehicle.setCondition(rs.getInt("conditionId"));
				vehicle.setLocation(rs.getInt("locationId"));

				vehicle.setCategotryName(rs.getString("category"));
				vehicle.setBrandName(rs.getString("brand"));
				vehicle.setFueltypeName(rs.getString("fuelType"));
				vehicle.setTransmissionName(rs.getString("transmission"));
				vehicle.setFeaturingName(rs.getString("featuring"));
				vehicle.setConditionName(rs.getString("condition"));
				vehicle.setLocationName(rs.getString("location"));

				listvehicle.add(vehicle);
			}
			return listvehicle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public ArrayList<Vehicle> searchAllVehicles(String title, int price_min, int price_max, int condition_nr,
//			int condition_nur, int condition_ur, int condition_uur) {
//		try {
//			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();
//
//			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId ORDER BY vehicle.vehicleId DESC limit 10";
//
//			if (title != null && price_min != -1 && price_max != -1 && condition_nr != -1 && condition_nur != -1
//					&& condition_ur != -1 && condition_uur != -1) {
//				query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE vehicle.title = %"
//						+ title + "% AND price >= " + price_min + " AND price <= " + price_max + " AND condtion = "
//						+ condition_nr + " OR condition = " + condition_nur + " OR condition = " + condition_ur
//						+ " OR condition = " + condition_uur + " ORDER BY vehicle.vehicleId DESC limit 10";
//			} else if (price_min != -1 && price_max != -1 && condition_nr != -1 && condition_nur != -1
//					&& condition_ur != -1 && condition_uur != -1) {
//				query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE price >= " + price_min + " AND price <= " + price_max + " AND condtion = "
//						+ condition_nr + " OR condition = " + condition_nur + " OR condition = " + condition_ur
//						+ " OR condition = " + condition_uur + " ORDER BY vehicle.vehicleId DESC limit 10";
//			}
//
//			Connection con = DBConnect.getConnection();
//
//			PreparedStatement pst = con.prepareStatement(query);
//			ResultSet rs = pst.executeQuery();
//
//			while (rs.next()) {
//				Vehicle vehicle = new Vehicle();
//
//				vehicle.setVehicleId(rs.getInt("vehicleId"));
//				vehicle.setUserId(rs.getInt("userId"));
//				vehicle.setTitle(rs.getString("title"));
//				vehicle.setPrice(rs.getDouble("price"));
//				vehicle.setManufactureYear(rs.getInt("manufactureYear"));
//				vehicle.setModel(rs.getString("model"));
//				vehicle.setModelVariant(rs.getString("modelVariant"));
//				vehicle.setMileage(rs.getString("mileage"));
//				vehicle.setEngineCapacity(rs.getString("engineCapacity"));
//				vehicle.setDescription(rs.getString("description"));
//				vehicle.setCategotry(rs.getInt("categoryId"));
//				vehicle.setBrand(rs.getInt("brandId"));
//				vehicle.setFueltype(rs.getInt("fuelTypeId"));
//				vehicle.setTransmission(rs.getInt("transmissionId"));
//				vehicle.setFeaturing(rs.getInt("featuringId"));
//				vehicle.setCondition(rs.getInt("conditionId"));
//				vehicle.setLocation(rs.getInt("locationId"));
//
//				vehicle.setCategotryName(rs.getString("category"));
//				vehicle.setBrandName(rs.getString("brand"));
//				vehicle.setFueltypeName(rs.getString("fuelType"));
//				vehicle.setTransmissionName(rs.getString("transmission"));
//				vehicle.setFeaturingName(rs.getString("featuring"));
//				vehicle.setConditionName(rs.getString("condition"));
//				vehicle.setLocationName(rs.getString("location"));
//
//				listvehicle.add(vehicle);
//			}
//			return listvehicle;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public ArrayList<Vehicle> searchAllVehicles(String title, int price_min, int price_max, int condition_nr,
			int condition_nur, int condition_ur, int condition_uur) {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			// Base query
			String query = "SELECT * FROM vehicle " + "INNER JOIN category ON category.categoryId = vehicle.categoryId "
					+ "INNER JOIN brand ON brand.brandId = vehicle.brandId "
					+ "INNER JOIN fueltype ON fueltype.fueltypeId = vehicle.fueltypeId "
					+ "INNER JOIN transmission ON transmission.transmissionId = vehicle.transmissionId "
					+ "INNER JOIN featuring ON featuring.featuringId = vehicle.featuringId "
					+ "INNER JOIN conditions ON conditions.conditionId = vehicle.conditionId "
					+ "INNER JOIN location ON location.locationId = vehicle.locationId ";

			// To dynamically build WHERE conditions
			StringBuilder whereClause = new StringBuilder();
			ArrayList<Object> parameters = new ArrayList<>();

			// Add conditions dynamically
			if (title != null && !title.isEmpty()) {
				whereClause.append("vehicle.title LIKE ? ");
				parameters.add("%" + title + "%");
			}
			if (price_min != -1) {
				if (whereClause.length() > 0) {
					whereClause.append("AND ");
				}
				whereClause.append("price >= ? ");
				parameters.add(price_min);
			}
			if (price_max != -1) {
				if (whereClause.length() > 0) {
					whereClause.append("AND ");
				}
				whereClause.append("price <= ? ");
				parameters.add(price_max);
			}
			if (condition_nr != -1 || condition_nur != -1 || condition_ur != -1 || condition_uur != -1) {
				if (whereClause.length() > 0) {
					whereClause.append("AND ");
				}
				whereClause.append(
						"(conditions.conditionId = ? OR conditions.conditionId = ? OR conditions.conditionId = ? OR conditions.conditionId = ?) ");
				parameters.add(condition_nr != -1 ? condition_nr : null); // Add `null` if not applicable
				parameters.add(condition_nur != -1 ? condition_nur : null);
				parameters.add(condition_ur != -1 ? condition_ur : null);
				parameters.add(condition_uur != -1 ? condition_uur : null);
			}

			// Append WHERE clause if any condition exists
			if (whereClause.length() > 0) {
				query += "WHERE " + whereClause.toString();
			}

			// Add default ordering and limit
			query += " ORDER BY vehicle.vehicleId DESC LIMIT 10";

			// Debugging: Print the final query
			System.out.println("Generated Query: " + query);

			// Prepare the statement
			Connection con = DBConnect.getConnection();
			PreparedStatement pst = con.prepareStatement(query);

			// Set dynamic parameters
			int paramIndex = 1;
			for (Object param : parameters) {
				if (param != null) {
					pst.setObject(paramIndex++, param);
				}
			}

			// Execute the query and process results
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Vehicle vehicle = new Vehicle();

				vehicle.setVehicleId(rs.getInt("vehicleId"));
				vehicle.setUserId(rs.getInt("userId"));
				vehicle.setTitle(rs.getString("title"));
				vehicle.setPrice(rs.getDouble("price"));
				vehicle.setManufactureYear(rs.getInt("manufactureYear"));
				vehicle.setModel(rs.getString("model"));
				vehicle.setModelVariant(rs.getString("modelVariant"));
				vehicle.setMileage(rs.getString("mileage"));
				vehicle.setEngineCapacity(rs.getString("engineCapacity"));
				vehicle.setDescription(rs.getString("description"));
				vehicle.setCategotry(rs.getInt("categoryId"));
				vehicle.setBrand(rs.getInt("brandId"));
				vehicle.setFueltype(rs.getInt("fuelTypeId"));
				vehicle.setTransmission(rs.getInt("transmissionId"));
				vehicle.setFeaturing(rs.getInt("featuringId"));
				vehicle.setCondition(rs.getInt("conditionId"));
				vehicle.setLocation(rs.getInt("locationId"));

				vehicle.setCategotryName(rs.getString("category"));
				vehicle.setBrandName(rs.getString("brand"));
				vehicle.setFueltypeName(rs.getString("fuelType"));
				vehicle.setTransmissionName(rs.getString("transmission"));
				vehicle.setFeaturingName(rs.getString("featuring"));
				vehicle.setConditionName(rs.getString("condition"));
				vehicle.setLocationName(rs.getString("location"));

				listvehicle.add(vehicle);
			}

			return listvehicle;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
