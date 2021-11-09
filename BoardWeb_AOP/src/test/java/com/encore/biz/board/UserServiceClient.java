package com.encore.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		// 2. ���� ��ü ��û(Lookup)
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. ��û�� ���� ���� (����Ŭ ���̺� ����� ������(id/password)�� ��)
		UserVO vo = new UserVO();
		vo.setId("test1");
		vo.setPassword("test1");
		
		UserVO user = userService.getUser(vo);
		
		// 4. ���� ���� ��� Ȯ��
		if(user != null){
			System.out.println(user.getName()+"���� �α��εǼ̽��ϴ�.");
		} else {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
		// ȸ�� ���� (role : �Է¹�������, 0 : ������, 1 : �Ŵ���, 2 : �Ϲ� ȸ��)
//		vo.setId("test123");
//		vo.setPassword("test123");
//		vo.setName("������");
//		userService.insertUser(vo);
		
		
		// ȸ������(���̵� �Է�)
//		vo.setId("test123");
//		userService.deleteUser(vo);
		
		// ȸ������(���̵� ������, �̸� ��й�ȣ ���� ����)
//		vo.setId("test2");
//		vo.setName("�̼���");
//		vo.setPassword("update");
//		userService.updateUser(vo);
		
		// ȸ����� (��A��ȣ ����)
		/*List<UserVO> userList = userService.getUserList(vo);
		for (UserVO user : userList){
			System.out.println(user.toString());
		}*/
		
		
		// 5. Spring �����̳� ����(�ڿ�����)
		container.close();
	}

}
