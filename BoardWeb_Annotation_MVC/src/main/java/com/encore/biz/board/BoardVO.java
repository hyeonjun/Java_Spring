package com.encore.biz.board;

import java.util.*;

/**
 * ** @author Playdata
 * 
 * VO : Value Object
 * Oracle 
 */
public class BoardVO {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BoardVO [seq=" + seq +", title="+ ", writer" + writer + ", content=" + content + ", regDate=" + regDate +", cnt="+ cnt+"]";
	}
}
