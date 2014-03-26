package com.coldharbour.model.net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Connection {
	private final int PORT = 8189;
	private final String HOST = "localhost";
	private Socket socket;
	private Scanner in;
	private PrintWriter out;

	public Connection() {

	}

	public Socket open() {
		try {
			socket = new Socket(HOST, PORT);
			in = new Scanner(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return socket;
	}
	
	public void send(String message) {
		out.println(message);
		out.flush();
	}
	
	public String read() {
		String msg = in.nextLine();
		System.out.println(msg);
		return msg;
	}
	
	public void close() {
		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
