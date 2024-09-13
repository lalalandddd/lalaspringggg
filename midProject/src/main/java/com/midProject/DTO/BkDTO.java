package com.midProject.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BkDTO {
	private int bid;
	private String btitl;
	private String burl;
	private MultipartFile bimg;
}
