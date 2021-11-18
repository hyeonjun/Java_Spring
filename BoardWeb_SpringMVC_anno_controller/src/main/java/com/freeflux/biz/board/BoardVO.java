package com.freeflux.biz.board;

import java.sql.Date;


/** VO : Value Object **/

public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	/** 여기부터 BoardController에서 @RequestParam 사용 **/
	private String searchCondition;
	private String searchKeyword;

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/** 여기까지 추가 **/

	public BoardVO() {
	}

	@Override
	public String toString() {
		String values = "";
		values += "BoardVO [seq=" + this.seq; 
		values +=  ", title=" + this.title;
		values +=  ", writer=" + this.writer;
		values +=  ", content=" + this.content;
		values +=  ", regDate=" + this.regDate;
		values +=  ", cnt=" + this.cnt;
		values += ']';
		return values;
	}

	/** getter/setter **/
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
	
}
