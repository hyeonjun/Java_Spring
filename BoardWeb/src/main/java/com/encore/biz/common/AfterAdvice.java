package com.encore.biz.common;

public class AfterAdvice {

	public AfterAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	public void afterLog(){
		System.out.println("[사후 처리] 비즈니스 로직 수행 중 무조건 동작");
	}
}
