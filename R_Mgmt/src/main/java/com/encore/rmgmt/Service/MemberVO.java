package com.encore.rmgmt.Service;


public class MemberVO {
	
	private int seq;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private int authority;
	

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
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


	public int getAuthority() {
		return authority;
	}


	public void setAuthority(int authority) {
		this.authority = authority;
	}


	@Override
	public String toString() {
		return "MemberVO [seq=" + seq + ", userId=" + userId + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", phone=" + phone + ", authority=" + authority + "]";
	}
	
	

}
