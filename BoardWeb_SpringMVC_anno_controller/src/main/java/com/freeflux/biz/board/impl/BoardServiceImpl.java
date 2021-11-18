package com.freeflux.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.common.Log4JAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0){
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		// Transaction Test
		this.boardDAO.insertBoard(vo);
		this.boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return this.boardDAO.getBoardList(vo);
	}

}

/**
 * Transaction

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.common.Log4JAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAOSpring boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0){
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		// Transaction Test
		this.boardDAO.insertBoard(vo);	// seq 값 100을 전달 : 현재 테이블에 해당 값이 없다고 가정
		this.boardDAO.insertBoard(vo);	// seq 값 100을 전달 : primary key 때문에 예외 발생
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return this.boardDAO.getBoardList(vo);
	}

}

**/

/**
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.common.Log4JAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public void insertBoard(BoardVO vo) {
		this.boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return this.boardDAO.getBoardList(vo);
	}

}

**/

/** LogAdvice
 * 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.common.LogigAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	private LogigAdvice log;

	public BoardServiceImpl() {
		this.log=new LogigAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		this.log.printLog();
		this.boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.log.printLog();
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.log.printLog();
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		this.log.printLog();
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		this.log.printLogging();
		return this.boardDAO.getBoardList(vo);
	}

}

**/

/** Log4JAdvice
 * 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.BoardService;
import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.common.Log4JAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	private Log4JAdvice log;

	public BoardServiceImpl() {
		this.log=new Log4JAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		this.log.printLogging();
		this.boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.log.printLogging();
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.log.printLogging();
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		this.log.printLogging();
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		this.log.printLogging();
		return this.boardDAO.getBoardList(vo);
	}

}

**/