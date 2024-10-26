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
import model.Vehicle;
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
		String location = request.getParameter("location");
		int category = Integer.parseInt(request.getParameter("category"));
		int brand = Integer.parseInt(request.getParameter("brand"));
		int fuelType = Integer.parseInt(request.getParameter("fuelType"));
		int transmission = Integer.parseInt(request.getParameter("transmission"));
		int featuring = Integer.parseInt(request.getParameter("featuring"));
		int userId = Integer.parseInt((String) session.getAttribute("userId"));

		boolean status = service.validateTitle(title);

		if (title == null || title.equals("") || title.length() < 2 || title.length() > 100) {
			request.setAttribute("validation", "Invalid Title !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (status) {
			request.setAttribute("validation", "This Title is Unavailabe !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else if (manufactureYear < 0 || !isInt.isInt(request.getParameter("manufactureYear"))
				|| manufactureYear > currentYear) {
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
		} else if (model == null || model.equals("") || model.length() < 2 || model.length() > 50) {
			request.setAttribute("validation", "Invalid Modal !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		Vehicle vehicle = new Vehicle();

		boolean validationStatus = service.validateBrand(brandName);

		if (validationStatus) {
			request.setAttribute("validation", "This Brand is already available !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else {

			boolean status = service.createBrand(brand);

			if (status) {

				ArrayList<Brand> updatedBrands = service.getAllBrands();
				request.setAttribute("brands", updatedBrands);

				request.setAttribute("status", "success");
				request.setAttribute("validation", "Brand Successfully Created !");

				dispatcher.forward(request, response);
			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("validation", "Brand Creation Failed !");

				dispatcher.forward(request, response);
			}
		}

		dispatcher.forward(request, response);

	}

}
