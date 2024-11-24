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

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		categoryService service = new categoryService();

		ArrayList<Category> categories = service.getAllCategories();
		request.setAttribute("categories", categories);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminCategory.jsp");

		dispatcher.forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminCategory.jsp");
		String process = request.getParameter("process");

		categoryService service = new categoryService();

		ArrayList<Category> categories = service.getAllCategories();
		request.setAttribute("categories", categories);

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
		}

		Category category = new Category();
		category.setCategoryName(categoryName);

		boolean validationStatus = service.validateCategory(categoryName);

		if (validationStatus) {
			request.setAttribute("validation", "This category is already available !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
			return;
		} else {

			boolean status = service.createCategory(category);

			if (status) {
				ArrayList<Category> updatedCategories = service.getAllCategories();
				request.setAttribute("categories", updatedCategories);

				request.setAttribute("status", "success");
				request.setAttribute("validation", "Category Successfully Created !");

				dispatcher.forward(request, response);
				return;
			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("validation", "Category Creation Failed !");

				dispatcher.forward(request, response);
				return;
			}
		}

	}

}
