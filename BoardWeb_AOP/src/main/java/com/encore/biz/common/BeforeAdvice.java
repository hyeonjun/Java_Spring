package com.encore.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public BeforeAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public void beforeLog(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����");
		System.out.println("[���� ó��] "+ method + "() �޼��� AGRD ���� : "+ args[0].toString());
	}

}
