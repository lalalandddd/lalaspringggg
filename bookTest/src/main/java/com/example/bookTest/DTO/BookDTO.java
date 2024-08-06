package com.example.bookTest.DTO;

import lombok.Data;

@Data
public class BookDTO {
	private String bookCode;
	private String bookSort;
	private String bookTitle;
	private int bookVolume;
	private String bookSubtitle;
	private int bookAllpage;
	private String bookWriter;
	private String bookPublisher;
	private boolean nowRental;
}
