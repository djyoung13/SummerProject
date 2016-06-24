package model;

public class Order{
	private int id;
	private String item;
	private String custName;
	private String custAddress;
	private String cardType;
	private String cardNumber;
	private String securityCode;
	
	
	public Order(int myID, String iName, String cName, String cAddress, String cType, String cNum, String sCode){
		this.id = myID;
		this.item = iName;
		this.custName = cName;
		this.custAddress = cAddress;
		this.cardType = cType;
		this.cardNumber = cNum;
		this.securityCode = sCode;
	}
	
	public Order(){
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int newID){
		this.id = newID;
	}
	
	public String getItem(){
		return item;
	}
	
	public void setItem(String newItem){
		this.item = newItem;
	}
	
	public String getName(){
		return custName;
	}
	
	public void setName(String newName){
		this.custName = newName;
	}
	
	public String getAddress(){
		return custAddress;
	}
	
	public void setAddress(String newAddress){
		this.custAddress = newAddress;
	}
	
	public String getCardType(){
		return cardType;
	}
	
	public void setCardType(String cType){
		this.cardType = cType;
	}
	
	public String getCardNumber(){
		return cardNumber;
	}
	
	public void setCardNumber(String cNumber){
		this.cardNumber = cNumber;
	}
	
	public String getSecCode(){
		return securityCode;
	}
	
	public void setSecCode(String secCode){
		this.securityCode = secCode;
	}
}