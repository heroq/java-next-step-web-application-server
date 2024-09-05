package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.AbstractController;
import core.web.mvc.ModelAndView;
import db.DataBase;
import model.User;

public class UpdateUserFormController extends AbstractController {

	@Override
	public ModelAndView excute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null
			|| !((User)request.getSession().getAttribute("user")).getUserId().equals(request.getParameter("userId"))) {
			return jspView("redirect:/");
		}

		return jspView("/user/update.jsp")
				.addModel("user", DataBase.findUserById(request.getParameter("userId")));
	}
}
