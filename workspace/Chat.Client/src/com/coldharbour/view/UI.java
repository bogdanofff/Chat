package com.coldharbour.view;

import org.eclipse.swt.widgets.Display;

public class UI {
	private final Display display;
	
	public UI() {
		display = new Display();
		System.out.println("UI display - " + display);
	}
	
	public void close() {
		display.close();
	}
}
