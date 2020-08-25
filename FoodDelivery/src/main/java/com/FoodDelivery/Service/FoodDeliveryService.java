package com.FoodDelivery.Service;

import java.util.List;

import com.FoodDelivery.Entity.MenuItemEntity;
import com.FoodDelivery.Entity.RestaurantEntity;
import com.FoodDelivery.Entity.UserCartEntity;
import com.FoodDelivery.Entity.UserOrdersEntity;

public interface FoodDeliveryService {
	
	public List<RestaurantEntity> loadHomePage(String location);

	public List<RestaurantEntity> viewRestaurants(String location);

	public List<MenuItemEntity> viewMenuItems(String restaurantName);
	
	public String addItemToCart(String userName, MenuItemEntity menuItem);
	
	public String ClearItemFromCart(String userName, String itemId);
	
	public String emptyCart(String userName);

	public UserCartEntity viewCart(String userName);

	public String placeYourOrder(String userName);

	public UserOrdersEntity viewOrder(String orderId);

	
	

}
