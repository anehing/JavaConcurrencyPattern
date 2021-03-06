package vh.httpServer;

public class HttpServerTest {
	
	private static final String CONTEXT = "/app";
	private static final int PORT = 8000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new SimpleHttpServer with HttpRequestFilter and HttpRequestHandler
		SimpleHttpServer simpleHttpServer = new SimpleHttpServer(PORT, CONTEXT, new HttpRequestFilter(), new HttpRequestHandler());
		
		 // Start the server
		simpleHttpServer.start();
		System.out.println("Server is started and listening on port " + PORT);
	}

}
