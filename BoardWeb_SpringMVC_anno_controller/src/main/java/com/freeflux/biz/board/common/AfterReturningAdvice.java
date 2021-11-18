package com.freeflux.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.freeflux.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	
	@AfterReturning(pointcut="PointCutCommon.getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		String method=jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user=(UserVO) returnObj;
			
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName()+" �α���(Admin)");
			}
		}
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� : "+returnObj.toString());
	}
}

/**
 * �ܺ� PointCut ����

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	
	@AfterReturning(pointcut="PointCutCommon.getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		String method=jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user=(UserVO) returnObj;
			
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName()+" �α���(Admin)");
			}
		}
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� : "+returnObj.toString());
	}
}
**/


/**
 * @Service , @Aspect , @Pointcut , @AfterReturning

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.freeflux.biz.board.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	@Pointcut("execution(* com.freeflux.biz..*Impl.get*(..))")
	public void getPointCut(){}
	
	@AfterReturning(pointcut="getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		String method=jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user=(UserVO) returnObj;
			
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName()+" �α���(Admin)");
			}
		}
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� : "+returnObj.toString());
	}
}
**/


/**
 * JoinPoint jp, Object returnObj

import org.aspectj.lang.JoinPoint;

import com.freeflux.biz.board.UserVO;

public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	public void afterLog(JoinPoint jp, Object returnObj){
		String method=jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user=(UserVO) returnObj;
			
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName()+" �α���(Admin)");
			}
		}
		System.out.println("[���� ó��] " + method +"() �޼��� ���� �� : "+returnObj.toString());
	}
}
**/

/**
 * 
 
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	public void afterLog(){
		System.out.println("[���� ó��] �����Ͻ� ���� ���� �� ����");
	}
}

**/