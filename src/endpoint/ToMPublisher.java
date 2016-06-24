package endpoint;

import javax.xml.ws.Endpoint;
import ws.ToMImpl;

public class ToMPublisher {
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8001/ws/TigersOfMemphis", new ToMImpl());
	}
}
