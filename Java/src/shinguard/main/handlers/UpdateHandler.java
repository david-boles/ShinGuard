package shinguard.main.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import shinguard.main.Start;
import space.davidboles.lib.ht.tp.HandlerFs;

public class UpdateHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		try {
			HandlerFs.respondHTML(arg0, 200, "Starting update procedure...");
			Start.server.stop(0);
			Runtime.getRuntime().exec("java -jar Start.jar");
			wait(500);
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
