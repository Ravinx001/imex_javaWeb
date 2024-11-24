package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import services.vehicleService;
import utils.IsInt;

@WebServlet("/vehicledelete")
public class VehicleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IsInt isInt = new IsInt();
		int vehicleId = 0;
		boolean status = false;

		if (!isInt.isInt(request.getParameter("vehicleId")) || request.getParameter("vehicleId").equals("")) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicle");
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		}

		Vehicle vehicle = new Vehicle();
		vehicleService vehicleservice = new vehicleService();

		vehicle.setVehicleId(vehicleId);

		status = vehicleservice.delete(vehicle);

		if (status) {
			request.setAttribute("validation", "Successfully Deleted !");
			request.setAttribute("status", "success");

			response.sendRedirect("vehicle");
			return;
		} else {
			request.setAttribute("validation", "Deletion Failed !");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicle");
			return;
		}

	}

}
