package rest;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/SummerProject")
public class RestaurantRS extends Application{
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Restaurant.class);
		return set;
	}
}
