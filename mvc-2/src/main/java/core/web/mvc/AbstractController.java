package core.web.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.view.JsonView;
import core.web.view.JspView;

public abstract class AbstractController implements Controller{
	protected ModelAndView jspView(String viewName) {
		return new ModelAndView(new JspView(viewName));
	}

	protected ModelAndView jsonView() {
		return new ModelAndView(new JsonView());
	}
}
