package com.demo.myService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.myService.DTO.BestFoodDto;

@Service
public class FoodService {
	public List<BestFoodDto> getFoods() {
		List<BestFoodDto> bestFoodDtoList=new ArrayList<>();
		
		BestFoodDto bestFoodDto=new BestFoodDto();
		bestFoodDto.setFood1("파국");
		bestFoodDtoList.add(bestFoodDto);
		
		bestFoodDtoList.add(bestFoodDto.of("짜장"));
		bestFoodDtoList.add(bestFoodDto.of("탕슉"));
		bestFoodDtoList.add(bestFoodDto.of("짬뽕"));
		bestFoodDtoList.add(bestFoodDto.of("만두"));
		bestFoodDtoList.add(bestFoodDto.of("잡채"));
		return bestFoodDtoList;
	}
}
