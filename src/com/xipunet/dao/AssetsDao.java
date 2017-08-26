package com.xipunet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.xipunet.commons.PageBean;
import com.xipunet.entity.Assets;
import com.xipunet.utils.JdbcUtils;
/**
 * 固定资产接口及实现
 * @author hgq
 *
 */

public class AssetsDao {
	//添加
	public void save(Assets assets){
		String sql = "insert into assets(users,p_type,amount,model,price,configration,serial_number,buy_time,receive_time,p_status,number,remark,type_id,company_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			JdbcUtils.getQueryRunner().update(sql,assets.getUsers(),assets.getP_type(),assets.getAmount(),assets.getModel(),assets.getPrice(),assets.getConfigration(),assets.getSerial_number(),assets.getBuy_time(),assets.getReceive_time(),assets.getP_status(),assets.getNumber(),assets.getRemark(),assets.getType_id(),assets.getCompany_id());
		} catch (SQLException e) {
			new RuntimeException();
		}
	}
	//删除
	public void delete(int id){
		String sql = "delete from assets where id = ?";
		try {
			JdbcUtils.getQueryRunner().update(sql,id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	//修改
	public void update(Assets assets){
		String sql = "update assets set users=?,p_type=?,amount=?,model=?,price=?,configration=?,serial_number=?,buy_time=?,receive_time=?,p_status=?,number=?,remark=? where id = ?";
		try {
			JdbcUtils.getQueryRunner().update(sql,assets.getUsers(),assets.getP_type(),assets.getAmount(),
					assets.getModel(),assets.getPrice(),assets.getConfigration(),
					assets.getSerial_number(),assets.getBuy_time(),assets.getReceive_time(),assets.getP_status(),
					assets.getNumber(),assets.getRemark(),assets.getId());
		} catch (SQLException e) {
			//throw new RuntimeException();
			e.printStackTrace();
		}
	}
	//查询所有
	public List<Assets> findAll(){
		String sql = "select * from assets";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		
	}
	//按照id查询公司名称和分类名称
		public List<Assets> findByCompanyIds( int company_id){
			String sql = "SELECT * FROM assets WHERE company_id = ?";
			try {
				return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class),company_id);
			} catch (SQLException e) {
				throw new RuntimeException();
			}	
		}
	
//按照id查询公司名称和分类名称
	public List<Assets> findNamesByIds(int type_id, int company_id){
		String sql = "SELECT DISTINCT company.remark,category.remark FROM assets,company,category WHERE assets.company_id = company.id AND assets.type_id = category.id AND company_id = ? AND type_id = ?";
		try{
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class),company_id,type_id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}		
	}
////按照序号查询公司名称
//	public List<Assets> findNameById(){
//		String sql = "SELECT company.remark,category.remark FROM assets,category,company WHERE assets.type_id=category.id AND assets.company_id=company.id";
//		return null;	
//	}
	//按照序号查资产类型
	//按照使用者查询
	public List<Assets> findByUsers(String users){
		String sql = "select * from assets where users=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class),users);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	//按照使用者模糊查询
	public List<Assets> findByUsers2(String users){
		String sql ="select * from assets where users like ?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class),"%"+users+"%");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	//根据ID查询
	public Assets findById(int id){
		String sql = "select * from assets where id =?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<Assets>(Assets.class),id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	//按资产类型汇总
	public List<Assets> sumByType(){
		String sql = "SELECT category.NAME,SUM(price) FROM assets,category WHERE assets.type_id = category.id GROUP BY type_id";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
	}
	
	//按公司汇总
	public List<Assets> sumByCompany(){
		String sql = "SELECT company.NAME,SUM(price) FROM assets,company WHERE assets.company_id = company.id GROUP BY company_id";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Assets>(Assets.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
	}
	
	
	//分页查询
	public void getAll(PageBean<Assets> pb,int type_id,int company_id) {
		// TODO Auto-generated method stub
		int totalCount = this.getTotalCount(type_id,company_id);
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

		String sql = "select * from assets where type_id = ? and company_id = ? limit ?,?";
		
		try {
			
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Assets> pageData = qr.query(sql, new BeanListHandler<Assets>(Assets.class),type_id,company_id, index, count);
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	//分页查询
	public void getAll(PageBean<Assets> pb,String users) {
		// TODO Auto-generated method stub
		int totalCount = this.getTotalCount(users);
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

		String sql = "select * from assets where users like ? limit ?,?";
		
		try {
			
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Assets> pageData = qr.query(sql, new BeanListHandler<Assets>(Assets.class),"%"+users+"%", index, count);
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public int getTotalCount(String users) {
		// TODO Auto-generated method stub
	String sql = "select count(*) from assets where users like ?";
		try {
		
			QueryRunner qr = JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>(),"%"+users+"%");
	
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int getTotalCount(int type_id,int company_id) {
	
	String sql = "select count(*) from assets where type_id = ? and company_id = ?";
		try {
		
			QueryRunner qr = JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>(),type_id,company_id);
	
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    }