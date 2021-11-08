package com.encore.biz.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.biz.emp.EmpService;
import com.encore.biz.emp.EmpVO;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAO empDAO;
	
	public EmpServiceImpl() {
		System.out.println("=== EmpServiceImpl() °´Ã¼ »ý¼º ===");
	}

	@Override
	public void insertEmp(EmpVO vo) {
		this.empDAO.insertEmp(vo);
		
	}

	@Override
	public void updateEmp(EmpVO vo) {
		this.empDAO.updateEmp(vo);
	}

	@Override
	public void deleteEmp(EmpVO vo) {
		this.empDAO.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return this.empDAO.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpVO vo) {
		return this.empDAO.getEmpList(vo);
	}
	
}
