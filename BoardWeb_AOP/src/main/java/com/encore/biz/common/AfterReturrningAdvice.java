package com.encore.biz.common;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.aspectj.lang.JoinPoint;

import com.encore.biz.board.UserVO;

public class AfterReturrningAdvice {

	public AfterReturrningAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	// ���� �������� ������ ��ü(������)�� ���ε��ϱ� ���ؼ���
	// ù��° �Ű����� Ÿ���� JoinPoint, �� ��° �Ű����� Ÿ���� Object
	// ���� ��� ���� ���� BoardVO ��ü��� �� ��° �Ű����� Ÿ���� BoardVO Ÿ������ �����ص� �ȴ�.
	// ������ ���� ���ø����̼ǿ����� � ��ü�� ���ϵ��� �𸣰� �빮�� Object Ÿ������ �����ϴ� ���� �Ϲ�����
	// �̿� ���� ���ϵ� ��ü�� ���ε��ϴ� ������ ���ε�(bind) ������� ��
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
