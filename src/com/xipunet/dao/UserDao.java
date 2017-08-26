package com.xipunet.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xipunet.entity.User;
import com.xipunet.utils.JdbcUtils;

public class UserDao {
	public User loginByUsername(String username,String password){
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	public User loginByEmail(String email,String password){
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<User>(User.class),email,password);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	public User findUsernameByEmail(String email){
		String sql = "select username from user where email = ?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	public User findPasswordByUsername(String username){
		String sql = "select password from user where username = ?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	//根据Id查询原密码
	public boolean findPasswordById(int id,String password){
		String sql = "select count(*) from user where id = ? and password = ?";
		try {
		Number number = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Number>(),id,password);
		return number.intValue()>0;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	
	//根据Id查询原密码
	public boolean findPasswordByUsername(String username,String password){
		String sql = "select count(*) from user where username = ? and password = ?";
		try {
		Number number = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Number>(),username,password);
		return number.intValue()>0;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	
	public void changePassword(String password , int id){
		String sql = "update user set password = ? where id = ?";
		try {
			JdbcUtils.getQueryRunner().update(sql,password ,id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void changePassword(String password , String username){
		String sql = "update user set password = ? where username = ?";
		try {
			JdbcUtils.getQueryRunner().update(sql,password,username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
