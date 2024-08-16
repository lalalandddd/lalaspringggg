package com.movieAndGame.DTO;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GameTargetMobileDTO {
	private int postId;
	private String writer;
	@NotEmpty(message="제목을 입력하세요.")
	private String title;
	@NotEmpty(message="모바일게임 이름을 입력하세요.")
	private String gameName;
	@Size(min=10, max=300, message="10~300자 안에서 작성하세요")
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private LocalDateTime writeDate;
}
