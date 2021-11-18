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
		System.out.println("[공통 로그] 비지니스 로직 수행전 동작");
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
		System.out.println("[공통 로그] 비지니스 로직 수행전 동작");
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
		System.out.println("[공통 로그] 비지니스 로직 수행전 동작");
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
		System.out.println("[공통 로그] 비지니스 로직 수행전 동작");
	}
}
**/

/**
 * 
 
public class LogAdvice {

	public LogAdvice() {
	}

	public void printLog(){
		System.out.println("[공통 로그] 비지니스 로직 수행전 동작");
	}
}


**/