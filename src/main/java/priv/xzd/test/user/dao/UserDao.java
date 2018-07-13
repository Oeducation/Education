package priv.xzd.test.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import priv.xzd.test.user.domain.User;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final static String MATCH_COUNT_SQL = "select password from t_user where phone=?";
	private final static String QUERY_BY_USERNAME = "select userid,username,phone from t_user where username=?";
	private final static String INSERT_USER_SQL = "insert into t_user(username,phone,password,ctime,utime) values(?,?,?,?,?)";
	private final static String QUERY_BY_PHONE = "select userid from t_user where phone=?";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public boolean getMatchCount(String phone, String password) {
		try {
			String realPassword = jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] { phone }, String.class);
			return bCryptPasswordEncoder.matches(password, realPassword);
		} catch (Exception e) {
			return false;
		}
	}

	public User findUserByUserName(final String userName) {
		final User user = new User();
		jdbcTemplate.query(QUERY_BY_USERNAME, new Object[] { userName }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("userid"));
				user.setUserName(userName);
				user.setPhone(rs.getString("phone"));
			}
		});
		return user;
	}

	public int InsertUser(User user) {
		String password = bCryptPasswordEncoder.encode(user.getPassword().trim());
		Object[] objects = { user.getUserName(), user.getPhone(), password, user.getCtime(), user.getUtime() };
		return jdbcTemplate.update(INSERT_USER_SQL, objects);
	}

	public boolean findIdByPhone(String phone) {
		try {
			jdbcTemplate.queryForObject(QUERY_BY_PHONE, new Object[] { phone }, Integer.class);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
