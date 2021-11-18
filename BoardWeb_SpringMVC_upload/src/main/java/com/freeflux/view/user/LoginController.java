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
		System.out.println("濡쒓렇�씤 �씤利� 泥섎━");
		
		UserVO user = userDAO.getUser(vo);
		
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 異붽� 硫붿꽌�뱶
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("濡쒓렇�씤 �솕硫댁쑝濡� �씠�룞");
		
		vo.setId("guest");
		vo.setPassword("1234");

		return "login.jsp";
	}
}

/**
 * @Controller / @RequestMapping(value="/login.do") 援ы쁽�븯湲�
 
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
		System.out.println("濡쒓렇�씤 泥섎━");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}

}

**/


/**
 * �쟾�넚 諛⑹떇�뿉 �뵲瑜� �슂泥� 泥섎━ : method=RequestMethod.POST
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
		System.out.println("濡쒓렇�씤 �씤利� 泥섎━");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginView(UserVO vo){
		System.out.println("濡쒓렇�씤 �솕硫댁쑝濡� �씠�룞");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/

/**
 * Command 媛앹껜 �씠由� 蹂�寃� : @ModelAttribute("user") 
 * => login.jsp �뙆�씪 �궡遺� �닔�젙 ${userVO.id } => ${user.id }
 *    �� 媛숈씠..  

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
		System.out.println("濡쒓렇�씤 �씤利� 泥섎━");
		
		if(userDAO.getUser(vo) != null){
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 異붽� 硫붿꽌�뱶
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("濡쒓렇�씤 �솕硫댁쑝濡� �씠�룞");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/

/**
 * Servlet API �씠�슜 : HttpSession 媛앹껜瑜� 留ㅺ컻蹂��닔濡� �쟾�떖諛쏆븘�꽌 
 * �궗�슜�옄 �씠由꾩쓣 �꽭�뀡�뿉 ���옣.
 * getBoardList.jsp �닔�젙 : ${userName } �떂 寃뚯떆�뙋�뿉 �삤�떊 嫄� �솚�쁺�빀�땲�떎..

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
		System.out.println("濡쒓렇�씤 �씤利� 泥섎━");
		
		UserVO user = userDAO.getUser(vo);
		
		if(userDAO.getUser(vo) != null){
			session.setAttribute("userName", user);
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	// 異붽� 硫붿꽌�뱶
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo){
		System.out.println("濡쒓렇�씤 �솕硫댁쑝濡� �씠�룞");
		
		vo.setId("Admin");
		vo.setPassword("admin");

		return "login.jsp";
	}
}
**/
