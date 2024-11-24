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

@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vehicleService vehicleService = new vehicleService();

		ArrayList<Vehicle> vehicles = vehicleService.getAllVehicles();
		request.setAttribute("vehicles", vehicles);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminVehicle.jsp");

		dispatcher.forward(request, response);
		return;
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	}

}
