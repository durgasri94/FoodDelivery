package com.FoodDelivery.Service;

import com.FoodDelivery.Entity.UserEntity;

public interface LoginService {
	
	public String register(UserEntity userDetail);
	
	public boolean login(String userName,String password);
}
