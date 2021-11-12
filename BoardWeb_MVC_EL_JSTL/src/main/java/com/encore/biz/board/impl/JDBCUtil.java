package com.encore.biz.board.impl;

import java.sql.*;

/**
 * JDBCUtil : ����Ŭ �����ͺ��̽��� �����ϰ�,
 * 			    �ش� �ڿ��� ������ �� �ִ� �޼��带 �����ϴ� Ŭ����
 * 
 * 
 * */
public class JDBCUtil {

	public JDBCUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * getConnection() : �����ϰ� ���� ����� �l���ϴ� Connection ��ü�� ��ȯ
	 * 
	 * */
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			return DriverManager.getConnection(url, "zlel175", "qwer1234");
			
		} catch (ClassNotFoundException e) {
			System.out.println("getConnection() ClassForName ERR => " +e.getMessage());
		} catch (SQLException e){
			System.out.println("getConnection() DriverManager ERR => " +e.getMessage());
		}
		
		return null;
	} // getConnection() End
	
	/**
	 * 
	 * close() : �ڿ� ���� �޼���(PreparedStatement, Connection)
	 * 
	 * */
	public static void close(PreparedStatement pstmt, Connection conn){
		if(pstmt != null){
			try {
				if(!pstmt.isClosed()){
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("close() PreparedStatement ERR => " +e.getMessage());
			} finally {
				pstmt=null;
			}
		}
		
		if(conn != null){
			try {
				if(!conn.isClosed()){
					conn.close();					
				}
			} catch (SQLException e) {
				System.out.println("close() Connection ERR => " +e.getMessage());
			} finally {
				conn=null;
			}
		}
	} // close(PreparedStatement pstmt, Connection conn)
	
	/**
	 * 
	 * close() : �ڿ� ���� �޼���(ResultSet / PreparedStatement / Connection)
	 * 
	 * */
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs != null){
			try {
				if(!rs.isClosed()){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("close() ResultSet ERR => " +e.getMessage());
			} finally {
				rs=null;
			}
		}
		
		if(pstmt != null){
			try {
				if(!pstmt.isClosed()){
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("close() PreparedStatement ERR => " +e.getMessage());
			} finally {
				pstmt=null;
			}
		}
		
		if(conn != null){
			try {
				if(!conn.isClosed()){
					conn.close();					
				}
			} catch (SQLException e) {
				System.out.println("close() Connection ERR => " +e.getMessage());
			} finally {
				conn=null;
			}
		}
	} // close(ResultSet rs, PreparedStatement pstmt, Connection conn)
	
}
