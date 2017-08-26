package com.xipunet.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xipunet.commons.PageBean;
import com.xipunet.entity.Assets;
import com.xipunet.entity.Log;
import com.xipunet.utils.JdbcUtils;

public class LogDao {
	//添加日志
    public void addLog(Log log){
    	String sql = "INSERT INTO LOG(create_time,operator,content,remark)VALUES(?,?,?,?)";
    		try {
				JdbcUtils.getQueryRunner().update(sql,log.getCreate_time(),
													  log.getOperator(),
													  log.getContent(),
													  log.getRemark());
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	
    };
    //按用户名查找日志
	//分页查询
	public void findLogByOperator(PageBean<Log> pb,String operator) {
		// TODO Auto-generated method stub
		int totalCount = this.getTotalCount(operator);
		pb.setTotalCount(totalCount);
	
	
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					 
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		
		}
	
		
		int currentPage = pb.getCurrentPage();
		if(currentPage==0){
			currentPage=1;	
		}
		int index = (currentPage- 1) * pb.getPageCount();		
		int count = pb.getPageCount();							

		String sql = "select * from log where operator like ? limit ?,?";
		
		try {
			
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Log> pageData = qr.query(sql, new BeanListHandler<Log>(Log.class),"%"+operator+"%", index, count);
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public int getTotalCount(String operator) {
		// TODO Auto-generated method stub
	String sql = "select count(*) from log where operator like ?";
		try {
		
			QueryRunner qr = JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>(),"%"+operator+"%");
	
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    
    public int getTotalCount() {
		// TODO Auto-generated method stub
	String sql = "select count(*) from log";
		try {
		
			QueryRunner qr = JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>());
	
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
  //分页查询
  	public void getAll(PageBean<Log> pb) {
  		// TODO Auto-generated method stub
  		int totalCount = this.getTotalCount();
  		pb.setTotalCount(totalCount);
  	
  	
  		if (pb.getCurrentPage() <=0) {
  			pb.setCurrentPage(1);					 
  		} else if (pb.getCurrentPage() > pb.getTotalPage()){
  			pb.setCurrentPage(pb.getTotalPage());		
  		}
  	
  		
  		int currentPage = pb.getCurrentPage();
  		int index = (currentPage- 1) * pb.getPageCount();		
  		int count = pb.getPageCount();							

  		String sql = "select * from log ORDER BY id DESC limit ?,?";
  		
  		try {
  			
  			QueryRunner qr = JdbcUtils.getQueryRunner();
  			List<Log> pageData = qr.query(sql, new BeanListHandler<Log>(Log.class), index, count);
  			pb.setPageData(pageData);
  			
  		} catch (Exception e) {
  			throw new RuntimeException(e);
  		}

  	}
}
