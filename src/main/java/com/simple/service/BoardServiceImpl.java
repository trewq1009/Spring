package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;
import com.simple.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

//	@Resource(name="dao")
//	private BoardDAO dao;
//	
//	
//	@Override
//	public void boardRegist(BoardVO vo) {
//		dao.boardRegist(vo);
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		return dao.getList();
//		
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//		dao.boardDelete(num);
//	}

	
	// ================== 마이바티스 연결 ===========================
	
	private BoardMapper boardMapper;
	
	@Override
	public void boardRegist(BoardVO vo) {
		boardMapper.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public void boardDelete(int num) {
		boardMapper.boardDelete(num);
	}


}
