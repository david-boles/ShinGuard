package shinguard.main.handlers;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import shinguard.main.DataManager;
import shinguard.main.math.Point;
import space.davidboles.lib.ht.tp.HandlerFs;

public class DisplayHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		String data = "";
		for(int i = 0; i < DataManager.points.size(); i++) {
			data += "ID: " + DataManager.ids.get(i) + "<br>";
			ArrayList<Point> idPoints = DataManager.points.get(i);
			
			for(int ii = 0; ii < idPoints.size(); ii++) {
				Point point = idPoints.get(ii);
				data += " X: " + point.getX() + "<br>Y: " + point.getY() + "<br>";
			}
		}
		HandlerFs.respondHTML(arg0, 200, data);

	}

}
