package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.Controller;
import db.DataBase;
import model.User;

public class CreateUserController implements Controller {
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		User user = new User(
			request.getParameter("userId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"));
		DataBase.addUser(user);
		return "/user/login.jsp";
	}
}
