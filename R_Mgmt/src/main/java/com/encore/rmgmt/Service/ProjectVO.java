package com.encore.rmgmt.Service;

public class ProjectVO {
	
	private int seq;
	private int pSeq;
	private int role;
	private String title;
	private String startDate;
	private String endDate;
	private String content;
	private String skill;
	private String issue;
	private String result;
	private String github;
	private String pictures;

	public ProjectVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectVO(int seq, int pSeq, int role, String title, String startDate, String endDate, String content,
			String skill, String issue, String result, String github, String pictures) {
		super();
		this.seq = seq;
		this.pSeq = pSeq;
		this.role = role;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.skill = skill;
		this.issue = issue;
		this.result = result;
		this.github = github;
		this.pictures = pictures;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
		
	public int getpSeq() {
		return pSeq;
	}
	
	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return "ProjectVO [seq=" + seq + ", pSeq=" + pSeq + ", role=" + role + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", content=" + content + ", skill=" + skill + ", issue=" + issue
				+ ", result=" + result + ", github=" + github + ", pictures=" + pictures + "]";
	}

	

	
	
}
