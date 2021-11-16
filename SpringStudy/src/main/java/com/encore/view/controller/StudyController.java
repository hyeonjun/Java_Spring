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
	
	// 1. 학습 목록 조회
	@RequestMapping(value="/getStudyList.do")
	public ModelAndView getStudyList(StudyVO vo, StudyDAO dao, ModelAndView mav){
		System.out.println("===> 학습 목록 조회");
		mav.addObject("studyList", dao.getStudyList(vo));
		mav.setViewName("getStudyList.jsp");
		return mav;
	}
	
	// 2. 학습 세부 조회
	@RequestMapping(value="/getStudy.do")
	public ModelAndView getStudy(StudyVO vo, StudyDAO dao, ModelAndView mav) {
		System.out.println("===> 학습 상세 조회");
		mav.addObject("study", dao.getStudy(vo));
		mav.setViewName("getStudy.jsp"); // ViewResolver에 의해
		return mav;
	}
	
	// 3. 학습 추가
	@RequestMapping(value="/insertStudy.do")
	public String insertStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> 학습 추가");
		dao.insertStudy(vo);
		return "getStudyList.do";
	}
	
	// 4. 학습 수정
	@RequestMapping(value="/updateStudy.do")
	public String updateStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> 학습 수정");
		dao.updateStudy(vo);
		return "getStudyList.do";
	}
	
	// 5. 학습 삭제
	@RequestMapping(value="/deleteStudy.do")
	public String deleteStudy(StudyVO vo, StudyDAO dao){
		System.out.println("===> 학습 삭제");
		dao.deleteStudy(vo);
		return "getStudyList.do";
	}
}
