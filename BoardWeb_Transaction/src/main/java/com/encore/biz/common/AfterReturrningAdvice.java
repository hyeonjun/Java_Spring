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
				System.out.println(vo.getName() + "�α���(Admin)");
			}
		}
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����");
		System.out.println("[���� ó��] "+method + " () �޼���/���ϰ� : "+returnObj.toString());
	}

}
