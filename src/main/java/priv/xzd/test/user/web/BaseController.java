package priv.xzd.test.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import priv.xzd.test.user.constant.CommonConstant;
import priv.xzd.test.user.domain.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";
	
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}

	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
		request.getSession().setAttribute(CommonConstant.USER_NAME, "已登录");
	}
}
