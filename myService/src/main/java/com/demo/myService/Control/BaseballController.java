package com.demo.myService.Control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.myService.DTO.PitcherDTO;
import com.demo.myService.Service.BaseballService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseballController {
	private final BaseballService baseballService;
	@GetMapping("/")
	public String baseball() {
		return "main";
	}
	@GetMapping("/bbSearch")
	public String bbSearch(@ModelAttribute PitcherDTO pitcherDTO, Model model) {
//		pitcherDTOList=baseballService.searchPitcher(pitcherDTOList);
		List<PitcherDTO> list=baseballService.searchPitcher(pitcherDTO);
		model.addAttribute("data",list);
		
		return "pitcherInfo";
	}
}
