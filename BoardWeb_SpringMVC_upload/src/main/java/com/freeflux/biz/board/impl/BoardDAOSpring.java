package com.freeflux.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// Transaction 占쌓쏙옙트占쏙옙 占쏙옙占쏙옙 SQL
	private final String BOARD_INSERT_TRANSACTION = "insert into board (seq, title, writer, content) values (?, ?, ?, ?)";
	// SQL 검색 쿼리 추가 : Like
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
		
	public BoardDAOSpring() {
	}
	
	/** CRUD 占쏙옙占� 占쌨쇽옙占쏙옙 占쏙옙占쏙옙 **/
	// 占쏙옙 占쏙옙占�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 insertBaord() 占쏙옙占� 처占쏙옙 : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT_TRANSACTION, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 updateBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 deleteBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoardList() 占쏙옙占� 처占쏙옙");
		
		Object[] agrs = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")){
			return jdbcTemplate.query(BOARD_LIST_T, agrs, new BoardRowMapper());
		}
		
		if(vo.getSearchCondition().equals("CONTENT")){
			return jdbcTemplate.query(BOARD_LIST_C, agrs, new BoardRowMapper());
		}
		
//		jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		return null;
	} // getBoardList(BoardVO vo) END
}

/**
 * Transaction 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	// Transaction 占쌓쏙옙트占쏙옙 占쏙옙占쏙옙 SQL
	private final String BOARD_INSERT_TRANSACTION = "insert into board_spring (seq, title, writer, content) values (?, ?, ?, ?)";
	
	public BoardDAOSpring() {
	}
	
	// CRUD 占쏙옙占� 占쌨쇽옙占쏙옙 占쏙옙占쏙옙 //
	// 占쏙옙 占쏙옙占�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 insertBaord() 占쏙옙占� 처占쏙옙 : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT_TRANSACTION, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 updateBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 deleteBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoardList() 占쏙옙占� 처占쏙옙");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	} // getBoardList(BoardVO vo) END
}

**/


/**
 * JdbcTemplate

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	public BoardDAOSpring() {
	}
	
	// CRUD 占쏙옙占� 占쌨쇽옙占쏙옙 占쏙옙占쏙옙 //
	// 占쏙옙 占쏙옙占�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 insertBaord() 占쏙옙占� 처占쏙옙 : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 updateBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 deleteBoard() 占쏙옙占� 처占쏙옙");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoardList() 占쏙옙占� 처占쏙옙");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	} // getBoardList(BoardVO vo) END
}
**/


/**
 * JdbcDaoSupport 占쏙옙占�
 
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {

	// SQL 占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	public BoardDAOSpring() {
	}

	@Autowired
	public void setSuperDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}

	
	// CRUD 占쏙옙占� 占쌨쇽옙占쏙옙 占쏙옙占쏙옙 //
	// 占쏙옙 占쏙옙占�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 insertBaord() 占쏙옙占� 처占쏙옙 : " + vo.toString());

		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 updateBoard() 占쏙옙占� 처占쏙옙");

		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 deleteBoard() 占쏙옙占� 처占쏙옙");

		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		
		Object[] args={vo.getSeq()};
		
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC占쏙옙 getBoardList() 占쏙옙占� 처占쏙옙");
		
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	} // getBoardList(BoardVO vo) END
}
**/