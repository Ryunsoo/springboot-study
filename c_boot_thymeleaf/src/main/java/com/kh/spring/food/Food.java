package com.kh.spring.food;

import javax.management.RuntimeErrorException;

import lombok.Data;

@Data
public class Food {

	private String name;
	private int price;
	
	public static Food createFood(String name) {
		
		Food food = new Food();
		food.setName(name);
		
		switch (name) {
		case "피자": food.setPrice(30000);
			break;
		case "햄버거": food.setPrice(5000);
			break;
		case "치킨": food.setPrice(18000);
			break;
		case "회": food.setPrice(20000);
			break;
		default: throw new RuntimeException();
		}
		return food;
	}
	
}
