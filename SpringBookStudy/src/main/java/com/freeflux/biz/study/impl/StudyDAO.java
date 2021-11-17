package com.freeflux.biz.study.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.study.StudyVO;

@Repository("studyDAO")
public class StudyDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String STUDY_LIST = "select * from study_tbl order by seq desc";
	private final String STUDY_GET = "select * from study_tbl where seq=?";
	private final String STUDY_INSERT = "insert into study_tbl (seq, category, title, content, cnt) values ((select nvl(max(seq), 0)+1 from study_tbl),?,?,?,?)";
	private final String STUDY_UPDATE = "update study_tbl set category=?, title=?, content=?, cnt=? where seq=?";
	private final String STUDY_DELETE = "delete from study_tbl where seq=?";
	public StudyDAO() {
		System.out.println("==> StudyDAO °´Ã¼");
	}
	
	public void insertStudy(StudyVO vo){
		System.out.println("===> insertStudy()");
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_INSERT);
			this.pstmt.setString(1, vo.getCategory());
			this.pstmt.setString(2, vo.getTitle());
			this.pstmt.setString(3, vo.getContent());
			this.pstmt.setInt(4, vo.getCnt());		
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public void updateStudy(StudyVO vo){
		System.out.println("===> updateStudy()");
		try{ // category=?, title=?, content=?, cnt=? where seq=?
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_UPDATE);
			this.pstmt.setString(1, vo.getCategory());
			this.pstmt.setString(2, vo.getTitle());
			this.pstmt.setString(3, vo.getContent());
			this.pstmt.setInt(4, vo.getCnt());
			this.pstmt.setInt(5, vo.getSeq());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public void deleteStudy(StudyVO vo){
		System.out.println("===> deleteStudy()");
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_DELETE);
			this.pstmt.setInt(1, vo.getSeq());		
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
	}
	
	public StudyVO getStudy(StudyVO vo){
		System.out.println("===> getStudy()");
		StudyVO study = null;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_GET);
			this.pstmt.setInt(1, vo.getSeq());
			this.rs = this.pstmt.executeQuery();
			if(this.rs.next()){
				study = new StudyVO();
				study.setSeq(this.rs.getInt("seq"));
				study.setCategory(this.rs.getString("category"));
				study.setTitle(this.rs.getString("title"));
				study.setContent(this.rs.getString("content"));
				study.setStudyDate(this.rs.getDate("studyDate"));
				study.setCnt(this.rs.getInt("cnt"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return study;
	}
	
	public List<StudyVO> getStudyList(StudyVO vo){
		System.out.println("===> getStudyList()");
		List<StudyVO> studyList = new ArrayList<StudyVO>();
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(STUDY_LIST);
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()){
				StudyVO study = new StudyVO();
				study.setSeq(this.rs.getInt("seq"));
				study.setCategory(this.rs.getString("category"));
				study.setTitle(this.rs.getString("title"));
				study.setContent(this.rs.getString("content"));
				study.setStudyDate(this.rs.getDate("studyDate"));
				study.setCnt(this.rs.getInt("cnt"));
				studyList.add(study);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return studyList;
	}
	
}
