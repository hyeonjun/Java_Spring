package com.jhj.biz.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhj.biz.emp.EmpService;
import com.jhj.biz.emp.EmpVO;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDAO empDAO;

	public EmpServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		this.empDAO.insertEmp(vo);
	}

	@Override
	public void updateEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		this.empDAO.updateEmp(vo);
	}

	@Override
	public void deleteEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		this.empDAO.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return this.empDAO.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpVO vo) {
		// TODO Auto-generated method stub
		return this.empDAO.getEmpList(vo);
	}

}
