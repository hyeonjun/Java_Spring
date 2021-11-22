package com.freeflux.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

@Repository
public class BoardDAOJPA {
	
	@PersistenceContext
	private EntityManager em;
	
	public BoardDAOJPA() {
	}
	
	public void insertBoard(BoardVO vo){
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo){
		em.merge(vo);
	}
	
	public void deleteBoard(BoardVO vo){
		em.remove(vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		return (BoardVO) em.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
	}

}
