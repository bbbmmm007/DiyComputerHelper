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

 Date: 18/09/2024 17:30:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `gender` int(11) NULL DEFAULT NULL COMMENT '性别:0-女，1-男',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `is_delete` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '是否被删除1是0否',
  `created_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '日志-最后修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 342 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (339, 'bbbmmm', '1CC6FF01839E621279DFE7ED3EFA4C84', 'FB30BDF5-4767-422C-97D7-B83EB249F3A4', NULL, NULL, NULL, '0', 'bbbmmm', '2024-09-02 02:53:55', 'bbbmmm', '2024-09-02 02:53:55');
INSERT INTO `t_user` VALUES (340, 'zhny', '055F4639A4542811E47A70A8CA895425', 'CCA32A20-69C8-46AC-A6D5-490371111C6B', NULL, NULL, NULL, '0', 'zhny', '2024-09-02 02:54:16', 'zhny', '2024-09-02 02:54:16');
INSERT INTO `t_user` VALUES (341, 'bm', '174283A2F43C36207CE72B89EE9930C0', 'F9FCA25B-FFC6-420E-ACC9-BE1FA7395592', NULL, NULL, NULL, '0', 'bm', '2024-09-02 02:54:28', 'bm', '2024-09-02 02:54:28');

SET FOREIGN_KEY_CHECKS = 1;
