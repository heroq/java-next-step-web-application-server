package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.AbstractController;
import core.web.mvc.ModelAndView;
import db.DataBase;

public class ListUserController extends AbstractController {
	@Override
	public ModelAndView excute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null) {
			return jspView("redirect:/user/login.jsp");
		}
		return jspView("/user/list.jsp")
				.addModel("users", DataBase.findAll());
	}
}
