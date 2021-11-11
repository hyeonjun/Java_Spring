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
		// 1. Ŭ���̾�Ʈ ��û ��� ���� ����
		// http://localhost/BoardWeb_Model2/login.jsp
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. Ŭ���̾�Ʈ ��û ��ο� ���� ó���� ������ �б�(Controller ��ü�� ���� ����)
		if(path.equals("/login.do")){
			System.out.println("===> �α��� ó��");
			// 1. ����ڰ� �Է��� ������(����) ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB ����
			UserVO vo= new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO dao = new UserDAO();
			UserVO user = dao.getUser(vo);
			
			// 3.����� ���� ȭ�� ������̼�(ȭ�� �б�)
			if(user != null){
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} else if(path.equals("/logout.do")){
			System.out.println("===> �α׾ƿ� ó��");
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.jsp");
			
		} else if(path.equals("/insertBoard.do")){
			System.out.println("===> �� ��� ó��");
			// 1. ����� �Է� ���� ����
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ����
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")){
			System.out.println("===> �� ���� ó��");
			// 1. ����� �Է� ���� ����
			request.setCharacterEncoding("UTF-8");
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
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")){
			System.out.println("===> �� ���� ó��");
			// 1. seq �Ķ���� �� ����
			request.setCharacterEncoding("UTF-8");
			String seq = request.getParameter("seq");
			
			// 2. DB ����
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")){
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
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")){
			System.out.println("===> �� ��� ó��");
			// 1. DB ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList(vo);
			
			// 3. ��ȸ ����� ���ǿ� ����
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		
		
	}

}
