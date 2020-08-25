package com.FoodDelivery.Entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserCartEntity {
	
	@Id
	public String userName;
	
	public double totalPrice;
	
	@ElementCollection
	@CollectionTable
	public List<MenuItemEntity> menuItems;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<MenuItemEntity> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItemEntity> menuItems) {
		this.menuItems = menuItems;
	}
	public UserCartEntity() {
		
	}
	public UserCartEntity(String userName, List<MenuItemEntity> menuItems,double totalPrice) {
		this.userName = userName;
		this.menuItems = menuItems;
		this.totalPrice = totalPrice;
	}

	
	


}
