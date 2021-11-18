package com.freeflux.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	BoardService service;

	public BoardController() {
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("湲� �벑濡� 泥섎━");
		service.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("湲� �닔�젙 泥섎━");
		System.out.println("踰덊샇 : " + vo.getSeq());
		System.out.println("�젣紐� : " + vo.getTitle());
		System.out.println("�옉�꽦�옄 : " + vo.getWriter());
		System.out.println("�궡�슜 : " + vo.getContent());
		System.out.println("�벑濡앹씪 : " + vo.getRegDate());
		System.out.println("議고쉶�닔 : " + vo.getCnt());
		
		service.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("湲� �궘�젣 泥섎━");

		service.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("湲� �긽�꽭 議고쉶 泥섎━");
		
		model.addAttribute("board", service.getBoard(vo));
		return "getBoard.jsp";
	}
	
	// 갬색 조건 목록 설정 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("제목", "TITLE");
		contitionMap.put("내용", "CONTENT");
		return contitionMap;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, Model model) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");
		
		System.out.println("조건 : " + condition);
		System.out.println("키워드 : " + keyword);
		vo.setSearchCondition(condition);
		vo.setSearchKeyword(keyword);
		model.addAttribute("boardList", service.getBoardList(vo));
		return "getBoardList.jsp";
	}	
}


/**
 * Controller �넻�빀 : Controller return type : ModelAndView
 
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("湲� �긽�꽭 議고쉶 泥섎━");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");

		mav.addObject("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

**/


/**
 * Controller return type : String
 
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� �긽�꽭 議고쉶 泥섎━");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	

**/


/**
 * @RequestParam �궗�슜 : BoardVO.java �닔�젙
 * 硫ㅻ쾭 蹂��닔 異붽� : searchCondition / searchKeyword 
 * getter / setter 異붽�
 * 
 * getBoardList.jsp �닔�젙
 * <form action="getBoardList.do" method="post">
 
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	

**/


/**
 * @ModelAttribute : 寃��깋 議곌굔 紐⑸줉 �꽕�젙 
 * getBaordList.jsp �닔�젙
 * 					<select name="searchCondition">
 *						<option value="TITLE">�젣紐�</option>
 *						<option value="CONTENT">�궡�슜</option>
 *					</select>

	// 寃��깋 議곌굔 紐⑸줉 �꽕�젙 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("�젣紐�", "TITLE");
		contitionMap.put("�궡�슜", "CONTENT");
		return contitionMap;
	}
**/


/**
 * @SessionAttribute �옉�뾽 �쟾 �뀒�뒪�듃
 
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	public BoardController() {
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �벑濡� 泥섎━");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �닔�젙 泥섎━");
		System.out.println("�옉�꽦�옄 �씠由� : " + vo.getWriter());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �궘�젣 泥섎━");

		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� �긽�꽭 議고쉶 泥섎━");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");
		
		System.out.println("寃��깋 議곌굔 : " + condition);
		System.out.println("寃��깋 �떒�뼱 : " + keyword);

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	// 寃��깋 議곌굔 紐⑸줉 �꽕�젙 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("�젣紐�", "TITLE");
		contitionMap.put("�궡�슜", "CONTENT");
		return contitionMap;
	}
}
**/


/**
 * @SessionAttribute 異붽�

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	public BoardController() {
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �벑濡� 泥섎━");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �닔�젙 泥섎━");

		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("湲� �궘�젣 泥섎━");

		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� �긽�꽭 議고쉶 泥섎━");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("湲� 紐⑸줉 寃��깋 泥섎━");
		
		System.out.println("寃��깋 議곌굔 : " + condition);
		System.out.println("寃��깋 �떒�뼱 : " + keyword);

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	// 寃��깋 議곌굔 紐⑸줉 �꽕�젙 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("�젣紐�", "TITLE");
		contitionMap.put("�궡�슜", "CONTENT");
		return contitionMap;
	}
}
 * */
