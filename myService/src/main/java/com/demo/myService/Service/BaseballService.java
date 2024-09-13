package com.demo.myService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.myService.DTO.PitcherDTO;
import com.demo.myService.Data.Ranking;

@Service
public class BaseballService {
	public List<PitcherDTO> searchPitcher(PitcherDTO pitcherDTO) {
//		PitcherDTO dto=PitcherDTO.of(pitcherDTO.getName());
		List<Ranking.Pitcher> list=Ranking.plist();
		List<PitcherDTO> pitcherDTOList=new ArrayList<>();
		for(Ranking.Pitcher pitcher : list) {
			pitcherDTOList.add(PitcherDTO.of(pitcher.getName(),pitcher.getLostPoint(),pitcher.getStrikeOut(),pitcher.getAer()));
			
		}
		return pitcherDTOList;
	}
}
