package com.freeflux.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
	}

	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@AfterThrowing(pointcut="allPointCut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		String method=jp.getSignature().getName();
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� ���� �߻�! ");

		if(exceptObj instanceof IllegalArgumentException){
			System.out.println("�������� ���� �ԷµǾ����ϴ�.");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("���� ������ ���� �ƴմϴ�.");
		}else if (exceptObj instanceof Exception) {
			System.out.println("������ �߻��߽��ϴ�.");
		}
	}
}

/**
 * @Service , @Aspect , @Pointcut , @AfterThrowing

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
	}

	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@AfterThrowing(pointcut="allPointCut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		String method=jp.getSignature().getName();
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� ���� �߻�! ");

		if(exceptObj instanceof IllegalArgumentException){
			System.out.println("�������� ���� �ԷµǾ����ϴ�.");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("���� ������ ���� �ƴմϴ�.");
		}else if (exceptObj instanceof Exception) {
			System.out.println("������ �߻��߽��ϴ�.");
		}
	}
}
**/

/** 
 * JoinPoint jp, Exception exceptObj

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
	}

	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		String method=jp.getSignature().getName();
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� �߻��� ���� �޽��� : "+exceptObj.getMessage());
	}
}
**/

/**
 * 

public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
	}

	public void exceptionLog(){
		System.out.println("[���� ó��] �����Ͻ� ���� ���� �� ���� �߻�");
	}
}
**/