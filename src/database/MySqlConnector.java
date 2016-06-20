package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import model.Menu;
import model.Order;

//In accordance with the assignment description,
//The client must be able to pull up a menu based on the restaurant
//and place an order requesting items on said menu.
public class MySqlConnector {
	
	public MySqlConnector() {
		try {
			//Driver registered
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("JDBC driver registered");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//Initializes the collection as well as the database
	private Connection getConnection() {
		try {
			//Confirms that the connection has been made to the SummerProject server
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/SummerProject" + "user=root&password=password");
			//Creates the database and the tables needed to hold the menu for the restaurant
			//as well as the order(s) made.
			System.out.println("Got Mysql database connection");
			PreparedStatement s1 = null;
			PreparedStatement s2 = null;
			PreparedStatement s3 = null;
			PreparedStatement s4 = null;
			//Creates the database.
			System.out.println("Creating the database...");
			s1 = conn.prepareStatement("CREATE DATABASE PROJECT");
			s1.executeUpdate();
			//Creates the first table, menu, which will hold the items that a customer can order
			System.out.println("Creating 'Menu' table...");
			s2 = conn.prepareStatement("CREATE TABLE MENU "+
										"(id INTEGER not NULL AUTO_INCREMENT, "+
										" restaurant VARCHAR(255), "+
										" item VARCHAR(255), " +
										" description VARCHAR(255), " +
										" price DECIMAL(4,2));");
			s2.executeUpdate();
			//Creates the second table, order, which is filled as customers place orders.
			System.out.println("Creating 'Order' table...");
			s3 = conn.prepareStatement("CREATE TABLE ORDER "+
										"(item VARCHAR(255), "+
										"custName VARCHAR(255), "+
										"custAddress VARCHAR(255), "+
										"paymentInfo VARCHAR(255));");
			s3.executeUpdate();
			//Populates the menu table. This is only necessary for the menu table
			//as the order table will be filled by customers.
			//I will be reusing s4 as my statement since each will be an input statement.
			//I chose 3 local menus for the project (5 items each), my personal favorite in the area, RP Tracks
			//along with Brother Junipers and Tigers of Memphis (the restaurant on campus)
			System.out.println("Creating menu...");
			System.out.println("Importing RP Tracks menu...");
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
										"VALUES('RP Tracks', 'Lots of Stuff', 'Chicken tenders, fried mozzarella, onion rings, fried mushrooms, and steak fries', 12.00)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Jerked Chicken Nachos', 'Spicy jerked chicken served on your choice of meat or black bean chili', 09.75)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Beef Burrito', 'A 1/4 pound of seasoned beef', 09.00)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Steakhouse Burger', 'Melted cheddar cheese, jalapeños and grilled onions', 09.50)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Original Patty Melt', 'A fresh ground hamburger patty served with grilled onions and swiss cheese on buttered rye toast', 09.50)");
			s4.executeUpdate();
			
			System.out.println("Importing Brother Juniper's menu...");
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Brother Juniper's', 'Denver Omlette', 'Ham, Cheddar Cheese, Green Onion, & Green Pepper', 09.95)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Brother Juniper's', 'Chorizo Sausage Burrito', 'Chorizo Sausage, Eggs, Tomatoes, Green Onions, Cheddar & Mozarella Cheese, Topped with Salsa & Sour Cream.', 09.50)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Brother Juniper's', 'Oatemal with Blueberries', '', 03.00)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Brother Juniper's', 'Veggie Sausage Scramble', 'Veggie Sausage, Tofu, Spinach & Roasted Red Peppers', 08.95)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Brother Juniper's', 'Egg & Cheese Biscuit Sandwich', '', 03.25)");
			s4.executeUpdate();
			
			System.out.println("Importing Tigers of Memphis menu...");
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Chicken Strip Basket', 'Four breaded chicken strips with your choice of sauce', 07.99)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Turkey Burger', 'Turkey patty, lettuce, sliced tomato, and onion on a bun, served with fries', 05.99)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Fried Pickles', 'Fried pickle chips served with ranch dressing', 03.99)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'New York Cheesecake', 'Topped with choice of strawberry, chocolate, or caramel drizzle', 04.99)");
			s4.executeUpdate();
			s4 = conn.prepareStatement("INSERT INTO MENU (id, restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Chocolate Brownie', 'With vanilla ice cream and chocolate drizzle', 05.99)");
			s4.executeUpdate();
			
			return conn;
		} catch (SQLException ex) {
			// Handles any errors encountered.
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
	
	//Returns any items with the restaurant name given by the user.
	public List<Menu> printMenu(String restaurantName){
		PreparedStatement st = null;
		ResultSet results = null;
		Connection conn1 = null;

		try{
			List<Menu> items = new ArrayList<Menu>();
			conn1 = getConnection();

			st = conn1.prepareStatement("select * from menu where restaurant = ?");
			st.setString(2, restaurantName);
			results = st.executeQuery();
			while (results.next()){
				Menu item = new Menu();
				item.setID(results.getInt("id"));
				item.setItem(results.getString("item"));
				item.setDescription(results.getString("description"));
				item.setPrice(results.getFloat("price"));
				item.setRestaurant(results.getString("restuarant"));
				items.add(item);
			}
			return items;
		} catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		//Freeing up resources
		finally{
			if (results != null){
				try{
					results.close();
				}
				catch (SQLException ex2){
				}

				results = null;
			}

			if (st != null){
				try{
					st.close();
				}
				catch (SQLException ex2){
				}

				st = null;
			}

			if (conn1 != null)
			{
				try{
					conn1.close();
				}
				catch(SQLException ex2){
				}

				conn1 = null;
			}

		}
		return null;
	}

	public boolean placeOrder(Order order){
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		
		try{
			con = getConnection();
			
			st = con.prepareStatement("insert into order values(?, ?, ?, ?)");
			st.setString(1,  order.getItem());
			st.setString(2,  order.getName());
			st.setString(3,  order.getAddress());
			st.setString(4,  order.getPayment());
			return st.executeUpdate() > 0;
		}
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
			if (rs != null){
				try{
					rs.close();
				}
				catch (SQLException sqlEX){
				}
				rs = null;
			}
			
			if (st != null){
				try{
					st.close();
				}
				catch (SQLException sqlEX){
				}
				st = null;
			}
			
			if (con != null){
				try{
					con.close();
				}
				catch (SQLException sqlEX){
				}
				con = null;
			}
		}
		return false;
	}
}