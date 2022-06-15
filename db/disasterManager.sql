DROP DATABASE IF EXISTS `disasterManager`;

CREATE DATABASE `disasterManager`;

USE `disasterManager`;

# 地理
CREATE TABLE addr( 
	`addr_code` CHAR(12) PRIMARY KEY,
	`name` VARCHAR(20) NOT NULL,
	`type` VARCHAR(10) NOT NULL
);

# 来源 大类
CREATE TABLE source_type( 
	`st_code` CHAR(1) PRIMARY KEY,
	`name` VARCHAR(10) NOT NULL
);

# 来源 子类
CREATE TABLE source_subtype(
	`st_code` CHAR(1), 
	`ss_code` CHAR(2),
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY(`st_code`, `ss_code`),
	FOREIGN KEY(`st_code`) REFERENCES source_type(`st_code`)
);

# 载体
CREATE TABLE carrier(
	`carrier_code` CHAR(1) PRIMARY KEY, 
	`name` VARCHAR(5) NOT NULL
);

# 灾情 大类
CREATE TABLE disaster_type( 
	`dt_code` CHAR(1) PRIMARY KEY,
	`name` VARCHAR(10) NOT NULL
);

# 灾情 子类
CREATE TABLE disaster_subtype(
	`dt_code` CHAR(1), 
	`ds_code` CHAR(2),
	`name` VARCHAR(5) NOT NULL,
	PRIMARY KEY(`dt_code`, `ds_code`),
	FOREIGN KEY(`dt_code`) REFERENCES disaster_type(`dt_code`)
);

# 灾情 指标
CREATE TABLE disaster_index(
	`dt_code` CHAR(1), 
	`di_code` CHAR(3),
	`name` VARCHAR(10) NOT NULL,
	PRIMARY KEY(`dt_code`, `di_code`),
	FOREIGN KEY(`dt_code`) REFERENCES disaster_type(`dt_code`)
);

# 灾情
CREATE TABLE disaster( 
	province VARCHAR(20) NOT NULL,		# 省
	city VARCHAR(20) NOT NULL,		# 市
	district VARCHAR(20) NOT NULL,		# 区
	street VARCHAR(20) NOT NULL,		# 街道
	community VARCHAR(20) NOT NULL,		# 居委会
	gmt_time DATETIME NOT NULL,
	source_type VARCHAR(10) NOT NULL,
	source_subtype VARCHAR(20) NOT NULL,
	carrier VARCHAR(5) NOT NULL, 		# 载体
	disaster_type VARCHAR(10) NOT NULL,
	disaster_subtype VARCHAR(5) NOT NULL,
	disaster_index VARCHAR(10) NOT NULL
); 