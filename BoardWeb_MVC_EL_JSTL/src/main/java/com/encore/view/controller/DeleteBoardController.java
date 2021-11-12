package com.encore.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	public DeleteBoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> �� ���� ó��");
		// 1. seq �Ķ���� �� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		return "getBoardList";
	}

}
