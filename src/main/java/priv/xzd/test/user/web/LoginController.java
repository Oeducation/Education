package priv.xzd.test.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import priv.xzd.test.user.command.LoginCommand;
import priv.xzd.test.user.command.UserCommand;
import priv.xzd.test.user.domain.User;
import priv.xzd.test.user.service.UserService;

@Controller
public class LoginController extends BaseController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "index.html")
	public String Index() {
		return "main";
	}

	@RequestMapping(value = "loginPage.html")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "registerPage.html")
	public String registerPage() {
		return "register";
	}

	@RequestMapping(value = "loginCheck.html", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		String str[] = loginCommand.checkParams();
		if (!str[0].equals("0")) {
			return new ModelAndView("login", "error", str[1]);
		}
		boolean isValidUser = userService.hasMatchUser(loginCommand.getPhone(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误");
		}
		User user = new User();
		user.setPhone(loginCommand.getPhone());
		setSessionUser(request, user);
		return new ModelAndView("main");
	}

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, UserCommand userCommand) {
		String str[] = userCommand.checkParams();
		if (!str[0].equals("0"))
			return new ModelAndView("register", "error", str[1]);
		int result = userService.registSuccess(userCommand);
		if (result < 1)
			return new ModelAndView("register", "error", "注册失败");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "checkPhone.html", method = RequestMethod.POST)
	@ResponseBody
	public String checkPhone(@RequestParam String phone) {
		boolean isphone = userService.checkPhone(phone);
		if (isphone)
			return "yes";
		return "no";
	}
}
