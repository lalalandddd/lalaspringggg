package com.demo.myService.DTO;

import lombok.Data;

@Data
public class MyageDTO {
	private String myname;
	private int myage;
	public static MyageDTO of(String name) {
		MyageDTO age=new MyageDTO();
		age.setMyname(name);
		age.setMyage(28);
		return age;
	}
}
