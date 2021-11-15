package com.encore.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

	public LogoutController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){
		System.out.println("===> 로그아웃 처리");
		session.invalidate();
		
		return "login.jsp";
	}

}
