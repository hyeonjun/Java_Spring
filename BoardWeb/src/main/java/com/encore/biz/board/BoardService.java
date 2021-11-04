package com.encore.biz.board;

import java.util.List;

public interface BoardService {
	/***
	 * CRUD 추상메서드 선언
	 * **/
	
	void insertBoard(BoardVO vo);
	
	void updatetBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList(BoardVO vo);
	
}
