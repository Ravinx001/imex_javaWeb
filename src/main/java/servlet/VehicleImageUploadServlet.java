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

			vehicleId = (int) session.getAttribute("vehicleId");
			session.removeAttribute("vehicleId");

			// Retrieve the file part
			Part filePart = request.getPart("image");
			if (filePart == null || filePart.getSize() == 0) {
				response.sendRedirect(
						"vehicleimage?validation=No file selected.&&status=failed&&vehicleId=" + vehicleId);
				return;
			}

			String fileName = filePart.getSubmittedFileName();
			if (fileName == null || fileName.isEmpty()) {
				response.sendRedirect("vehicleimage?validation=Invalid file.&&status=failed&&vehicleId=" + vehicleId);
				return;
			}

			// Extract file extension
			String fileExtension = fileName.substring(fileName.lastIndexOf("."));
			if (!fileExtension.matches("\\.(jpg|jpeg|png|gif)$")) {
				response.sendRedirect(
						"vehicleimage?validation=Invalid file type.&&status=failed&&vehicleId=" + vehicleId);
				return;
			}

			// Generate a unique file name
			String uniqueFileName = System.currentTimeMillis() + "_" + java.util.UUID.randomUUID() + fileExtension;

			// Define the upload folder
//			String uploadFolder = "D:\\Projects\\Java Web Projects\\imex_javaWeb\\src\\main\\webapp\\images\\vehicleImages";

			// Dynamically determine the upload folder
			String uploadFolder = getServletContext().getRealPath("/images/vehicleImages");
			File uploadDir = new File(uploadFolder);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs(); // Create directory if it doesn't exist
			}

			System.out.println("path Exists or not: " + uploadDir.exists());

			String filePath = uploadFolder + File.separator + uniqueFileName;

			vehicleService vehicleservice = new vehicleService();

			// Check if the image already exists for this vehicle
			boolean imageStatus = vehicleservice.imageCheck(vehicleId);

			if (imageStatus) {
				// Get the current image path from the database
				String existingImagePath = vehicleservice.getVehicleImagePath(vehicleId);

				System.out.println("existingImagePath: " + uploadFolder + File.separator + existingImagePath);

				if (existingImagePath != null) {
					File existingFile = new File(uploadFolder + File.separator + existingImagePath);
					if (existingFile.exists()) {
						// Delete the existing image
						boolean deleted = existingFile.delete();
						System.out.println("Existing image deleted: " + deleted);
					}
				}
			}

			// Save the new image
			filePart.write(filePath);

			// Save the relative path to the database
			imagePath = "images/vehicleImages/" + uniqueFileName;

			System.out.println("imagePath: " + imagePath);

			boolean status = false;

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
