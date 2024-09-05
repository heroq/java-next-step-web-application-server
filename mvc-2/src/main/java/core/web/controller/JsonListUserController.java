package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.AbstractController;
import core.web.mvc.ModelAndView;
import db.DataBase;

public class JsonListUserController extends AbstractController {
	@Override
	public ModelAndView excute(HttpServletRequest request, HttpServletResponse response) {
		return jsonView().addModel("users", DataBase.findAll());
	}
}
