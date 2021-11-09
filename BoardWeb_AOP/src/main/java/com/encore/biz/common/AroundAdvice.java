package com.encore.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		
		System.out.println("[BEFORE] ����Ͻ� �޼��� ���� �� ó��");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] ����Ͻ� �޼��� ���� �� ó��");
		stopWatch.stop();
		
		System.out.println(method + "() ���� �ð� : " + stopWatch.getTotalTimeMillis() + "(ms)��");
		
		return returnObj;
	}
}
