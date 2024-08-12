package com.movieAndGame.DTO;

import lombok.Data;

@Data
public class MovieMemberDTO {
	private int movieMemberId;
	private String memberId;
	private String name;
	private String password;
	private String email;
	private String tel;
	private int birthYear;
	private int birthMonth;
}

