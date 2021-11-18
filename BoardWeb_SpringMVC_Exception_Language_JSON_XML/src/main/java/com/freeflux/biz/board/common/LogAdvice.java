package com.freeflux.biz.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {

	public LogAdvice() {
	}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Before("allPointCut()")
	public void printLog(){
		System.out.println("[���� �α�] �����Ͻ� ���� ������ ����");
	}
	
}

/**
 * @Aspect : annotation.Aspect

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {

	public LogAdvice() {
	}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Before("allPointCut()")
	public void printLog(){
		System.out.println("[���� �α�] �����Ͻ� ���� ������ ����");
	}
	
}
**/

/**
 * @Before : annotation.Before

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
public class LogAdvice {

	public LogAdvice() {
	}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Before("allPointCut()")
	public void printLog(){
		System.out.println("[���� �α�] �����Ͻ� ���� ������ ����");
	}
	
}
**/

/**
 *	@Pointcut : annotation.Pointcut
 
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
public class LogAdvice {

	public LogAdvice() {
	}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.get*(..))")
	public void getPointCut(){}

}
**/

/** 
 *  JoinPoint

import org.aspectj.lang.JoinPoint;

public class LogAdvice {

	public LogAdvice() {
	}

	public void printLog(JoinPoint jp){
		System.out.println("[���� �α�] �����Ͻ� ���� ������ ����");
	}
}
**/

/**
 * 
 
public class LogAdvice {

	public LogAdvice() {
	}

	public void printLog(){
		System.out.println("[���� �α�] �����Ͻ� ���� ������ ����");
	}
}


**/