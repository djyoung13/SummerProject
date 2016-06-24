package ws;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.io.*;
import java.util.List;

import model.Menu;
import model.Order;
@WebService
@SOAPBinding(style = Style.RPC)
public interface ToM {
	@WebMethod
	public List<Order> retrieveToMOrder(Order order) throws ClassNotFoundException;
}