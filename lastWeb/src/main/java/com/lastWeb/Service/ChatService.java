package com.lastWeb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lastWeb.DTO.ChatDTO;
import com.lastWeb.Entity.Chat;
import com.lastWeb.Repository.ChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final ChatRepository chatRepository;
	public void save(ChatDTO chatDTO) {
		// 1. DTO > Entity  (of 를 만들었다면 한큐에 해결... 아니면 아래처럼 일일이 기재)
		// DTO는 데이터베이스에 저장이 안 되기 때문... Entity만 저장이 가능
		Chat chat=new Chat();
		chat.setUserName(chatDTO.getUserName());
		chat.setUserAge(chatDTO.getUserAge());
		chat.setDetail(chatDTO.getDetail());
		// 2. Entity를 Repository를 통해 save
		chatRepository.save(chat);
	}
	public List<ChatDTO> getDtos(){
		// 뷰 페이지에 데이터를 출력하기 위해 DTO에 담는다.
		List<ChatDTO> dtos=new ArrayList<>();
		// 데이터베이스에서 조회해서 가져오기 = findXXX 메서드 findAll findById 등등
		List<Chat> list=chatRepository.findAll();
		// Entity > DTO 뷰에 출력하려면 DTO가 필요하기 때문...
		for(Chat data : list) {
			// data는 Chat Entity 객체
			dtos.add(ChatDTO.of(data));
		}
		return dtos;
	}
}
