/**
 * 
 */
package com.freeflux.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freeflux.biz.user.UserVO;
import com.freeflux.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	public LoginController() {
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리");
		
		UserVO user = userDAO.getUser(vo);
		
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 추가 메서드
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("로그인 화면으로 이동");
		
		vo.setId("guest");
		vo.setPassword("1234");

		return "login.jsp";
	}
}

/**
 * @Controller / @RequestMapping(value="/login.do") 구현하기
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeflux.biz.user.UserVO;
import com.freeflux.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	public LoginController() {
	}

	@RequestMapping(value="/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}

}

**/


/**
 * 전송 방식에 따른 요청 처리 : method=RequestMethod.POST
 * @RequestMapping(value="/login.do", method=RequestMethod.POST)
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freeflux.biz.user.UserVO;
import com.freeflux.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	public LoginController() {
	}

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginView(UserVO vo){
		System.out.println("로그인 화면으로 이동");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/

/**
 * Command 객체 이름 변경 : @ModelAttribute("user") 
 * => login.jsp 파일 내부 수정 ${userVO.id } => ${user.id }
 *    와 같이..  

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freeflux.biz.user.UserVO;
import com.freeflux.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	public LoginController() {
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 추가 메서드
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("로그인 화면으로 이동");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/

/**
 * Servlet API 이용 : HttpSession 객체를 매개변수로 전달받아서 
 * 사용자 이름을 세션에 저장.
 * getBoardList.jsp 수정 : ${userName } 님 게시판에 오신 걸 환영합니다..

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freeflux.biz.user.UserVO;
import com.freeflux.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	public LoginController() {
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리");
		
		UserVO user = userDAO.getUser(vo);
		
		if(userDAO.getUser(vo) != null){
			session.setAttribute("userName", user);
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 추가 메서드
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("로그인 화면으로 이동");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/
