package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {

	// 서비스 클레스에서 구현한 메서드를 추상메서드로 선언
		public void scoreRegist(ScoreVO vo);	// 등록 메서드
		
		public ArrayList<ScoreVO> getList();	// 목록
		
		public void scoreDelete(int index);		// 삭제
		
	
}
