package core.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.Controller;
import db.DataBase;
import model.User;

public class UpdateUserFormController implements Controller {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null
			|| !((User)request.getSession().getAttribute("user")).getUserId().equals(request.getParameter("userId"))) {
			return "/";
		}

		request.setAttribute("user", DataBase.findUserById(request.getParameter("userId")));
		return "/user/update.jsp";
	}
}
