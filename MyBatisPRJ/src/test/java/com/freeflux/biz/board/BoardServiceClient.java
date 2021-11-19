package com.freeflux.biz.board;

import java.util.List;

import com.freeflux.biz.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("mybatis 테스트 제목4");
		vo.setContent("mybatis 테스트 내용4");
		vo.setWriter("mybatis4");
		dao.insertBoard(vo);
		
		vo.setSeq(50);
		vo.setTitle("mybatis update");
		vo.setContent("mybatis update");
		dao.updateBoard(vo);
		
		
		vo.setSeq(48);
		dao.deleteBoard(vo);
		
//		vo.setSearchCondition("TITLE");
//		vo.setSearchKeyword("");
		List<BoardVO> board = dao.getBoardList(vo);
		for(BoardVO item : board){
			System.out.println(item.toString());
		}
	}

}
