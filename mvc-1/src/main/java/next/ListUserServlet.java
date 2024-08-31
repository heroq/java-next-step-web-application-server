package next;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DataBase;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/user/login.jsp");
			return;
		}

		request.setAttribute("users", DataBase.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
		dispatcher.forward(request, response);
	}
}
