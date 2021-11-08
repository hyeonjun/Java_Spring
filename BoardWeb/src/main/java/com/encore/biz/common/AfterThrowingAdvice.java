package com.encore.biz.common;

public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public void afterThrowingLog(){
		System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외발생");
	}

}
