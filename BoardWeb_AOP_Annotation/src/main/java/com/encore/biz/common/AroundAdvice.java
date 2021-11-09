package com.encore.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}*/
	
	@Around("PointCutCommon.allPointCut()")
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
