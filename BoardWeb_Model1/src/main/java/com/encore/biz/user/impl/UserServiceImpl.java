package com.encore.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.biz.user.UserService;
import com.encore.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	public UserServiceImpl() {
		System.out.println("===> UserServiceImpl °´Ã¼ »ý¼º");

	}	

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		this.userDAO.insertUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return this.userDAO.getUserList(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		this.userDAO.deleteUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		this.userDAO.updateUser(vo);
	}

}
