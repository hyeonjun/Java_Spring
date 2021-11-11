package com.encore.biz.user;

import java.util.List;

public interface UserService {
	public UserVO getUser(UserVO vo);
	
	public void insertUser(UserVO vo);
	
	public List<UserVO> getUserList(UserVO vo);
	
	public void deleteUser(UserVO vo);
	
	public void updateUser(UserVO vo);
}
