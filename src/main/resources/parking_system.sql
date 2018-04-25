CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标记删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM parking_system.admin;

CREATE TABLE `charge_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(20) NOT NULL DEFAULT '' COMMENT '用户种类',
  `discount_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '折扣种类',
  `discount_info` varchar(20) NOT NULL DEFAULT '' COMMENT '折扣信息',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标记删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `car_id` varchar(20) NOT NULL DEFAULT '' COMMENT '车牌号',
  `parking_space_id` int(11) NOT NULL DEFAULT '0' COMMENT '车位号',
  `start_park_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进入停车场时间',
  `end_park_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '离开停车场时间',
  `fee` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '停车费用',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标记删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `parking_fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(11) NOT NULL DEFAULT '0' COMMENT '停车订单ID',
  `fee` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '停车费用',
  `pay_type` int(11) NOT NULL DEFAULT '0' COMMENT '支付方式',
  `charge_rule` int(11) NOT NULL DEFAULT '0' COMMENT '收费规则',
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `parking_space` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `station_type` varchar(20) DEFAULT '' COMMENT '车位种类',
  `station_area` varchar(30) NOT NULL DEFAULT '' COMMENT '车位区域',
  `station_no` int(11) NOT NULL DEFAULT '0' COMMENT '车位编号',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标记删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `index_area_no` (`station_area`,`station_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `count_fee` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
  `car_id` varchar(20) NOT NULL DEFAULT '' COMMENT '车牌号',
  `phone` varchar(13) NOT NULL DEFAULT '' COMMENT '电话号',
  `user_type` varchar(20) NOT NULL DEFAULT '' COMMENT '用户种类',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标记删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `index_car_id` (`car_id`),
  KEY `index_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





