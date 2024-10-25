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

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("profile.jsp");
	}

	@SuppressWarnings({ "unused" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("password");
		String reupwd = request.getParameter("repassword");
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("profile.jsp");
		HttpSession session = request.getSession();

		// Regular expression for email validation
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher matcher = emailPattern.matcher(uemail);

		if (uname == null || uname.equals("") || uname.length() < 2 || uname.length() > 50) {
			request.setAttribute("validation", "Invalid Name !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);

		} else if (uemail == null || uemail.equals("") || !matcher.matches()) {
			request.setAttribute("validation", "Invalid Email !");
			request.setAttribute("status", "failed");

			dispatcher.forward(request, response);
		} else {
			userService service = new userService();

			if (!uemail.equals(session.getAttribute("email"))) {
				boolean emailStatus = service.validateEmail(uemail);

				if (emailStatus) {
					request.setAttribute("validation", "This Email Unavailabe !");
					request.setAttribute("status", "failed");

					dispatcher.forward(request, response);
				}
			}

			if ((!upwd.equals("")) && upwd.length() < 8 || upwd.length() > 50) {
				request.setAttribute("validation", "Invalid Password !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);

			} else if ((!upwd.equals("")) && !upwd.equals(reupwd)) {
				request.setAttribute("validation", "Invalid Re Enter Password !");
				request.setAttribute("status", "failed");

				dispatcher.forward(request, response);
			} else {
				boolean status = false;

				Hashing hash = new Hashing();

				User user = new User();

				user.setUserId(session.getAttribute("userId"));
				user.setName(uname);
				user.setEmail(uemail);
				user.setPassword(hash.hashPassword(upwd));

				if (upwd != null || !upwd.equals("")) {
					status = service.updateUserWithoutPassword(user);
				} else {
					status = service.updateUserAll(user);
				}

				if (status) {

					User loggedUser = service.getUserById(user);

					session.setAttribute("userId", loggedUser.getUserId());
					session.setAttribute("name", loggedUser.getName());
					session.setAttribute("email", loggedUser.getEmail());
					session.setAttribute("password", loggedUser.getPassword());

					request.setAttribute("status", "success");
					request.setAttribute("validation", "Profile Successfully Updated !");

				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("validation", "Update Failed !");
				}

				dispatcher.forward(request, response);
			}

		}

	}

}
