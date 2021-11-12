package com.encore.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	public GetBoardListController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> �� ��� ó��");
		// 1. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 3. ��ȸ ����� ���ǿ� ����
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}

}
