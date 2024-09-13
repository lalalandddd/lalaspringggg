package com.endContorl.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.endContorl.DTO.TravelDestDTO;
import com.endContorl.DTO.TravelInfoDTO;
import com.endContorl.Service.TravelSerivce;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TravelController {
//	@Autowired
//	private TravelSerivce travelService;
	private final TravelSerivce travelService;
	@GetMapping("/travel")
	public String travel(Model model) {
		model.addAttribute("myId","sky");
		// model은 컨트롤에서 뷰로 데이터를 전달하기 위한 용도
		// DTO는 사용자의 요청/응답에 사용된다. 사용자가 입력한 데이터를 저장하거나
		// 사용자 화면(뷰페이지)에 데이터를 출력하기 위한 용도
		// DTO를 사용하면 입력한 값에 대한 유효성 체크를 쉽게 할 수 있다.
		// Service는 컨트롤과 DB 사이에서 동작
		return "main";
	}
	@PostMapping("/search")
	public String search(@ModelAttribute TravelDestDTO travel, Model model) {
		// 입력한 여행지 TravelDestDTO 클래스의 travel 객체에 저장했다!
		// 여행지에 맞는 항공권과 패키지에 대한 정보를 보여줘야 한다!!
		// 사용자가 넘겨준 데이터가 아닌 다른 데이터들은 Service를 통해 가져온다!
//		TravelService travelService=new TravelService();
//		travelService.test();
		TravelInfoDTO info=travelService.travelSearch(travel);
		model.addAttribute("info",info);
		return "result";
	}
}

/*
여행지를 입력한다. 입력한 여행지의 항공권 금액과 패키지에 대해 출력한다.
DTO - 여행지, 항공권 금액, 패키지 저장용
  - 여행지 입력 : TravelDestDTO
  - 항공권, 패키지 : TravelInfoDTO
*/