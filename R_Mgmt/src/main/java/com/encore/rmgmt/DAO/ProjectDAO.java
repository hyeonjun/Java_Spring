package com.encore.rmgmt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.encore.rmgmt.Service.ProjectVO;

@Repository("projectDAO")
public class ProjectDAO {
	
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	//													seq pSeq role title start end content skill issue result github
	private final String PROJECT_INSERT = "insert into r_project values (?, pSeq.nextval ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String PROJECT_UPDATE = "update r_project set title=?, start_date=?, end_date=?, content=?, skill=?, issue=?, result=?, github=?, pictures=? where seq=? and p_seq=?";
	private final String PROJECT_DELETE = "delete from r_project where seq=? and p_seq=?";
	private final String GET_PROJECT_ONE = "select * from r_project where seq=? and p_seq=?";
	private final String GET_PROJECT_LIST = "select * from r_project where seq=? and role=?";
	
	public ProjectDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertProject(ProjectVO vo){
		System.out.println("===> JDBC insertProject() 扁瓷 贸府 " + vo.toString());
		boolean result = false;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(PROJECT_INSERT);
			//start end content skill issue result github
			this.pstmt.setInt(1, vo.getSeq());
//			this.pstmt.setInt(2, vo.getpSeq());
			this.pstmt.setInt(2, vo.getRole());
			this.pstmt.setString(3, vo.getTitle());
			this.pstmt.setString(4, vo.getStartDate());
			this.pstmt.setString(5, vo.getEndDate());
			this.pstmt.setString(6, vo.getContent());
			this.pstmt.setString(7, vo.getSkill());
			this.pstmt.setString(8, vo.getIssue());
			this.pstmt.setString(9, vo.getResult());
			this.pstmt.setString(10, vo.getGithub());
			this.pstmt.setString(11, vo.getPictures());
			this.pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertProject() ERR => "+e.getMessage());
			result = false;
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return result;
	}
	
	public boolean updateProject(ProjectVO vo){
		System.out.println("===> JDBC updateProject() 扁瓷 贸府 " + vo.toString());
		boolean result = false;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(PROJECT_UPDATE);
			// title=?, start?, end=?, content=?, skill=?, issue=?, result=?, github=? where seq=? and pSeq=?
			this.pstmt.setString(1, vo.getTitle());
			this.pstmt.setString(2, vo.getStartDate());
			this.pstmt.setString(3, vo.getEndDate());
			this.pstmt.setString(4, vo.getContent());
			this.pstmt.setString(5, vo.getSkill());
			this.pstmt.setString(6, vo.getIssue());
			this.pstmt.setString(7, vo.getResult());
			this.pstmt.setString(8, vo.getGithub());
			this.pstmt.setString(9, vo.getPictures());
			this.pstmt.setInt(10, vo.getSeq());
			this.pstmt.setInt(11, vo.getpSeq());
			
			this.pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("updateProject() ERR => "+e.getMessage());
			result = false;
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return result;
	}
	
	public boolean deleteProject(ProjectVO vo){
		System.out.println("===> JDBC deleteProject() 扁瓷 贸府 " + vo.toString());
		boolean result = false;
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(PROJECT_DELETE);
			// where seq=? and pSeq=?
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.setInt(2, vo.getpSeq());
			this.pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteProject() ERR => "+e.getMessage());
			result = false;
		} finally {
			JDBCUtil.close(this.pstmt, this.conn);
		}
		return result;
	}
	
	public ProjectVO getProjectOne(ProjectVO vo){
		System.out.println("===> JDBC getProjectOne() 扁瓷 贸府" + vo.toString());
		ProjectVO project = null;
		try{
			// seq=? and pSeq=?
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(GET_PROJECT_ONE);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.setInt(2, vo.getpSeq());			
			this.rs = this.pstmt.executeQuery();
			if(this.rs.next()){
				project = new ProjectVO();
				project.setSeq(this.rs.getInt("seq"));
				project.setpSeq(this.rs.getInt("p_seq"));
				project.setRole(this.rs.getInt("role"));
				project.setTitle(this.rs.getString("title"));
				project.setStartDate(this.rs.getString("start_date"));
				project.setEndDate(this.rs.getString("end_date"));
				project.setContent(this.rs.getString("content"));
				project.setSkill(this.rs.getString("skill"));
				project.setIssue(this.rs.getString("issue"));
				project.setResult(this.rs.getString("result"));
				project.setGithub(this.rs.getString("github"));
				project.setPictures(this.rs.getString("pictures"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getProjectOne() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return project;
	}
	
	public List<ProjectVO> getProjectList(ProjectVO vo){
		System.out.println("===> JDBC getProjectList() 扁瓷 贸府" + vo.toString());
		List<ProjectVO> projectList = new ArrayList<ProjectVO>();
		
		try{
			// where seq=? and role=?
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(GET_PROJECT_LIST);
			this.pstmt.setInt(1, vo.getSeq());
			this.pstmt.setInt(2, vo.getRole());			
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()){
				ProjectVO project = new ProjectVO();
				project.setSeq(this.rs.getInt("seq"));
				project.setpSeq(this.rs.getInt("p_seq"));
				project.setRole(this.rs.getInt("role"));
				project.setTitle(this.rs.getString("title"));
				project.setStartDate(this.rs.getString("start_date"));
				project.setEndDate(this.rs.getString("end_date"));
				project.setContent(this.rs.getString("content"));
				project.setSkill(this.rs.getString("skill"));
				project.setIssue(this.rs.getString("issue"));
				project.setResult(this.rs.getString("result"));
				project.setGithub(this.rs.getString("github"));
				project.setPictures(this.rs.getString("pictures"));
				projectList.add(project);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getProjectList() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		return projectList;
	}

}
