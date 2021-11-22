package com.freeflux.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		// 1. EntityManager 생성 : persistence-unit : "JPAProject"
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
				EntityManager em = emf.createEntityManager();
				
				// 2. Transaction 생성
				EntityTransaction tx = em.getTransaction();
				
				try{
					// 3. Transaction 시작
					tx.begin();
					
					// 데이터 삽입 및 조회
					Board board = new Board();
					board.setTitle("JPA 제목2");
					board.setWriter("JPA");
					board.setContent("JPA 내용2");
					
					// 데이터 삽입
					em.persist(board);
					
					// 목록 조회
					String jpql = "select b from Board b order by b.seq desc";
					List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
					for(Board b : boardList){
						System.out.println(b.toString());
					}
					
					// 4. Transaction commit
					tx.commit();
					
				} catch (Exception e) {
					// 5. Transaction RollBack
					tx.rollback();
				} finally {
					// 6. EntityManager 자원해제
					em.close();
				}
				// 7. EntityManagerFactory 자원해제
				emf.close();
	}

}
