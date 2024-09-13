package com.midProject.control;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.midProject.DTO.BkDTO;
import com.midProject.service.BkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
	private final BkService bkService;
	@GetMapping("/")
	public String libraryhome(Model model) {
		BkDTO bkDTO=new BkDTO();
		model.addAttribute("bkDTO", bkDTO);
		return "library";
	}
	@GetMapping("/manage")
	public String bookManage() {
		return "/manager/manager";
	}
	@GetMapping("/write")
	public String write(Model model) {
		BkDTO bkDTO = new BkDTO();
		model.addAttribute("bkDTO", bkDTO);
		return  "book/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BkDTO bkDTO) {
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				String fileName=bimg.getOriginalFilename();
				String savePath="C:/lalalandddd/bookimage/"+fileName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+fileName);
				bkService.bookSave(bkDTO);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/library/index";
	}
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("bookList", bkService.findAllBooks());
		return "book/index";
	}
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		BkDTO bkDTO=bkService.findById(id);
		model.addAttribute("bkDTO",bkDTO);
		return "book/view";
	}
//	@GetMapping("/index")
//	public String index(Model model) {
//		BkDTO bkDTO=new BkDTO();
//		model.addAttribute("bkDTO", bkDTO);
//		return  "book/index";
//	}
//	@PostMapping("/write")
//	public String write(@ModelAttribute BkDTO bkDTO, Model model) {
//		MultipartFile bimg=bkDTO.getBimg();
//		if(!bimg.isEmpty()) {
//			try {
//				String fileName=bimg.getOriginalFilename();
//				String savePath="C:/lalalandddd/bookimage/"+fileName;
//				bimg.transferTo(new File(savePath));
//				bkDTO.setBurl("/image/"+fileName);
//				BkService.bookSave(bkDTO);
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return "redirect:/write";
//	}
//	@GetMapping("/index")
//	public String index(Model model) {
//		BkDTO bkDTO=new BkDTO();
//		model.addAttribute("bkDTO", bkDTO);
//		return  "book/index";
//	}
	@GetMapping("/delete")
	public String delete(@RequestParam("bid") int bid) {
		bkService.delete(bid);
		return "redirect:/book/index";
	}
}
