package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.userService;
import utils.Hashing;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uemail = request.getParameter("email");
		String upwd = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();

		// Regular expression for email validation
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher matcher = emailPattern.matcher(uemail);

		if (uemail == null || uemail.equals("") || !matcher.matches()) {
			request.setAttribute("validation", "Invalid Email !");
			request.setAttribute("status", "failed");

			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;

		} else if (upwd == null || upwd.equals("") || upwd.length() < 8 || upwd.length() > 50) {
			request.setAttribute("validation", "Invalid Password !");
			request.setAttribute("status", "failed");

			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Hashing hash = new Hashing();

		User user = new User();
		user.setEmail(uemail);
		user.setPassword(hash.hashPassword(upwd));

		userService service = new userService();

		boolean status = service.validate(user);

		if (status) {

			User loggedUser = service.getOne(user);
			session.setAttribute("userId", loggedUser.getUserId());
			session.setAttribute("name", loggedUser.getName());
			session.setAttribute("email", loggedUser.getEmail());
			session.setAttribute("password", loggedUser.getPassword());
			request.setAttribute("status", "success");

			dispatcher = request.getRequestDispatcher("admin.jsp");

		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("validation", "Invalid Email or Password !");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}

		dispatcher.forward(request, response);
		return;

	}

}
