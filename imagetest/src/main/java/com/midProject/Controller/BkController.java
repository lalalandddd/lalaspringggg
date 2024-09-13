package com.midProject.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.midProject.DTO.BkDTO;
import com.midProject.Service.BkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BkController {
	private final BkService bkService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookList", bkService.findAllBooks());
        return "index";
    }
    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("bkDTO", new BkDTO());
        return "write";
    }
    @PostMapping("/write")
    public String write(@ModelAttribute BkDTO bkDTO) {
        MultipartFile bimg=bkDTO.getBimg();
        if (!bimg.isEmpty()) {
            try {
                String fileName=bimg.getOriginalFilename();
//                String savePath = new File("src/main/resources/static/image/" + fileName).getAbsolutePath();
                String savePath="C:/lalalandddd/bookimage/" + fileName;
                bimg.transferTo(new File(savePath));
                bkDTO.setBurl("/image/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bkService.bookSave(bkDTO);
        return "redirect:/write";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("bid") int bid, Model model) {
//        BkDTO bkDTO = bkService.findById(bid);
        model.addAttribute("bkDTO", bkService.findById(bid));
        return "view";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bid") int bid) {
        bkService.delete(bid);
        return "redirect:/";
    }
	@PostMapping("/update")
//    public String update(@ModelAttribute BkDTO bkDTO, @RequestParam("bimg") MultipartFile file) {
//        if (!file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
////            String savePath = new File("src/main/resources/static/image/" + fileName).getAbsolutePath();
//          String savePath="C:/lalalandddd/bookimage/"+fileName;
//            try {
//                file.transferTo(new File(savePath));
//                bkDTO.setBurl(savePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        bkService.update(bkDTO);
//        return "redirect:/view/" + bkDTO.getBid();
	public String update(@ModelAttribute BkDTO bkDTO) {
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				String fileName=bimg.getOriginalFilename();
				String savePath="C:/lalalandddd/bookimage/"+fileName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			bkDTO.setBurl(bkService.findById(bkDTO.getBid()).getBurl());
		}
		bkService.update(bkDTO);
		return "redirect:/view/"+bkDTO.getBid();
	}
}
