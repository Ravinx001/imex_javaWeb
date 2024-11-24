package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Brand;
import model.Category;
import model.Vehicle;
import services.brandService;
import services.categoryService;
import services.vehicleService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		categoryService categoryService = new categoryService();
		brandService brandService = new brandService();
		vehicleService vehicleService = new vehicleService();

//		fuelTypeService fuelTypeService = new fuelTypeService();
//		transmissionService transmissionService = new transmissionService();
//		conditionService conditionService = new conditionService();
//		featuringService featuringService = new featuringService();
//		locationService locationService = new locationService();

		ArrayList<Category> categories = categoryService.getAllTopCategories();
		request.setAttribute("categories", categories);

		ArrayList<Brand> brands = brandService.getAllBrands();
		request.setAttribute("brands", brands);

		ArrayList<Vehicle> recomendedVehicles = vehicleService.getAllRecommendedVehicles();
		request.setAttribute("recomendedvehicles", recomendedVehicles);

		ArrayList<Vehicle> usedVehicles = vehicleService.getAllUsedVehicles();
		request.setAttribute("usedvehicles", usedVehicles);

		ArrayList<Vehicle> newVehicles = vehicleService.getAllNewVehicles();
		request.setAttribute("newvehicles", newVehicles);

//		ArrayList<FuelType> fuelTypes = fuelTypeService.getAllfuelTypes();
//		request.setAttribute("fuelTypes", fuelTypes);
//
//		ArrayList<Transmission> transmissions = transmissionService.getAllTansmissions();
//		request.setAttribute("transmissions", transmissions);
//
//		ArrayList<Condition> conditions = conditionService.getAllConditions();
//		request.setAttribute("conditions", conditions);
//
//		ArrayList<Location> locations = locationService.getAllLocations();
//		request.setAttribute("locations", locations);
//
//		ArrayList<Featuring> featurings = featuringService.getAllFeaturings();
//		request.setAttribute("featurings", featurings);

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");

		dispatcher.forward(request, response);
		return;

	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
