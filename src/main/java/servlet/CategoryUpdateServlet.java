package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import services.categoryService;
import services.vehicleService;

@WebServlet("/categoryupdate")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId = 0;
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateCategory.jsp");

		categoryId = Integer.parseInt(request.getParameter("categoryId"));

		if (categoryId == 0) {
			request.setAttribute("validation", "Error");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		}

		categoryService service = new categoryService();

		Category category = new Category();

		category = service.getOne(categoryId);

		request.setAttribute("category", category);

		dispatcher.forward(request, response);
		return;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("updateCategory.jsp");
		String process = request.getParameter("process");

		int categoryId = 0;
		categoryId = Integer.parseInt(request.getParameter("categoryId"));

		categoryService service = new categoryService();
		vehicleService vehicleService = new vehicleService();
		Category categoryUpdated = new Category();

		categoryUpdated = service.getOne(categoryId);

		request.setAttribute("category", categoryUpdated);

		if (process.equals("update")) {

			String categoryName = request.getParameter("categoryName");

			if (categoryName == null || categoryName.equals("") || categoryName.length() < 2
					|| categoryName.length() > 50) {
				request.setAttribute("validation", "Invalid categoryName !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			} else if (process == null || process.equals("")) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			} else if (categoryId == 0) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			}

			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setCategoryId(categoryId);

			boolean validationStatus = service.validateCategory(categoryName);

			if (validationStatus) {
				request.setAttribute("validation", "This category is already available !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			} else {

				boolean status = service.update(category);

				categoryUpdated = service.getOne(categoryId);

				request.setAttribute("category", categoryUpdated);

				category = service.getOne(categoryId);

				if (status) {

					request.setAttribute("status", "success");
					request.setAttribute("validation", "Category Successfully Updated !");

					dispatcher.forward(request, response);
					return;
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("validation", "Category Updation Failed !");

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
			} else if (categoryId == 0) {
				request.setAttribute("validation", "Error");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
				return;
			}

			Category category = new Category();
			category.setCategoryId(categoryId);

			boolean vehicleAvailabilityStatus = vehicleService.getByCategory(categoryId);

			if (vehicleAvailabilityStatus) {
				request.setAttribute("status", "failed");
				request.setAttribute("validation",
						"Category Can't Deleted As Vehicle Ads are refered by this Category!");

				dispatcher.forward(request, response);
				return;
			}

			boolean status = service.delete(category);

			if (status) {
				dispatcher = request.getRequestDispatcher("adminCategory.jsp");

				ArrayList<Category> categories = service.getAllCategories();
				request.setAttribute("categories", categories);

				request.setAttribute("status", "success");
				request.setAttribute("validation", "Category Successfully Deleted !");

				dispatcher.forward(request, response);
				return;
			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("validation", "Category Deletion Failed !");

				dispatcher.forward(request, response);
				return;
			}

		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("validation", "Category Deletion Failed !");

			dispatcher.forward(request, response);
			return;
		}

	}

}
