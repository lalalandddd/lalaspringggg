package com.endContorl.Service;

import org.springframework.stereotype.Service;

import com.endContorl.DTO.TravelDestDTO;
import com.endContorl.DTO.TravelInfoDTO;

@Service
public class TravelSerivce {
	public void test() {
		System.out.println("서비스 클래스 테스트");
	}
	// 여행지에 맞는 항공권과 패키지 찾기
	public TravelInfoDTO travelSearch(TravelDestDTO travelDestDTO) {
		// 데이터베이스에서 조회하여 입력한 여행지와 일치하는 데이터 찾아서 가져오기
		TravelInfoDTO travelInfoDTO=new TravelInfoDTO();
		travelInfoDTO.setTravelId(10);
		travelInfoDTO.setTicketPrice(1677600);
		travelInfoDTO.setTravelPackage("룩셈부르크 4박7일 무제한바 패키지");
		return travelInfoDTO;
	}
}
