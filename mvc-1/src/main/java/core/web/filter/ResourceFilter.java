package core.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class ResourceFilter implements Filter {

	private static final List<String> resourcePrefixs = new ArrayList<>();

	private RequestDispatcher requestDispatcher;

	// static block, JVM에서 첫 로드 시 작동
	static {
		resourcePrefixs.add("/css");
		resourcePrefixs.add("/js");
		resourcePrefixs.add("/fonts");
		resourcePrefixs.add("/images");
		resourcePrefixs.add("/favicon.ico");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		requestDispatcher = filterConfig.getServletContext().getRequestDispatcher("default");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// contextPath 제외한 순수한 서블릿 결과
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if(isResourceUrl(path)) {
			requestDispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean isResourceUrl(String url) {
		for (String prefix : resourcePrefixs) {
			if (url.startsWith(prefix)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {

	}
}
