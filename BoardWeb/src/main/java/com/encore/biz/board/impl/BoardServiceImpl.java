package com.encore.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.biz.board.BoardService;
import com.encore.biz.board.BoardVO;
import com.encore.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	/***
	 * @Repository("boardDAO")
	 *	public class BoardDAO <= 주입(@Autowired)
	 */
	@Autowired
	private BoardDAO boardDAO;
	private LogAdvice log;

	public BoardServiceImpl() {
		System.out.println("===> BoardSericeImpl() 객체 생성");
	}

	@Override
	public void insertBoard(BoardVO vo) {
/*		if (vo.getSeq() == 0){ // AfterThrow 확인용
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");  
		}*/
		this.boardDAO.insertBoard(vo);
	}

	@Override
	public void updatetBoard(BoardVO vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		vo = this.boardDAO.getBoard(vo);
		this.boardDAO.updateCnt(vo);
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return this.boardDAO.getBoardList(vo);
	}

}
