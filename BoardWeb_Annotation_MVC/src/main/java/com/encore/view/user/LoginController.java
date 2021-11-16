package com.encore.view.user;

import com.encore.biz.user.UserVO;
import com.encore.biz.user.impl.UserDAO;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	public LoginController() {
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String logView(@ModelAttribute("user") UserVO vo){
		System.out.println("==> 로그인 화면으로 이동 <==");
		vo.setId("guest");
		vo.setPassword("1234");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO dao, HttpSession session){
		System.out.println("==> 로그인 처리 <==");
		
		UserVO user = dao.getUser(vo);
//		System.out.println(user.toString());
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
