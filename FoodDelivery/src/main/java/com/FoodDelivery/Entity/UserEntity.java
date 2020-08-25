package com.FoodDelivery.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserEntity {
	
	@Id
	public String userName;
	
	public String password;
	
	public double phoneNumber;
	
	public String address;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
