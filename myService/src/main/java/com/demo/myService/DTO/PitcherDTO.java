package com.demo.myService.DTO;

import lombok.Data;

@Data
public class PitcherDTO {  // 한 명의 투수에 대한 변수를 가진 클래스
	private String name;  // 이름
	private int lostPoint;  // 실점
	private int strikeOut;  // 탈삼진
	private float avgEarnedRun;  // 평균자책점
	
	public static PitcherDTO of(String name, int lp, int so, float aer) {
		PitcherDTO pitcherDTO=new PitcherDTO();
		pitcherDTO.setName(name);
		pitcherDTO.setLostPoint(lp);
		pitcherDTO.setStrikeOut(so);
		pitcherDTO.setAvgEarnedRun(aer);
		return pitcherDTO;
	}
}
