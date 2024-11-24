package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import services.searchService;
import services.vehicleService;
import utils.IsInt;

@WebServlet("/allads")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vehicleService vehicleService = new vehicleService();
		searchService searchService = new searchService();

		ArrayList<Vehicle> recomendedVehicles = vehicleService.getAllRecommendedVehicles();
		request.setAttribute("recomendedvehicles", recomendedVehicles);

		ArrayList<Vehicle> allVehicles = searchService.getAllVehicles();
		request.setAttribute("allvehicles", allVehicles);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adlisting.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Title: " + request.getParameter("title"));
		System.out.println("Price-min: " + request.getParameter("price-min"));
		System.out.println("Price-max: " + request.getParameter("price-max"));
		System.out.println("Condition: " + request.getParameter("condition-nr"));
		System.out.println("Condition: " + request.getParameter("condition-nur"));
		System.out.println("Condition: " + request.getParameter("condition-ur"));
		System.out.println("Condition: " + request.getParameter("condition-uur"));

		vehicleService vehicleService = new vehicleService();
		searchService searchService = new searchService();

		ArrayList<Vehicle> recomendedVehicles = vehicleService.getAllRecommendedVehicles();
		request.setAttribute("recomendedvehicles", recomendedVehicles);

		ArrayList<Vehicle> allVehicles = searchService.getAllVehicles();

		IsInt isInt = new IsInt();
		RequestDispatcher dispatcher = request.getRequestDispatcher("adlisting.jsp");

		if (!request.getParameter("title").equals("")
				&& (request.getParameter("title").length() < 2 || request.getParameter("title").length() > 100)) {
			request.setAttribute("validation", "Invalid Title !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!request.getParameter("price-min").equals("") && !isInt.isInt(request.getParameter("price-min"))) {
			request.setAttribute("validation", "Invalid Min Price !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!request.getParameter("price-max").equals("") && !isInt.isInt(request.getParameter("price-max"))) {
			request.setAttribute("validation", "Invalid Max Price !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!isInt.isInt(request.getParameter("condition-nr")) && request.getParameter("condition-nr") != null) {
			request.setAttribute("validation", "Invalid Condition !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!isInt.isInt(request.getParameter("condition-nur")) && request.getParameter("condition-nur") != null) {
			request.setAttribute("validation", "Invalid Condition !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!isInt.isInt(request.getParameter("condition-ur")) && request.getParameter("condition-ur") != null) {
			request.setAttribute("validation", "Invalid Condition !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		if (!isInt.isInt(request.getParameter("condition-uur")) && request.getParameter("condition-uur") != null) {
			request.setAttribute("validation", "Invalid Condition !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		String title = null;
		int price_min = -1;
		int price_max = -1;
		int condition_nr = -1;
		int condition_nur = -1;
		int condition_ur = -1;
		int condition_uur = -1;

		if (!request.getParameter("title").equals("")) {
			title = request.getParameter("title");
		}

		if (!request.getParameter("price-min").equals("")) {
			price_min = Integer.parseInt(request.getParameter("price-min"));

			if (price_min < 0) {
				request.setAttribute("validation", "Invalid Min Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("")) {
			price_max = Integer.parseInt(request.getParameter("price-max"));

			if (price_max < 0) {
				request.setAttribute("validation", "Invalid Max Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("") && !request.getParameter("price-min").equals("")) {
			if (price_max < price_min) {
				request.setAttribute("validation", "Invalid Price Range !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("")) {
			price_max = Integer.parseInt(request.getParameter("price-max"));

			if (price_max < 0) {
				request.setAttribute("validation", "Invalid Max Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("")) {
			price_max = Integer.parseInt(request.getParameter("price-max"));

			if (price_max < 0) {
				request.setAttribute("validation", "Invalid Max Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("")) {
			price_max = Integer.parseInt(request.getParameter("price-max"));

			if (price_max < 0) {
				request.setAttribute("validation", "Invalid Max Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (!request.getParameter("price-max").equals("")) {
			price_max = Integer.parseInt(request.getParameter("price-max"));

			if (price_max < 0) {
				request.setAttribute("validation", "Invalid Max Price !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			}
		}

		if (request.getParameter("condition-nr") != null) {
			condition_nr = Integer.parseInt(request.getParameter("condition-nr"));
		}

		if (request.getParameter("condition-nur") != null) {
			condition_nur = Integer.parseInt(request.getParameter("condition-nur"));
		}

		if (request.getParameter("condition-ur") != null) {
			condition_ur = Integer.parseInt(request.getParameter("condition-ur"));
		}

		if (request.getParameter("condition-uur") != null) {
			condition_uur = Integer.parseInt(request.getParameter("condition-uur"));
		}

		allVehicles = searchService.searchAllVehicles(title, price_min, price_max, condition_nr, condition_nur,
				condition_ur, condition_uur);
		request.setAttribute("allvehicles", allVehicles);

		request.setAttribute("title", title);
		request.setAttribute("price_min", price_min);
		request.setAttribute("price_max", price_max);
		request.setAttribute("condition_nr", condition_nr);
		request.setAttribute("condition_nur", condition_nur);
		request.setAttribute("condition_ur", condition_ur);
		request.setAttribute("condition_uur", condition_uur);

		System.out.println("Title: " + title);
		System.out.println("Price-min: " + price_max);
		System.out.println("Price-max: " + price_min);
		System.out.println("Conditio-nr: " + condition_nr);
		System.out.println("Condition-nur: " + condition_nur);
		System.out.println("Condition-ur: " + condition_ur);
		System.out.println("Condition-uur: " + condition_uur);

		dispatcher.forward(request, response);

	}

}
