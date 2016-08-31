package shinguard.main;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import shinguard.main.handlers.CalibrationHandler;
import shinguard.main.handlers.DataHandler;
import shinguard.main.handlers.DisplayHandler;
import shinguard.main.handlers.FieldHandler;
import shinguard.main.handlers.PointHandler;
import shinguard.main.handlers.PositionSetHandler;
import shinguard.main.handlers.UpdateHandler;

public class Start {
	
	public static HttpServer server;
	
	public static HttpHandler positionSetHandler = new PositionSetHandler();
	public static HttpHandler updateHandler = new UpdateHandler();
	public static HttpHandler calibrationHandler = new CalibrationHandler();
	public static HttpHandler dataHandler = new DataHandler();
	public static HttpHandler displayHandler = new DisplayHandler();
	public static HttpHandler fieldHandler = new FieldHandler();
	public static HttpHandler pointHandler = new PointHandler();

	public static void main(String[] args) {
		initializeServer();
		server.createContext("/set_position", positionSetHandler);
		server.createContext("/update", updateHandler);
		server.createContext("/calibrate", calibrationHandler);
		server.createContext("/data", dataHandler);
		server.createContext("/display", displayHandler);
		server.createContext("/field", fieldHandler);
		server.createContext("/point", pointHandler);
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
