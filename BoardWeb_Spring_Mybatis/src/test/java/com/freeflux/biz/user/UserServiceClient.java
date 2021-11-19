package com.freeflux.biz.user;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring Container�� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring Container�κ��� UserServiceImpl ��ü�� ��û(lookup)�Ѵ�.
		UserService userService = (UserService) container.getBean("userService");

		// 3. ȸ�� ��ũ üũ�� ���� �� ����
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test1234");
		
		// 4. ȸ�� ��ũ üũ �ɽ�Ʈ
		UserVO user=userService.getUser(vo);
		if(user != null){
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}

		// 5. Spring Container ����
		container.close();

	}

}
