package com.encore.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.biz.board.BoardService;
import com.encore.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	/***
	 * @Repository("boardDAO")
	 *	public class BoardDAO <= 林涝(@Autowired)
	 */
	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		System.out.println("===> BoardSericeImpl() 按眉 积己");
	}

	@Override
	public void insertBoard(BoardVO vo) {
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
