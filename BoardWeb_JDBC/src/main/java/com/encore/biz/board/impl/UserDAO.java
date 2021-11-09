package com.encore.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.biz.board.UserVO;

/***
 * @author Playdata
 * 회원정보 관리
 * getUser(UserVO) 
 * 
 */
@Repository("userDAO")
public class UserDAO {
	// JDBC 관련
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	// SQL
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT = "insert into users values (?, ?, ?, 2)";
	private final String USER_LIST = "select * from users";
	private final String USER_DELETE = "delete from users where id=?";
	private final String USER_UPDATE = "update users set name=?, password=? where id=?";
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("===> UserDAO 객체 생성");
	}
	
	/**
	 * 회원 정보 반환
	 * @param UserVO
	 * @return UserVO
	 */
	public UserVO getUser(UserVO vo){
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserVO user = null;
		
		try {
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(USER_GET);
			this.pstmt.setString(1, vo.getId());
			this.pstmt.setString(2, vo.getPassword());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				user = new UserVO();
				user.setId(this.rs.getString("id"));
				user.setPassword(this.rs.getString("password"));
				user.setName(this.rs.getString("name"));
				user.setRole(this.rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("getUser() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	} // getUser() 
	
	/**
	 * 
	 * @param vo
	 */
	public void insertUser(UserVO vo){
		System.out.println("===> JDBC insertUser() 기능 처리" + vo.toString());
		
		try {
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(USER_INSERT);
			this.pstmt.setString(1, vo.getId());
			this.pstmt.setString(2, vo.getPassword());
			this.pstmt.setString(3, vo.getName());
			this.pstmt.executeUpdate();		
			
		} catch (Exception e) {
			System.out.println("insertUser() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		
	} // insertUser() end
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public List<UserVO> getUserList(UserVO vo){
		System.out.println("===> JDBC getUserList() 기능 처리" + vo.toString());
		
		List<UserVO> userList = new ArrayList<UserVO>();
		
		try {
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(USER_LIST);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()){
				UserVO user = new UserVO();
				user.setId(this.rs.getString("id"));
				user.setPassword("******");
				user.setName(this.rs.getString("name"));
				user.setRole(this.rs.getString("role"));
				userList.add(user);
			}
		} catch (Exception e) {
			System.out.println("getUserList() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return userList;
	
	} // getUserList() end
	
	/**
	 * 아이디 맞으면 삭제 가능
	 * @param vo
	 */
	public void deleteUser(UserVO vo){
		System.out.println("===> JDBC deleteUser() 기능 처리" + vo.toString());
		
		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(USER_DELETE);
			this.pstmt.setString(1, vo.getId());
			this.pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("deleteUser() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // deleteUser() end
	
	/**
	 * 이름, 비밀번호 변경
	 * @param vo
	 */
	public void updateUser(UserVO vo){
		System.out.println("===> JDBC updateUser() 기능 처리" + vo.toString());

		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(USER_UPDATE);
			this.pstmt.setString(1, vo.getName());
			this.pstmt.setString(2, vo.getPassword());
			this.pstmt.setString(3, vo.getId());
			this.pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateUser() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		
	} // updateUser() end
	
	
	
	
	

}
