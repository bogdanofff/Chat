package com.coldharbour.model.observer;

import java.util.List;

public interface Observer {
	public void update(String msg);
	public void updateUserList(List<String> userList);
}
