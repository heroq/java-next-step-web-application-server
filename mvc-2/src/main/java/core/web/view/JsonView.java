package core.web.view;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.web.mvc.View;

public class JsonView implements View {

	@Override
	public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		resp.getWriter().print(mapper.writeValueAsString(model));
	}
}
