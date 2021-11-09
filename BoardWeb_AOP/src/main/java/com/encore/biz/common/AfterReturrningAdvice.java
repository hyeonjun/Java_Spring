package com.encore.biz.common;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.aspectj.lang.JoinPoint;

import com.encore.biz.board.UserVO;

public class AfterReturrningAdvice {

	public AfterReturrningAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	// 리턴 시점에서 리던된 객체(데이터)를 바인딩하기 위해서는
	// 첫번째 매개변수 타입은 JoinPoint, 두 번째 매개변수 타입은 Object
	// 만약 모든 리턴 값이 BoardVO 객체라면 두 번째 매개변수 타입은 BoardVO 타입으로 설정해도 된다.
	// 하지만 범용 애플리케이션에서는 어떤 객체가 리턴될지 모르게 대문에 Object 타입으로 선언하는 것이 일반적임
	// 이와 같이 리턴된 객체를 바인딩하는 변수를 바인드(bind) 변수라고 함
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
