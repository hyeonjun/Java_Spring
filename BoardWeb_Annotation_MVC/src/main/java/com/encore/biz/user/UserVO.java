package com.encore.biz.user;

/***
 * @author Playdata
 * id		 : 아이디
 * password  : 비밀번호
 * name 	 : 이름
 * role	 	 : 권한
 */

public class UserVO {
	
	private String id;
	private String password;
	private String name;
	private String role;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

	
	
}
