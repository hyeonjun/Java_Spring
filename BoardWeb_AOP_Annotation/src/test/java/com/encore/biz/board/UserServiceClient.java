package com.encore.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		// 2. 서비스 객체 요청(Lookup)
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. 요청된 서비스 실행 (오라클 테이블에 저장된 데이터(id/password)와 비교)
		UserVO vo = new UserVO();
		vo.setId("test1");
		vo.setPassword("test1");
		
		UserVO user = userService.getUser(vo);
		
		// 4. 서비스 실행 결과 확인
		if(user != null){
			System.out.println(user.getName()+"님이 로그인되셨습니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
		
		// 회원 가입 (role : 입력받지않음, 0 : 관리자, 1 : 매니저, 2 : 일반 회원)
//		vo.setId("test123");
//		vo.setPassword("test123");
//		vo.setName("ㅋㅋㅋ");
//		userService.insertUser(vo);
		
		
		// 회원삭제(아이디 입력)
//		vo.setId("test123");
//		userService.deleteUser(vo);
		
		// 회원수정(아이디 맞으면, 이름 비밀번호 변경 가능)
//		vo.setId("test2");
//		vo.setName("이수정");
//		vo.setPassword("update");
//		userService.updateUser(vo);
		
		// 회원목록 (비밃번호 제외)
		/*List<UserVO> userList = userService.getUserList(vo);
		for (UserVO user : userList){
			System.out.println(user.toString());
		}*/
		
		
		// 5. Spring 컨테이너 종료(자원해제)
		container.close();
	}

}
