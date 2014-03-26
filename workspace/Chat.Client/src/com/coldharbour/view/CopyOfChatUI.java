package com.coldharbour.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coldharbour.controllers.Controller;
import com.coldharbour.model.observer.Observer;


public class CopyOfChatUI implements Observer {
	private final int DEFAULTH_WIDTH = 680;
	private final int DEFAULTH_HEIGHT = 400;
	private final String title = "Chat v 0.3";
	private volatile Display display;
	private Shell shell;
	private Text chatWindow;
	private Text messageWindow;
	private Text userListWindow;
	private Controller controller;
	private List<String> listMsg = new ArrayList<>();

	public CopyOfChatUI(Controller controller) {
		super();
		this.controller = controller;
	}
	
	public void initialize() {
		Display display = new Display();
		System.out.println("1 - " + Display.getDefault());
		Shell shell = new Shell(display);
		shell.setText(title);
		shell.setSize(DEFAULTH_WIDTH, DEFAULTH_HEIGHT);
		
		Button disconnectBtn = new Button(shell, SWT.PUSH);
		disconnectBtn.setBounds(29, 248, 75, 23);
		disconnectBtn.setText("Disconnect");
		disconnectBtn.pack();
		
		Button sendBtn = new Button(shell, SWT.PUSH);
		sendBtn.setBounds(430, 329, 75, 23);
		sendBtn.setText("Send");
		sendBtn.pack();
		
		chatWindow = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		chatWindow.setBounds(150, 12, 378, 180);
		
		messageWindow = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		messageWindow.setBounds(150, 250, 378, 50);
		
		userListWindow = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		userListWindow.setBounds(540, 12, 110, 290);
		
		disconnectBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				controller.disconnect();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		sendBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				controller.send(messageWindow.getText());
				messageWindow.setText("");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		shell.setLayout(null);  
		shell.open();
		
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public String getMessage() {
		String msg = messageWindow.getText();
		messageWindow.setText("");
		return msg;
	}

	@Override
	public void update(final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
//		msg = msg + "\r\n";
//		listMsg.add(msg);
//		StringBuilder message = new StringBuilder();
//		for (String str : listMsg) {
//			message.append(str);
//		}
//		final String finalMessage = message.toString();
//		System.out.println("update - " + Display.getDefault());
//		Display.getDefault().asyncExec(new Runnable() {
//			public void run() {
				System.out.println("async - " + Display.getDefault());
				chatWindow.setText(msg);
			}
		});
	}

	public void dispose() {
		shell.dispose();
		display.dispose();
	}

}
