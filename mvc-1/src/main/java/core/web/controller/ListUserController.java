package core.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.Controller;
import db.DataBase;

public class ListUserController implements Controller {
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null) {
			return "redirect:/user/login.jsp";
		}
		request.setAttribute("users", DataBase.findAll());
		return "/user/list.jsp";
	}
}
