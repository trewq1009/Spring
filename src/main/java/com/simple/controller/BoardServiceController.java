package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {

	@Resource(name="boardService")
	private BoardService service;
	
	
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	@RequestMapping("/boardForm")
	public String boardForm(BoardVO vo) {
		service.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> list = service.getList();
		
		model.addAttribute("list", list);
		
		return "service/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int num) {
		
		service.boardDelete(num);
		
		return "redirect:/service/boardList";
	}
	
	
	
}
