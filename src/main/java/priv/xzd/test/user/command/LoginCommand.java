package priv.xzd.test.user.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand {
	private String phone;
	private String password;

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

	public String[] checkParams() {
		String str[] = { "0", "" };
		if (null == this.password || this.password.equals("")) {
			return new String[] { "100", "密码不能为空" };
		}
		if (null == phone || phone.trim().equals("")) {
			return new String[] { "100", "手机号码不能为空" };
		}
		if (false == checkPhone()) {
			return new String[] { "100", "手机号格式不正确" };
		}
		return str;
	}

	private boolean checkPhone() {
		if (null == this.phone || this.phone.trim().equals(""))
			return false;
		String phone = this.phone.trim();
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = p.matcher(this.phone);
		return matcher.matches();
	}
}
