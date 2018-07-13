package priv.xzd.test.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import priv.xzd.test.user.constant.CommonConstant;
import priv.xzd.test.user.domain.User;

public class FormFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

	private static final String[] INHERENT_ESCAPE_URIS = {"/index.html","registerPage.html","loginPage.html","register.html","loginCheck.html","checkPhone.html"};

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			filterChain.doFilter(request, response);
		} else {
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpServletRequest);
			if (userContext == null && !isURILogin(httpServletRequest.getRequestURI(), httpServletRequest)) {
				request.getRequestDispatcher("loginPage.html").forward(request, response);
			}
			filterChain.doFilter(request, response);
		}

	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}

	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0)
				return true;
		}
		return false;
	}
}
