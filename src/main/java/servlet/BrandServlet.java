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
import services.brandService;

@WebServlet("/brand")
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		brandService service = new brandService();

		ArrayList<Brand> brands = service.getAllBrands();
		request.setAttribute("brands", brands);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminBrand.jsp");

		dispatcher.forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminBrand.jsp");
		String process = request.getParameter("process");

		brandService service = new brandService();

		ArrayList<Brand> brands = service.getAllBrands();
		request.setAttribute("brands", brands);

		String brandName = request.getParameter("brandName");

		if (brandName == null || brandName.equals("") || brandName.length() < 2 || brandName.length() > 50) {
			request.setAttribute("validation", "Invalid Brand Name !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else if (process == null || process.equals("")) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		}

		Brand brand = new Brand();
		brand.setBrandName(brandName);

		boolean validationStatus = service.validateBrand(brandName);

		if (validationStatus) {
			request.setAttribute("validation", "This Brand is already available !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else {

			boolean status = service.createBrand(brand);

			if (status) {

				ArrayList<Brand> updatedBrands = service.getAllBrands();
				request.setAttribute("brands", updatedBrands);

				request.setAttribute("status", "success");
				request.setAttribute("validation", "Brand Successfully Created !");

				dispatcher.forward(request, response);
				return;
			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("validation", "Brand Creation Failed !");

				dispatcher.forward(request, response);
				return;
			}
		}

	}

}
