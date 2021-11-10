package com.encore.rmgmt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
@RequestMapping("home/*") // URL view��� ��û�� ������ ViewController ���� 
public class ViewController {
	
	@RequestMapping(value="/home/login", method=RequestMethod.GET)
	public ModelAndView signIn(){ // URL view/home �̶�� ��û�� ���� home() ����
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/home/signUp", method=RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}


}
