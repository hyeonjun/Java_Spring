package com.freeflux.biz.board.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {

	public AroundAdvice() {
	}

	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Around("allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method=pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[BEFORE] : �����Ͻ� �޼��� ���� ���� ó���� ����...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : �����Ͻ� �޼��� ���� �Ŀ� ó���� ����...");

		stopWatch.stop();
		
		System.out.println(method + "() �޼��� ���࿡ �ɸ� �ð� : "+ stopWatch.getTotalTimeMillis()+"(ms)��");
		return obj;
	}
}


/**
 * @Service , @Aspect , @Pointcut , @Around

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {

	public AroundAdvice() {
	}

	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Around("allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method=pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[BEFORE] : �����Ͻ� �޼��� ���� ���� ó���� ����...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : �����Ͻ� �޼��� ���� �Ŀ� ó���� ����...");

		stopWatch.stop();
		
		System.out.println(method + "() �޼��� ���࿡ �ɸ� �ð� : "+ stopWatch.getTotalTimeMillis()+"(ms)��");
		return obj;
	}
}
**/


/**
 * StopWatch

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	public AroundAdvice() {
	}

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method=pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[BEFORE] : �����Ͻ� �޼��� ���� ���� ó���� ����...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : �����Ͻ� �޼��� ���� �Ŀ� ó���� ����...");

		stopWatch.stop();
		
		System.out.println(method + "() �޼��� ���࿡ �ɸ� �ð� : "+ stopWatch.getTotalTimeMillis()+"(ms)��");
		return obj;
	}
}
**/

/**
 * 
 
import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	public AroundAdvice() {
	}

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] : �����Ͻ� �ļ��� ���� ���� ó���� ����...");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] : �����Ͻ� �ļ��� ���� �Ŀ� ó���� ����...");
		
		return returnObj;
	}
}

**/