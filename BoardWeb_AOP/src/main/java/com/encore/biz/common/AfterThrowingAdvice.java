package com.encore.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public void afterThrowingLog(JoinPoint jp, Exception e){
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ���ܹ߻�");
		System.out.println("[���� ó��] "+method +" ()�޼���  : "+e.getMessage());
	}

}
