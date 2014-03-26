package com.coldharbour.model;

public class User {
	private String login;
	private String password;
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String login() {
		return login;
	}

	public String password() {
		return password;
	}


}
