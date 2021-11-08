package com.encore.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] 비즈니스 메서드 수행 전 처리");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] 비즈니스 메서드 수행 후 처리");
		
		return returnObj;
	}
}
