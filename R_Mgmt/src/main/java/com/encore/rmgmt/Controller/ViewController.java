package com.encore.rmgmt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
@RequestMapping("home/*") // URL view라는 요청이 들어오면 ViewController 실행 
public class ViewController {
	
	@RequestMapping(value="/home/login", method=RequestMethod.GET)
	public ModelAndView signIn(){ // URL view/home 이라는 요청이 오면 home() 실행
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/home/signUp", method=RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}


}
