package com.freeflux.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	public BeforeAdvice() {
	}

	
	@Before("PointCutCommon.allPointCut()")
	public void beforeLog(JoinPoint jp){
		String method=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		
		System.out.println("[���� ó��] "+method+"() �޼��� ARGS ���� : "+args[0].toString());
	}
}


/**
 * �ܺ� PointCut ����

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	public BeforeAdvice() {
	}

	
	@Before("PointCutCommon.allPointCut()")
	public void beforeLog(JoinPoint jp){
		String method=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		
		System.out.println("[���� ó��] "+method+"() �޼��� ARGS ���� : "+args[0].toString());
	}
}
**/


/**
 * @Service , @Aspect , @Pointcut , @Before

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	public BeforeAdvice() {
	}

	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Before("allPointCut()")
	public void beforeLog(JoinPoint jp){
		String method=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		
		System.out.println("[���� ó��] "+method+"() �޼��� ARGS ���� : "+args[0].toString());
	}
}
**/

/**
 *	JoinPoint

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public BeforeAdvice() {
	}

	public void beforeLog(JoinPoint jp){
		String method=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		
		System.out.println("[���� ó��] "+method+" () �޼��� ARGS ���� : "+args[0].toString());
	}
}
**/
/**
 * 

public class BeforeAdvice {

	public BeforeAdvice() {
	}

	public void beforeLog(){
		System.out.println("[���� ó��] �����Ͻ� ���� ���� �� ����");
	}
}

**/
