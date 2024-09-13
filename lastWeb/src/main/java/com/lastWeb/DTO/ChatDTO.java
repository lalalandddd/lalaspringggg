package com.lastWeb.DTO;

import com.lastWeb.Entity.Chat;

import lombok.Data;

@Data
public class ChatDTO {
	private String userName;
	private int userAge;
	private String detail;
	public static ChatDTO of(Chat chat) {
		ChatDTO chatDTO=new ChatDTO();
		chatDTO.setUserName(chat.getUserName());
		chatDTO.setUserAge(chat.getUserAge());
		chatDTO.setDetail(chat.getDetail());
		return chatDTO;
	}
}
