package com.encore.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}*/
	
	@AfterThrowing(pointcut="PointCutCommon.allPointCut()", throwing="e")
	public void afterThrowingLog(JoinPoint jp, Exception e){
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ���ܹ߻�");
		System.out.println("[���� ó��] "+method +" ()�޼���  : "+e.getMessage());
	}

}
