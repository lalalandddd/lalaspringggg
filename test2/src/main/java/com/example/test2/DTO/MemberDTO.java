package com.example.test2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Data 모든 필요한 애너테이션 한번에 불러오기
public class MemberDTO {
	private String userId;
	private String userPw;
	private String userEmail;
	private String userTel;
	private String userBirth;
}
