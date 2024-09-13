package com.BookProject.Control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
//	@GetMapping("/index")
//	public String index(){
//		return "index";
//	}
//	@GetMapping("/login")
//	public String login(){
//		return "login";
//	}
	@GetMapping("/search")
	public String search(Model model){
		model.addAttribute("bkSearchDTO", new BkSearchDTO());
		return "book/search";
	}
//	@GetMapping("/searchkeyword")
//	public String bookSearch(@ModelAttribute BkSearchDTO bkSearchDTO, Model model) {
//		String st = bkSearchDTO.getSearchType();
//		String sk = bkSearchDTO.getSearchKeyword();
//		List<BkDTO> books;
//		switch(st) {
//		case "btitl": books=bkService.searchBtitl(sk);
//		model.addAttribute("books", books);
//		model.addAttribute("search",bkSearchDTO);
//		break;
//		case "bwrit": books=bkService.searchBwrit(sk);
//		model.addAttribute("books", books);
//		model.addAttribute("search",bkSearchDTO);
//		break;
//		case "bpubl": books=bkService.searchBpubl(sk);
//		model.addAttribute("books", books);
//		model.addAttribute("search",bkSearchDTO);
//		break;
//		case "bsort": books=bkService.searchBsort(sk);
//		model.addAttribute("books", books);
//		model.addAttribute("search",bkSearchDTO);
//		break;
//		default: books=Collections.emptyList();
//		}
//		model.addAttribute("st",st);
//		model.addAttribute("sk",sk);
//    	return "book/results";
//	}
//	@GetMapping("/searchkeyword")
//	public String bookSearch(@ModelAttribute BkSearchDTO bkSearchDTO, Model model) {
//		String st = bkSearchDTO.getSearchType();
//		String sk = bkSearchDTO.getSearchKeyword();
//		List<BkDTO> books = bkService.searchBooks(st, sk);
//		model.addAttribute("books", books);
//		model.addAttribute("st",st);
//		model.addAttribute("sk",sk);
//    	return "book/results";
//	}
	@GetMapping("/searchkeyword")
	public String bookSearch(HttpServletRequest rq, Model model, RedirectAttributes ra, @RequestParam(defaultValue = "0") int page) {
		String st1=rq.getParameter("searchType1");
		String sk1=rq.getParameter("searchKeyword1");
		String st2=rq.getParameter("searchType2");
		String sk2=rq.getParameter("searchKeyword2");
		String st3=rq.getParameter("searchType3");
		String sk3=rq.getParameter("searchKeyword3");
		String st4=rq.getParameter("searchType4");
		String sk4=rq.getParameter("searchKeyword4");
		int pageSize=10;
		Pageable pageable=PageRequest.of(page, pageSize);
		if(sk1.isEmpty()&&sk2.isEmpty()&&sk3.isEmpty()&&sk4.isEmpty()) {
			ra.addFlashAttribute("alertMessage","검색 결과가 없습니다");
			return "redirect:/search";
		}
		Page<BkDTO> books=bkService.searchBooksByMultipleCriteria(st1, sk1, st2, sk2, st3, sk3, st4, sk4, pageable);
//		List<BkDTO> books=new ArrayList<>();
//		if(sk1!=null&&!sk1.isEmpty()) books.addAll(bkService.searchBooks(st1, sk1));
//		if(sk2!=null&&!sk2.isEmpty()) books.addAll(bkService.searchBooks(st2, sk2));
//		if(sk3!=null&&!sk3.isEmpty()) books.addAll(bkService.searchBooks(st3, sk3));
//		if(sk4!=null&&!sk4.isEmpty()) books.addAll(bkService.searchBooks(st4, sk4));
//		if(sk1.isEmpty()&&sk2.isEmpty()&&sk3.isEmpty()&&sk4.isEmpty()) {
//			ra.addFlashAttribute("alertMessage","검색 결과가 없습니다.");
//			return "redirect:/search";
//		}
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
		return "book/results";
	}
	@GetMapping("/write")
	public String write(Model model){
		model.addAttribute("bkDTO",new BkDTO());
		return "book/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BkDTO bkDTO, @RequestParam("bimg") MultipartFile file, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "book/write"; }
		String uploadPath="";
		String saveName="";
		String fileUrl="";
		if(!file.isEmpty()) {
			try {
				byte[] fileData=file.getBytes();
				uploadPath="C:/lalalandddd/bookimage";
				saveName=fileService.uploadFile(uploadPath, file.getOriginalFilename(), fileData);
//				saveName=fileService.uploadFile(uploadPath, file.getOriginalFilename(), MultipartFile.getBytes());
				fileUrl="/image/"+saveName;
				bkDTO.setBurl(fileUrl);
				bkDTO.setFilename(saveName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bkService.bookSave(bkDTO);
		return "redirect:/write";
	}
//	@GetMapping("/view/{bid}")
//	public String view(@PathVariable Long bid, Model model){
//		BkDTO bk=bkService.findById(bid);
//		Long maxBid=bkService.findMaxBid();
//		Long minBid=bkService.findMinBid();
//		model.addAttribute("bk",bk);
//		model.addAttribute("maxBid",maxBid);
//		model.addAttribute("minBid",minBid);
//		return "book/view";
//	}
	@GetMapping("/view/{bid}")
	public String view(@PathVariable("bid") Long bid, Model model){
		model.addAttribute("bk",bkService.findById(bid));
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
		if(!file.isEmpty()) {
			try {
				byte[] fileData=file.getBytes();
				String uploadPath="C:/lalalandddd/bookimage";
				String saveName=fileService.uploadFile(uploadPath, file.getOriginalFilename(), fileData);
				String fileUrl="/image/"+saveName;
				bkDTO.setBurl(fileUrl);
				bkDTO.setFilename(saveName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			bkDTO.setBurl(bkService.findById(bkDTO.getBid()).getBurl());
		}
		bkService.update(bkDTO);
		return "redirect:/view/"+bkDTO.getBid();
	}
}
