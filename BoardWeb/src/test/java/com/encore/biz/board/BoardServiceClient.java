package com.encore.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.encore.biz.board.impl.JDBCUtil;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Sprig 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체 요청
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 글 등록 테스트
//		BoardVO vo = new BoardVO();
//		vo.setTitle("임시 제목2");
//		vo.setWriter("임지 작성자2");
//		vo.setContent("임시 내용2");
//		boardService.insertBoard(vo);
		
		// 4. 글 목록 기능 테스트
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		int cnt = 0;
//		for(BoardVO board : boardList){
//			System.out.println("record "+cnt+" : "+board.toString());
//		}
		
		// 5. 글 삭제
//		BoardVO vo = new BoardVO();
//		vo.setSeq(1);
//		boardService.deleteBoard(vo);
		
		// 6. 글 수정
//		BoardVO vo = new BoardVO();
//		vo.setTitle("수성 제목");
//		vo.setContent("수정 내용");
//		vo.setSeq(2);
//		boardService.updatetBoard(vo);
		
		// 7. seq 번호를 이용한 상세보기
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		vo = boardService.getBoard(vo);
		System.out.println(vo.toString());
		
		// 8. cnt 필드 증가
		
		
		container.close();
		
	}

}
