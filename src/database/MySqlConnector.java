package database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Menu;
import model.Order;

//In accordance with the assignment description,
//The client must be able to pull up a menu based on the restaurant
//and place an order requesting items on said menu.
public class MySqlConnector {
	//Constructor
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
	
	//Initializes the connection
	private static Connection getConnection() {
		try {
			//Confirms that the connection has been made to the SummerProject server
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/?", "root", "password");
			//Creates the database and the tables needed to hold the menu for the restaurant
			//as well as the order(s) made.
			System.out.println("Got Mysql database connection");
			return conn;
		} catch (SQLException ex) {
			// Handles any errors encountered.
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
	
	//Initializes the database (if needed).
	//Requires the following 3 methods.
	public static void initializeDB(){
		Connection conn = getConnection();
		createDB(conn);
		useDB(conn);
		createTables(conn);
	}
	
	//Creates a database aptly titled Summer Project if one isn't there.
	public static boolean createDB(Connection conn){
		try{
			PreparedStatement st = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS SummerProject;");
			st.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.getStackTrace();
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("Error in creating database");
			return false;
		}
	}
	
	//Creates the tables for the menu and order.
	public static boolean createTables(Connection conn){
		PreparedStatement st = null;
		
		/* Creates the Menu table with ALL items and the restaurant they are from */
		try{
			st = conn.prepareStatement("CREATE TABLE IF NOT EXISTS MENU "+
					"(id INTEGER AUTO_INCREMENT PRIMARY KEY, "+
					" restaurant VARCHAR(255), "+
					" item VARCHAR(255), " +
					" description VARCHAR(255), " +
					" price DECIMAL(4,2));");
			st.executeUpdate();
			System.out.println("Creating menu...");
			System.out.println("Importing RP Tracks menu...");
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
										"VALUES('RP Tracks', 'Lots of Stuff', 'Chicken tenders, fried mozzarella, onion rings, fried mushrooms, and steak fries', 12.00)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Jerked Chicken Nachos', 'Spicy jerked chicken served on your choice of meat or black bean chili', 09.75)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Beef Burrito', 'A 1/4 pound of seasoned beef', 09.00)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Steakhouse Burger', 'Melted cheddar cheese, jalapeños and grilled onions', 09.50)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('RP Tracks', 'Original Patty Melt', 'A fresh ground hamburger patty served with grilled onions and swiss cheese on buttered rye toast', 09.50)");
			st.executeUpdate();
			System.out.println("DONE");
			
			System.out.println("Importing Brother Juniper's menu...");
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Brother Junipers', 'Denver Omlette', 'Ham, Cheddar Cheese, Green Onion, & Green Pepper', 09.95)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Brother Junipers', 'Chorizo Sausage Burrito', 'Chorizo Sausage, Eggs, Tomatoes, Green Onions, Cheddar & Mozarella Cheese, Topped with Salsa & Sour Cream.', 09.50)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Brother Junipers', 'Oatemal with Blueberries', '', 03.00)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Brother Junipers', 'Veggie Sausage Scramble', 'Veggie Sausage, Tofu, Spinach & Roasted Red Peppers', 08.95)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Brother Junipers', 'Egg & Cheese Biscuit Sandwich', '', 03.25)");
			st.executeUpdate();
			System.out.println("Done");
			System.out.println("Importing Tigers of Memphis menu...");
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Chicken Strip Basket', 'Four breaded chicken strips with your choice of sauce', 07.99)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Turkey Burger', 'Turkey patty, lettuce, sliced tomato, and onion on a bun, served with fries', 05.99)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Fried Pickles', 'Fried pickle chips served with ranch dressing', 03.99)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'New York Cheesecake', 'Topped with choice of strawberry, chocolate, or caramel drizzle', 04.99)");
			st.executeUpdate();
			st = conn.prepareStatement("INSERT IGNORE INTO MENU (restaurant, item, description, price) "+
					"VALUES('Tigers of Memphis', 'Chocolate Brownie', 'With vanilla ice cream and chocolate drizzle', 05.99)");
			st.executeUpdate();
			System.out.println("Done");
		}
		catch(SQLException ex){
			ex.getStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.out.println("Error in creating customers table");
			return false;
		}
		
		/* Creates the Order table which will track all incoming orders */
		System.out.println("Creating 'Order' table...");
		try{
			st = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ORDERS "+
									"(id INTEGER AUTO_INCREMENT PRIMARY KEY," +
									" item VARCHAR(255),"+
									" custName VARCHAR(255),"+
									" custAddress VARCHAR(255),"+
									" cardType VARCHAR(255),"+
									" cardNumber VARCHAR(255),"+
									" securityCode VARCHAR(255));");
			st.executeUpdate();
		}
		catch(SQLException ex){
			ex.getStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.out.println("Error in creating order table");
			return false;			
		}
		return true;
	}
	
	//Allows for the "USE" of the database via SQL in a Java method
	public static boolean useDB(Connection conn){
		try{
			PreparedStatement st = conn.prepareStatement("USE SummerProject");
			st.executeUpdate();
			return true;
		}
		catch(SQLException ex){
			ex.getStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.out.println("Error in creating customers table");
			return false;			
		}
	}
	
	//Prints the menu based on the restaurant name.
	public ArrayList<Menu> printMenu(String restaurantName){
		PreparedStatement st = null;
		ResultSet results = null;
		Connection conn1 = null;
		try{
			ArrayList<Menu> items = new ArrayList<Menu>();
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

	//An overloaded version of the printMenu method that will print ALL items
	//regardless of what menu they are on.
	public ArrayList<Menu> printMenu(){
		PreparedStatement st = null;
		ResultSet results = null;
		Connection conn1 = null;
		try{
			ArrayList<Menu> items = new ArrayList<Menu>();
			conn1 = getConnection();

			st = conn1.prepareStatement("select * from menu where restaurant = ?");
			st.setString(2, "*");
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
	
	//Places an order on the Order table.
	public boolean placeOrder(Order order){
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		
		try{
			con = getConnection();
			
			st = con.prepareStatement("insert into order values(?, ?, ?, ?, ?, ?)");
			st.setString(1,  order.getItem());
			st.setString(2,  order.getName());
			st.setString(3,  order.getAddress());
			st.setString(4,  order.getCardType());
			st.setString(5,  order.getCardNumber());
			st.setString(6,  order.getSecCode());
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
	
	public static void main(String[] args){
		initializeDB();
		
	}
}