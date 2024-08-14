package com.movieAndGame.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GameMemberDTO {
	private int gameMemberId;
	@NotEmpty(message="아이디를 입력하세요.")
	private String memberId;
	@Size(min=6, max=15, message="비밀번호는 6~15자리로 입력하세요.")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="비밀번호는 영어와 숫자만 사용 가능합니다.")
	private String password;
	@NotEmpty(message="이름은 필수 기재 사항입니다.")
	private String name;
	private String nick;
	@NotEmpty(message="이메일은 필수 기재 사항입니다.")
	@Email(message="이메일이 잘못되었습니다.")
	private String email;
	@NotEmpty(message="연락처는 필수 기재 사항입니다.")
	private String tel;
	private int birthYear;
	private int birthMonth;
}
