package com.coldharbour.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coldharbour.controllers.IController;
import com.coldharbour.model.User;


public class AuthUI {
	
	final private int DEFAULTH_WIDTH = 300;
	final private int DEFAULTH_HEIGHT = 450;
	final String title = "Auth";
	private Display display;
	private Shell shell;
	private Text loginText;
	private Text passwordText;
	private IController controller;
	
	public AuthUI(IController controller) {
		this.controller = controller;
	}
	
	public void initialize() {
		display = Display.getDefault();
		shell = new Shell(display);
		shell.setSize(DEFAULTH_WIDTH, DEFAULTH_HEIGHT);
		shell.setText(title);
		
		Label loginLabel = new Label(shell, SWT.CENTER);
		loginLabel.setText("Login");
		loginLabel.setBounds(90, 70, 100, 20);
		
		Label passwordLabel = new Label(shell, SWT.CENTER);
		passwordLabel.setText("Password");
		passwordLabel.setBounds(90, 130, 100, 20);
		
		loginText = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.CENTER);
		loginText.setBounds(90, 95, 100, 20);
		
		passwordText = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.CENTER | SWT.PASSWORD);
		passwordText.setBounds(90, 155, 100, 20);
		
		Button enterButton = new Button(shell, SWT.PUSH | SWT.CENTER);
		enterButton.setText("Enter");
		enterButton.setBounds(90, 190, 100, 30);
		
		Link registerLink = new Link(shell, SWT.CENTER);
		registerLink.setText("<a>Register</a>");
		registerLink.setBounds(90, 230, 50, 320);
		
		Label separate = new Label(shell, SWT.SEPARATOR);
		separate.setBounds(140, 230, 5 , 15);
		
		Link forgotLink = new Link(shell, SWT.CENTER);
		forgotLink.setText("<a>Forgot?</a>");
		forgotLink.setBounds(150, 230, 50, 320);
		
		enterButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				controller.login();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		registerLink.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.register();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		forgotLink.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				controller.forgotten();
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
//		shell.close();
//		display.dispose();
	}
	
	public void dispose() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				shell.dispose();
			}
		});
	}
	
//	public String getLogin() {
//		return loginText.getText();
//	}
//
//	public String getPwd() {
//		return passwordText.getText();
//	}

	public User getUSer() {
		User user = new User(loginText.getText(), passwordText.getText());
		return user;
	}

}
