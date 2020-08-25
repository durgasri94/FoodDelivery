package com.FoodDelivery.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodDelivery.Entity.MenuItemEntity;
import com.FoodDelivery.Entity.RestaurantEntity;
import com.FoodDelivery.Entity.UserCartEntity;
import com.FoodDelivery.Entity.UserOrdersEntity;
import com.FoodDelivery.Table.RestaurantRepository;
import com.FoodDelivery.Table.UserCartRepository;
import com.FoodDelivery.Table.UserOrdersRepository;

@Service
public class FoodDeliveryServiceImpl implements FoodDeliveryService {
	@Autowired 
	RestaurantRepository restaurantRepo;
	@Autowired 
	UserCartRepository userCartRepo;
	@Autowired 
	UserOrdersRepository userOrderRepo;

	@Override
	public List<RestaurantEntity> loadHomePage(String location) {
		restaurantRepo.save(new RestaurantEntity("Anjappar", 
				"Chennai", true, "10% discount", 
				true, "9AM to 12PM", addItemsToMenuList()));	
		restaurantRepo.save(new RestaurantEntity("The Hole In The Wall Cafe",
				"Bangalore", false, "", 
				true, "11AM to 4AM", addItemsToMenuList()));
		List<RestaurantEntity> resDeatils = restaurantRepo.findByLocation(location);
		return resDeatils.stream()
				.filter(res ->( res.isOffer & res.isOpened)).limit(5)
				.collect(Collectors.toList());
	}

	private List<MenuItemEntity> addItemsToMenuList() {
		List<MenuItemEntity> menuItems = new ArrayList<>();
		menuItems.add(new MenuItemEntity("c8abda6f-87e6-4830-9bc6-5e08b0adbc72",
				"Meals",false,100,10));
		menuItems.add(new MenuItemEntity("0137fb7e-5e0f-45cf-bd09-bacc4eae5020",
				"Chapathi",true,50,80));
		menuItems.add(new MenuItemEntity("e1f343c8-cb83-4774-8706-4f6939f2191b",
				"Dosa",false,110,56));
		menuItems.add(new MenuItemEntity("05725c2c-9374-4534-8257-6d375ff0bfcd",
				"Gravy",false,75,100));
		menuItems.add(new MenuItemEntity("f16f26c1-4b26-4bdb-9fe3-b354ceae5b21",
				"Chicken 65",false,350,60));
		return menuItems;
	}

	@Override
	public List<RestaurantEntity> viewRestaurants(String location) {
		List<RestaurantEntity> resDeatils = restaurantRepo.findByLocation(location);
		return resDeatils.stream()
				.collect(Collectors.toList());
	}

	@Override
	public List<MenuItemEntity> viewMenuItems(String restaurantName) {
		Optional<RestaurantEntity> resDeatils = restaurantRepo.findById(restaurantName);
		return resDeatils.isPresent() ? resDeatils.get().getMenuItems() : Collections.emptyList();
	}

	@Override
	public String addItemToCart(String userName, MenuItemEntity menuItem) {
		List<MenuItemEntity> userCart = new ArrayList<MenuItemEntity>();
		Optional<UserCartEntity> cartItems = userCartRepo.findById(userName);
		if (cartItems.isPresent()) {
			userCart.addAll(cartItems.get().getMenuItems());
		}
		userCart.add(menuItem);
		userCartRepo.save(new UserCartEntity(userName,userCart,getTotalPrice(userCart)));
		return "Items added to the cart";
	}

	@Override
	public String ClearItemFromCart(String userName, String itemId) {
		List<MenuItemEntity> userCart = new ArrayList<MenuItemEntity>();
		Optional<UserCartEntity> cartItems = userCartRepo.findById(userName);
		if (cartItems.isPresent()) {
			userCart = cartItems.get().getMenuItems().stream().
					filter(cart -> itemId != cart.getItemId()).
					collect(Collectors.toList());
			userCartRepo.save(new UserCartEntity(userName,userCart,getTotalPrice(userCart)));
		}
		return "Item cleared from Cart";
	}

	@Override
	public String emptyCart(String userName) {
		Optional<UserCartEntity> cartItems = userCartRepo.findById(userName);
		if (cartItems.isPresent()) {
			userCartRepo.deleteById(userName);
		}
		return "Cart cleared";
	}
	@Override
	public UserCartEntity viewCart(String userName) {
		Optional<UserCartEntity> userCartItem = userCartRepo.findById(userName);
		return userCartItem.isPresent() ?  userCartItem.get() : getDefault(userName);
	}

	public UserCartEntity getDefault(String userName) {
		return new UserCartEntity(userName,Collections.emptyList(),0);
	}

	@Override
	public String placeYourOrder(String userName) {
		List<MenuItemEntity> cartItems = userCartRepo.findById(userName).get().getMenuItems();
		userOrderRepo.save(new UserOrdersEntity
				(UUID.randomUUID().toString(), userName, 
						ZonedDateTime.now(), getTotalPrice(cartItems), cartItems));
		userCartRepo.deleteById(userName);
		return "Order was placed";
	}
	
	private double getTotalPrice(List<MenuItemEntity> cartItems) {
		double totalPrice = 0;
		for(int index = 0;index < cartItems.size(); index ++) {
			totalPrice = totalPrice+cartItems.get(index).getPrice();
		}
		return totalPrice;
   }

	@Override
	public UserOrdersEntity viewOrder(String orderId) {
		Optional<UserOrdersEntity> orderDetail=userOrderRepo.findById(orderId);
		return orderDetail.get();
	}
}
