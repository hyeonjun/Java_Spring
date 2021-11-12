package com.encore.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	public InsertBoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("===> �� ��� ó��");
		// 1. ����� �Է� ���� ����
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		// getBoardList
		return "getBoardList";
	}

}
