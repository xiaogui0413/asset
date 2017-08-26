CREATE DATABASE assets DEFAULT CHARACTER SET utf8;
USE assets;
CREATE TABLE assets(
	id INT PRIMARY KEY AUTO_INCREMENT,-- 主键
	users VARCHAR(10),		  -- 使用者
	p_type VARCHAR(50),		  -- 类别
	amount VARCHAR(11),			  -- 数量
	model VARCHAR(50),		  -- 型号
	price VARCHAR(20),                     -- 价格		
	configration VARCHAR(100),        -- 配置
	serial_number VARCHAR(50),	  -- 序列号
	buy_time VARCHAR(20),		  -- 购买时间
	receice_time VARCHAR(20),  	  -- 领取时间
	p_status VARCHAR(11),			  -- 使用状态
	number VARCHAR(10),  	       	  -- 编号
	remark VARCHAR(100)		  -- 备注
	);
	
CREATE TABLE LOG(
	id INT PRIMARY KEY AUTO_INCREMENT,-- 主键
	create_time DATETIME,			  -- 创建时间
	operator VARCHAR(20),			  -- 操作人
	content TEXT(100),				  -- 修改内容
	remark TEXT(100)				  -- 备注
	);
