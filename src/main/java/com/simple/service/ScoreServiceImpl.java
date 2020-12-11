package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService")	// scoreService 이름으로 bean생성과 같다
public class ScoreServiceImpl implements ScoreService {

	@Resource(name="scoreDAO")
	private ScoreDAO scoreDAO;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		scoreDAO.scoreRegist(vo);
	}

	
	@Override
	public ArrayList<ScoreVO> getList() {
		
		return scoreDAO.getList();
	}


	@Override
	public void scoreDelete(int index) {
		scoreDAO.scoreDelete(index);
	}
	
	

}
