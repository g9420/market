# Host: localhost  (Version 5.7.20-log)
# Date: 2020-07-27 13:48:56
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "tb_banner"
#

CREATE TABLE `tb_banner` (
  `IMG_ID` bigint(20) NOT NULL,
  `IMG_NAME` varchar(255) NOT NULL,
  `IMG_INFO` varchar(255) NOT NULL,
  `IMG_URL` varchar(255) NOT NULL,
  `IMG_STATE` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`IMG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_category"
#

CREATE TABLE `tb_category` (
  `CATE_ID` bigint(20) NOT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `CATE_NAME` varchar(255) NOT NULL,
  `ORDER_NUM` bigint(20) NOT NULL,
  `CREATE_TIME` bigint(20) NOT NULL,
  `MODIFY_TIME` bigint(20) NOT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_collection"
#

CREATE TABLE `tb_collection` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_uid` int(11) NOT NULL DEFAULT '0',
  `_gid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "tb_discuss"
#

CREATE TABLE `tb_discuss` (
  `DISCUSS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DISCUSS_DESC` varchar(255) NOT NULL,
  `DISCUSS_TIME` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `STUFF_ID` bigint(20) NOT NULL,
  `RECEIVE_DISCUSS_ID` bigint(20) DEFAULT '0',
  PRIMARY KEY (`DISCUSS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_file_type"
#

CREATE TABLE `tb_file_type` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_name` varchar(255) NOT NULL DEFAULT 'null',
  `_active` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "tb_file_form"
#

CREATE TABLE `tb_file_form` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_file_name` varchar(255) NOT NULL DEFAULT 'null',
  `_url` varchar(255) NOT NULL DEFAULT 'null',
  `_type_id` int(11) NOT NULL DEFAULT '0',
  `_table` varchar(255) NOT NULL DEFAULT 'null',
  `_table_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_id`),
  KEY `_type_id` (`_type_id`),
  CONSTRAINT `tb_file_form_ibfk_1` FOREIGN KEY (`_type_id`) REFERENCES `tb_file_type` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for table "tb_footprint"
#

CREATE TABLE `tb_footprint` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `sid` int(11) NOT NULL DEFAULT '0',
  `time` bigint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_news"
#

CREATE TABLE `tb_news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `disscuss_id` int(11) NOT NULL DEFAULT '0',
  `uid` int(11) NOT NULL DEFAULT '0',
  `active` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_session"
#

CREATE TABLE `tb_session` (
  `_id` varchar(255) NOT NULL DEFAULT 'null',
  `_session_key` varchar(255) NOT NULL DEFAULT 'null',
  `_token` varchar(255) NOT NULL DEFAULT 'null',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "tb_stuff"
#

CREATE TABLE `tb_stuff` (
  `STUFF_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STUFF_NAME` varchar(255) NOT NULL,
  `STUFF_INFO` varchar(255) NOT NULL DEFAULT '',
  `STUFF_PRICE` double NOT NULL DEFAULT '0',
  `STUFF_ACTIVE` int(11) NOT NULL DEFAULT '0',
  `USER_ID` bigint(20) NOT NULL,
  `CATE_ID` bigint(20) NOT NULL,
  `CREATE_TIME` bigint(20) NOT NULL,
  `MODIFY_TIME` bigint(20) DEFAULT '0',
  `page_view` int(11) unsigned DEFAULT '0' COMMENT '点击数',
  PRIMARY KEY (`STUFF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for table "tb_user"
#

CREATE TABLE `tb_user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_openid` varchar(255) NOT NULL DEFAULT 'null',
  `_nickName` varchar(255) NOT NULL DEFAULT '',
  `_address` varchar(255) NOT NULL DEFAULT 'null',
  `_school` varchar(255) NOT NULL DEFAULT 'null',
  `_phone` varchar(255) NOT NULL DEFAULT 'null',
  `_gender` int(11) NOT NULL DEFAULT '0',
  `_city` varchar(255) NOT NULL DEFAULT 'null',
  `_province` varchar(255) NOT NULL DEFAULT 'null',
  `_country` varchar(255) NOT NULL DEFAULT 'null',
  `_avatarUrl` varchar(255) NOT NULL DEFAULT 'null',
  `_true_name` varchar(255) NOT NULL DEFAULT 'null',
  `_qq` varchar(255) NOT NULL DEFAULT 'null',
  `_wechat` varchar(255) NOT NULL DEFAULT 'null',
  `_active` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for table "tb_version"
#

CREATE TABLE `tb_version` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
