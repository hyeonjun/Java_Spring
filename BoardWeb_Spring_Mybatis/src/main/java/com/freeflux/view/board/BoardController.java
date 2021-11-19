package com.freeflux.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.freeflux.biz.board.BoardListVO;
import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	// 다형성 : 비지니스 컴포넌트 수정과 무관한 작업
	@Autowired
	private BoardService boardService;

	public BoardController() {
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{  // 수정
		System.out.println("글 등록 처리");
	
		/** File Upload 추가 **/
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()){
			String fileName=uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/filestorage/"+fileName));
		}
		/** 여기까지 **/
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");

		// null Check
		if(vo.getSearchCondition() == null){
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null){
			vo.setSearchKeyword("");
		}
		
		//Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	// 검색 조건 목록 설정 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("제목", "TITLE");
		contitionMap.put("내용", "CONTENT");
		return contitionMap;
	}
	
	// 데이터 변환 : XML
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList=boardService.getBoardList(vo);
		
		BoardListVO boardListVO=new BoardListVO();
		boardListVO.setBoardList(boardList);
System.out.println("~~~~ => " +boardListVO.toString());		
		return boardListVO;
	}
}


/**
 * Controller 통합 : Controller return type : ModelAndView
 
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		mav.addObject("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

**/


/**
 * Controller return type : String
 
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	

**/


/**
 * @RequestParam 사용 : BoardVO.java 수정
 * 멤버 변수 추가 : searchCondition / searchKeyword 
 * getter / setter 추가
 * 
 * getBoardList.jsp 수정
 * <form action="getBoardList.do" method="post">
 
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	

**/


/**
 * @ModelAttribute : 검색 조건 목록 설정 
 * getBaordList.jsp 수정
 * 					<select name="searchCondition">
 *						<option value="TITLE">제목</option>
 *						<option value="CONTENT">내용</option>
 *					</select>

	// 검색 조건 목록 설정 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("제목", "TITLE");
		contitionMap.put("내용", "CONTENT");
		return contitionMap;
	}
**/


/**
 * @SessionAttribute 작업 전 테스트
 
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
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		System.out.println("작성자 이름 : " + vo.getWriter());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	// 검색 조건 목록 설정 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("제목", "TITLE");
		contitionMap.put("내용", "CONTENT");
		return contitionMap;
	}
}
**/


/**
 * @SessionAttribute 추가

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
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
							   BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	// 검색 조건 목록 설정 
	@ModelAttribute("contitionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> contitionMap = new HashMap<String, String>();
		contitionMap.put("제목", "TITLE");
		contitionMap.put("내용", "CONTENT");
		return contitionMap;
	}
}
**/



/**
 * 데이터 변환 : Json
 * 
	// 데이터 변환
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList=boardService.getBoardList(vo);
		
		return boardList;
	}
**/
