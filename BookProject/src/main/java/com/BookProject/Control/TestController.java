package com.BookProject.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookProject.DTO.BkImgDTO;
import com.BookProject.Service.BkImgService;

@Controller
public class TestController {
	@Autowired
	private BkImgService bkImgService;
	@GetMapping("/image")
	public String image(Model model) {
		BkImgDTO bkImgDTO=new BkImgDTO();
		model.addAttribute("bkImgDTO",bkImgDTO);
		return "imgwritetest";
	}
	@PostMapping("/image")
	public String imgSave(@ModelAttribute BkImgDTO bkImgDTO, Model model) {
		try {
			bkImgService.imgSave(bkImgDTO);
			return "redirect:/image";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error","이미지 저장 오류!");
			return "error";
		}
	}
}
