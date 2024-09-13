package com.demo.myService.DTO;

import lombok.Data;

@Data
public class BestFoodDto {
	private String food1;
//	private String food2;
//	private String food3;
//	private String food4;
//	private String food5;
	public static BestFoodDto of(String food) {
		BestFoodDto bestFoodDto=new BestFoodDto();
		bestFoodDto.setFood1(food);
		return bestFoodDto;
	}
}
