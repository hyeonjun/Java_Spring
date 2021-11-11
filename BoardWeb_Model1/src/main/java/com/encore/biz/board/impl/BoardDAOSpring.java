package com.encore.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.encore.biz.board.BoardVO;

@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * JdbcDaoSupport 클래스가 제공하는 getJdbcTemlate() 메서드를 이용하여
	 * JdbcTemlate 객체를 반환받을 수 있다
	 * 반환받은 JdbcTemlate 객체의 여러가지 메서드를 이용하여 SQL문처리
	 * 
	 * 단, getJdbcTemlate() 메서드가 JdbcTemlate 객체를 반환하려면
	 * 먼저 DataSource 개게를 가지고 있어야하기 때문에
	 * applicationContext.xml에 등록한 DataSource 객체를 DI해야함
	 * => JdbcDaoSupport 클래스가 제공하는 setSuperDataSource() 메서드를 이용하여 DI 가능
	 * => 자동 의존성 주입을 위해 @Autowired 을 설정
	 * BoardDAOSpring 클래스는 component-scan에 의해 자동으로 객체 생성이 이루어져야 하므로
	 * @Repository 설정
	 */
	
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
//	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values (?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	public BoardDAOSpring() {
		// TODO Auto-generated constructor stub
	}

/*	applicationContext.xml에서 <bean>으로 등록함
/*	@Autowired
	public void setSuperDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}*/
	
	/**
	 * CRUD 기능 메서드 구현
	 */
	public void insertBoard(BoardVO vo){
		System.out.println("==> insertBoard()");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		
	}
	public void updateBoard(BoardVO vo){
		System.out.println("==> updateBoard()");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		
	}
	public void deleteBoard(BoardVO vo){
		System.out.println("==> deleteBoard()");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		
	}
	/** 검색 결과를 특정타입으로 매핑할 경우에는 RowMapper 인터페이스를 구현받은 파생 클래스 필요 **/
	public BoardVO getBoard(BoardVO vo){
		System.out.println("==> getBoard()");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		
		return jdbcTemplate.query(BOARD_LIST, new BoardMapper());
	}
	
}
