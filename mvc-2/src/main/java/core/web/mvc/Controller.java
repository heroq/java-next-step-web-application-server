package core.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView excute(HttpServletRequest request, HttpServletResponse response);
}
