package com.freeflux.biz.board.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

	public CommonExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
//		mav.setViewName("error.jsp"); // webapp ���� ���� ����
		mav.setViewName("/common/arithmeticError.jsp"); // webapp/common �� ����
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
//		mav.setViewName("error.jsp"); // webapp ���� ���� ����
		mav.setViewName("/common/nullPointerError.jsp"); // webapp/common �� ����
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
//		mav.setViewName("error.jsp"); // webapp ���� ���� ����
		mav.setViewName("/common/Error.jsp"); // webapp/common �� ����
		return mav;
	}
	

}
