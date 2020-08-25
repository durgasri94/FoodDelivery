package com.FoodDelivery.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Entity.UserCartEntity;

public interface UserCartRepository extends JpaRepository<UserCartEntity, String> {

}
