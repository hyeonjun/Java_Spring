package com.encore.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.study.StudyVO;
import com.encore.spring.study.impl.StudyDAO;

@Controller
public class StudyController {

	public StudyController() {
		// TODO Auto-generated constructor stub
	}
	
	// 1. �н� ��� ��ȸ
	@RequestMapping(value="/getStudyList.do")
	public ModelAndView getStudyList(StudyVO vo, StudyDAO dao, ModelAndView mav){
		System.out.println("===> �н� ��� ��ȸ");
		mav.addObject("studyList", dao.getStudyList(vo));
		mav.setViewName("getStudyList.jsp");
		return mav;
	}
	
	// 2. �н� ���� ��ȸ
	@RequestMapping(value="/getStudy.do")
	public ModelAndView getStudy(StudyVO vo, StudyDAO dao, ModelAndView mav) {
		System.out.println("===> �н� �� ��ȸ");
		mav.addObject("study", dao.getStudy(vo));
		mav.setViewName("getStudy.jsp"); // ViewResolver�� ����
		return mav;
	}
	
	// 3. �н� �߰�
	@RequestMapping(value="/insertStudy.do")
	public String insertStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> �н� �߰�");
		dao.insertStudy(vo);
		return "getStudyList.do";
	}
	
	// 4. �н� ����
	@RequestMapping(value="/updateStudy.do")
	public String updateStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> �н� ����");
		dao.updateStudy(vo);
		return "getStudyList.do";
	}
	
	// 5. �н� ����
	@RequestMapping(value="/deleteStudy.do")
	public String deleteStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> �н� ����");
		dao.deleteStudy(vo);
		return "getStudyList.do";
	}
}
