package database;

import java.sql.SQLException;
import java.util.List;

import model.Menu;
import model.Order;


public class MySqlClient {

	public MySqlConnector connector;
	public MySqlClient(){
		connector = new MySqlConnector();
	}
}
