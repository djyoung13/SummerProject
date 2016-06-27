package rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ws.*;
import model.*;
import database.MySqlConnector;;

@Path("/rest")
public class Restaurant {
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/menu/all")
	public Response getAllItems(){
		Connection conn = MySqlConnector.getConnection();
		MySqlConnector.initializeDB();
		String output = "";
		ArrayList<Menu> items = MySqlConnector.printMenu();
		for (Menu m : items){
			output += m.toString() + "\n";
		}
		return Response.ok(output, "text/html").build();
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/menu/{restaurant}")
	public Response getSpecificMenu(@PathParam("restaurant") String rName){
		Connection conn = MySqlConnector.getConnection();
		MySqlConnector.initializeDB();
		String output = "";
		ArrayList<Menu> items = MySqlConnector.printMenu(rName);
		for (Menu m : items){
			output += m.toString() + "\n";
		}
		return Response.ok(output, "text/html").build();
		
	}
}
