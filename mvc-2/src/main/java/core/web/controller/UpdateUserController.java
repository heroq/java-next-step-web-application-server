package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.AbstractController;
import core.web.mvc.ModelAndView;
import db.DataBase;
import model.User;

public class UpdateUserController extends AbstractController {

	@Override
	public ModelAndView excute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null
			|| !((User)request.getSession().getAttribute("user")).getUserId().equals(request.getParameter("userId"))) {
			return jspView("redirect:/");
		}

		User user = new User(
			request.getParameter("userId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"));
		DataBase.addUser(user);

		return jspView("/user/list");
	}
}
