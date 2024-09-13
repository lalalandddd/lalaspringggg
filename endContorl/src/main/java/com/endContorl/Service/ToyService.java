package com.endContorl.Service;

import org.springframework.stereotype.Service;

import com.endContorl.DTO.ToyDTO;
import com.endContorl.DTO.ToysDTO;

@Service
public class ToyService {
	public ToysDTO toySearch(ToyDTO toyDTO) {
		ToysDTO toysDTO=new ToysDTO();
		toysDTO.setToyName("헬로카봇 킹가이즈");
		toysDTO.setToyPrice(67000);
		toysDTO.setAge(6);
		toysDTO.setToyText("변화무쌍 4단변신 미래에서온 변신천재");
		return toysDTO;
	}
}
