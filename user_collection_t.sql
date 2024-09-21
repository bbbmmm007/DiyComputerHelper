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

 Date: 18/09/2024 17:30:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_collection_t
-- ----------------------------
DROP TABLE IF EXISTS `user_collection_t`;
CREATE TABLE `user_collection_t`  (
  `coid` int(20) NOT NULL AUTO_INCREMENT,
  `uid` int(20) NOT NULL,
  `id` int(20) NOT NULL,
  `child_id` int(11) NOT NULL,
  `item_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` bigint(20) NOT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`coid`) USING BTREE,
  INDEX `fk_user_collection_t_uid`(`uid`) USING BTREE,
  CONSTRAINT `fk_user_collection_t_uid` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collection_t
-- ----------------------------
INSERT INTO `user_collection_t` VALUES (34, 339, 100000466, 214, '4090', 14555, 'mm', '2024-09-02 09:28:16');
INSERT INTO `user_collection_t` VALUES (35, 339, 100000468, 214, '4060ti', 3200, 'mm', '2024-09-02 09:28:18');
INSERT INTO `user_collection_t` VALUES (36, 339, 100000465, 214, '4080supper', 8999, 'mm', '2024-09-02 09:28:20');
INSERT INTO `user_collection_t` VALUES (76, 341, 100000465, 214, '4080supper', 8899, 'mm', '2024-09-18 06:51:37');

SET FOREIGN_KEY_CHECKS = 1;
