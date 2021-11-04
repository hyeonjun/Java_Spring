package com.encore.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.encore.biz.board.impl.JDBCUtil;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Sprig �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� BoardServiceImpl ��ü ��û
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. �� ��� �׽�Ʈ
//		BoardVO vo = new BoardVO();
//		vo.setTitle("�ӽ� ����2");
//		vo.setWriter("���� �ۼ���2");
//		vo.setContent("�ӽ� ����2");
//		boardService.insertBoard(vo);
		
		// 4. �� ��� ��� �׽�Ʈ
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		int cnt = 0;
//		for(BoardVO board : boardList){
//			System.out.println("record "+cnt+" : "+board.toString());
//		}
		
		// 5. �� ����
//		BoardVO vo = new BoardVO();
//		vo.setSeq(1);
//		boardService.deleteBoard(vo);
		
		// 6. �� ����
//		BoardVO vo = new BoardVO();
//		vo.setTitle("���� ����");
//		vo.setContent("���� ����");
//		vo.setSeq(2);
//		boardService.updatetBoard(vo);
		
		// 7. seq ��ȣ�� �̿��� �󼼺���
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		vo = boardService.getBoard(vo);
		System.out.println(vo.toString());
		
		// 8. cnt �ʵ� ����
		
		
		container.close();
		
	}

}
