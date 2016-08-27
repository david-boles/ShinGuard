package shinguard.main.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import shinguard.main.DataManager;
import shinguard.main.math.Point;
import space.davidboles.lib.ht.tp.HandlerFs;

public class CalibrationHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		//Expected URI format: /calibrate?c0lati=<>&c0long=<>&c1lati=<>&c1long=<>&c2lati=<>&c2long=<>
		
		String recieved = arg0.getRequestURI().toString();
		System.out.println("Recieved, parsing: " + recieved);
		
		try {
			String parsing = java.net.URLDecoder.decode(recieved, "UTF-8");
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c0latiString = parsing.substring(0, parsing.indexOf('=')-7);
			double c0lati = Double.parseDouble(c0latiString);
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c0longString = parsing.substring(0, parsing.indexOf('=')-7);
			double c0long = Double.parseDouble(c0longString);
			
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c1latiString = parsing.substring(0, parsing.indexOf('=')-7);
			double c1lati = Double.parseDouble(c1latiString);
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c1longString = parsing.substring(0, parsing.indexOf('=')-7);
			double c1long = Double.parseDouble(c1longString);
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c2latiString = parsing.substring(0, parsing.indexOf('=')-7);
			double c2lati = Double.parseDouble(c2latiString);
			

			System.out.println(parsing);
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String c2longString = parsing;
			double c2long = Double.parseDouble(c2longString);
			

			System.out.println("C0 Latitude: " + c0lati);
			System.out.println("c0 Longitude: " + c0long);
			System.out.println("C1 Latitude: " + c1lati);
			System.out.println("c1 Longitude: " + c1long);
			System.out.println("C2 Latitude: " + c2lati);
			System.out.println("c2 Longitude: " + c2long);
						
			HandlerFs.respondHTML(arg0, HandlerFs.CODE_OK, "got it!");
			
			DataManager.calibrateMapper(new Point(c0long, c0lati), new Point(c1long, c1lati), new Point(c2long, c2lati));
		}catch (Exception e) {
			System.err.println("Failed decoding calibration:");
			System.err.println(recieved);
			e.printStackTrace();
			
			HandlerFs.respondHTML(arg0, HandlerFs.CODE_OK, "parsing failed :(");
		}

	}

}
