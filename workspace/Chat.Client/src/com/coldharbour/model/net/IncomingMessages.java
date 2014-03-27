package com.coldharbour.model.net;

import com.coldharbour.model.observer.Observer;
import com.coldharbour.model.observer.Subject;

public class IncomingMessages implements Subject, Runnable {
	private Connection connect;
	private Observer o;
	private boolean state = true;
	
	public IncomingMessages(Connection connect, Observer o) {
		this.connect = connect;
		this.o = o;
	}

	@Override
	public void run() {
		while(state) {
			String msg = connect.read();
			if (msg.equals("UpdateUserList")) {
			o.updateUserList(connect.readObject());	
			} else 
				notifyObserver(msg);
		}
	}

	@Override
	public void notifyObserver(String msg) {
		o.update(msg);
	}
	
	public void stop() {
		state = false;
	}

}
