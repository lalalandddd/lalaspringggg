package com.movieAndGame.DTO;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MovieReviewDTO {
	private int review_id;
	@NotBlank(message="제목을 입력하세요.")
	private String title;
	private String writer;
	@Size(min=10, max=300, message="10~300자 안에서 작성하세요")
	private String content;
	private LocalDateTime write_date;
}
