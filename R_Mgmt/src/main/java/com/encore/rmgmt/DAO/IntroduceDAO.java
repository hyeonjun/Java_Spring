package com.encore.rmgmt.DAO;

import java.sql.*;

import com.encore.rmgmt.DAO.JDBCUtil;
import com.encore.rmgmt.Service.IntroduceVO;
import org.springframework.stereotype.Repository;

@Repository("introduceDAO")
public class IntroduceDAO {
	
	// JDBC
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	// SQL 包访
//	private final String INTRODUCE_INSERT = "insert into r_introduce (seq, blog, github, picture, writing) values (?, ?, ?, ?, ?)";
	private final String INTRODUCE_UPDATE = "update r_introduce set title=?, blog=?, github=?, picture=?, writing=? where seq=?";
	private final String INTRODUCE_LIST = "select B.nickname, B.email, B.phone, A.title, A.blog, A.github, A.picture, A.writing"
										   +" from r_introduce A, r_member B"
										   +" where A.seq=? and B.seq=A.seq";
//	private final String INTRODUCE_DELETE = "delete from r_introduce where seq=?";
	

	public IntroduceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public IntroduceVO getIntroduce(int seq){
		IntroduceVO intro = null;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(INTRODUCE_LIST);
			this.pstmt.setInt(1, seq);
			this.rs = this.pstmt.executeQuery();
			// B.nickname, B.email, B.phone, A.blog, A.github, A.picture, A.writing
			if(this.rs.next()){
				intro = new IntroduceVO();
				intro.setName(this.rs.getString("nickname"));
				intro.setEmail(this.rs.getString("email"));
				intro.setPhone(this.rs.getString("phone"));
				intro.setTitle(this.rs.getString("title"));
				intro.setBlog(this.rs.getString("blog"));
				intro.setGithub(this.rs.getString("github"));
				intro.setPicture(this.rs.getString("picture"));
				intro.setWriting(this.rs.getString("writing"));
			}
		} catch (Exception e) {
			System.out.println("getIntroduce() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return intro;
	} // getIntroduce
	
	public IntroduceVO getIntroduce(IntroduceVO vo){
		System.out.println("===> JDBC getIntroduce() 扁瓷 贸府" + vo.toString());
		IntroduceVO intro = null;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(INTRODUCE_LIST);
			this.pstmt.setInt(1, vo.getSeq());
			this.rs = this.pstmt.executeQuery();
			// B.nickname, B.email, B.phone, A.blog, A.github, A.picture, A.writing
			if(this.rs.next()){
				intro = new IntroduceVO();
				intro.setName(this.rs.getString("nickname"));
				intro.setEmail(this.rs.getString("email"));
				intro.setPhone(this.rs.getString("phone"));
				intro.setTitle(this.rs.getString("title"));
				intro.setBlog(this.rs.getString("blog"));
				intro.setGithub(this.rs.getString("github"));
				intro.setPicture(this.rs.getString("picture"));
				intro.setWriting(this.rs.getString("writing"));
			}
		} catch (Exception e) {
			System.out.println("getIntroduce() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return intro;
	} // getIntroduce
	
	/*public void deleteIntroduce(IntroduceVO vo){
		System.out.println("===> JDBC deleteIntroduce() 扁瓷 贸府" + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(INTRODUCE_DELETE);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteIntroduce() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	} */// deleteIntroduce
	
	public void updateIntroduce(IntroduceVO vo){
		System.out.println("===> JDBC updateIntroduce() 扁瓷 贸府" + vo.toString());
//		boolean result = false;
		// blog=? github=? picture=? writing=?
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(INTRODUCE_UPDATE);
			this.pstmt.setString(1, vo.getTitle());
			this.pstmt.setString(2, vo.getBlog());
			this.pstmt.setString(3, vo.getGithub());
			this.pstmt.setString(4, vo.getPicture());
			this.pstmt.setString(5, vo.getWriting());
			this.pstmt.setInt(6, vo.getSeq());
			this.pstmt.executeUpdate();
//			result = true;
		} catch (Exception e) {
//			result = false;
			System.out.println("updateIntroduce() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
//		return result;
	} // updateIntroduceupdateIntroduce

}
