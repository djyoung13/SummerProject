package model;

public class Order{
	private String item;
	private String custName;
	private String custAddress;
	private String paymentInfo;
	
	public String getItem(){
		return item;
	}
	
	public void setID(String newItem){
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
	
	public String getPayment(){
		return paymentInfo;
	}
	
	public void setPayment(String newPayment){
		this.paymentInfo = newPayment;
	}
}