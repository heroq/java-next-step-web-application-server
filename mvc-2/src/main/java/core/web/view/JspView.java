package core.web.view;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.mvc.View;

public class JspView implements View {

	private final String viewName;
	private final static String DEFAULT_REDIRECT_PREFIX = "redirect:";

	public JspView(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
			resp.sendRedirect(viewName.substring(DEFAULT_REDIRECT_PREFIX.length()));
			return;
		}

		Set<String> keys = model.keySet();
		for(String key : keys) {
			req.setAttribute(key, model.get(key));
		}

		RequestDispatcher rd = req.getRequestDispatcher(viewName);

		rd.forward(req, resp);
	}
}

