package com.encore.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	public BeforeAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}*/
		
	@Before("PointCutCommon.allPointCut()")
	public void beforeLog(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����");
		System.out.println("[���� ó��] "+ method + "() �޼��� AGRD ���� : "+ args[0].toString());
	}

}
