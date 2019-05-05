/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bid-system

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/05/2019 11:28:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mark_seekcar
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_seekcar`;
CREATE TABLE `t_mark_seekcar`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开标找车编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `project_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '项目编号',
  `start_city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '出发城市',
  `start_addr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '出发地点',
  `end_city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '目的地城市',
  `end_addr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '目的地',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '出发时间',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '联系人姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '联系人电话',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开标找车表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
