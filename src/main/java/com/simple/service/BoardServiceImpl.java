package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="dao")
	private BoardDAO dao;
	
	
	@Override
	public void boardRegist(BoardVO vo) {
		dao.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return dao.getList();
		
	}

	@Override
	public void boardDelete(int num) {
		
		dao.boardDelete(num);
	}

}
