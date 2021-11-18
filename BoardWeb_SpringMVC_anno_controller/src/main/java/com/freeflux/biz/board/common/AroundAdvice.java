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
		
		System.out.println("[BEFORE] : 비지니스 메서드 수행 전에 처리할 내용...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : 비지니스 메서드 수행 후에 처리할 내용...");

		stopWatch.stop();
		
		System.out.println(method + "() 메서드 수행에 걸린 시간 : "+ stopWatch.getTotalTimeMillis()+"(ms)초");
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
		
		System.out.println("[BEFORE] : 비지니스 메서드 수행 전에 처리할 내용...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : 비지니스 메서드 수행 후에 처리할 내용...");

		stopWatch.stop();
		
		System.out.println(method + "() 메서드 수행에 걸린 시간 : "+ stopWatch.getTotalTimeMillis()+"(ms)초");
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
		
		System.out.println("[BEFORE] : 비지니스 메서드 수행 전에 처리할 내용...");
		
		Object obj = pjp.proceed();
		
		System.out.println("[AFTER] : 비지니스 메서드 수행 후에 처리할 내용...");

		stopWatch.stop();
		
		System.out.println(method + "() 메서드 수행에 걸린 시간 : "+ stopWatch.getTotalTimeMillis()+"(ms)초");
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
		System.out.println("[BEFORE] : 비지니스 ㅔ서드 수행 전에 처리할 내용...");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] : 비지니스 ㅔ서드 수행 후에 처리할 내용...");
		
		return returnObj;
	}
}

**/