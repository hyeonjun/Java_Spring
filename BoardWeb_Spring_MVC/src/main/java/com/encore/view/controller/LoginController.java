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
		System.out.println("===> �α��� ó��");
		// 1. ����ڰ� �Է��� ������(����) ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ����
		UserVO vo= new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		// 3.����� ���� ȭ�� ������̼�(ȭ�� �б�) - ó������� DispatcherServlet���� ����
		if(user != null){
			return "getBoardList.do";
		} else {
			return "login";
			// ���ϸ� ��ȯ�ϴ� ���� : DispatcherServlet�� ViewResolver���� ���Ͽ� ���� Ȯ���� �� ��θ� �繮���Ѵ�.
		}
	}

}
