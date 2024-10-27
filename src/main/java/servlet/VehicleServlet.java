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

import model.Vehicle;
import services.validateService;
import services.vehicleService;
import utils.IsDouble;
import utils.IsInt;

@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vehicleService service = new vehicleService();

		ArrayList<Vehicle> vehicles = service.getAllVehicles();
		request.setAttribute("vehicles", vehicles);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminVehicle.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminVehicleCreate.jsp");
		HttpSession session = request.getSession();

		vehicleService service = new vehicleService();
		validateService validateservice = new validateService();

		IsDouble isDouble = new IsDouble();
		IsInt isInt = new IsInt();
		ZonedDateTime nowInSriLanka = ZonedDateTime.now(ZoneId.of("Asia/Colombo"));
		int currentYear = nowInSriLanka.getYear();

		String title = request.getParameter("title");

		double price = Double.parseDouble(request.getParameter("price"));
		int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));
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
		int userId = Integer.parseInt((String) session.getAttribute("userId"));

		boolean titleStatus = service.validateTitle(title);

		boolean categoryStatus = validateservice.validateCategoryWithId(category);
		boolean brandStatus = validateservice.validateBrandWithId(brand);
		boolean fuelTypeStatus = validateservice.validateFueltypeWithId(fuelType);
		boolean transmissionStatus = validateservice.validateTransmissionWithId(transmission);
		boolean featuringStatus = validateservice.validateFeaturingWithId(featuring);
		boolean locationStatus = validateservice.validateLocationWithId(location);
		boolean conditionStatus = validateservice.validateLocationWithId(condition);
		boolean userStatus = validateservice.validateUserWithId(userId);

		if (title == null || title.equals("") || title.length() < 2 || title.length() > 100) {
			request.setAttribute("validation", "Invalid Title !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (titleStatus) {
			request.setAttribute("validation", "This Title is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!manufactureYear.trim().isEmpty() && (manufactureYear < 0
				|| !isInt.isInt(request.getParameter("manufactureYear")) || manufactureYear > currentYear)) {
			request.setAttribute("validation", "Invalid Year !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (price < 0 || !isDouble.isDouble(request.getParameter("price"))) {
			request.setAttribute("validation", "Invalid Price !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (model == null || model.equals("") || model.length() < 2 || model.length() > 50) {
			request.setAttribute("validation", "Invalid Modal !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (modelVariant == null || modelVariant.equals("") || modelVariant.length() < 2
				|| modelVariant.length() > 50) {
			request.setAttribute("validation", "Invalid Modal Variant !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (mileage == null || mileage.equals("") || mileage.length() < 2 || mileage.length() > 50) {
			request.setAttribute("validation", "Invalid Mileage !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (engineCapacity == null || engineCapacity.equals("") || engineCapacity.length() < 2
				|| engineCapacity.length() > 45) {
			request.setAttribute("validation", "Invalid Engine Capacity !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (description == null || description.equals("") || description.length() < 2
				|| description.length() > 2000) {
			request.setAttribute("validation", "Invalid Description !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!categoryStatus) {
			request.setAttribute("validation", "This Category is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!brandStatus) {
			request.setAttribute("validation", "This Brand is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!fuelTypeStatus) {
			request.setAttribute("validation", "This Fuel Type is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!transmissionStatus) {
			request.setAttribute("validation", "This Transmission is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!featuringStatus) {
			request.setAttribute("validation", "This Featuring is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!locationStatus) {
			request.setAttribute("validation", "This Location is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!conditionStatus) {
			request.setAttribute("validation", "This Condition is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (!userStatus) {
			request.setAttribute("validation", "This Invalid User Id !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		Vehicle vehicle = new Vehicle();

		vehicle.setTitle(title);
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
		vehicle.setFeaturing(featuring);
		vehicle.setUserId(userId);

		boolean status = service.createVehicle(vehicle);

		if (status) {

			ArrayList<Vehicle> vehicles = service.getAllVehicles();
			request.setAttribute("vehicles", vehicles);

			dispatcher = request.getRequestDispatcher("adminVehicle.jsp");

			request.setAttribute("status", "success");
			request.setAttribute("validation", "Vehicle Advertisement Successfully Created !");

			dispatcher.forward(request, response);
		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("validation", "Vehicle Advertisement Creation Failed !");

			dispatcher.forward(request, response);
		}

	}

}
