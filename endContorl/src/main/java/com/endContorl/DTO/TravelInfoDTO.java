package com.endContorl.DTO;

import lombok.Data;

@Data
public class TravelInfoDTO {  // 뷰페이지 데이터 출력을 위한 클래스
	private int travelId;
	private int ticketPrice;  // 항공권 금액
	private String travelPackage;  // 여행패키지
}
