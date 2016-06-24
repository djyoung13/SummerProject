package endpoint;

import javax.xml.ws.Endpoint;
import ws.RPTracksImpl;;

public class RPTracksPublisher {
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:5003/ws/broadway", new RPTracksImpl());
	}
}
