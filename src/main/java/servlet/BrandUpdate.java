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

@WebServlet("/brandupdate")
public class BrandUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int brandId = 0;
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateBrand.jsp");

		brandId = Integer.parseInt(request.getParameter("brandId"));

		if (brandId == 0) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		}

		brandService service = new brandService();

		Brand brand = new Brand();

		brand = service.getOne(brandId);

		request.setAttribute("brand", brand);

		dispatcher.forward(request, response);
		return;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("updateBrand.jsp");
		String process = request.getParameter("process");

		int brandId = 0;
		brandId = Integer.parseInt(request.getParameter("brandId"));

		brandService service = new brandService();
		Brand brandUpdated = new Brand();

		brandUpdated = service.getOne(brandId);
		request.setAttribute("brand", brandUpdated);

		if (process.equals("update")) {

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
			} else if (brandId == 0) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			}

			Brand brand = new Brand();
			brand.setBrandName(brandName);
			brand.setBrandId(brandId);

			boolean validationStatus = service.validateBrand(brandName);

			if (validationStatus) {
				request.setAttribute("validation", "This Brand is already available !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			} else {

				boolean status = service.update(brand);

				brandUpdated = service.getOne(brandId);
				request.setAttribute("brand", brandUpdated);

				if (status) {

					request.setAttribute("status", "success");
					request.setAttribute("validation", "Brand Successfully Updated !");

					dispatcher.forward(request, response);
					return;
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("validation", "Brand Updation Failed !");

					dispatcher.forward(request, response);
					return;
				}
			}

		} else if (process.equals("delete")) {

			if (process == null || process.equals("")) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			} else if (brandId == 0) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			}

			Brand brand = new Brand();
			brand.setBrandId(brandId);

			boolean status = service.delete(brand);

			if (status) {
				dispatcher = request.getRequestDispatcher("adminBrand.jsp");

				ArrayList<Brand> brands = service.getAllBrands();
				request.setAttribute("brands", brands);

				request.setAttribute("status", "success");
				request.setAttribute("validation", "Brand Successfully Deleted !");

				dispatcher.forward(request, response);
				return;
			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("validation", "Brand Deletion Failed !");

				dispatcher.forward(request, response);
				return;
			}

		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("validation", "Brand Deletion Failed !");

			dispatcher.forward(request, response);
			return;
		}

	}

}
