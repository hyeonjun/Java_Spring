package com.encore.rmgmt.Service;

public class IntroduceVO {
	
	private int seq;
	private String name;
	private String title;
	private String email;
	private String phone;
	private String blog;
	private String github;
	private String picture;
	private String writing;
	
	public IntroduceVO() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String wirting) {
		this.writing = wirting;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "IntroduceVO [seq=" + seq + ", name=" + name + ", title=" + title + ", email=" + email + ", phone="
				+ phone + ", blog=" + blog + ", github=" + github + ", picture=" + picture + ", writing=" + writing
				+ "]";
	}

	
}
