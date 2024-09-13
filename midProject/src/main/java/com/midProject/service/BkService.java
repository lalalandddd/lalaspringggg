package com.midProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.midProject.DAO.BkDAO;
import com.midProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BkService {
	private final BkDAO bkDAO;
	public void bookSave(BkDTO bkDTO) { if(bkDTO!=null) { bkDAO.save(bkDTO); } }
	public List<BkDTO> findAllBooks(){ return bkDAO.findAll(); }
	public BkDTO findById(int id) { return bkDAO.findById(id); }
	public void delete(int bid) {
//		String imagePath = bkDAO.getImagePath(bid);
//        File file = new File(imagePath);
//        if (file.exists()) {
//            file.delete();
//        }
		bkDAO.delete(bid);
	}
}
