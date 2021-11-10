package com.encore.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PointCutCommon {

	public PointCutCommon() {
		// TODO Auto-genserated constructor stub
	}
	
	@Pointcut("execution(* com.encore.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Pointcut("execution(* com.encore.biz..*Impl.get*(..))")
	public void getPointCut(){}
	
	
}
