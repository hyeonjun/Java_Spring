package com.encore.view.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // <= 톰캣이 서블릿들을 구분하기 위한 상수(수정 불가)
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
	
    public DispatcherServlet() {
        super();
    }
    
    // DispatcherServlet 객체가 생성된 직후, 호출되어 요청전에 준비해야 할 사항들
    public void init(ServletConfig config) throws ServletException {
    	this.handlerMapping = new HandlerMapping(); // 요청 처리 "컨트롤러 객체"를 반환받기 위함
    	this.viewResolver = new ViewResolver(); // 컨트롤러의 처리 결과 화면의 "경로 및 파일명.확장자"를 반환받기 위함
    	this.viewResolver.setPrefix("./");
    	this.viewResolver.setSuffix(".jsp");
    }
    
    // 전송방식(Get 요청) : form 태그 method="get" 또는 웹 주소줄을 통해 직접 값 전달, a 태그의 href 속성을 통해 값 전달 등
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	// 전송방식(Get 요청) : 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 클라이언트 요청 경로 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping에게 요청사항에 맞는 컨트롤러 객체 요청
		Controller controller = handlerMapping.getController(path);
		
		// 3. 컨트롤러에게 요청 내용을 전달하여 처리 요청
		String viewName = controller.handleRequest(request, response);
		
		// 4. ViewResolver에게 출력화면에 대한 전체 경로명을 요청
		String view = null;
		if(!viewName.contains("do")){				// "login"
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;						// "getBoardList.do"
		}
		
		// 5. 웹 브라우저에게 응답 처리
		response.sendRedirect(view);
	}

}
