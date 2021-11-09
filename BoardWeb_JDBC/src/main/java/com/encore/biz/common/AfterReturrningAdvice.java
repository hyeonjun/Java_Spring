package com.encore.biz.common;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.encore.biz.board.UserVO;


@Service
@Aspect
public class AfterReturrningAdvice {
	
	
	public AfterReturrningAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Pointcut("execution(* com.encore.biz..*Impl.get*(..))")
	public void getPointCut(){}*/
	
	@AfterReturning(pointcut="PointCutCommon.getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO){
			UserVO vo = (UserVO) returnObj;
			
			if (vo.getRole().equals("0")){
				System.out.println(vo.getName() + "로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
		System.out.println("[사후 처리] "+method + " () 메서드/리턴값 : "+returnObj.toString());
	}

}
