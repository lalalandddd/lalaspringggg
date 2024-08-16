package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.MovieMemberDAO;
import com.movieAndGame.DTO.MovieMemberDTO;

@Service
public class MovieMemberService {
	@Autowired
	private MovieMemberDAO movieMemberDAO;
	// 회원가입 데이터베이스 저장
	// 사용자가 회원가입 양식에 입력한 데이터를 데이터베이스에 저장하기 전에
	// 아이디 중복을 확인하고 중복이면 가입 불가능 설정을 해야 한다.
	// 중복이면 true 반환, 아니면 false 반환
	// 즉 controller이 false를 받아야 데이터베이스에 데이터를 저장하고 회원가입이 가능하다.
	// 중복 여부 확인 1. 데이터베이스에서 직접 중복 여부 확인 (쿼리문만 작성하면 되니 쉽다.)
	// 중복 여부 확인 2. 데이터베이스를 모두 가져와서 중복 여부 확인 (자바를 작성해야 비교해서 어렵다.)
	public boolean signUpSave(MovieMemberDTO movieMemberDTO) {
		List<String> memberIdList=movieMemberDAO.findAllId();  // 멤버id 모두 가져와
//		System.out.println(memberIdList.size());// 잘 가져왔는지 확인 (현재 가입된 인원수가 표시된다.)
		// 가져온 id와 회원가입에 적은 id 비교(contain에서 중복되면 true, indexOf에서 중복되면 -1이 아닌 숫자)
		if(memberIdList.contains(movieMemberDTO.getMemberId())) return true;
		movieMemberDAO.insert(movieMemberDTO);
		return false;
	}
	public MovieMemberDTO login(MovieMemberDTO movieMemberDTO) {
		return movieMemberDAO.login(movieMemberDTO);
	}
}
