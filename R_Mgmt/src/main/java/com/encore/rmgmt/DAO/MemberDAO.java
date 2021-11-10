package com.encore.rmgmt.DAO;

import java.sql.*;
import org.springframework.stereotype.Repository;

import com.encore.rmgmt.Service.IntroduceVO;
import com.encore.rmgmt.Service.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	
	// JDBC 包访
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	// SQL 包访
	private final String MEMBER_GET = "select * from r_member where userid=?";
	private final String MEMBER_GET_SEQ = "select * from r_member where seq=?";
	private final String MEMBER_INSERT = "insert into r_member values (r_seq.nextval, ?, ?, ?, ?, ?, 2)";
	private final String INTRODUCE_INSERT = "insert into r_introduce values (?, ?, ?, ?, ?, ?)";

	public MemberDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("===> memberDAO 按眉 积己");
	}
	
	public MemberVO getUserOne(int seq){
		System.out.println("==> getUserOne() SEQ");
		MemberVO member = null;
		
		try{
			this.conn =JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(MEMBER_GET_SEQ);
			this.pstmt.setInt(1, seq);
			this.rs = this.pstmt.executeQuery();
			if(this.rs.next()){
				member = new MemberVO();
				member.setSeq(this.rs.getInt("seq"));
				member.setUserId(this.rs.getString("userid"));
				member.setPassword(this.rs.getString("password"));
				member.setNickname(this.rs.getString("nickname"));
				member.setEmail(this.rs.getString("email"));
				member.setPhone(this.rs.getString("phone"));
			}
		} catch (Exception e) {
			System.out.println("getUserOne() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return member;
	}
	
	public MemberVO getUserOne(MemberVO vo){
		System.out.println("==> getUserOne()");
		MemberVO member = null;
		
		try{
			this.conn =JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(MEMBER_GET);
			this.pstmt.setString(1, vo.getUserId());
			this.rs = this.pstmt.executeQuery();
			if(this.rs.next()){
				member = new MemberVO();
				member.setSeq(this.rs.getInt("seq"));
				member.setUserId(this.rs.getString("userid"));
				member.setPassword(this.rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("getUserOne() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return member;
	}
	
	public boolean userJoin(MemberVO vo){
		System.out.println("==> userJoin()");
		boolean result = false;
		System.out.println("userJoin : "+vo.toString());
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(MEMBER_INSERT);
			this.pstmt.setString(1, vo.getUserId());
			this.pstmt.setString(2, vo.getPassword());
			this.pstmt.setString(3, vo.getNickname());
			this.pstmt.setString(4, vo.getEmail());
			this.pstmt.setString(5, vo.getPhone());
			this.pstmt.executeUpdate();
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("userJoin() ERR => "+e.getMessage());
			result=false;
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return result;
	}
	
	public void insertIntroduce(MemberVO vo){
		System.out.println("===> JDBC insertIntroduce() 扁瓷 贸府 " + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(INTRODUCE_INSERT);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.setString(2, null);
			this.pstmt.setString(3, null);
			this.pstmt.setString(4, null);
			this.pstmt.setString(5, null);
			this.pstmt.setString(6, null);
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertIntroduce() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} // insertIntroduce
	

}
