package com.xipunet.service;

import java.util.List;


import com.xipunet.commons.PageBean;
import com.xipunet.dao.AssetsDao;
import com.xipunet.entity.Assets;

public class AssetsService {
	AssetsDao assetsDao = new AssetsDao();
	//添加资产
	public void save(Assets assets){
		assetsDao.save(assets);
		
	}
	//删除资产
	public void delete(int id){
		assetsDao.delete(id);
		
	}
	//修改资产
	public void update(Assets assets){
		assetsDao.update(assets);
		
	}
	public List<Assets> findAll(){
		return assetsDao.findAll();
		
	}
	public Assets findById(int id){
		return assetsDao.findById(id);
	}
	
	public List<Assets> findByName(String users){
		return assetsDao.findByUsers(users);
	}
	public List<Assets> findByName2(String users){
		return assetsDao.findByUsers2(users);
	}

	public void getAll(PageBean<Assets> pb,int type_id,int company_id) {
		// TODO Auto-generated method stub
		try {
		assetsDao.getAll(pb,type_id,company_id);
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	}
	
	public void getAll(PageBean<Assets> pb,String users){
		assetsDao.getAll(pb, users);
	}
	public List<Assets> sumByCompany(){
		return assetsDao.sumByCompany();
		
	}
	public List<Assets> sumByType(){
		return assetsDao.sumByType();
	
	}
	public List<Assets> findByCompanyIds(int company_id){
		return assetsDao.findByCompanyIds(company_id);
	}
	
	public List<Assets> findNamesByIds(int company_id,int type_id){
		return assetsDao.findNamesByIds(type_id, company_id);
	}
 

}
