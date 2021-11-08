package com.encore.biz.emp.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.biz.emp.impl.JDBCUtil;
import com.encore.biz.emp.EmpVO;

@Repository("empDAO")
public class EmpDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String EMP_INSERT = "insert into emp values((select nvl(max(empno), 0)+1 from emp), ?, ?, ?, ?, ?, ?, ?)";
	private final String EMP_UPDATE = "update emp set ename=?, job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?";
	private final String EMP_DELETE = "delete from emp where empno=?";
	private final String EMP_GET = "select * from emp where empno=?";
	private final String EMP_LIST = "select * from emp";
	
	
	public EmpDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("=== EmpDAO() 按眉 积己 ===");
	}
	// "insert into emp values((select nvl(max(empno), 0)+1 from emp), ?, ?, ?, ?, ?, ?, ?";
	public void insertEmp(EmpVO vo){
		System.out.println("===> JDBC insertEmp() 扁瓷 贸府 " + vo.toString());
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(EMP_INSERT);
			this.pstmt.setString(1, vo.getEname());
			this.pstmt.setString(2, vo.getJob());
			this.pstmt.setInt(3, vo.getMgr());
			this.pstmt.setDate(4, vo.getHiredate());
			this.pstmt.setInt(5, vo.getSal());
			this.pstmt.setInt(6, vo.getComm());
			this.pstmt.setInt(7, vo.getDeptno());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertEmp() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	} // insert
	
	// "update emp set ename=?, job=?, mgr=?, sal=?, comm=?, deptno=? where empno";
	public void updateEmp(EmpVO vo){
		System.out.println("===> JDBC updateEmp() 扁瓷 贸府" + vo.toString());
		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(EMP_UPDATE);
			this.pstmt.setString(1, vo.getEname());
			this.pstmt.setString(2, vo.getJob());
			this.pstmt.setInt(3, vo.getMgr());
			this.pstmt.setInt(4, vo.getSal());
			this.pstmt.setInt(5, vo.getComm());
			this.pstmt.setInt(6, vo.getDeptno());
			this.pstmt.setInt(7, vo.getEmpno());
			this.pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("updateEmp() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	} // update
	
	// "delete from emp where empno=?";
	public void deleteEmp(EmpVO vo){
		System.out.println("===> JDBC deleteEmp() 扁瓷 贸府" + vo.toString());
		try{
			
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(EMP_DELETE);
			this.pstmt.setInt(1, vo.getEmpno());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteEmp() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	// "select * from emp where empno=?";
	public EmpVO getEmp(EmpVO vo){
		System.out.println("===> JDBC getEmp() 扁瓷 贸府" + vo.toString());
		EmpVO emp = null;
		
		try{
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(EMP_GET);
			this.pstmt.setInt(1, vo.getEmpno());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				emp = new EmpVO();
				emp.setEmpno(this.rs.getInt("empno"));
				emp.setEname(this.rs.getString("ename"));
				emp.setJob(this.rs.getString("job"));
				emp.setMgr(this.rs.getInt("mgr"));
				emp.setHiredate(this.rs.getDate("hiredate"));
				emp.setSal(this.rs.getInt("sal"));
				emp.setComm(this.rs.getInt("comm"));
				emp.setDeptno(this.rs.getInt("deptno"));
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getEmp() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}
		
		return emp;
	} // getEmp
	
	public List<EmpVO> getEmpList(EmpVO vo){
		System.out.println("===> JDBC getEmpList() 扁瓷 贸府" + vo.toString());
		List<EmpVO> empList = new ArrayList<EmpVO>();
		
		try {
			this.conn = JDBCUtil.getConnection();
			this.pstmt = this.conn.prepareStatement(EMP_LIST);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()){
				EmpVO emp = new EmpVO();
				emp.setEmpno(this.rs.getInt("empno"));
				emp.setEname(this.rs.getString("ename"));
				emp.setJob(this.rs.getString("job"));
				emp.setMgr(this.rs.getInt("mgr"));
				emp.setHiredate(this.rs.getDate("hiredate"));
				emp.setSal(this.rs.getInt("sal"));
				emp.setComm(this.rs.getInt("comm"));
				emp.setDeptno(this.rs.getInt("deptno"));
				empList.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getEmpList() ERR => "+e.getMessage());
		} finally {
			JDBCUtil.close(this.rs, this.pstmt, this.conn);
		}

		return empList;
	} // getEmpList
	

}
