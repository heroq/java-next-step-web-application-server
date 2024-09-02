package core.web.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

	private RequestMapping rm;
	private final static String DEFAULT_REDIRECT_PREFIX = "redirect:";

	@Override
	public void init(){
		rm = new RequestMapping();
		rm.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Controller controller = rm.getController(uri);
		String viewName = controller.excute(req, resp);
		try {
			move(viewName, req, resp);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void move(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
			resp.sendRedirect(viewName.substring(DEFAULT_REDIRECT_PREFIX.length()));
			return;
		}

		RequestDispatcher rd = req.getRequestDispatcher(viewName);
		rd.forward(req, resp);
	}
}
