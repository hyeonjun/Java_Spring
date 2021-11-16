package com.encore.spring.study;

public class StudyVO {
	
	private int seq;
	private String studyDate;
	private String subject;
	private String content;
	private int volume;

	public StudyVO() {
		// TODO Auto-generated constructor stub
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getStudyDate() {
		return studyDate;
	}

	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StudyVO [seq=" + seq + ", studyDate=" + studyDate + ", subject=" + subject + ", content=" + content
				+ ", volume=" + volume + "]";
	}
	
}
