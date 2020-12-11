package com.simple.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

//	// 1st
//	private ScoreService service = new ScoreServiceImpl();	// 전역변수로 선언
	
	// 2nd
	// 스프링 컨테이너에 직접 bean으로 생성하고 자동주입명령
//	@Autowired
//	@Resource(name="service")
//	private ScoreService service;
	
	
	// 3nd
//	@Autowired
//	@Qualifier("scoreService")
	@Resource(name="scoreService")
	private ScoreService service;
	
	
	
	// 점수입력 화면 처리
	@RequestMapping("/scoreRegist")
	public String score() {
		
		return "service/scoreRegist";
	}
	
	// 점수입력 폼처리
	@RequestMapping("/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		service.scoreRegist(vo);
		
		return "service/scoreResult";
	}
	
	
	// 점수목록 요청
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
	
		ArrayList<ScoreVO> list = service.getList();
		
		model.addAttribute("list", list);	// 모델에 list저장
		
		return "service/scoreList";		// 점수 목록 화면
	}
	
	
	// 점수 삭제 요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int index) {
		
		service.scoreDelete(index);
		
		
		return "redirect:/service/scoreList";	// 리스트 목록으로 리다이렉트
	}
	
	
	
	
}





























