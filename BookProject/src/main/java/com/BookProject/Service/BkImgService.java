package com.BookProject.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.BookProject.DAO.BkImgDAO;
import com.BookProject.DTO.BkImgDTO;

@Service
public class BkImgService {
	@Autowired
	private BkImgDAO bkImgDAO;
	private final String uploadDir="C:\\lalalandddd\\bookimage";
	public void imgSave(BkImgDTO bkImgDTO) throws IOException, SQLException{
		MultipartFile file=bkImgDTO.getBimg();
		if (!file.isEmpty()) {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path path = Paths.get(uploadDir + filename);
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            file.transferTo(path.toFile());
            bkImgDTO.setBurl(path.toString());
            bkImgDAO.imgSave(bkImgDTO);
        }
	}
	public BkImgDTO getImage(int id) throws SQLException{
		return bkImgDAO.findById(id);
	}
}
