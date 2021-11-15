package com.encore.biz.board;

import java.util.List;

public interface BoardService {
	/***
	 * CRUD �߻�޼��� ����
	 * **/
	
	void insertBoard(BoardVO vo);
	
	void updatetBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList(BoardVO vo);
	
}
