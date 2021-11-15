package com.encore.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.encore.biz.board.BoardVO;

/** BoardDAOSpring의 getBoard() / getBoardList()의 반환타입을 매핑하기 위한 클래스
 * 즉 검색(조회)된 결과값을 BoardVO 객체 타입으로 매핑
 * @author Playdata
 *
 */
public class BoardMapper implements RowMapper<BoardVO> {

	public BoardMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		/* 기능 : 검색된 레코드의 개수만큼 반복해서 자동 호출되는 메서드,
		 * 검색된 레코드의 각 데이터를 지정한 객체레 매핑하여 반환
		 * queryForObject() 실행 시 1회
		 * query() 실행 시 다수 반복
		 *  => 반복하여 객체를 매핑 후 List 컬렉션에 담아서 반환
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
