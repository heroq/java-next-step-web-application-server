package next;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DataBase;
import model.User;

@WebServlet("/user/login")
public class LoginUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		User user = DataBase.findUserById(request.getParameter("userId"));

		boolean loginResult = user != null && user.getPassword().equals(request.getParameter("password"));
		if(loginResult) {
			httpSession.setAttribute("user", user);
		} else {
			httpSession.setAttribute("user", null);
		}

		response.sendRedirect(loginResult ? "/" : "/user/login_failed.jsp");
	}
}
