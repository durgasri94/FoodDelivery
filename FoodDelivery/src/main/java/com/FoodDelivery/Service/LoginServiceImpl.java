package com.FoodDelivery.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodDelivery.Entity.UserEntity;
import com.FoodDelivery.Table.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired 
	UserRepository userRepo;
	
    @Override
  	public String register(UserEntity userDeatils) {
		List<UserEntity> UserEntityList= userRepo.findAll();
	    if(isAlreadyUser(UserEntityList,userDeatils)) {
	    	return "UserName already available";
	    }
	    userRepo.save(userDeatils);
		return "User Registered SuccessFully";
	}

	private boolean isAlreadyUser(List<UserEntity> UserEntityList, UserEntity userDeatils) {
		List<UserEntity> filteredList = UserEntityList.stream().
				filter(userInfo-> userInfo.getUserName().equals(userDeatils.getUserName()))
						.collect(Collectors.toList());
		return filteredList.isEmpty() ? false : true;
	}

	@Override
	public boolean login(String userName,String password) {
		List<UserEntity> UserEntityList= userRepo.findAll();
		List<UserEntity> filteredList = UserEntityList.stream().
				filter(userInfo-> userInfo.getUserName().equals(userName)
						&& userInfo.getPassword().equals(password)).collect(Collectors.toList());
		return filteredList.isEmpty() ? false : true;
	}
}
