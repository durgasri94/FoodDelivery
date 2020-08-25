package com.FoodDelivery.Entity;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserOrdersEntity {
	
	@Id
	public String orderId;
	
	public String userName;
	
	public ZonedDateTime orderTime;
	
	public double totalPrice;
	@ElementCollection
	@CollectionTable
	public List<MenuItemEntity> orderItems;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ZonedDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(ZonedDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<MenuItemEntity> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<MenuItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
	public UserOrdersEntity() {
		
	}
	public UserOrdersEntity(String orderId, String userName, ZonedDateTime orderTime, double totalPrice,
			List<MenuItemEntity> orderItems) {
		this.orderId = orderId;
		this.userName = userName;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.orderItems = orderItems;
	}
	
}
