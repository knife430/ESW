/*
Navicat MySQL Data Transfer

Source Server         : captain
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : esw

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-16 20:08:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `handler`
-- ----------------------------
DROP TABLE IF EXISTS `handler`;
CREATE TABLE `handler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of handler
-- ----------------------------
INSERT INTO `handler` VALUES ('1', 'mcz', '1');
INSERT INTO `handler` VALUES ('2', 'xjp', '2');
INSERT INTO `handler` VALUES ('3', 'ply', '3');
