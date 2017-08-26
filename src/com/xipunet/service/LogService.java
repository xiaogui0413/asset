package com.xipunet.service;



import java.util.List;

import com.xipunet.commons.PageBean;
import com.xipunet.dao.LogDao;
import com.xipunet.entity.Log;
	
public class LogService {
	LogDao logDao = new LogDao();

	
	public void getAll(PageBean<Log> pb) {
		// TODO Auto-generated method stub
		try {
			logDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void add(Log log) {
		// TODO Auto-generated method stub
		logDao.addLog(log);
	}
	public void findLogByOperator(PageBean<Log> pb,String operator){
		logDao.findLogByOperator(pb, operator);
		
	}
}
