package endpoint;

import javax.xml.ws.Endpoint;
import ws.BrotherJuniperImpl;

public class BrotherJuniperPublisher {
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8000/ws/BrotherJuniper", new BrotherJuniperImpl());
	}
}
