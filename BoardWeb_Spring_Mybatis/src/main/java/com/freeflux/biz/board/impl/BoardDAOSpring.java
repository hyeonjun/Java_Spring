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

	// SQL ��ɾ� ��� ����
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	// Transaction �׽�Ʈ�� ���� SQL
	private final String BOARD_INSERT_TRANSACTION = "insert into board_spring (seq, title, writer, content) values (?, ?, ?, ?)";
	
	// SQL : Search 추가
	private final String BOARD_LIST_T = "select * from board_spring where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board_spring where content like '%'||?||'%' order by seq desc";
	
	public BoardDAOSpring() {
	}
	
	/** CRUD ��� �޼��� ���� **/
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBaord() 기능 처리 : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT_TRANSACTION, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() 기능 처리");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() 기능 처리");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() 기능 처리");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoardList() 기능 처리");
		
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")){
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}
		if(vo.getSearchCondition().equals("CONTENT")){
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
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

	// SQL ��ɾ� ��� ����
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	// Transaction �׽�Ʈ�� ���� SQL
	private final String BOARD_INSERT_TRANSACTION = "insert into board_spring (seq, title, writer, content) values (?, ?, ?, ?)";
	
	public BoardDAOSpring() {
	}
	
	// CRUD ��� �޼��� ���� //
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBaord() ��� ó�� : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT_TRANSACTION, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoardList() ��� ó��");
		
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

	// SQL ��ɾ� ��� ����
	private final String BOARD_INSERT = "insert into board_spring (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board_spring), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board_spring set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board_spring where seq=?";
	private final String BOARD_GET = "select * from board_spring where seq=?";
	private final String BOARD_LIST = "select * from board_spring order by seq desc";

	public BoardDAOSpring() {
	}
	
	// CRUD ��� �޼��� ���� //
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBaord() ��� ó�� : " + vo.toString());

		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");

		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
		
		Object[] args={vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoardList() ��� ó��");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	} // getBoardList(BoardVO vo) END
}
**/


/**
 * JdbcDaoSupport ���
 
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {

	// SQL ��ɾ� ��� ����
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

	
	// CRUD ��� �޼��� ���� //
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBaord() ��� ó�� : " + vo.toString());

		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	} // insertBoard(BoardVO vo) END

	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");

		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	} // updateBoard(BoardVO vo) END

	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");

		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	} // deleteBoard(BoardVO vo) END


	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
		
		Object[] args={vo.getSeq()};
		
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	} // getBoard(BoardVO vo) END

	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoardList() ��� ó��");
		
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	} // getBoardList(BoardVO vo) END
}
**/