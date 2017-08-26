package com.xipunet.service;

import com.xipunet.dao.UserDao;
import com.xipunet.entity.User;

public class UserService {
	UserDao userDao = new UserDao();
	public User loginByUsername(String loginInfo,String password){
		return userDao.loginByUsername(loginInfo, password);
	}
	public User loginByEmail(String loginInfo,String password){
		return userDao.loginByEmail(loginInfo, password);
	}
	public User findUsernameByEmail(String email){
		return userDao.findUsernameByEmail(email);
	}
	public User findPasswordByUsername(String username){
		return userDao.findPasswordByUsername(username);
	}
	public void changePassword(String password,int id){
		
			userDao.changePassword(password, id);
	}
	public void changePassword(String password , String username){
			userDao.changePassword(password, username);
	}
	public boolean findPasswordById(int id,String password){
			return userDao.findPasswordById(id, password);
	}
	public boolean findPasswordByUsername(String username,String password){
			return userDao.findPasswordByUsername(username, password);
	}

}
