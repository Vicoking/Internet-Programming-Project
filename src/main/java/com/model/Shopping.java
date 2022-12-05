package com.model;

public class Shopping {
	String title;
	String actor;
  	float price;
  	int quantity;
  	
  	public Shopping() {
  	    title="";
  	    actor="";
  	    price=0;
  	    quantity=0;
  	  }
  	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
