package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Inquiry;
import services.InquiryService;

@WebServlet("/inquiry")
public class InquiryCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InquiryService inquiryService = new InquiryService();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("home");

		InquiryService inquiryService = new InquiryService();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String inquiry = request.getParameter("inquiry");
		boolean status = false;

		// Validate vehicleId (must be a valid integer)
		if (request.getParameter("vehicleId") == null || request.getParameter("vehicleId").equals("")
				|| !request.getParameter("vehicleId").matches("\\d+")) {

			request.setAttribute("validation", "Error !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

			return;
		}

		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

		dispatcher = request.getRequestDispatcher("viewadd?vehicleId=" + vehicleId);

		// Validate name
		if (name == null || name.equals("") || name.length() < 2 || name.length() > 20) {
			request.setAttribute("validation", "Invalid Name !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

			return;
		} else if (email == null || email.equals("") || !email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
			request.setAttribute("validation", "Invalid Email !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

			return;
		} else if (mobile == null || mobile.equals("")
				|| !mobile.matches("^(070|071|072|075|076|077|078|079)\\d{7}$")) {
			request.setAttribute("validation", "Invalid Mobile !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else if (inquiry == null || inquiry.equals("") || inquiry.length() < 10 || inquiry.length() > 250) {
			request.setAttribute("validation", "Invalid Inquiry Length !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

			return;
		} else {
			Inquiry inquiryObject = new Inquiry();

			inquiryObject.setVehicleId(vehicleId);
			inquiryObject.setCustomerName(name);
			inquiryObject.setCustomerEmail(email);
			inquiryObject.setCustomerMobile(mobile);
			inquiryObject.setInquiry(inquiry);

			status = inquiryService.createInquiry(inquiryObject);
		}

		System.out.println("Name: " + request.getParameter("name"));
		System.out.println("Email: " + request.getParameter("email"));
		System.out.println("Mobile: " + request.getParameter("mobile"));
		System.out.println("Inquiry: " + request.getParameter("inquiry"));
		System.out.println("VehicleId: " + request.getParameter("vehicleId"));

		if (status) {
			request.setAttribute("validation", "Inquiry Successfully Created !");
			request.setAttribute("status", "success");

			dispatcher.forward(request, response);

			return;
		} else {
			request.setAttribute("validation", "Inquiry Sending Failed!");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

			return;
		}

	}

}
