package com.jhj.biz.emp;

import java.util.List;

public interface EmpService {
	
	void insertEmp(EmpVO vo);
	
	void updateEmp(EmpVO vo);
	
	void deleteEmp(EmpVO vo);
	
	EmpVO getEmp(EmpVO vo);
	
	List<EmpVO> getEmpList(EmpVO vo);

}
