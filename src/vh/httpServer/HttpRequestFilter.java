package vh.httpServer;

import java.io.IOException;
import java.net.URI;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

public class HttpRequestFilter extends Filter {
	private static final String FILTER_DESC = "HttpRequestFilter creates a String from the request parameters "
			                                   + "and pass it to HttpRequestHandler";
	private static final String F_NAME = "fname";
    private static final String L_NAME = "lname";
    
    private static final String AND_DELIMITER = "&";
    private static final String EQUAL_DELIMITER = "=";

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return FILTER_DESC;
	}
  
	@Override
	public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
		// TODO Auto-generated method stub
		
		
		// Create a string form the request query parameters
		URI uri= exchange.getRequestURI();
		String paramString = createStringFromQueryParams(uri);

		// Set paramString as a request attribute
		exchange.setAttribute("paramString", paramString);
		
		// Chain the request to HttpRequestHandler
		chain.doFilter(exchange);
	}
	
	private String createStringFromQueryParams(URI uri){
		
		String fName = "";
		String lName = "";
		String[] queryParams = null;
		// Get the request query
		String query = uri.getQuery();
		if(query!=null)  queryParams = query.split(AND_DELIMITER);
		if(queryParams!=null){
			for(String params : queryParams){
				String[] param = params.split(EQUAL_DELIMITER);
				if(param.length>0){
					for(String pa : param){
						if(F_NAME.equalsIgnoreCase(pa)) fName=pa;
						if(L_NAME.equalsIgnoreCase(pa)) lName=pa;
					}
				}
			}
		}		
		 return "Hello, " + fName + " " + lName;
	}
}
