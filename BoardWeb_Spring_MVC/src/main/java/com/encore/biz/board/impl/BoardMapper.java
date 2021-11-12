package com.encore.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.encore.biz.board.BoardVO;

/** BoardDAOSpring�� getBoard() / getBoardList()�� ��ȯŸ���� �����ϱ� ���� Ŭ����
 * �� �˻�(��ȸ)�� ������� BoardVO ��ü Ÿ������ ����
 * @author Playdata
 *
 */
public class BoardMapper implements RowMapper<BoardVO> {

	public BoardMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		/* ��� : �˻��� ���ڵ��� ������ŭ �ݺ��ؼ� �ڵ� ȣ��Ǵ� �޼���,
		 * �˻��� ���ڵ��� �� �����͸� ������ ��ü�� �����Ͽ� ��ȯ
		 * queryForObject() ���� �� 1ȸ
		 * query() ���� �� �ټ� �ݺ�
		 *  => �ݺ��Ͽ� ��ü�� ���� �� List �÷��ǿ� ��Ƽ� ��ȯ
		 * */
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}

}
