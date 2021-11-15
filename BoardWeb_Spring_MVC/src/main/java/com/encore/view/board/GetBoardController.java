package com.encore.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	public GetBoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("===> �� �󼼺��� ó��");
		
		// board.getSeq()
		// 1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		
		// 3. �˻� ����� ȭ�� ������  ModelAndView ��ü�� ��� ��ȯ
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard"); // ViewResolver�� ����
		return mav;
	}

}
