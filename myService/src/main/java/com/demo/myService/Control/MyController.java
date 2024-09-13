package com.demo.myService.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.myService.DTO.BestFoodDto;
import com.demo.myService.Service.FoodService;

@Controller
public class MyController {
	@Autowired FoodService foodService;
	@GetMapping("/food")
	public String food() {
		return "food";
	}
	@GetMapping("/bestFood")
	public String bestFood(Model model) {
		List<BestFoodDto> list=foodService.getFoods();
		model.addAttribute("foodlist",list);
		return "bestFood";
	}
}
