package com.BookProject.Control;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BookProject.DTO.BkDTO;
import com.BookProject.DTO.BkSearchDTO;
import com.BookProject.Service.BkService;
import com.BookProject.Service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BkController {
	private final BkService bkService;
	private final FileService fileService;
	@GetMapping("/")
	public String home(Model model, @RequestParam(defaultValue = "0") int page) {
		int pageSize = 10;
		List<BkDTO> bookList = bkService.findPaginated(page, pageSize);
		int totalBooks = bkService.countAllBooks();
		int totalPages = (int) Math.ceil((double) totalBooks / pageSize);
		model.addAttribute("bookList", bookList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		return "book/index";
	}
	@GetMapping("/search")
	public String search(Model model){
		model.addAttribute("bkSearchDTO", new BkSearchDTO());
		return "book/search";
	}
	@GetMapping("/searchkeyword")
	public String bookSearch(HttpServletRequest rq, Model model, RedirectAttributes ra, @RequestParam(defaultValue = "0") int page) {
		String st1=rq.getParameter("searchType1")!=null ? rq.getParameter("searchType1") : "";
		String sk1=rq.getParameter("searchKeyword1")!=null ? rq.getParameter("searchKeyword1") : "";
		String st2=rq.getParameter("searchType2")!=null ? rq.getParameter("searchType2") : "";
		String sk2=rq.getParameter("searchKeyword2")!=null ? rq.getParameter("searchKeyword2") : "";
		String st3=rq.getParameter("searchType3")!=null ? rq.getParameter("searchType3") : "";
		String sk3=rq.getParameter("searchKeyword3")!=null ? rq.getParameter("searchKeyword3") : "";
		String st4=rq.getParameter("searchType4")!=null ? rq.getParameter("searchType4") : "";
		String sk4=rq.getParameter("searchKeyword4")!=null ? rq.getParameter("searchKeyword4") : "";
		if(sk1.isEmpty()&&sk2.isEmpty()&&sk3.isEmpty()&&sk4.isEmpty()) {
			ra.addFlashAttribute("alertMessage","입력된 검색 단어가 없습니다");
			return "redirect:/search";
		}
		int pageSize=10;
		Pageable pageable=PageRequest.of(page, pageSize);
		Page<BkDTO> books=bkService.searchBooksByMultipleCriteria(st1, sk1, st2, sk2, st3, sk3, st4, sk4, pageable);
		if(books.isEmpty()) {
			ra.addFlashAttribute("alertMessage","검색 결과가 없습니다");
			return "redirect:/search";
		}
		String stl1=convertToReadableLabel(st1);
		String stl2=convertToReadableLabel(st2);
		String stl3=convertToReadableLabel(st3);
		String stl4=convertToReadableLabel(st4);
		model.addAttribute("books",books.getContent());
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPages",books.getTotalPages());
		model.addAttribute("st1",st1);
		model.addAttribute("sk1",sk1);
		model.addAttribute("st2",st2);
		model.addAttribute("sk2",sk2);
		model.addAttribute("st3",st3);
		model.addAttribute("sk3",sk3);
		model.addAttribute("st4",st4);
		model.addAttribute("sk4",sk4);
		model.addAttribute("stl1",stl1);
		model.addAttribute("stl2",stl2);
		model.addAttribute("stl3",stl3);
		model.addAttribute("stl4",stl4);
		return "book/results";
	}
	private String convertToReadableLabel(String st) {
		switch(st) {
		case "btitl": return "책 제목";
		case "bwrit": return "지은이";
		case "bpubl": return "출판사";
		case "bsort": return "분류";
		default: return "";
		}
	}
	@GetMapping("/write")
	public String write(Model model){
		model.addAttribute("bkDTO",new BkDTO());
		model.addAttribute("false","");
		return "book/write";
	}
	@PostMapping("/write")
	public String write(@Valid @ModelAttribute BkDTO bkDTO, @RequestParam("bimg") MultipartFile file, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("bkDTO",bkDTO);
			return "book/write";
		}
		String uploadPath="";
		String saveName="";
		String fileUrl="";
		if(!file.isEmpty()) {
			try {
				byte[] fileData=file.getBytes();
				uploadPath="src/main/resources/static/image/bimg/";
				saveName=fileService.uploadFile(uploadPath, file.getOriginalFilename(), fileData);
				fileUrl="/image/"+saveName;
				bkDTO.setBurl(fileUrl);
				bkDTO.setFilename(saveName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!bkService.bookSave(bkDTO)) {
			model.addAttribute("bkDTO",bkDTO);
			model.addAttribute("check","이미 등록된 도서입니다");
			return "book/write";
		}
		bkService.bookSave(bkDTO);
		model.addAttribute("bkDTO",bkDTO);
		model.addAttribute("bsave","도서 등록 성공");
		return "book/write";
	}
	@GetMapping("/view/{bid}")
	public String view(@PathVariable("bid") Long bid, Model model, RedirectAttributes ra){
		Optional<BkDTO> bko=bkService.findById(bid);
		if(!bko.isPresent()) {
			Long nextBid=bkService.findNextValidBid(bid);
			if(nextBid!=null) {
				return "redirect:/view/"+nextBid;
			}
			ra.addFlashAttribute("alertMessage","해당 도서를 찾을 수 없습니다.");
			return "redirect:/error";
		}
		BkDTO bk=bko.get();
		Long maxBid=bkService.findMaxBid();
		Long minBid=bkService.findMinBid();
		Long preBid=bkService.findPreviousValidBid(bid);
		Long nextBid=bkService.findNextValidBid(bid);
		model.addAttribute("bk",bk);
		model.addAttribute("maxBid",maxBid);
		model.addAttribute("minBid",minBid);
		model.addAttribute("preBid",preBid);
		model.addAttribute("nextBid",nextBid);
		return "book/view";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("bid") Long bid) {
		bkService.delete(bid);
		return "redirect:/";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute BkDTO bkDTO, @RequestParam("bimg") MultipartFile file, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "book/write"; }
		String uploadPath="";
		String saveName="";
		String fileUrl="";
		if(!file.isEmpty()) {
			try {
				byte[] fileData=file.getBytes();
				uploadPath="src/main/resources/static/image/bimg/";
				saveName=fileService.uploadFile(uploadPath, file.getOriginalFilename(), fileData);
				fileUrl="/image/"+saveName;
				bkDTO.setBurl(fileUrl);
				bkDTO.setFilename(saveName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			BkDTO bbkk=bkService.findById(bkDTO.getBid()).orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다"));
			bkDTO.setBurl(bbkk.getBurl());
		}
		bkService.update(bkDTO);
		return "redirect:/view/"+bkDTO.getBid();
	}
//	@GetMapping("/index")
//	public String index(){
//		return "index";
//	}
//	@GetMapping("/login")
//	public String login(){
//		return "login";
//	}
}
