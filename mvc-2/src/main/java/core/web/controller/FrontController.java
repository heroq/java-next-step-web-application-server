package core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.AbstractController;
import core.web.mvc.ModelAndView;

public class FrontController extends AbstractController {

	private final String forwardUrl;

	public FrontController(String forwardUrl) {
		this.forwardUrl = forwardUrl;
		if(forwardUrl == null || forwardUrl.isEmpty()) {
			throw new NullPointerException("forwardUrl is null");
		}
	}

	@Override
	public ModelAndView excute(HttpServletRequest request, HttpServletResponse response) {
		return jspView(forwardUrl);
	}
}
