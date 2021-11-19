package com.freeflux.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	static {
		try{
			if(sessionFactory == null){
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static SqlSession getSqlSessionInstance(){
		return sessionFactory.openSession();
	}
}

/*
 * private static SqlSessionFactory sessionFactory = null;
 * 	전체 프로젝트에서 유일한(static) 객체로 생성되어야 한다.
 * 	역할 : Mybatis 작업을 실제로 수행할 수 있는 메서드를 보유한 SqlSession 객체를 생성하는 역할(openSession())
 * 
 * Mybatis 작업을 위한 환경 설정 파일 읽기
 * 	해당 파일은 src/main/resources 에 위치해야하며 src/main/resources에 접근할 수 있는 Resources 클래스의 메서드를 이용
 * 	(Resources.getResourceAsReader("sql-map-config.xml"))
 * 
 * 	읽어들인 Mybatis 환경 설정 파일 내용을 토대로 SqlSessionFactory 객체를 제작
 *  	=> sessionFactory = new SqlSessionFacoryBuilder().build(reader);
 * 
 * 	외부(다른 클래스)에서 작성을 위한 SqlSession 객체를 얻을 수 있도록 메서드 선언
 * 		return sessionFactory.openSession();
 * 
 * */
