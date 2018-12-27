/*
Navicat MySQL Data Transfer

Source Server         : captain
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : esw

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-27 13:00:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mail`
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` int(5) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `state` int(20) DEFAULT NULL,
  `time` timestamp(4) NULL DEFAULT NULL,
  `rank` int(5) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail
-- ----------------------------

INSERT INTO `mail` VALUES ('8', 'mcz', '1', '00638261999', '1', '2018-12-25 17:39:00.0000', '1');
