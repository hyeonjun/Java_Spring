package com.encore.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service	// <bean id="around" class="com.encore.biz.common.LogAdvice"></bean>
@Aspect		// allPointCut이라는 Pointcut + <aop:before ~~~> 라는 어드바이스 	
public class LogAdvice {
	
	public LogAdvice(){
	}
//	<aop:aspect ref="around"></aop:aspect>
	
	
//	<aop:pointcut expression="execution(* com.encore.biz..*Impl.*(..))" id="allPointcut"/>
	/*@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}*/
	
//	<aop:before method="printLog" pointcut-ref="allPointcut" />
	@Before("PointCutCommon.allPointCut()")
	public void printLog(){
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
