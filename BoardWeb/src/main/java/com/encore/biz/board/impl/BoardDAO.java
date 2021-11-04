package com.encore.biz.board.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.biz.board.BoardVO;

/***
 * 
 * @author Playdata
 * BoardDAO : CRUD 관련 메서드 보유 클래스
 * insertBoard(): insert into ~
 * updateBoard(): update ~ set ~
 * deleteBoard(): delete from ~
 * getBoard(): select ~ from ~ where ~
 * getBoardList(): select ~ from ~
 * 
 * SQL Query 관련 상수 선언
 */

@Repository("boardDAO") // Component로 써도 되지만 데이터데이스 관련 어노테이션이라고 명시하기위해 Repository 사용
public class BoardDAO {
	
	// JDBC 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL 관련 상수(대문자) 선언
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_CNT_UPDATE = "update board set cnt=? where seq=?";
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("==> BoardDAO 개체 생성");
	}
	
	/** CRUD 관련 메서드들 선언 **/
	
	/**
	 * 글 등록 메서드
	 * param : BoardVO
	 * return : x
	 */
	public void insertBoard(BoardVO vo){
		System.out.println("===> JDBC insertBoard() 기능 처리" + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_INSERT);
			this.pstmt.setString(1, vo.getTitle());
			this.pstmt.setString(2, vo.getWriter());
			this.pstmt.setString(3, vo.getContent());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // insertBoard
	
	/**
	 * 글 수정 메서드
	 * param : BoardVO
	 * return : x
	 */
	public void updateBoard(BoardVO vo){
		System.out.println("===> JDBC updateBoard() 기능 처리" + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_UPDATE);
			this.pstmt.setString(1, vo.getTitle());
			this.pstmt.setString(2, vo.getContent());
			this.pstmt.setInt(3, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // updateBoard
	
	/**
	 * 글 삭제 메서드
	 * param : BoardVO
	 * return : x
	 */
	public void deleteBoard(BoardVO vo){
		System.out.println("===> JDBC deleteBoard() 기능 처리" + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_DELETE);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // deleteBoard
	
	/**
	 * 글 상세보기 메서드
	 * param : BoardVO
	 * return : BoardVO
	 */
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> JDBC getBoard() 기능 처리" + vo.toString());
		BoardVO board = null;
		
		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_GET);
			this.pstmt.setInt(1, vo.getSeq());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				board = new BoardVO();
				board.setSeq(this.rs.getInt("seq"));
				board.setTitle(this.rs.getString("title"));
				board.setWriter(this.rs.getString("writer"));
				board.setContent(this.rs.getString("content"));
				board.setRegDate(this.rs.getDate("regdate"));
				board.setCnt(this.rs.getInt("cnt"));
			}
			
		} catch (Exception e) {
			System.out.println("getBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		
		return board;
	}
	
	/**
	 * 글 목록 메서드
	 * param : BoardVO
	 * return : List<BoardVO>
	 */
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JDBC getBoardList() 기능 처리" + vo.toString());
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_LIST);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()){
				BoardVO board = new BoardVO();
				board.setSeq(this.rs.getInt("seq"));
				board.setTitle(this.rs.getString("title"));
				board.setWriter(this.rs.getString("writer"));
				board.setContent(this.rs.getString("content"));
				board.setRegDate(this.rs.getDate("regdate"));
				board.setCnt(this.rs.getInt("cnt"));
				boardList.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("getBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		
		return boardList;
	}
	
	/**
	 * 글 CNT 수정 메서드
	 * param : BoardVO
	 * return : x
	 */
	public void updateCnt(BoardVO vo){
		System.out.println("===> JDBC updateBoard() 기능 처리" + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(BOARD_CNT_UPDATE);
			this.pstmt.setInt(1, vo.getCnt()+1);
			this.pstmt.setInt(2, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateBoard() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // updateBoard
	
}
