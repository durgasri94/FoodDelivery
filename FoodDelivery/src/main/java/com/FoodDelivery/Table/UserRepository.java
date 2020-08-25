package com.FoodDelivery.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String>{
	

}
