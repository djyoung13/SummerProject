package endpoint;

import javax.xml.ws.Endpoint;
import ws.RestaurantMenuImpl;

public class RestaurantMenuPublisher {
	
	public static void main(String[] args){
		Endpoint.publish("http://localhost:9999/ws/SummerProject", new RestaurantMenuImpl());
	}
}
