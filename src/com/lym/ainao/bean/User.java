package com.lym.ainao.bean;

public class User {
	private static final Integer SEX_MAN = 0;
	private static final Integer SEX_WOMAN = 1;
	private String objectId;// ID
	private String userName;
	private String password;
	private Integer sex;
	private String phoneNumber;
	private boolean phoneVerification;// 电话号码是否验证
	private Integer loginType;// 登陆方式（用户名/qq/微信）

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isPhoneVerification() {
		return phoneVerification;
	}

	public void setPhoneVerification(boolean phoneVerification) {
		this.phoneVerification = phoneVerification;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

}
