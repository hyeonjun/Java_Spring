package com.encore.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	//			��û����	��Ʈ�ѷ�
	private Map<String, Controller> mappings; // mappings : ��û���װ� ��Ʈ�ѷ��� �ѽ����� ����(put())
	
	public HandlerMapping() {
		this.mappings = new HashMap<String, Controller>();
		this.mappings.put("/login.do", new LoginController());
		this.mappings.put("/getBoardList.do", new GetBoardListController());
		this.mappings.put("/getBoard.do", new GetBoardController());
		this.mappings.put("/insertBoard.do", new InsertBoardController());
		this.mappings.put("/updateBoard.do", new UpdateBoardController());
		this.mappings.put("/deleteBoard.do", new DeleteBoardController());
		this.mappings.put("/logout.do", new LogoutController());
		
	}
	
	// DispatcherServlet�� ȣ���Ͽ� ������� ��ȯ�޴� �޼���
	public Controller getController(String path){
		return mappings.get(path);
	}

}
