package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.DAO.CoffeDao;
import com.example.bookTest.DTO.CoffeDto;

@Service
public class CoffeService {
	private final CoffeDao coffeDao;
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao=coffeDao;
	}
	public void coffeReg(CoffeDto coffeDto) {
		if(coffeDto!=null) {
			coffeDao.insert(coffeDto);
		}
	}
	public List<CoffeDto> coffeeAll(){
		return coffeDao.coffee();
	}
	public CoffeDto getCoffee(int id) {
		if(id!=0) { return coffeDao.findId(id); }
		return null;
	}
	public void coffeDelete(int id) {
		coffeDao.coffeDelete(id);
	}
}
