package com.example.test2.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test2.DTO.InquiryDTO;

@Controller
public class InquiryController {
	@GetMapping("/inquiry")
	public String inquiryList() {
		return "/inquiry/inquiryList";
	}
	@GetMapping("/inquiryView")
	public String inquiryView() {
		return "/inquiry/inquiryView";
	}
	@GetMapping("/inquiryWrite")
	public String inquiryWrite() {
		return "/inquiry/inquiryWrite";
	}
	@PostMapping("/inquiryWrite")
	public String inquiryWrite(@ModelAttribute InquiryDTO inquiryDTO) {
		return "/inquiry/inquiryView";
	}
}
