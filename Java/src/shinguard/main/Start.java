package shinguard.main;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import shinguard.main.handlers.PositionSetHandler;

public class Start {
	
	static HttpServer server;
	
	//Room light
	public static PositionSetHandler positionSetHandler = new PositionSetHandler();

	public static void main(String[] args) {
		initializeServer();
		server.createContext("/set_position", positionSetHandler);
	}
	
	static void initializeServer() {
		try {
			server = HttpServer.create(new InetSocketAddress(7356), 100);
			server.setExecutor(null);
		    server.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
