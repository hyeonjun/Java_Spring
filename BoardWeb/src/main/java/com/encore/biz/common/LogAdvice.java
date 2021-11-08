package com.encore.biz.common;

public class LogAdvice {
	
	public LogAdvice(){
		
	}
	
	// 각 비즈니스 로직 수행 메서드에 대한 로그 출력 공통 메서드
	public void printLog(){
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
