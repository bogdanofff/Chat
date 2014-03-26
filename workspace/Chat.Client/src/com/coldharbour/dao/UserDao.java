package com.coldharbour.dao;

public interface UserDao {
	public void addUsers(String login, String paswword);
	
	public boolean existUsers(String login);
	
	
}
