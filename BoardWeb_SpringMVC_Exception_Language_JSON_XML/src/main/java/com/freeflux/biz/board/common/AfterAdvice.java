package com.freeflux.biz.board.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {

	public AfterAdvice() {
	}

	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@After("allPointCut()")
	public void finallyLog(){
		System.out.println("[���� ����] �����Ͻ� ���� ���� �� ������ ����");
	}
}

/**
 * @Service , @Aspect , @Pointcut , @After
 
@Service
@Aspect
public class AfterAdvice {

	public AfterAdvice() {
	}

	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@After("allPointCut()")
	public void finallyLog(){
		System.out.println("[���� ����] �����Ͻ� ���� ���� �� ������ ����");
	}
} 
**/


/**
 * 
 

public class AfterAdvice {

	public AfterAdvice() {
	}

	public void finallyLog(){
		System.out.println("[���� ����] �����Ͻ� ���� ���� �� ������ ����");
	}
}
**/