/*
Navicat MySQL Data Transfer

Source Server         : captain
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : esw

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-27 13:00:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `submitter`
-- ----------------------------
DROP TABLE IF EXISTS `submitter`;
CREATE TABLE `submitter` (
  `rank` int(5) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submitter
-- ----------------------------

INSERT INTO `submitter` VALUES ('1', 'mcz');
