package com.freeflux.view.stduy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freeflux.biz.study.StudyVO;
import com.freeflux.biz.study.impl.StudyDAO;

@Controller
public class StudyController {

	public StudyController() {
		System.out.println("==> StudyController °´Ã¼");
	}
	
	@RequestMapping(value="/insertStudy.do", method=RequestMethod.GET)
	public String insertStudyView(){
		System.out.println("==> insertStudyView()");
		return "insertStudy.jsp";
	}
	
	@RequestMapping(value="/insertStudy.do", method=RequestMethod.POST)
	public String insertStudy(StudyVO vo, StudyDAO dao){
		System.out.println("==> insertStudy()");
		dao.insertStudy(vo);
		return "getStudyList.do";
	}
	
	@RequestMapping(value="/updateStudy.do", method=RequestMethod.GET)
	public String updateStudyView(StudyVO vo, StudyDAO dao, Model model){
		System.out.println("==> updateStudyView()");
		model.addAttribute("study", dao.getStudy(vo));
		return "updateStudy.jsp";
	}
	
	@RequestMapping(value="/updateStudy.do", method=RequestMethod.POST)
	public String updateStudy(StudyVO vo, StudyDAO dao){
		System.out.println("==> updateStudy()");
		dao.updateStudy(vo);
		return "getStudyList.do";
	}
	
	@RequestMapping(value="/deleteStudy.do")
	public String deleteStudy(StudyVO vo, StudyDAO dao){
		System.out.println("==> deleteStudy()");
		dao.deleteStudy(vo);
		return "getStudyList.do";
	}
	
	@RequestMapping(value="/getStudy.do")
	public String getStudy(StudyVO vo, StudyDAO dao, Model model){
		System.out.println("==> getStudy()");
		model.addAttribute("study", dao.getStudy(vo));
		return "getStudy.jsp";
	}
	
	@RequestMapping(value="/getStudyList.do")
	public String getStudyList(StudyVO vo, StudyDAO dao, Model model){
		System.out.println("==> getStudyList()");
		model.addAttribute("studyList", dao.getStudyList(vo));
		return "getStudyList.jsp";
	}
	
}
