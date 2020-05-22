/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : whsxy

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 09/06/2019 14:19:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `location` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '可可', 21, '0724', '武汉');
INSERT INTO `user` VALUES (2, '小可', 18, '1090', '北京');
INSERT INTO `user` VALUES (3, '小米', 16, '1098', '上海');
INSERT INTO `user` VALUES (4, '苹果', 17, '1224', '广州');
INSERT INTO `user` VALUES (5, '可可', 18, '0724', '武汉');
INSERT INTO `user` VALUES (6, '文文', 22, '0526', '鄂州');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
