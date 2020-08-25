package com.FoodDelivery.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class MenuItemEntity{
	public String itemId;
	
	public String itemName;
	 
	public boolean isOutOfStock;
	
	public double price;
	
	public double quantity;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isOutOfStock() {
		return isOutOfStock;
	}

	public void setOutOfStock(boolean isOutOfStock) {
		this.isOutOfStock = isOutOfStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public MenuItemEntity() {
		
	}
	public MenuItemEntity(String itemId, String itemName, boolean isOutOfStock, double price, double quantity) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.isOutOfStock = isOutOfStock;
		this.price = price;
		this.quantity = quantity;
	}
}
