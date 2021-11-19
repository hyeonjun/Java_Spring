package com.freeflux.biz.board.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

	public CommonExceptionHandler() {
	}
	
	// 연산 Exception 발생 시.
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/arithmeticError.jsp");
		return mav;
	}
	
	// Null Exception 발생 시.
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/nullPointerError.jsp");
		return mav;
	}
	
	// 그외  Exception 발생 시.
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}

}
