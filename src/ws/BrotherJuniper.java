package ws;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.io.*;
import java.util.ArrayList;

import model.Menu;
import model.Order;
@WebService
@SOAPBinding(style = Style.RPC)
public interface BrotherJuniper {
	@WebMethod
	public ArrayList<Order> retrieveBJOrder(Order order) throws ClassNotFoundException;
}
