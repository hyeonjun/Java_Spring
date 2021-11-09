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
		
		
		System.out.println("[BEFORE] 비즈니스 메서드 수행 전 처리");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] 비즈니스 메서드 수행 후 처리");
		stopWatch.stop();
		
		System.out.println(method + "() 실행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return returnObj;
	}
}
