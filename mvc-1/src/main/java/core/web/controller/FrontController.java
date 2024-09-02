package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.Controller;

public class FrontController implements Controller {

	private final String forwardUrl;

	public FrontController(String forwardUrl) {
		this.forwardUrl = forwardUrl;
		if(forwardUrl == null || forwardUrl.isEmpty()) {
			throw new NullPointerException("forwardUrl is null");
		}
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		return forwardUrl;
	}
}
