package shinguard.main.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import space.davidboles.lib.ht.tp.HandlerFs;

public class PositionSetHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		//Expected URI format: /set_position?id=<id num>&lati=<latitude as double>&long=<longitude as double>
		
		String recieved = arg0.getRequestURI().toString();
		System.out.println("Recieved, parsing: " + recieved);
		
		try {
			String parsing = java.net.URLDecoder.decode(recieved, "UTF-8");
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String idString = parsing.substring(0, parsing.indexOf('=')-5);
			int idVal = Integer.decode(idString);
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String latiString = parsing.substring(0, parsing.indexOf('=')-5);
			double latiVal = Double.parseDouble(latiString);
			
			parsing = parsing.substring(parsing.indexOf('=')+1);
			String longString = parsing;
			double longVal = Double.parseDouble(longString);
			
			System.out.println("ID: " + idVal);
			System.out.println("Latitude: " + latiVal);
			System.out.println("Longitude: " + longVal);
			
			HandlerFs.respondHTML(arg0, HandlerFs.CODE_OK, "got it!");
		}catch (Exception e) {
			System.err.println("Failed decoding position set:");
			System.err.println(recieved);
			e.printStackTrace();
			
			HandlerFs.respondHTML(arg0, HandlerFs.CODE_OK, "parsing failed :(");
		}
		

	}

}
