package com.encore.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;
import com.encore.biz.user.UserVO;
import com.encore.biz.user.impl.UserDAO;

public class DispatcherServlet_Backup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet_Backup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ ��û ��� ���� ����
		// http://localhost/BoardWeb_Model2/login.jsp
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. Ŭ���̾�Ʈ ��û ��ο� ���� ó���� ������ �б�(Controller ��ü�� ���� ����)
		if(path.equals("/login.do")){
			
			
		} else if(path.equals("/logout.do")){
			
			
		} else if(path.equals("/insertBoard.do")){
			
			
		} else if(path.equals("/updateBoard.do")){
			
			
			
			
		} else if(path.equals("/deleteBoard.do")){
			
			
			
			
			
			
		} else if(path.equals("/getBoard.do")){
			
			
		} else if(path.equals("/getBoardList.do")){

		}
		
		
	}

}
