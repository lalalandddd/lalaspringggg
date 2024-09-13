package com.BookProject.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BkImgDTO {
	private int bimgid;
	private MultipartFile bimg;
	private String burl;
//	private String bogn;
}
