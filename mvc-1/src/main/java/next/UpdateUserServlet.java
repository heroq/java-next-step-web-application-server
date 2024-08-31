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

@WebServlet("/user/update")
public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null
			|| !((User)request.getSession().getAttribute("user")).getUserId().equals(request.getParameter("userId"))) {
			response.sendRedirect("/");
			return;
		}

		User user = new User(
			request.getParameter("userId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"));
		DataBase.addUser(user);
		response.sendRedirect("/user/list");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null
			|| !((User)request.getSession().getAttribute("user")).getUserId().equals(request.getParameter("userId"))) {
			response.sendRedirect("/");
			return;
		}

		request.setAttribute("user", DataBase.findUserById(request.getParameter("userId")));
		request.getRequestDispatcher("/user/update.jsp").forward(request, response);
	}
}
