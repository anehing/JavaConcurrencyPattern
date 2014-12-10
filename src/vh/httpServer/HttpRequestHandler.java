package vh.httpServer;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HttpRequestHandler implements HttpHandler {
	
	private static final String PARAM_STRING = "paramString";

	private static final int HTTP_OK_STATUS = 200;

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		
	    // Get the paramString form the request
        String response = exchange.getAttribute(PARAM_STRING).toString();
        System.out.println("Response: " + response);

        // Set the response header status and length
        exchange.sendResponseHeaders(HTTP_OK_STATUS, response.getBytes().length);

        // Write the response string
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
	}

}
