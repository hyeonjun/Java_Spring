package com.encore.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	// 1. �� ��� ��ȸ
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO dao, ModelAndView mav) { // ��ȸ�� ������� ȭ���� ���� �������ϱ� ������ ModelAndView ���
		System.out.println("===> �� ��� ó��");
		mav.addObject("boardList", dao.getBoardList(vo)); // Model ���� ����
		mav.setViewName("getBoardList.jsp"); // View ���� ����
		return mav;
	}
	
	// 2. �� �� ��ȸ
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO dao, ModelAndView mav) {
		System.out.println("===> �� �󼼺��� ó��");
		mav.addObject("board", dao.getBoard(vo));
		mav.setViewName("getBoard.jsp"); // ViewResolver�� ����
		return mav;
	}
	
	// 3. �� ��� ó��
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("===> �� ��� ó��");
		dao.insertBoard(vo);
		return "getBoardList.do"; // ���̺��� ����Ǿ��� ������ getBoardList.do �� ��û�ؾ���
	}
	
	// 4. �� ���� ó��
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("===> �� ���� ó��");
		dao.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 5. �� ���� ó��
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao){
		System.out.println("===> �� ���� ó��");
		dao.deleteBoard(vo);
		return "getBoardList.do";
	}
}
