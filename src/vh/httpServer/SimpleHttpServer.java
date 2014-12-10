package vh.httpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
	private HttpServer httpServer;
	
	public SimpleHttpServer(int port,String context,Filter filter, HttpHandler handler){
		
		try {
			// Create HttpServer which is listening on the given port
			httpServer = HttpServer.create(new InetSocketAddress(port), 0);
			
			// Create a new context for the given context and handler
			HttpContext	httpcontext =httpServer.createContext(context, handler);
			
			// Add HttpRequestFilter to the context
			httpcontext.getFilters().add(filter);
			
			// Create a default executor
			httpServer.setExecutor(null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	public void start(){
		this.httpServer.start();
	}
}
