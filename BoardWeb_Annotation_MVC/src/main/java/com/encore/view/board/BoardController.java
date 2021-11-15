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
	
	// 1. 글 목록 조회
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO dao, ModelAndView mav) { // 조회된 결과값과 화면을 같이 보내야하기 때문에 ModelAndView 사용
		System.out.println("===> 글 목록 처리");
		mav.addObject("boardList", dao.getBoardList(vo)); // Model 정보 저장
		mav.setViewName("getBoardList.jsp"); // View 정보 저장
		return mav;
	}
	
	// 2. 글 상세 조회
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO dao, ModelAndView mav) {
		System.out.println("===> 글 상세보기 처리");
		mav.addObject("board", dao.getBoard(vo));
		mav.setViewName("getBoard.jsp"); // ViewResolver에 의해
		return mav;
	}
	
	// 3. 글 등록 처리
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("===> 글 등록 처리");
		dao.insertBoard(vo);
		return "getBoardList.do"; // 테이블이 변경되었기 때문에 getBoardList.do 로 요청해야함
	}
	
	// 4. 글 수정 처리
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("===> 글 수정 처리");
		dao.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 5. 글 삭제 처리
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao){
		System.out.println("===> 글 삭제 처리");
		dao.deleteBoard(vo);
		return "getBoardList.do";
	}
}
