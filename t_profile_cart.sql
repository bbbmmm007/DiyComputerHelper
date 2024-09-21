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

 Date: 18/09/2024 17:30:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_profile_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_profile_cart`;
CREATE TABLE `t_profile_cart`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车数据id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `id` int(11) NOT NULL COMMENT '商品id',
  `child_id` int(11) NOT NULL COMMENT '子分类id',
  `ancestor_id` int(11) NOT NULL COMMENT '祖id',
  `ancestor_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '祖分类名称',
  `price` bigint(20) NULL DEFAULT NULL COMMENT '商品参考价',
  `item_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `created_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cid`, `ancestor_id`) USING BTREE,
  INDEX `fk_t_profile_cart_uid`(`uid`) USING BTREE,
  CONSTRAINT `fk_t_profile_cart_uid` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 136 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_profile_cart
-- ----------------------------
INSERT INTO `t_profile_cart` VALUES (105, 339, 100000465, 214, 2, '显卡', 8999, '4080supper', 'mm', 'bbbmmm', '2024-09-02 09:28:24', 'bbbmmm', '2024-09-02 09:28:24');
INSERT INTO `t_profile_cart` VALUES (106, 339, 100000478, 521, 5, '电源', 1099, '振华SFX1000W 金牌全模组电源', 'ss', 'bbbmmm', '2024-09-02 09:28:29', 'bbbmmm', '2024-09-02 09:28:29');
INSERT INTO `t_profile_cart` VALUES (107, 339, 100000484, 323, 3, '散热', 569, '瓦尔基里360水冷', 'ss', 'bbbmmm', '2024-09-02 09:28:32', 'bbbmmm', '2024-09-02 09:28:32');
INSERT INTO `t_profile_cart` VALUES (108, 339, 100000522, 122, 1, 'cpu', 2599, 'R7 7800X3D', 'bm', 'bbbmmm', '2024-09-02 09:28:55', 'bbbmmm', '2024-09-02 09:28:55');
INSERT INTO `t_profile_cart` VALUES (109, 339, 100001406, 611, 6, '内存', 600, '宏碁掠夺者DDR5 32*2 特调海力士A-DIE颗粒低时序', 'bm', 'bbbmmm', '2024-09-02 09:29:15', 'bbbmmm', '2024-09-02 09:29:15');
INSERT INTO `t_profile_cart` VALUES (110, 339, 100001448, 711, 7, '固态', 1520, '金士顿4T PCIe4.0 精选颗粒高速固态', 'bm', 'bbbmmm', '2024-09-02 09:29:23', 'bbbmmm', '2024-09-02 09:29:23');
INSERT INTO `t_profile_cart` VALUES (111, 339, 100001628, 822, 8, '机箱', 200, '先马机箱', 'bm', 'bbbmmm', '2024-09-02 09:29:32', 'bbbmmm', '2024-09-02 09:29:32');
INSERT INTO `t_profile_cart` VALUES (112, 339, 100000896, 431, 4, '主板', 2200, '华硕 Z790 D5 WiFi', 'bm', 'bbbmmm', '2024-09-02 09:29:47', 'bbbmmm', '2024-09-02 09:29:47');

SET FOREIGN_KEY_CHECKS = 1;
