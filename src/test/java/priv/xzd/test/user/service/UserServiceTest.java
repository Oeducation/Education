package priv.xzd.test.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;
import org.testng.annotations.*;

import priv.xzd.test.user.domain.User;
import priv.xzd.test.user.web.LoginController;

@ContextConfiguration(locations= {"classpath*:/dao-spring.xml","classpath*:/web-spring.xml"})
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
	private UserService userService;
	private LoginController LoginController;
	
	@Autowired
	public void setLoginController(LoginController loginController) {
		this.LoginController = loginController;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void hasMatchUser() {
		User user=new User();
		user.setPassword("aini1234");
		user.setUserName("xue");
		user.setPhone("666");
		user.setCtime(new Date());
		user.setUtime(new Date());
	}
}
