package com.coldharbour.model.net;

import com.coldharbour.model.User;

public class Authentication {
	private String resultCode;

	public Authentication(User user, Connection connect) {
		connect.send(user.login());
		connect.send(user.password());
		resultCode = connect.read();
	}

	public boolean authenticate() {
		if (resultCode.equals("OK200"))
			return true;
		else
			return false;
	}
}
