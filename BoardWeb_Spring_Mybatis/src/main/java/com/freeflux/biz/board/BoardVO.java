package com.freeflux.biz.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


/** Entity Class : Value Object **/
@Entity
@Table(name="BOARD")
public class BoardVO {
	
	@Id
	@GeneratedValue
	private int seq;
	private String title;
	private String writer;
	private String content;
	
	@Temporal(TemporalType.DATE)
	private Date regDate;
	private int cnt;
	
	@Transient
	private String searchCondition;
	
	@Transient
	private String searchKeyword;
	
	@Transient
	private MultipartFile uploadFile;

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
		values +=  ", searchCondition="+ this.searchCondition;
		values +=  ", searchKeyword="+ this.searchKeyword;
		values +=  ", uploadFile="+ this.uploadFile;
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

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}

/**
 * Json 결과물에서 제외 : @JsonIgnore
 
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}


**/