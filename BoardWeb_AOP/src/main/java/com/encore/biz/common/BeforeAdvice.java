package com.encore.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public BeforeAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public void beforeLog(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] 비즈니스 로직 수행 전 동작");
		System.out.println("[사전 처리] "+ method + "() 메서드 AGRD 정보 : "+ args[0].toString());
	}

}
