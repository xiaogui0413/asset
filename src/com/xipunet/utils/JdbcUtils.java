package com.xipunet.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//初始化连接池
public class JdbcUtils {
	public static DataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}

}
