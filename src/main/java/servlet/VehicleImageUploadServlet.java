package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class VehicleImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vehicleService vehicleservice = new vehicleService();
		HttpSession session = request.getSession();

		IsInt isInt = new IsInt();
		int vehicleId = 0;

		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle");

		if (!isInt.isInt(request.getParameter("vehicleId"))) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else {
			vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

			session.setAttribute("vehicleId", vehicleId);
		}

		Vehicle vehicle = new Vehicle();

		System.out.println("Int Vehicle Id: " + vehicleId);

		vehicle = vehicleservice.getOne(vehicleId);

		request.setAttribute("vehicle", vehicle);

		System.out.println("Vehicle Id: " + session.getAttribute("vehicleId"));
		System.out.println("Vehicle Image Path: " + vehicle);

		dispatcher = request.getRequestDispatcher("adminVehicleImageUpload.jsp");

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
			if (session.getAttribute("vehicleId") == null) {

				response.sendRedirect("vehicle?validation=Vehicle ID is missing.&&status=failed");
				return;
			}

			System.out.println("Vehicle Id: " + session.getAttribute("vehicleId"));

			vehicleId = (int) session.getAttribute("vehicleId");

			System.out.println("Int Vehicle Id: " + vehicleId);
			session.removeAttribute("vehicleId");

			// Retrieve the file part
			Part filePart = request.getPart("image");
			if (filePart == null || filePart.getSize() == 0) {

				response.sendRedirect(
						"vehicleimage?validation=No file selected.&&status=failed&&vehicleId=" + vehicleId);
				return;
			}

			System.out.println("filePart: " + filePart);

			// Get the file name
			String fileName = filePart.getSubmittedFileName();

			if (fileName == null || fileName.isEmpty()) {

				response.sendRedirect("vehicleimage?validation=Invalid file.&&status=failed&&vehicleId=" + vehicleId);
				return;
			}

			System.out.println("fileName: " + fileName);

			// Define the upload folder
//			String uploadFolder = getServletContext().getRealPath("/images/vehicle/");

//			String uploadFolder = getServletContext().getRealPath("") + "images" + File.separator + "vehicle";

			String uploadFolder = "D:\\Projects\\Java Web Projects\\imex_javaWeb\\src\\main\\webapp\\images\\vehicleImages";

			File uploadDir = new File(uploadFolder);

			if (!uploadDir.exists()) {
				uploadDir.mkdirs(); // Create directory if it doesn't exist
			}

			System.out.println("uploadFolder: " + uploadFolder);

			// Save the file
			String filePath = uploadFolder + File.separator + fileName;
			filePart.write(filePath);

			System.out.println("Save filePath: " + filePath);

			// Save the relative path to the database
			imagePath = "images/vehicle/" + fileName;

			System.out.println("Databse Save Path: " + imagePath);

			vehicleService vehicleservice = new vehicleService();

			boolean imageStatus = vehicleservice.imageCheck(vehicleId);
			boolean status = false;

			System.out.println("imageStatus: " + imageStatus);

			if (imageStatus) {
				status = vehicleservice.updateVehicleImage(vehicleId, imagePath);
			} else {
				status = vehicleservice.saveVehicleImage(vehicleId, imagePath);
			}

			if (status) {

				response.sendRedirect(
						"vehicleimage?validation=Image uploaded successfully.&&status=success&&vehicleId=" + vehicleId);
			} else {

				response.sendRedirect(
						"vehicleimage?validation=Failed to save image in database.&&status=failed&&vehicleId="
								+ vehicleId);
			}
		} catch (Exception e) {

			e.printStackTrace();

			response.sendRedirect(
					"vehicleimage?validation=Error occurred during upload.&&status=failed&&vehicleId=" + vehicleId);
		}

	}

}
