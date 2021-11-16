package com.jhj.biz.emp.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jhj.biz.emp.EmpVO;

public class EmpMapper implements RowMapper<EmpVO> {

	public EmpMapper() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpVO vo = new EmpVO();
		vo.setEno(rs.getInt("eno"));
		vo.setEname(rs.getString("ename"));
		vo.setJob(rs.getString("job"));
		vo.setHiredate(rs.getString("hiredate"));
		vo.setSale(rs.getInt("sale"));
		vo.setCommission(rs.getInt("commission"));
		vo.setDeptno(rs.getInt("deptno"));
		return vo;
	}

}
