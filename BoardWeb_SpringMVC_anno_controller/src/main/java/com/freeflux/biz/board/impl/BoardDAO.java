package com.freeflux.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

/** DAO : Data Access Object **/

@Repository("boardDAO")
public class BoardDAO {

	// JDBC 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// SQL 검색 쿼리 추가 : Like
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	public BoardDAO() {
	}

	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC insertBaord() : " + vo.toString());

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(BOARD_INSERT);
			this.stmt.setString(1, vo.getTitle());
			this.stmt.setString(2, vo.getWriter());
			this.stmt.setString(3, vo.getContent());
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	} // insertBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC占쏙옙 updateBoard() 占쏙옙占� 처占쏙옙");

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(BOARD_UPDATE);
			this.stmt.setString(1, vo.getTitle());
			this.stmt.setString(2, vo.getContent());
			this.stmt.setInt(3, vo.getSeq());
			this.stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	} // updateBoard(BoardVO vo) END

	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC占쏙옙 deleteBoard() 占쏙옙占� 처占쏙옙");

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(BOARD_DELETE);
			this.stmt.setInt(1, vo.getSeq());
			this.stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	} // deleteBoard(BoardVO vo) END

	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		BoardVO board = null;

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(BOARD_GET);
			this.stmt.setInt(1, vo.getSeq());
			this.rs = this.stmt.executeQuery();

			if (this.rs.next()) {
				board = new BoardVO();
				board.setSeq(this.rs.getInt("seq"));
				board.setTitle(this.rs.getString("title"));
				board.setWriter(this.rs.getString("writer"));
				board.setContent(this.rs.getString("content"));
				board.setRegDate(this.rs.getDate("regdate"));
				board.setCnt(this.rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	} // getBoard(BoardVO vo) END

	
	
	
	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC getBoardList()"+vo.getSearchCondition());
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			this.conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")){
				this.stmt = this.conn.prepareStatement(BOARD_LIST_T);
			}
			if(vo.getSearchCondition().equals("CONTENT")){
				this.stmt = this.conn.prepareStatement(BOARD_LIST_C);
			}
			this.stmt.setString(1, vo.getSearchKeyword());
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
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
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	} // getBoardList(BoardVO vo) END
}
