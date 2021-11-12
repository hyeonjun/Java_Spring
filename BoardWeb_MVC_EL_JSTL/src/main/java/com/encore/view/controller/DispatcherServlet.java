package com.encore.view.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // <= ��Ĺ�� �������� �����ϱ� ���� ���(���� �Ұ�)
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
	
    public DispatcherServlet() {
        super();
    }
    
    // DispatcherServlet ��ü�� ������ ����, ȣ��Ǿ� ��û���� �غ��ؾ� �� ���׵�
    public void init(ServletConfig config) throws ServletException {
    	this.handlerMapping = new HandlerMapping(); // ��û ó�� "��Ʈ�ѷ� ��ü"�� ��ȯ�ޱ� ����
    	this.viewResolver = new ViewResolver(); // ��Ʈ�ѷ��� ó�� ��� ȭ���� "��� �� ���ϸ�.Ȯ����"�� ��ȯ�ޱ� ����
    	this.viewResolver.setPrefix("./");
    	this.viewResolver.setSuffix(".jsp");
    }
    
    // ���۹��(Get ��û) : form �±� method="get" �Ǵ� �� �ּ����� ���� ���� �� ����, a �±��� href �Ӽ��� ���� �� ���� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	// ���۹��(Get ��û) : 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ ��û ��� ���� ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping���� ��û���׿� �´� ��Ʈ�ѷ� ��ü ��û
		Controller controller = handlerMapping.getController(path);
		
		// 3. ��Ʈ�ѷ����� ��û ������ �����Ͽ� ó�� ��û
		String viewName = controller.handleRequest(request, response);
		
		// 4. ViewResolver���� ���ȭ�鿡 ���� ��ü ��θ��� ��û
		String view = null;
		if(!viewName.contains("do")){				// "login"
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;						// "getBoardList.do"
		}
		
		// 5. �� ���������� ���� ó��
		response.sendRedirect(view);
	}

}
