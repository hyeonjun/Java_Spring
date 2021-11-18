package com.freeflux.biz.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	public JDBCUtil() {

	}
	
	public static Connection getConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연습용 코드
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			return DriverManager.getConnection(url, "zlel175", "qwer1234");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}	// getConnection() END

	public static void close(PreparedStatement stmt, Connection conn){
		if(stmt != null){
			try{
				if(!stmt.isClosed()){
					stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn != null){
			try{
				if(!conn.isClosed()){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
	}	// close(PreparedStatement stmt, Connection conn) END
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn){
		if(rs != null){
			try{
				if(!rs.isClosed()){
					stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		
		if(stmt != null){
			try{
				if(!stmt.isClosed()){
					stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn != null){
			try{
				if(!conn.isClosed()){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
	}	// close(ResultSet rs, PreparedStatement stmt, Connection conn) END
	
}
