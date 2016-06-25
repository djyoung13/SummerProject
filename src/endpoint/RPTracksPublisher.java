package endpoint;

import javax.xml.ws.Endpoint;
import ws.RPTracksImpl;;

public class RPTracksPublisher {
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8002/ws/RPTracks", new RPTracksImpl());
	}
}
