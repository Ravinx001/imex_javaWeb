package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			response.sendRedirect("vehicle?validation=Error.&&status=failed");
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		}

		vehicleService vehicleservice = new vehicleService();

		System.out.println("Vehicle Id from Vehicle Delete Servlet: " + vehicleId);

		status = vehicleservice.delete(vehicleId);

		if (status) {
			response.sendRedirect("vehicle?validation=Successfully Deleted !&&status=success");
			return;
		} else {
			response.sendRedirect("vehicle?validation=Deletion Failed !&&status=failed");
			return;
		}

	}

}
