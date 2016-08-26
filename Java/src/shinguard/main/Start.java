package shinguard.main;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import shinguard.main.handlers.PositionSetHandler;
import shinguard.main.handlers.UpdateHandler;

public class Start {
	
	public static HttpServer server;
	
	public static PositionSetHandler positionSetHandler = new PositionSetHandler();
	public static UpdateHandler updateHandler = new UpdateHandler();

	public static void main(String[] args) {
		initializeServer();
		server.createContext("/set_position", positionSetHandler);
		server.createContext("/update", updateHandler);
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
