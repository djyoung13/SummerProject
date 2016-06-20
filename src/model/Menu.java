package model;

public class Menu {
	
	private int id;
	private String restaurant;
	private String item;
	private String description;
	private float price;
	
	//Constructors
	public Menu(String restaurantName, String itemName, String desc, float itemPrice){
		this.restaurant = restaurantName;
		this.item = itemName;
		this.description = desc;
		this.price = itemPrice;
	}
	
	public Menu(){
		
	}
	
	//Getters and Setters
	public int getID(){
		return id;
	}
	
	public void setID(int newID){
		this.id = newID;
	}
	
	public String getRestaurant(){
		return restaurant;
	}
	
	public void setRestaurant(String newRestaurant){
		this.restaurant = newRestaurant;
	}
	
	public String getItem(){
		return item;
	}
	
	public void setItem(String newItem)
	{
		this.item = newItem;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
	
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float newPrice){
		this.price = newPrice;
	}
	
	//String method
	public String toString(){
		return item + ": " + description + "............." + price;
	}

}
