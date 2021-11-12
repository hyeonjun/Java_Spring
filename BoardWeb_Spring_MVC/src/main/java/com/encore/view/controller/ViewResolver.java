package com.encore.view.controller;

public class ViewResolver {
	
	private String prefix; // ����� ����� ������ ��θ�
	private String suffix; // ����� ����� ������ Ȯ����
	
	public ViewResolver() {
		
	}
	
	// DispatcherServlet�� ȣ���Ͽ� ���ȭ�� ���Ͽ� ���� ��� �� Ȯ���ڸ� �ϼ��Ͽ� ��ȯ����.
	public String getView(String viewName){
		return this.prefix + viewName + this.suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	

}
