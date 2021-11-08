package com.encore.biz;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.encore.biz.emp.EmpService;
import com.encore.biz.emp.EmpVO;

public class EmpServiceClient {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		EmpService empService = (EmpService) container.getBean("empService");
		
		EmpVO vo = new EmpVO();
		
//		사원 등록
//		vo.setEname("홍길동");
//		vo.setJob("사원");
//		vo.setMgr(1002);
//		vo.setHiredate(Date.valueOf("2021-11-05"));
//		vo.setSal(200);
//		vo.setComm(50);
//		vo.setDeptno(10);
//		empService.insertEmp(vo);
		
//		사원수정
		vo.setEmpno(2);
		vo.setEname("고길동");
		vo.setJob("대리");
		vo.setMgr(1003);
		vo.setSal(250);
		vo.setComm(60);
		vo.setDeptno(20);
		empService.updateEmp(vo);
		
//		사원 삭제
//		vo.setEmpno(2);
//		empService.deleteEmp(vo);
		
//		사원 정보
//		vo.setEmpno(1);
//		EmpVO emp = empService.getEmp(vo);
//		System.out.println(emp.toString());
		
//		사원 리스트
		List<EmpVO> empList = empService.getEmpList(vo);
		for (EmpVO e : empList){
			System.out.println(e.toString());
		}
		
		
	}

}
