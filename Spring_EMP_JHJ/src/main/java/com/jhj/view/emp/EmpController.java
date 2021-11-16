package com.jhj.view.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.biz.emp.EmpVO;
import com.jhj.biz.emp.impl.EmpDAO;

@Controller
public class EmpController {

	public EmpController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/getEmpList.do")
	public ModelAndView getEmpList(EmpVO vo, EmpDAO dao, ModelAndView mv){
		System.out.println("getEmpList <======");
		mv.addObject("empList", dao.getEmpList(vo));
		mv.setViewName("getEmpList.jsp");
		return mv;
	}
	
	@RequestMapping(value="/getEmp.do")
	public ModelAndView getEmp(EmpVO vo, EmpDAO dao, ModelAndView mv){
		mv.addObject("emp", dao.getEmp(vo));
		mv.setViewName("getEmp.jsp");
		return mv;
	}
	
	@RequestMapping(value="/insertEmp.do")
	public String insertEmp(EmpVO vo, EmpDAO dao){
		System.out.println(vo.toString());
		dao.insertEmp(vo);
		return "getEmpList.do";
	}
	
	@RequestMapping(value="/updateEmp.do")
	public String updateEmp(EmpVO vo, EmpDAO dao){
		dao.updateEmp(vo);
		return "getEmpList.do";
	}
	
	@RequestMapping(value="/deleteEmp.do")
	public String deleteEmp(EmpVO vo, EmpDAO dao){
		dao.deleteEmp(vo);
		return "getEmpList.do";
	}

}
