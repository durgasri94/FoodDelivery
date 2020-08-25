package com.FoodDelivery.Table;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Entity.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,String> {
	public List<RestaurantEntity> findByLocation(String location);
}
