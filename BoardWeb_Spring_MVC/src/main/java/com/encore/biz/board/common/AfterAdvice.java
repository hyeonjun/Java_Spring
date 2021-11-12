package com.encore.biz.board.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {

	public AfterAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}*/
	
	@After("PointCutCommon.allPointCut()")
	public void afterLog(){
		System.out.println("[사후 처리] 비즈니스 로직 수행 중 무조건 동작");
	}
}
