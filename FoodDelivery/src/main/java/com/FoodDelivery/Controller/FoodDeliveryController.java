package com.FoodDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodDelivery.Entity.MenuItemEntity;
import com.FoodDelivery.Entity.RestaurantEntity;
import com.FoodDelivery.Entity.UserCartEntity;
import com.FoodDelivery.Entity.UserOrdersEntity;
import com.FoodDelivery.Service.FoodDeliveryService;

@RestController
public class FoodDeliveryController {
	@Autowired 
	FoodDeliveryService foodDeliveryService;
	
	@GetMapping(value="/loadHomePage/{location}")
	public List<RestaurantEntity> loadHomePage(@PathVariable("location")String location) {
		return foodDeliveryService.loadHomePage(location);
	}
	
	@GetMapping(value ="/viewRestaurants/{location}")
	public List<RestaurantEntity> viewRestaurants(@PathVariable("location")String location) {
		return foodDeliveryService.viewRestaurants(location);
	}
	
	@GetMapping(value ="/viewMenuItems/{restaurantName}")
	public List<MenuItemEntity> viewMenuItems(@PathVariable("restaurantName")String restaurantName) {
		return foodDeliveryService.viewMenuItems(restaurantName);
	}
	
	@PostMapping(path ="/addToCart")
	public String addToCart(String userName,MenuItemEntity menuItem) {
		return foodDeliveryService.addItemToCart(userName, menuItem);
	}
	
	@PostMapping(path ="/ClearItemFromCart")
	public String ClearItemFromCart(String userName,MenuItemEntity menuItem) {
		return foodDeliveryService.addItemToCart(userName, menuItem);
	}
	
	@DeleteMapping(path ="/emptyCart")
	public String emptyCart(String userName) {
		return foodDeliveryService.emptyCart(userName);
	}
	
	@GetMapping(value ="/viewCart/{userName}")
	public UserCartEntity viewCart(@PathVariable("userName")String userName) {
		return foodDeliveryService.viewCart(userName);
	}
	@PostMapping(path ="/placeYourOrder")
	public String placeYourOrder(String userName) {
		return foodDeliveryService.placeYourOrder(userName);
	}
	
	@GetMapping(path ="/viewOrder/{orderId}")
	public UserOrdersEntity viewOrder(@PathVariable("orderId")String orderId) {
		return foodDeliveryService.viewOrder(orderId);
	}
}
