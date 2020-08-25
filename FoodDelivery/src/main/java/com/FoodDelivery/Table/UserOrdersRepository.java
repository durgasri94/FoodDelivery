package com.FoodDelivery.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Entity.UserOrdersEntity;

public interface UserOrdersRepository extends JpaRepository<UserOrdersEntity, String> {

}
