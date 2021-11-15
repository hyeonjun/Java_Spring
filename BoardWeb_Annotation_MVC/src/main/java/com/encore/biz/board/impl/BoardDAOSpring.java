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
	 * JdbcDaoSupport Ŭ������ �����ϴ� getJdbcTemlate() �޼��带 �̿��Ͽ�
	 * JdbcTemlate ��ü�� ��ȯ���� �� �ִ�
	 * ��ȯ���� JdbcTemlate ��ü�� �������� �޼��带 �̿��Ͽ� SQL��ó��
	 * 
	 * ��, getJdbcTemlate() �޼��尡 JdbcTemlate ��ü�� ��ȯ�Ϸ���
	 * ���� DataSource ���Ը� ������ �־���ϱ� ������
	 * applicationContext.xml�� ����� DataSource ��ü�� DI�ؾ���
	 * => JdbcDaoSupport Ŭ������ �����ϴ� setSuperDataSource() �޼��带 �̿��Ͽ� DI ����
	 * => �ڵ� ������ ������ ���� @Autowired �� ����
	 * BoardDAOSpring Ŭ������ component-scan�� ���� �ڵ����� ��ü ������ �̷������ �ϹǷ�
	 * @Repository ����
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

/*	applicationContext.xml���� <bean>���� �����
/*	@Autowired
	public void setSuperDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}*/
	
	/**
	 * CRUD ��� �޼��� ����
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
	/** �˻� ����� Ư��Ÿ������ ������ ��쿡�� RowMapper �������̽��� �������� �Ļ� Ŭ���� �ʿ� **/
	public BoardVO getBoard(BoardVO vo){
		System.out.println("==> getBoard()");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		
		return jdbcTemplate.query(BOARD_LIST, new BoardMapper());
	}
	
}
