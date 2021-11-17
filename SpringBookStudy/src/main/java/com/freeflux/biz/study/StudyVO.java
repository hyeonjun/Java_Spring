package com.freeflux.biz.study;

import java.sql.Date;

public class StudyVO {

	private int seq;
	private String category;
	private String title;
	private String content;
	private Date studyDate;
	private int cnt;
		
	public StudyVO() {
		System.out.println("==> StudyVO °´Ã¼");
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStudyDate() {
		return studyDate;
	}

	public void setStudyDate(Date studyDate) {
		this.studyDate = studyDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "StudyVO [seq=" + seq + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", studyDate=" + studyDate + ", cnt=" + cnt + "]";
	}
	
}
