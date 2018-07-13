package priv.xzd.test.user.service;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.xzd.test.user.dao.UserDao;
import priv.xzd.test.user.domain.User;

public class test{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dao-spring.xml");
		UserService userService =ac.getBean(UserService.class);
		User user=new User();
		user.setPassword("aini1234");
		user.setUserName("xue");
		user.setPhone("555");
		user.setCtime(new Date());
		user.setUtime(new Date());
	}
}
