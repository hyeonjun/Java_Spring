package com.encore.spring.study.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.spring.study.StudyVO;
import com.encore.spring.study.impl.JDBCUtil;

@Repository("studyDAO")
public class StudyDAO {

	// JDBC 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String STUDY_INSERT = "insert into spring values ((select nvl(max(seq), 0)+1 from spring), ?, ?, ?, ?)";
	private final String STUDY_UPDATE = "update spring set subject=?, content=?, volume=? where seq=?";
	private final String STUDY_DELETE = "delete from spring where seq=?";
	private final String STUDY_GET = "select * from spring where seq=?";
	private final String STUDY_LIST = "select * from spring order by seq desc";

	public StudyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertStudy(StudyVO vo){
		System.out.println("===> JDBC insertStudy() 기능 처리" + vo.toString());
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_INSERT);
			this.pstmt.setString(1,  vo.getStudyDate());
			this.pstmt.setString(2, vo.getSubject());
			this.pstmt.setString(3, vo.getContent());
			this.pstmt.setInt(4, vo.getVolume());
			this.pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("insertStudy() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public void updateStudy(StudyVO vo){
		System.out.println("===> JDBC updateStudy() 기능 처리" + vo.toString());
		try{ // studyDate=?, subject=?, content=?, volume=? where seq=?
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_UPDATE);
			this.pstmt.setString(1, vo.getSubject());
			this.pstmt.setString(2, vo.getContent());
			this.pstmt.setInt(3, vo.getVolume());
			this.pstmt.setInt(4, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("updateStudy() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public void deleteStudy(StudyVO vo){
		System.out.println("===> JDBC deleteStudy() 기능 처리" + vo.toString());
		try{ // delete from spring where seq=?
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_DELETE);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("deleteStudy() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public StudyVO getStudy(StudyVO vo){
		System.out.println("===> JDBC getStudy() 기능 처리" + vo.toString());
		StudyVO study = null;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_GET);
			this.pstmt.setInt(1, vo.getSeq());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				study = new StudyVO();
				study.setSeq(this.rs.getInt("seq"));
				study.setStudyDate(this.rs.getString("studyDate"));
				study.setSubject(this.rs.getString("subject"));
				study.setContent(this.rs.getString("content"));
				study.setVolume(this.rs.getInt("volume"));
			}
		} catch (Exception e) {
			System.out.println("getStudy() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return study;
	}
	
	public List<StudyVO> getStudyList(StudyVO vo){
		System.out.println("===> JDBC getStudyList() 기능 처리" + vo.toString());
		List<StudyVO> studyList = new ArrayList<StudyVO>();
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_LIST);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()){
				StudyVO study = new StudyVO();
				study.setSeq(this.rs.getInt("seq"));
				study.setStudyDate(this.rs.getString("studyDate"));
				study.setSubject(this.rs.getString("subject"));
				study.setContent(this.rs.getString("content"));
				study.setVolume(this.rs.getInt("volume"));
				studyList.add(study);
			}
		} catch (Exception e) {
			System.out.println("getStudyList() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return studyList;
	}
}
