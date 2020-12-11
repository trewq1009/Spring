package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizUser;
import com.simple.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	
	// quiz01, quiz02, quiz03화면을 동시에 처리
	// 반환유형 void형으로 맞추고 맵핑값을 배열로 전달하면
	
	
	
	
	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
	public void views() {
		
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(@ModelAttribute("info") QuizVO vo) {
		
		System.out.println(vo.getYear() + vo.getMonth() + vo.getDay());
		
		
		return "quiz/quiz01_ok";
	}
	
	// =================== quiz02
	
	@RequestMapping("/join")
	public String join(@ModelAttribute("user") QuizUser user) {
		
		return "quiz/quiz02_ok";
	}


	
	// ====================== quiz03
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@ModelAttribute("user") QuizUser user,
						@ModelAttribute("pw_check") String pw_check,
						RedirectAttributes RA) {
		
		if(user.getId().equals("")) {
			RA.addFlashAttribute("msg", "아이디를 확인하세요");
			
			return "redirect:/quiz/quiz03";
		} else if(!user.getPw().equals(pw_check) || user.getPw().equals("")) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			
			return "quiz/quiz03_ok";
		}
	}
	
	
	
	// 강사님 해답 Quiz03
	/*
	@RequestMapping("/join02")
	public String join02(@RequestParam(value="id", required=false, defaultValue="") String id,
						 @RequestParam(value="pw") String pw,
						 @RequestParam(value="pw_check") String pw_check,
						 RedirectAttributes RA,
						 Model model) {
		
		if(id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {	// 정상적으로 처리된 경우
			model.addAttribute("id", id);
			return "quiz/quiz03_ok";
		}
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
}
