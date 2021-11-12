package com.encore.view.controller;

public class ViewResolver {
	
	private String prefix; // 결과를 출력할 파일의 경로명
	private String suffix; // 결과를 출력할 파일의 확장자
	
	public ViewResolver() {
		
	}
	
	// DispatcherServlet이 호출하여 출력화면 파일에 대한 경로 및 확장자를 완성하여 반환받음.
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
