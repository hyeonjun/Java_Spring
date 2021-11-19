package com.freeflux.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.impl.JDBCUtil;
import com.freeflux.biz.user.UserVO;

/** DAO : Data Access Object **/

@Repository("userDAO")
public class UserDAO {

	// JDBC ���� ��� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL ��ɾ� ��� ����
	private final String USER_GET = "select * from users where id=? and password=?";

	public UserDAO() {
	}

	/** CRUD ��� �޼��� ���� **/
	// ȸ�� �α� üũ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ��� ó��");
		UserVO user = null;

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(USER_GET);
			this.stmt.setString(1, vo.getId());
			this.stmt.setString(2, vo.getPassword());
			this.rs = this.stmt.executeQuery();

			if (this.rs.next()) {
				user = new UserVO();
				user.setId(this.rs.getString("id"));
				user.setPassword(this.rs.getString("password"));
				user.setName(this.rs.getString("name"));
				user.setRole(this.rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	} // getBoard(BoardVO vo) END

}


/**
 * @Repository

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.UserVO;

@Repository("userDAO")
public class UserDAO {

	// JDBC ���� ��� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL ��ɾ� ��� ����
	private final String USER_GET = "select * from users where id=? and password=?";

	public UserDAO() {
	}


	// ȸ�� �α� üũ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ��� ó��");
		UserVO user = null;

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(USER_GET);
			this.stmt.setString(1, vo.getId());
			this.stmt.setString(2, vo.getPassword());
			this.rs = this.stmt.executeQuery();

			if (this.rs.next()) {
				user = new UserVO();
				user.setId(this.rs.getString("id"));
				user.setPassword(this.rs.getString("password"));
				user.setName(this.rs.getString("name"));
				user.setRole(this.rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	} // getBoard(BoardVO vo) END

}
**/



/**
 * 
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;
import com.freeflux.biz.board.UserVO;


public class UserDAO {

	// JDBC ���� ��� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL ��ɾ� ��� ����
	private final String USER_GET = "select * from users where id=? and password=?";

	public UserDAO() {
	}


	// ȸ�� �α� üũ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ��� ó��");
		UserVO user = null;

		try {
			this.conn = JDBCUtil.getConnection();
			this.stmt = this.conn.prepareStatement(USER_GET);
			this.stmt.setString(1, vo.getId());
			this.stmt.setString(2, vo.getPassword());
			this.rs = this.stmt.executeQuery();

			if (this.rs.next()) {
				user = new UserVO();
				user.setId(this.rs.getString("id"));
				user.setPassword(this.rs.getString("password"));
				user.setName(this.rs.getString("name"));
				user.setRole(this.rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	} // getBoard(BoardVO vo) END

}

**/