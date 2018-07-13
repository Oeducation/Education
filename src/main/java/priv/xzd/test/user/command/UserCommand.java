package priv.xzd.test.user.command;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCommand {
	private String username;
	private String phone;
	private String password;
	private String repassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String[] checkParams() {
		String str[] = { "0", "" };
		if (!isChineseName()) {
			return new String[] { "100", "请输入真实姓名" };
		}
		if (!isPhone()) {
			return new String[] { "100", "请输入正确的手机号" };
		}
		if (!checkPassword()) {
			return new String[] { "100", "请检查密码" };
		}
		return str;
	}

	public boolean checkPassword() {
		if (null == this.password || this.password.trim().equals(""))
			return false;
		if (null == this.repassword || this.repassword.trim().equals(""))
			return false;
		if (!this.password.equals(this.repassword))
			return false;
		return true;
	}

	public boolean isChineseName() {
		if (null == this.username || this.username.trim().equals(""))
			return false;
		String name = this.username.trim();
		Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5]{1,6}$");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean isPhone() {
		if (null == this.phone || this.phone.trim().equals(""))
			return false;
		String phone = this.phone.trim();
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = p.matcher(phone);
		return matcher.matches();
	}
}
