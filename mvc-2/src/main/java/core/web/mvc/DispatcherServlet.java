package core.web.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.controller.FrontController;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

	private RequestMapping rm;

	@Override
	public void init(){
		rm = new RequestMapping();
		rm.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Controller controller = rm.getController(uri);
		if(controller == null) {
			controller = new FrontController(uri);
		}
		ModelAndView mav = controller.excute(req, resp);
		View view = mav.getView();
		view.render(mav.getModel(), req, resp);
	}
}
