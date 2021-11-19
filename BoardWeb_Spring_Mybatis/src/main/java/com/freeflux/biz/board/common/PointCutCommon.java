package com.freeflux.biz.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PointCutCommon {

	public PointCutCommon() {
	}

	@Pointcut("execution(* com.freeflux.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	@Pointcut("execution(* com.freeflux.biz..*Impl.get*(..))")
	public void getPointCut(){}
	
}
