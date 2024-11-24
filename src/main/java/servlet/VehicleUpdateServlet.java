package servlet;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Brand;
import model.Category;
import model.Condition;
import model.Featuring;
import model.FuelType;
import model.Location;
import model.Transmission;
import model.Vehicle;
import services.brandService;
import services.categoryService;
import services.conditionService;
import services.featuringService;
import services.fuelTypeService;
import services.locationService;
import services.transmissionService;
import services.validateService;
import services.vehicleService;
import utils.IsDouble;
import utils.IsInt;

@WebServlet("/vehicleupdate")
public class VehicleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		categoryService categoryService = new categoryService();
		brandService brandService = new brandService();
		fuelTypeService fuelTypeService = new fuelTypeService();
		transmissionService transmissionService = new transmissionService();
		conditionService conditionService = new conditionService();
		featuringService featuringService = new featuringService();
		locationService locationService = new locationService();
		vehicleService vehicleservice = new vehicleService();

		IsInt isInt = new IsInt();
		int vehicleId = 0;

		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle");

		if (!isInt.isInt(request.getParameter("vehicleId"))) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		}

		ArrayList<Category> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);

		ArrayList<Brand> brands = brandService.getAllBrands();
		request.setAttribute("brands", brands);

		ArrayList<FuelType> fuelTypes = fuelTypeService.getAllfuelTypes();
		request.setAttribute("fuelTypes", fuelTypes);

		ArrayList<Transmission> transmissions = transmissionService.getAllTansmissions();
		request.setAttribute("transmissions", transmissions);

		ArrayList<Condition> conditions = conditionService.getAllConditions();
		request.setAttribute("conditions", conditions);

		ArrayList<Location> locations = locationService.getAllLocations();
		request.setAttribute("locations", locations);

		ArrayList<Featuring> featurings = featuringService.getAllFeaturings();
		request.setAttribute("featurings", featurings);

		Vehicle vehicle = new Vehicle();
		vehicle = vehicleservice.getOne(vehicleId);

		request.setAttribute("vehicle", vehicle);

		dispatcher = request.getRequestDispatcher("adminVehicleUpdate.jsp");

		dispatcher.forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IsInt isInt = new IsInt();
		int vehicleId = 0;

		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle");

		categoryService categoryService = new categoryService();
		brandService brandService = new brandService();
		fuelTypeService fuelTypeService = new fuelTypeService();
		transmissionService transmissionService = new transmissionService();
		conditionService conditionService = new conditionService();
		featuringService featuringService = new featuringService();
		locationService locationService = new locationService();
		vehicleService vehicleservice = new vehicleService();

		Vehicle vehicle = new Vehicle();

		ArrayList<Category> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);

		ArrayList<Brand> brands = brandService.getAllBrands();
		request.setAttribute("brands", brands);

		ArrayList<FuelType> fuelTypes = fuelTypeService.getAllfuelTypes();
		request.setAttribute("fuelTypes", fuelTypes);

		ArrayList<Transmission> transmissions = transmissionService.getAllTansmissions();
		request.setAttribute("transmissions", transmissions);

		ArrayList<Condition> conditions = conditionService.getAllConditions();
		request.setAttribute("conditions", conditions);

		ArrayList<Location> locations = locationService.getAllLocations();
		request.setAttribute("locations", locations);

		ArrayList<Featuring> featurings = featuringService.getAllFeaturings();
		request.setAttribute("featurings", featurings);

		if (!isInt.isInt(request.getParameter("vehicleId")) || request.getParameter("vehicleId").equals("")) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		}

		vehicle = vehicleservice.getOne(vehicleId);

		dispatcher = request.getRequestDispatcher("vehicleupdate?vehicleId=" + vehicleId);

		HttpSession session = request.getSession();

		vehicleService service = new vehicleService();
		validateService validateservice = new validateService();

		IsDouble isDouble = new IsDouble();
		ZonedDateTime nowInSriLanka = ZonedDateTime.now(ZoneId.of("Asia/Colombo"));
		int currentYear = nowInSriLanka.getYear();
		int userId = (int) session.getAttribute("userId");

		System.out.println("Title: " + request.getParameter("title"));
		System.out.println("Price: " + request.getParameter("vehicleprice"));
		System.out.println("manufactureYear: " + request.getParameter("manufactureYear"));
		System.out.println("currentYear: " + currentYear);
		System.out.println("model: " + request.getParameter("model"));
		System.out.println("modelVariant: " + request.getParameter("modelVariant"));
		System.out.println("mileage: " + request.getParameter("mileage"));
		System.out.println("engineCapacity: " + request.getParameter("engineCapacity"));
		System.out.println("description: " + request.getParameter("description"));
		System.out.println("Location: " + request.getParameter("location"));
		System.out.println("category: " + request.getParameter("category"));
		System.out.println("brand: " + request.getParameter("brand"));
		System.out.println("fuelType: " + request.getParameter("fuelType"));
		System.out.println("transmission: " + request.getParameter("transmission"));
		System.out.println("condition: " + request.getParameter("condition"));
		System.out.println("featuring: " + request.getParameter("featuring"));
		System.out.println("userId: " + userId);

		String title = request.getParameter("title");

		double price = 0.0;

		if (isDouble.isDouble(request.getParameter("vehicleprice"))) {
			price = Double.parseDouble(request.getParameter("vehicleprice"));
		}

		int manufactureYear = 0;

		if (isInt.isInt(request.getParameter("manufactureYear"))) {
			manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));
		}

		String model = request.getParameter("model");
		String modelVariant = request.getParameter("modelVariant");
		String mileage = request.getParameter("mileage");
		String engineCapacity = request.getParameter("engineCapacity");
		String description = request.getParameter("description");
		int location = Integer.parseInt(request.getParameter("location"));
		int condition = Integer.parseInt(request.getParameter("condition"));
		int category = Integer.parseInt(request.getParameter("category"));
		int brand = Integer.parseInt(request.getParameter("brand"));
		int fuelType = Integer.parseInt(request.getParameter("fuelType"));
		int transmission = Integer.parseInt(request.getParameter("transmission"));
		int featuring = Integer.parseInt(request.getParameter("featuring"));

		boolean titleStatus = service.validateTitle(title);

		boolean categoryStatus = validateservice.validateCategoryWithId(category);
		boolean brandStatus = validateservice.validateBrandWithId(brand);
		boolean fuelTypeStatus = validateservice.validateFueltypeWithId(fuelType);
		boolean transmissionStatus = validateservice.validateTransmissionWithId(transmission);
		boolean featuringStatus = validateservice.validateFeaturingWithId(featuring);
		boolean locationStatus = validateservice.validateLocationWithId(location);
		boolean conditionStatus = validateservice.validateConditionWithId(condition);
		boolean userStatus = validateservice.validateUserWithId(userId);

		System.out.println("titleStatus: " + titleStatus);
		System.out.println("categoryStatus: " + categoryStatus);
		System.out.println("brandStatus: " + brandStatus);
		System.out.println("fuelTypeStatus: " + fuelTypeStatus);
		System.out.println("transmissionStatus: " + transmissionStatus);
		System.out.println("featuringStatus: " + featuringStatus);
		System.out.println("locationStatus: " + locationStatus);
		System.out.println("conditionStatus: " + conditionStatus);
		System.out.println("userStatus: " + userStatus);

		if (title == null || title.equals("") || title.length() < 2 || title.length() > 100) {
			request.setAttribute("validation", "Invalid Title !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (titleStatus && !title.equals(vehicle.getTitle())) {
			request.setAttribute("validation", "This Title is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (price != 0.00 && price < 0) {
			request.setAttribute("validation", "Invalid Price !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((manufactureYear != 0) && (manufactureYear > currentYear)) {
			request.setAttribute("validation", "Invalid Year !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((!request.getParameter("model").equals("")) && (model.length() < 2 || model.length() > 50)) {
			request.setAttribute("validation", "Invalid Model !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((!request.getParameter("modelVariant").equals(""))
				&& (modelVariant.length() < 2 || modelVariant.length() > 50)) {
			request.setAttribute("validation", "Invalid Modal Variant !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((!request.getParameter("mileage").equals("")) && (mileage.length() < 2 || mileage.length() > 50)) {
			request.setAttribute("validation", "Invalid Mileage !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((!request.getParameter("engineCapacity").equals(""))
				&& (engineCapacity.length() < 2 || engineCapacity.length() > 45)) {
			request.setAttribute("validation", "Invalid Engine Capacity !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if ((!request.getParameter("description").equals(""))
				&& (description.length() < 2 || description.length() > 2000)) {
			request.setAttribute("validation", "Invalid Description !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!categoryStatus) {
			request.setAttribute("validation", "Select Category is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!brandStatus) {
			request.setAttribute("validation", "This Brand is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!fuelTypeStatus) {
			request.setAttribute("validation", "This Fuel Type is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!transmissionStatus) {
			request.setAttribute("validation", "This Transmission is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!featuringStatus) {
			request.setAttribute("validation", "This Featuring is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!locationStatus) {
			request.setAttribute("validation", "This Location is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!conditionStatus) {
			request.setAttribute("validation", "This Condition is Unavailabe !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		} else if (!userStatus) {
			request.setAttribute("validation", "This Invalid User Id !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		}

		System.out.println("Title: " + title);
		System.out.println("Price: " + price);
		System.out.println("manufactureYear: " + manufactureYear);
		System.out.println("currentYear: " + currentYear);
		System.out.println("model: " + model);
		System.out.println("modelVariant: " + modelVariant);
		System.out.println("mileage: " + mileage);
		System.out.println("engineCapacity: " + engineCapacity);
		System.out.println("description: " + description);
		System.out.println("Location: " + location);
		System.out.println("category: " + category);
		System.out.println("brand: " + brand);
		System.out.println("fuelType: " + fuelType);
		System.out.println("transmission: " + transmission);
		System.out.println("condition: " + condition);
		System.out.println("featuring: " + featuring);
		System.out.println("userId: " + userId);

		vehicle.setTitle(title);
		vehicle.setPrice(price);
		vehicle.setManufactureYear(manufactureYear);
		vehicle.setModel(model);
		vehicle.setModelVariant(modelVariant);
		vehicle.setMileage(mileage);
		vehicle.setEngineCapacity(engineCapacity);
		vehicle.setDescription(description);
		vehicle.setLocation(location);
		vehicle.setCategotry(category);
		vehicle.setBrand(brand);
		vehicle.setFueltype(fuelType);
		vehicle.setTransmission(transmission);
		vehicle.setCondition(condition);
		vehicle.setFeaturing(featuring);
		vehicle.setUserId(userId);
		vehicle.setVehicleId(vehicleId);

		boolean status = service.update(vehicle);

		System.out.println("status: " + status);

		if (status) {

			ArrayList<Vehicle> vehicles = service.getAllVehicles();
			request.setAttribute("vehicles", vehicles);

			dispatcher = request.getRequestDispatcher("adminVehicle.jsp");

			request.setAttribute("status", "success");
			request.setAttribute("validation", "Vehicle Advertisement Successfully Updated !");

			dispatcher.forward(request, response);
			return;
		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("validation", "Vehicle Advertisement Update Failed !");

			response.sendRedirect("vehicleupdate?vehicleId=" + vehicleId);
			return;
		}
	}

}
