package com.midProject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.midProject.DAO.BkDAO;
import com.midProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BkService {
	private final BkDAO bkDAO;
	public void bookSave(BkDTO bkDTO) { if (bkDTO!=null) { bkDAO.save(bkDTO); } }
	public List<BkDTO> findAllBooks() { return bkDAO.findAll(); }
	public BkDTO findById(int bid) { return bkDAO.findById(bid); }
	public void delete(int bid) { bkDAO.delete(bid); }
	public void update(BkDTO bkDTO) { bkDAO.update(bkDTO); }
}
