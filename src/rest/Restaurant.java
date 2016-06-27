package rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ws.*;
import model.*;

@Path("/rest")
public class Restaurant {
	ArrayList<Order> myOrders;
	BrotherJuniper menu1;
	RPTracks menu2;
	ToM menu3;
	boolean init = false;			
	
//	@GET
//	@Produces({MediaType.TEXT_PLAIN})
//	@Path("/menu/all")
//	//public Response getAllItems() throws IOException{
//		
//	}
}
