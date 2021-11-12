package com.encore.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.biz.user.UserVO;
import com.encore.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> 로그인 처리");
		// 1. 사용자가 입력한 데이터(정보) 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동
		UserVO vo= new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		// 3.결과에 따른 화면 내비게이션(화면 분기) - 처리결과를 DispatcherServlet에게 전달
		if(user != null){
			return "getBoardList.do";
		} else {
			return "login";
			// 파일명만 반환하는 이유 : DispatcherServlet이 ViewResolver에게 파일에 대한 확장자 및 경로를 재문의한다.
		}
	}

}
