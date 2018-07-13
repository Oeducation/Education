package priv.xzd.test.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import priv.xzd.test.user.command.UserCommand;
import priv.xzd.test.user.dao.UserDao;
import priv.xzd.test.user.domain.User;
@Service
public class UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	
	public boolean hasMatchUser(String phone, String password) {
		return userDao.getMatchCount(phone, password);
	}

	public User findUserBuUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	@Transactional
	public int registSuccess(UserCommand userCommand) {
		User user = new User();
		user.setCtime(new Date());
		user.setUtime(new Date());
		user.setUserName(userCommand.getUsername());
		user.setPassword(userCommand.getPassword());
		user.setPhone(userCommand.getPhone());
		return userDao.InsertUser(user);
	}

	public boolean checkPhone(String phone) {
		return userDao.findIdByPhone(phone);
	}
}
