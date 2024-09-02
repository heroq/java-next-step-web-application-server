package core.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.web.mvc.Controller;
import db.DataBase;
import model.User;

public class LoginUserController implements Controller {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		User user = DataBase.findUserById(request.getParameter("userId"));

		boolean loginResult = user != null && user.getPassword().equals(request.getParameter("password"));
		if(loginResult) {
			httpSession.setAttribute("user", user);
		} else {
			httpSession.removeAttribute("user");
		}

		return loginResult ? "/" : "/user/login_failed.jsp";
	}
}
