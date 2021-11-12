package com.encore.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	public GetBoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("===> �� �󼼺��� ó��");
		// board.getSeq()
		// 1. �Ķ���� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		
		// 3. ��ȸ ����� ���ǿ� ����
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
	}

}
