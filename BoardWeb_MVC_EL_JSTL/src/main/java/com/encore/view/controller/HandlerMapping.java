package com.encore.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	//			요청사항	컨트롤러
	private Map<String, Controller> mappings; // mappings : 요청사항과 컨트롤러를 한쌍으로 저장(put())
	
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
	
	// DispatcherServlet이 호출하여 결과값을 반환받는 메서드
	public Controller getController(String path){
		return mappings.get(path);
	}

}
