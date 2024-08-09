package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.DAO.MemberDAO;
import com.example.bookTest.DTO.MemberDTO;

@Service
public class LibraryMemberService {
	private final MemberDAO memberDAO;
	@Autowired
	public LibraryMemberService(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	public void memberSave(MemberDTO memberDTO) {
		if(memberDTO!=null) {
			memberDAO.insert(memberDTO);
		}
	}
	public List<MemberDTO> selectAll(){
		return memberDAO.select();
	}
	public MemberDTO getMember(int idnb) {
		if(idnb!=0) { return memberDAO.findIdnb(idnb); }
		return null;
	}
}
