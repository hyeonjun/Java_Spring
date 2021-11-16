package com.jhj.biz.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jhj.biz.emp.EmpVO;

@Repository
public class EmpDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmpDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private final String EMP_GET = "select * from emp_tbl where eno=?";
	private final String EMP_LIST = "select * from emp_tbl order by eno";
	private final String EMP_INSERT = "insert into emp ((select nvl(max(eno), 0)+1 from emp_tbl), ?, ?, to_date(?), ?, ?, ?)";
	private final String EMP_UPDATE = "update emp_tbl set ename=?, job=?, sale=?, commission=?, deptno=?";
	private final String EMP_DELETE = "delete from emp_tbl where eno=?";
	
	public boolean insertEmp(EmpVO vo){
		jdbcTemplate.update(EMP_INSERT, vo.getEname(), vo.getJob(), vo.getHiredate(), vo.getSale(), vo.getCommission(), vo.getDeptno());
		return true;
	}
	
	public void updateEmp(EmpVO vo){
		jdbcTemplate.update(EMP_UPDATE, vo.getEname(), vo.getJob(), vo.getSale(), vo.getCommission(), vo.getDeptno());
	}
	
	public void deleteEmp(EmpVO vo){
		jdbcTemplate.update(EMP_DELETE, vo.getEno());
	}
	
	public EmpVO getEmp(EmpVO vo){
		Object[] args = {vo.getEno()};
		return jdbcTemplate.queryForObject(EMP_GET, args, new EmpMapper());
	}
	
	public List<EmpVO> getEmpList(EmpVO vo){
		
		return jdbcTemplate.query(EMP_LIST, new EmpMapper());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
