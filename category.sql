/*
 Navicat Premium Dump SQL

 Source Server         : bbbmmm
 Source Server Type    : MySQL
 Source Server Version : 50725 (5.7.25)
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 50725 (5.7.25)
 File Encoding         : 65001

 Date: 18/09/2024 17:29:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类号id',
  `ancestor_id` int(11) NULL DEFAULT NULL COMMENT '主类id',
  `ancestor_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父类id',
  `parent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `child_id` int(11) NULL DEFAULT NULL COMMENT '子类id',
  `child_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 1, 'cpu', 11, 'Intel', 111, '十二代');
INSERT INTO `category` VALUES (2, 1, 'cpu', 11, 'Intel', 112, '十三代');
INSERT INTO `category` VALUES (3, 1, 'cpu', 11, 'Intel', 113, '十四代');
INSERT INTO `category` VALUES (4, 1, 'cpu', 12, 'AMD', 121, '5000系');
INSERT INTO `category` VALUES (5, 1, 'cpu', 12, 'AMD', 122, '7000系');
INSERT INTO `category` VALUES (6, 1, 'cpu', 12, 'AMD', 123, '9000系');
INSERT INTO `category` VALUES (7, 2, '显卡', 21, 'NVIDIA', 211, '10系');
INSERT INTO `category` VALUES (8, 2, '显卡', 21, 'NVIDIA', 212, '20系');
INSERT INTO `category` VALUES (9, 2, '显卡', 21, 'NVIDIA', 213, '30系');
INSERT INTO `category` VALUES (10, 2, '显卡', 21, 'NVIDIA', 214, '40系');
INSERT INTO `category` VALUES (11, 2, '显卡', 22, 'AMD', 221, '5000系');
INSERT INTO `category` VALUES (12, 2, '显卡', 22, 'AMD', 222, '6000系');
INSERT INTO `category` VALUES (13, 2, '显卡', 22, 'AMD', 223, '7000系');
INSERT INTO `category` VALUES (14, 3, '散热', 31, '风冷', 311, '单塔');
INSERT INTO `category` VALUES (15, 3, '散热', 31, '风冷', 312, '双塔');
INSERT INTO `category` VALUES (16, 3, '散热', 32, '水冷', 321, '120');
INSERT INTO `category` VALUES (17, 3, '散热', 32, '水冷', 322, '240');
INSERT INTO `category` VALUES (18, 3, '散热', 32, '水冷', 323, '360');
INSERT INTO `category` VALUES (19, 4, '主板', 41, 'D4', 411, '入门级');
INSERT INTO `category` VALUES (20, 4, '主板', 41, 'D4', 412, '中端级');
INSERT INTO `category` VALUES (21, 4, '主板', 42, 'D5', 421, '入门级');
INSERT INTO `category` VALUES (22, 4, '主板', 42, 'D5', 422, '中端级');
INSERT INTO `category` VALUES (25, 5, '电源', 51, '全模组', 511, '金牌');
INSERT INTO `category` VALUES (26, 5, '电源', 51, '全模组', 512, '铜牌');
INSERT INTO `category` VALUES (27, 5, '电源', 52, '非全模组', 521, '金牌');
INSERT INTO `category` VALUES (28, 5, '电源', 52, '非全模组', 522, '铜牌');
INSERT INTO `category` VALUES (29, 6, '内存', 61, 'DDR4', 611, '特调颗粒');
INSERT INTO `category` VALUES (30, 6, '内存', 61, 'DDR4', 612, '非特调颗粒');
INSERT INTO `category` VALUES (31, 6, '内存', 62, 'DDR5', 621, '特调颗粒');
INSERT INTO `category` VALUES (32, 6, '内存', 62, 'DDR5', 622, '非特调颗粒');
INSERT INTO `category` VALUES (33, 7, '固态', 71, 'PICE4.0', 711, '精选颗粒');
INSERT INTO `category` VALUES (34, 7, '固态', 71, 'PICE4.0', 712, '非精选颗粒');
INSERT INTO `category` VALUES (35, 7, '固态', 72, 'PICE3.0', 721, '精选颗粒');
INSERT INTO `category` VALUES (36, 7, '固态', 72, 'PICE3.0', 722, '非精选颗粒');
INSERT INTO `category` VALUES (37, 8, '机箱', 81, '普通机箱', 811, '海景房');
INSERT INTO `category` VALUES (38, 8, '机箱', 81, '普通机箱', 812, '非海景房');
INSERT INTO `category` VALUES (39, 8, '机箱', 82, '高端定制', 821, '海景房');
INSERT INTO `category` VALUES (40, 8, '机箱', 82, '高端定制', 822, '非海景房');
INSERT INTO `category` VALUES (41, 4, '主板', 41, 'D4', 413, '高端定制');
INSERT INTO `category` VALUES (42, 4, '主板', 42, 'D5', 423, '高端定制');

SET FOREIGN_KEY_CHECKS = 1;
