package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Vehicle;
import services.vehicleService;
import utils.IsInt;

@WebServlet("/vehicleimage")
public class VehicleImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vehicleService vehicleservice = new vehicleService();

		IsInt isInt = new IsInt();
		int vehicleId = 0;

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminVehicleImageUpload.jsp");

		if (!isInt.isInt(request.getParameter("vehicleId"))) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			response.sendRedirect("vehicle");
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		}

		Vehicle vehicle = new Vehicle();
		vehicle = vehicleservice.getOne(vehicleId);

		request.setAttribute("vehicle", vehicle);

		dispatcher.forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int vehicleId = 0;
		String imagePath = null;
		HttpSession session = request.getSession();

		try {
			// Retrieve the vehicleId
			String vehicleIdStr = request.getParameter("vehicleId");

			if (vehicleIdStr == null || vehicleIdStr.isEmpty()) {
				session.setAttribute("validation", "Vehicle ID is missing.");
				session.setAttribute("status", "failed");

				response.sendRedirect("vehicle");
				return;
			}

			vehicleId = Integer.parseInt(vehicleIdStr);

			// Retrieve the file part
			Part filePart = request.getPart("image");
			if (filePart == null || filePart.getSize() == 0) {
				session.setAttribute("validation", "No file selected.");
				session.setAttribute("status", "failed");

				response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
				return;
			}

			// Get the file name
			String fileName = filePart.getSubmittedFileName();

			if (fileName == null || fileName.isEmpty()) {
				session.setAttribute("validation", "Invalid file.");
				session.setAttribute("status", "failed");

				response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
				return;
			}

			// Define the upload folder
			String uploadFolder = getServletContext().getRealPath("/images/vehicle/");

			File uploadDir = new File(uploadFolder);

			if (!uploadDir.exists()) {
				uploadDir.mkdirs(); // Create directory if it doesn't exist
			}

			// Save the file
			String filePath = uploadFolder + File.separator + fileName;
			filePart.write(filePath);

			// Save the relative path to the database
			imagePath = "images/vehicle/" + fileName;

			vehicleService vehicleservice = new vehicleService();

			boolean status = vehicleservice.updateVehicleImage(vehicleId, imagePath);

			if (status) {
				session.setAttribute("status", "success");
				session.setAttribute("validation", "Image uploaded successfully.");
				response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
			} else {
				session.setAttribute("validation", "Failed to save image in database.");
				session.setAttribute("status", "failed");
				response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
			}
		} catch (Exception e) {

			e.printStackTrace();

			session.setAttribute("validation", "Error occurred during upload.");
			session.setAttribute("status", "failed");

			response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
		}

//		@Override
//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//		        throws ServletException, IOException {
//
//		    request.setCharacterEncoding("UTF-8");
//		    response.setContentType("text/html;charset=UTF-8");
//
//		    int vehicleId = 0;
//		    String imagePath = null;
//
//		    try {
//		        // Retrieve the vehicleId
//		        String vehicleIdStr = request.getParameter("vehicleId");
//		        if (vehicleIdStr == null || vehicleIdStr.isEmpty()) {
//		            request.setAttribute("validation", "Vehicle ID is missing.");
//		            request.setAttribute("status", "failed");
//		            response.sendRedirect("vehicle");
//		            return;
//		        }
//
//		        vehicleId = Integer.parseInt(vehicleIdStr);
//
//		        // Retrieve the file part
//		        Part filePart = request.getPart("image");
//		        if (filePart == null || filePart.getSize() == 0) {
//		            request.setAttribute("validation", "No file selected.");
//		            request.setAttribute("status", "failed");
//		            response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
//		            return;
//		        }
//
//		        // Get the file name
//		        String fileName = filePart.getSubmittedFileName();
//		        if (fileName == null || fileName.isEmpty()) {
//		            request.setAttribute("validation", "Invalid file.");
//		            request.setAttribute("status", "failed");
//		            response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
//		            return;
//		        }
//
//		        // Define the upload folder
//		        String uploadFolder = getServletContext().getRealPath("/images/vehicle/");
//		        File uploadDir = new File(uploadFolder);
//		        if (!uploadDir.exists()) {
//		            uploadDir.mkdirs(); // Create directory if it doesn't exist
//		        }
//
//		        // Save the file
//		        String filePath = uploadFolder + File.separator + fileName;
//		        filePart.write(filePath);
//
//		        // Save the relative path to the database
//		        imagePath = "images/vehicle/" + fileName;
//		        vehicleService vehicleservice = new vehicleService();
//		        boolean status = vehicleservice.updateVehicleImage(vehicleId, imagePath);
//
//		        if (status) {
//		            request.setAttribute("status", "success");
//		            request.setAttribute("validation", "Image uploaded successfully.");
//		            response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
//		        } else {
//		            request.setAttribute("validation", "Failed to save image in database.");
//		            request.setAttribute("status", "failed");
//		            response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
//		        }
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		        request.setAttribute("validation", "Error occurred during upload.");
//		        request.setAttribute("status", "failed");
//		        response.sendRedirect("vehicleimage?vehicleId=" + vehicleId);
//		    }
//		}
	}

}
