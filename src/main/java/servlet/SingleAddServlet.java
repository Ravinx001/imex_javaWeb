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
import services.vehicleService;
import utils.IsInt;

/**
 * Servlet implementation class SingleAddServlet
 */
@WebServlet("/viewadd")
public class SingleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IsInt isInt = new IsInt();
		int vehicleId = 0;

		RequestDispatcher dispatcher = request.getRequestDispatcher("home");

		vehicleService vehicleService = new vehicleService();

		ArrayList<Vehicle> recomendedVehicles = vehicleService.getAllRecommendedVehicles();
		request.setAttribute("recomendedvehicles", recomendedVehicles);

		if (!isInt.isInt(request.getParameter("vehicleId"))) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

		vehicleService service = new vehicleService();

		Vehicle vehicle = new Vehicle();

		vehicle = service.getOne(vehicleId);

		if (vehicle == null) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		}

		request.setAttribute("vehicle", vehicle);

		dispatcher = request.getRequestDispatcher("singleAddView.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
