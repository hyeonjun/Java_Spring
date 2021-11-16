package com.encore.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	public UpdateBoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("===> �� ���� ó��");
		// 1. ����� �Է� ���� ����
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		// "seq"�� ����� ȭ�鿡���� ������ �ʵ��� type="hidden"���� ��������
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);

		//getBoardList
		return "getBoardList";
	}

}