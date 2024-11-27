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
			PreparedStatement pst = con
					.prepareStatement("insert into vehicle values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1, vehicle.getTitle());

			if (vehicle.getPrice() == 0.0) {
				pst.setString(2, "NULL");
			} else {
				pst.setDouble(2, vehicle.getPrice());
			}

			pst.setInt(3, vehicle.getManufactureYear());
			pst.setString(4, vehicle.getModel());
			pst.setString(5, vehicle.getModelVariant());
			pst.setString(6, vehicle.getMileage());
			pst.setString(7, vehicle.getEngineCapacity());
			pst.setString(8, vehicle.getDescription());
			pst.setInt(9, vehicle.getCategotry());
			pst.setInt(10, vehicle.getBrand());
			pst.setInt(11, vehicle.getFueltype());
			pst.setInt(12, vehicle.getTransmission());
			pst.setInt(13, vehicle.getFeaturing());
			pst.setInt(14, vehicle.getUserId());
			pst.setInt(15, vehicle.getLocation());
			pst.setInt(16, vehicle.getCondition());

			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("Title: " + vehicle.getTitle());
			System.out.println("Price: " + vehicle.getPrice());
			System.out.println("manufactureYear: " + vehicle.getManufactureYear());
			System.out.println("model: " + vehicle.getModel());
			System.out.println("modelVariant: " + vehicle.getModelVariant());
			System.out.println("mileage: " + vehicle.getMileage());
			System.out.println("engineCapacity: " + vehicle.getEngineCapacity());
			System.out.println("description: " + vehicle.getDescription());
			System.out.println("Location: " + vehicle.getLocation());
			System.out.println("category: " + vehicle.getCategotry());
			System.out.println("brand: " + vehicle.getBrand());
			System.out.println("fuelType: " + vehicle.getFueltype());
			System.out.println("transmission: " + vehicle.getTransmission());
			System.out.println("condition: " + vehicle.getCondition());
			System.out.println("featuring: " + vehicle.getFeaturing());
			System.out.println("userId: " + vehicle.getUserId());
			System.out.println("query: " + pst);

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
			String query = "select * from vehicle inner join category on category.categoryId = vehicle.categoryId inner join brand on brand.brandId = vehicle.brandId inner join fueltype on fueltype.fueltypeId = vehicle.fueltypeId inner join transmission on transmission.transmissionId = vehicle.transmissionId inner join featuring on featuring.featuringId = vehicle.featuringId inner join conditions on conditions.conditionId = vehicle.conditionId inner join location on location.locationId = vehicle.locationId WHERE vehicleId = ?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, vehicleId);

			ResultSet rs = pst.executeQuery();

			System.out.println("Select Query: " + rs);

			Vehicle vehicle = new Vehicle();

			if (rs.next()) {
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

				String imagePth = getVehicleImagePath(vehicleId);

				if (imagePth != null) {

					vehicle.setImagePath(imagePth);

					System.out.println("Image Path From Service Class: " + imagePth);
				} else {
					vehicle.setImagePath("images/no-image.svg");
				}

				return vehicle;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Vehicle vehicle) {

		try {
			PreparedStatement pst = con.prepareStatement(
					"update vehicle set title = ?, price = ?, manufactureYear = ?, model = ?, modelVariant = ?, mileage = ?, engineCapacity = ?, description = ?, locationId = ?, categoryId = ?, brandId = ?, fuelTypeId = ?, transmissionId = ?, featuringId = ?, userId = ?, conditionId = ? where vehicleId = ?");

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
			pst.setInt(16, vehicle.getCondition());
			pst.setInt(17, vehicle.getVehicleId());

			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("Title: " + vehicle.getTitle());
			System.out.println("Price: " + vehicle.getPrice());
			System.out.println("manufactureYear: " + vehicle.getManufactureYear());
			System.out.println("model: " + vehicle.getModel());
			System.out.println("modelVariant: " + vehicle.getModelVariant());
			System.out.println("mileage: " + vehicle.getMileage());
			System.out.println("engineCapacity: " + vehicle.getEngineCapacity());
			System.out.println("description: " + vehicle.getDescription());
			System.out.println("Location: " + vehicle.getLocation());
			System.out.println("category: " + vehicle.getCategotry());
			System.out.println("brand: " + vehicle.getBrand());
			System.out.println("fuelType: " + vehicle.getFueltype());
			System.out.println("transmission: " + vehicle.getTransmission());
			System.out.println("condition: " + vehicle.getCondition());
			System.out.println("featuring: " + vehicle.getFeaturing());
			System.out.println("userId: " + vehicle.getUserId());
			System.out.println("query: " + pst);

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(int vehicleId) {

		try {
			PreparedStatement pst1 = con.prepareStatement("delete from vehimgpaths where vehicleId = ?");
			PreparedStatement pst2 = con.prepareStatement("delete from vehicle WHERE vehicleId = ?");

			pst1.setInt(1, vehicleId);
			pst2.setInt(1, vehicleId);

			System.out.println("Vehicle Id from Vehicle Delete Service Function: " + vehicleId);

			int rowCount1 = pst1.executeUpdate();
			int rowCount2 = pst2.executeUpdate();

			if (rowCount2 > 0) {
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

				String imagePth = getVehicleImagePath(rs.getInt("vehicleId"));

				if (imagePth != null) {

					vehicle.setImagePath(imagePth);

					System.out.println("Image Path From Service Class: " + imagePth);
				} else {
					vehicle.setImagePath("images/no-image.svg");
				}

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

				String imagePth = getVehicleImagePath(rs.getInt("vehicleId"));

				if (imagePth != null) {

					vehicle.setImagePath(imagePth);

					System.out.println("Image Path From Service Class: " + imagePth);
				} else {
					vehicle.setImagePath("images/no-image.svg");
				}

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

				String imagePth = getVehicleImagePath(rs.getInt("vehicleId"));

				if (imagePth != null) {

					vehicle.setImagePath(imagePth);

					System.out.println("Image Path From Service Class: " + imagePth);
				} else {
					vehicle.setImagePath("images/no-image.svg");
				}

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

				String imagePth = getVehicleImagePath(rs.getInt("vehicleId"));

				if (imagePth != null) {

					vehicle.setImagePath(imagePth);

					System.out.println("Image Path From Service Class: " + imagePth);
				} else {
					vehicle.setImagePath("images/no-image.svg");
				}

				listvehicle.add(vehicle);
			}
			return listvehicle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveVehicleImage(int vehicleId, String imagePath) {
		try {
			PreparedStatement pst = con.prepareStatement("insert into vehimgpaths values(0,?,?)");

			pst.setString(1, imagePath);
			pst.setInt(2, vehicleId);

			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("Image Path: " + imagePath);
			System.out.println("Vehicle Id: " + vehicleId);

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateVehicleImage(int vehicleId, String imagePath) {
		try {
			PreparedStatement pst = con.prepareStatement("update vehimgpaths set vehimgpath = ? WHERE vehicleId = ?");

			pst.setString(1, imagePath);
			pst.setInt(2, vehicleId);

			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("----------- ------------ ----------");
			System.out.println("Image Path: " + imagePath);
			System.out.println("Vehicle Id: " + vehicleId);

			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean imageCheck(int vehicleId) {

		try {
			String query = "select * from vehimgpaths WHERE vehicleId = ?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, vehicleId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getVehicleImagePath(int vehicleId) {
		try {
			String query = "select * from vehimgpaths WHERE vehicleId = ?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, vehicleId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return rs.getString("vehimgpath");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean getByCategory(int categoryId) {

		try {
			String query = "select * from vehicle WHERE categoryId = ?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, categoryId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean getByBrand(int brandId) {

		try {
			String query = "select * from vehicle WHERE brandId = ?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, brandId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
