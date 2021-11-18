package com.freeflux.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	
	@XmlElement(name="board")
	private List<BoardVO> boardList;
	
	public BoardListVO() {
		// TODO Auto-generated constructor stub
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "BoardListVO [boardList=" + boardList + "]";
	}

}
