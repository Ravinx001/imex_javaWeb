package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Vehicle;
import utils.DBConnect;

public class vehicleService {

	private Connection con = DBConnect.getConnection();

	public boolean createVehicle(Vehicle vehicle) {

		try {
			PreparedStatement pst = con.prepareStatement("insert into brand values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1, vehicle.getTitle());
			pst.setDouble(2, vehicle.getPrice());
			pst.setInt(3, vehicle.getManufactureYear());
			pst.setString(4, vehicle.getModel());
			pst.setString(5, vehicle.getModelVariant());
			pst.setString(6, vehicle.getMileage());
			pst.setString(7, vehicle.getEngineCapacity());
			pst.setString(8, vehicle.getDescription());
			pst.setInt(9, vehicle.getLocation());
			pst.setInt(10, vehicle.getCategotry());
			pst.setInt(11, vehicle.getBrand());
			pst.setInt(12, vehicle.getFueltype());
			pst.setInt(13, vehicle.getTransmission());
			pst.setInt(14, vehicle.getFeaturing());
			pst.setInt(15, vehicle.getUserId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateTitle(String title) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from vehicle where title = ?");

			pst.setString(1, title);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Vehicle getOne(int vehicleId) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from vehicle where vehicleId = ?");

			pst.setInt(1, vehicleId);

			ResultSet rs = pst.executeQuery();

			Vehicle vehicle = new Vehicle();

			if (rs.next()) {
				vehicle.setVehicleId(rs.getInt("vehicleId"));
				vehicle.setTitle(rs.getString("title"));
				vehicle.setManufactureYear(rs.getInt("manufactureYear"));
				vehicle.setModel(rs.getString("modal"));
				vehicle.setModelVariant(rs.getString("modelVariant"));
				vehicle.setMileage(rs.getString("mileage"));
				vehicle.setEngineCapacity(rs.getString("engineCapacity"));
				vehicle.setDescription(rs.getString("description"));
				vehicle.setLocation(rs.getInt("location"));
				vehicle.setCategotry(rs.getInt("categoryId"));
				vehicle.setBrand(rs.getInt("brandId"));
				vehicle.setFueltype(rs.getInt("fuelTypeId"));
				vehicle.setTransmission(rs.getInt("transmissionId"));
				vehicle.setFeaturing(rs.getInt("featuringId"));
				vehicle.setUserId(rs.getInt("userId"));

				return vehicle;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Vehicle vehicle) {

		try {
			PreparedStatement pst = con.prepareStatement(
					"update vehicle set title = ?, price = ?, manufactureYear = ?, model = ?, modelVariant = ?, mileage = ?, engineCapacity = ?, description = ?, location = ?, categoryId = ?, brandId = ?, fuelTypeId = ?, transmissionId = ?, featuringId = ?, userId = ? where vehicleId = ?");

			pst.setString(1, vehicle.getTitle());
			pst.setDouble(2, vehicle.getPrice());
			pst.setInt(3, vehicle.getManufactureYear());
			pst.setString(4, vehicle.getModel());
			pst.setString(5, vehicle.getModelVariant());
			pst.setString(6, vehicle.getMileage());
			pst.setString(7, vehicle.getEngineCapacity());
			pst.setString(8, vehicle.getDescription());
			pst.setInt(9, vehicle.getLocation());
			pst.setInt(10, vehicle.getCategotry());
			pst.setInt(11, vehicle.getBrand());
			pst.setInt(12, vehicle.getFueltype());
			pst.setInt(13, vehicle.getTransmission());
			pst.setInt(14, vehicle.getFeaturing());
			pst.setInt(15, vehicle.getUserId());
			pst.setInt(16, vehicle.getVehicleId());

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(Vehicle vehicle) {

		try {
			PreparedStatement pst1 = con.prepareStatement("delete from vehimgpaths where vehicleId = ?");
			PreparedStatement pst2 = con.prepareStatement("delete from vehicle where vehicleId = ?");

			pst1.setInt(1, vehicle.getVehicleId());
			pst2.setInt(1, vehicle.getVehicleId());

			int rowCount1 = pst1.executeUpdate();
			int rowCount2 = pst2.executeUpdate();

			if (rowCount1 > 0 && rowCount2 > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Vehicle> getAllVehicles() {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId";
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

	public ArrayList<Vehicle> getAllRecommendedVehicles() {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE vehicle.featuringId = 1 ORDER BY vehicle.vehicleId DESC LIMIT 5";
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

	public ArrayList<Vehicle> getAllUsedVehicles() {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE vehicle.conditionId = 3 OR vehicle.conditionId = 4 ORDER BY vehicle.vehicleId DESC LIMIT 5";
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

	public ArrayList<Vehicle> getAllNewVehicles() {
		try {
			ArrayList<Vehicle> listvehicle = new ArrayList<Vehicle>();

			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE vehicle.conditionId = 1 OR vehicle.conditionId = 2 ORDER BY vehicle.vehicleId DESC LIMIT 5";
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

}
