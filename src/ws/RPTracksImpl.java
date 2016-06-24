package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Menu;
import model.Order;
import ws.RPTracks;
import database.MySqlConnector;

//Allows the service specifically for RPTracks to retrieve an order made to their restaurant
//The customer information has been replaced with RP Tracks info.
//The order information that goes into the ORDER table will not have this change.
@WebService(endpointInterface = "ws.RPTracks")
public class RPTracksImpl implements RPTracks {
	@Override
	public List<Order> retrieveRPOrder(Order order){
		ResultSet result = null;
		try{
			List<Order> myOrder = new ArrayList<Order>();
			String dbURL = "jdbc:mysql://localhost/SummerProject";
			String userName = "root";
			String password = "password";
		
			Class.forName("com.mysql.jbdc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, userName, password);
			PreparedStatement st = null;
			st = conn.prepareStatement("SELECT * from order where id = ?");
			st.setInt(1, order.getID());
			result = st.executeQuery();
			while (result.next()){
				Order item = new Order();
				item.setID(result.getInt("id"));
				item.setItem(result.getString("item"));
				item.setName(result.getString("RP Tracks"));
				item.setAddress("3547 Walker Ave, Memphis, TN 38111");
				item.setCardType("Visa");
				item.setCardNumber("1234567891012131");
				item.setSecCode("123");
				myOrder.add(item);
			}
			return myOrder;
		} catch(SQLException | ClassNotFoundException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return null;
	}
}
