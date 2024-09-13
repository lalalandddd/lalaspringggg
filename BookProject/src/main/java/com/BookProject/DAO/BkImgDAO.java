package com.BookProject.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.BookProject.DTO.BkImgDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BkImgDAO {
	private final JdbcTemplate jdbcTemplate;
	public void imgSave(BkImgDTO bkImgDTO) {
		String sql="INSERT INTO bookinfoimg (bimgid, bimg, burl) VALUES (?,?,?)";
		jdbcTemplate.update(sql, bkImgDTO.getBimgid(), bkImgDTO.getBimg(), bkImgDTO.getBurl());
	}
	public BkImgDTO findById(int id) {
        String sql = "SELECT * FROM bookinfoimg WHERE bimgid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            BkImgDTO bkImgDTO = new BkImgDTO();
            bkImgDTO.setBimgid(rs.getInt("bimgid"));
            bkImgDTO.setBurl(rs.getString("burl"));
            return bkImgDTO;
        });
    }
}
