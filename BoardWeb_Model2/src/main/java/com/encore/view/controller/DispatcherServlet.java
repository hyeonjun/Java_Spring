package com.encore.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.biz.board.BoardVO;
import com.encore.biz.board.impl.BoardDAO;
import com.encore.biz.user.UserVO;
import com.encore.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 클라이언트 요청 경로 정보 추출
		// http://localhost/BoardWeb_Model2/login.jsp
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. 클라이언트 요청 경로에 따라 처리할 내용을 분기(Controller 객체로 변경 예정)
		if(path.equals("/login.do")){
			System.out.println("===> 로그인 처리");
			// 1. 사용자가 입력한 데이터(정보) 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동
			UserVO vo= new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO dao = new UserDAO();
			UserVO user = dao.getUser(vo);
			
			// 3.결과에 따른 화면 내비게이션(화면 분기)
			if(user != null){
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} else if(path.equals("/logout.do")){
			System.out.println("===> 로그아웃 처리");
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.jsp");
			
		} else if(path.equals("/insertBoard.do")){
			System.out.println("===> 글 등록 처리");
			// 1. 사용자 입력 정보 추출
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")){
			System.out.println("===> 글 수정 처리");
			// 1. 사용자 입력 정보 추출
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			// "seq"는 사용자 화면에서는 보이지 않도록 type="hidden"으로 설정했음
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")){
			System.out.println("===> 글 삭제 처리");
			// 1. seq 파라미터 값 추출
			request.setCharacterEncoding("UTF-8");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")){
			System.out.println("===> 글 상세보기 처리");
			// board.getSeq()
			// 1. 파라미터 받음
			String seq = request.getParameter("seq");
			
			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO dao = new BoardDAO();
			BoardVO board = dao.getBoard(vo);
			
			// 3. 조회 결과를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")){
			System.out.println("===> 글 목록 처리");
			// 1. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList(vo);
			
			// 3. 조회 결과를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		
		
	}

}
