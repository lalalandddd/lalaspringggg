package com.demo.myService.Data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Ranking {
	
	public static List<Pitcher> plist(){
		// Entity 클래스의 내부 클래스 만드는 분위기
		List<Pitcher> list=new ArrayList<>();
		list.add(new Pitcher("류현진",121,72,3.89f));
		list.add(new Pitcher("히트",169,42,2.31f));
		list.add(new Pitcher("원태인",105,60,3.56f));
		return list;
	}
	
	@Data  // Ranking 위에 만들면 아래가 안만들어진다. 주의!
	public static class Pitcher{
		private String name;
		private int lostPoint;
		private int strikeOut;
		private float aer;
		public Pitcher(String name, int lp, int so, float aer) {
			this.name=name;
			this.lostPoint=lp;
			this.strikeOut=so;
			this.aer=aer;
		}
	}
}
