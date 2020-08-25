package com.FoodDelivery.Entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class RestaurantEntity {
	@Id
	public String restaurantName;
	public String location;
	public boolean isOffer;
	public String offer;
	public boolean isOpened;
	public String workingTime;
	@ElementCollection
	@CollectionTable
	public List<MenuItemEntity> menuItems;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantLocation() {
		return location;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.location = restaurantLocation;
	}
	public boolean isOffer() {
		return isOffer;
	}
	public void setOffer(boolean isOffer) {
		this.isOffer = isOffer;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public boolean isOpened() {
		return isOpened;
	}
	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}
	public String getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	public List<MenuItemEntity> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItemEntity> menuItems) {
		this.menuItems = menuItems;
	}
	public RestaurantEntity() {
		
	}
	public RestaurantEntity(String restaurantName, String restaurantLocation, boolean isOffer, String offer,
			boolean isOpened, String workingTime, List<MenuItemEntity> menuItems) {
		this.restaurantName = restaurantName;
		this.location = restaurantLocation;
		this.isOffer = isOffer;
		this.offer = offer;
		this.isOpened = isOpened;
		this.workingTime = workingTime;
		this.menuItems = menuItems;
	}

}
