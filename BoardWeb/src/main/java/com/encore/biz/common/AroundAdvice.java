package com.encore.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] ����Ͻ� �޼��� ���� �� ó��");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] ����Ͻ� �޼��� ���� �� ó��");
		
		return returnObj;
	}
}
