package com.coldharbour.controllers;

import org.eclipse.swt.widgets.Display;

import com.coldharbour.model.*;
import com.coldharbour.view.*;

public class Controller implements IController {
	private AuthUI auth;
	private IChatModel model;
	
	public Controller(UI ui) {
		model = new ChatModel(this);
		auth = new AuthUI(this);
		auth.initialize();
	}

	@Override
	public void login() {
		model.connect(auth.getUSer());
	}

	@Override
	public void send(String message) {
		model.send(message);
	} 

	@Override
	public void disconnect() {
		model.disconnect();
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forgotten() {
		// TODO Auto-generated method stub
		
	}
	
	public void closeAuthUI() {
		auth.dispose();
	}
	
	public void showError(String message) {
		auth.showError(message);
	}
}
