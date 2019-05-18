/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : jx-bid-system

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 19/04/2019 15:19:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_guarantee
-- ----------------------------
DROP TABLE IF EXISTS `t_guarantee`;
CREATE TABLE `t_guarantee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '保函编号',
  `project_id` bigint(20) DEFAULT '0' COMMENT '项目编号',
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户编号',
  `project_name` varchar(100) DEFAULT '' COMMENT '项目名称',
  `open_mark_time` datetime DEFAULT NULL COMMENT '开标时间',
  `mark_unit_name` varchar(32) DEFAULT '' COMMENT '招标单位名称',
  `construction_period` int(10) DEFAULT '0' COMMENT '工期(天)',
  `assure_price` bigint(20) DEFAULT '0' COMMENT '担保金额(万元)',
  `guarantee_comp` varchar(32) DEFAULT '' COMMENT '担保公司',
  `guarantee_price` bigint(20) DEFAULT '0' COMMENT '保函费(元)',
  `applicant` varchar(20) DEFAULT '' COMMENT '申请人',
  `name` varchar(20) DEFAULT '' COMMENT '联系人',
  `phone` varchar(15) DEFAULT '' COMMENT '手机号',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '申请保函表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for t_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_account_detail`;
CREATE TABLE `t_account_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账目编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NULL DEFAULT NULL COMMENT '金额',
  `integral` bigint(20) NULL DEFAULT NULL COMMENT '积分',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '收入或支出',
  `sub_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收支类型',
  `pay_type` tinyint(4) NULL DEFAULT NULL COMMENT '支付方式',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户账目明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_achievement`;
CREATE TABLE `t_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业绩编号',
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户编号',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'URL链接',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '我的业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_advertisement
-- ----------------------------
DROP TABLE IF EXISTS `t_advertisement`;
CREATE TABLE `t_advertisement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '轮播广告编号',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '轮播图标题',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '内容',
  `img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '图片地址',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'URL链接',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '轮播广告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_aptitude_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_aptitude_resource`;
CREATE TABLE `t_aptitude_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资质资源编号',
  `aptitude_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '资质编号',
  `resource_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '资源编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资质资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_aptitude_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_aptitude_transfer`;
CREATE TABLE `t_aptitude_transfer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资质转让编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '转让类别',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '项目名称',
  `comp_aptitude_level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '企业资质等级',
  `comp_aptitude_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '企业资质类型',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '联系电话',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资质转让表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `category_id` bigint(20) NOT NULL COMMENT '类别编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `cover_img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图片',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章内容',
  `view_count` int(11) NULL DEFAULT 0 COMMENT '阅读量',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人编号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article_category
-- ----------------------------
DROP TABLE IF EXISTS `t_article_category`;
CREATE TABLE `t_article_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 1 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_article_comment`;
CREATE TABLE `t_article_comment`  (
  `id` bigint(20) NOT NULL COMMENT '评论编号',
  `article_id` bigint(20) NOT NULL COMMENT '文章编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论标题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论详情',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 1 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_builder
-- ----------------------------
DROP TABLE IF EXISTS `t_builder`;
CREATE TABLE `t_builder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建造师编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `gender` tinyint(4) NULL DEFAULT 0 COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生年份',
  `certificate_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '证件地址',
  `certificate_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '证书类别',
  `certificate_major_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '证书专业类型',
  `certificate_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '证书状态',
  `certificate_reg_status` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '初始' COMMENT '注册状态',
  `salary` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '期望年薪',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '说明',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '建造师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_builder_req
-- ----------------------------
DROP TABLE IF EXISTS `t_builder_req`;
CREATE TABLE `t_builder_req`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建造师需求编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '说明',
  `people` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '所需人才',
  `people_count` int(10) NULL DEFAULT 0 COMMENT '所需人数',
  `salary` bigint(20) NULL DEFAULT 0 COMMENT '提供年薪',
  `comp_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '企业地址',
  `comp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '企业名称',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '建造师需求表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_builder_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_builder_resource`;
CREATE TABLE `t_builder_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建造师资源编号',
  `builder_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '建造师编号',
  `resource_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '资源编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '建造师资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_aptitude
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_aptitude`;
CREATE TABLE `t_comp_aptitude`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业资质编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `certificate_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '证件号码',
  `certificate_detail` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资质详情',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业资质表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_builder
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_builder`;
CREATE TABLE `t_comp_builder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业建造师编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `gender` tinyint(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 0 COMMENT '性别',
  `reg_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '注册证件号码',
  `major_level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '专业等级',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业建造师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_house_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_house_achievement`;
CREATE TABLE `t_comp_house_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业房建业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程名称',
  `builder_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '注册建造师',
  `mark_money` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '中标金额',
  `build_scale` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '建设规模',
  `region_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目所属地区归类',
  `build_comp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '建设单位',
  `project_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程地址',
  `contract_date` date NULL DEFAULT NULL COMMENT '合同签订日期',
  `mark_date` date NULL DEFAULT NULL COMMENT '中标日期',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目负责人',
  `certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目负责人证书号',
  `constructors` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '施工员',
  `constructors_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '施工员证书号',
  `constructors_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '施工员身份证号',
  `quality_worker` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '质量员',
  `quality_worker_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '质量员证书号',
  `quality_worker_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '质量员身份证号',
  `security_officer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '安全员',
  `security_officer_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '安全员证书号',
  `security_officer_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '安全员身份证号',
  `standard_worker` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标准员',
  `standard_worker_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标准员证书号',
  `standard_worker_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标准员身份证号',
  `material_man` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '材料员',
  `material_man_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '材料员证书号',
  `material_man_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '材料员身份证号',
  `mechanic` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '机械员',
  `mechanic_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '机械员证书号',
  `mechanic_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '机械员身份证号',
  `labors` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '劳务员',
  `labors_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '劳务员证书号',
  `labors_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '劳务员身份证号',
  `data_clerk` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资料员',
  `data_clerk_certificate_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资料员证书号',
  `data_clerk_id_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资料员身份证号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业房建业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_key_project_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_key_project_achievement`;
CREATE TABLE `t_comp_key_project_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业重点工程业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程名称',
  `build_comp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '建设单位',
  `mark_money` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '中标金额',
  `start_date` date NULL DEFAULT NULL COMMENT '开工时间',
  `end_date` date NULL DEFAULT NULL COMMENT '竣工时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业重点工程业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_personnel
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_personnel`;
CREATE TABLE `t_comp_personnel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业人员编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `job_title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '职称',
  `job_detail` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '职业资格及专业',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_traffic_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_traffic_achievement`;
CREATE TABLE `t_comp_traffic_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业交通业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程名称',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目负责人',
  `technology_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '技术负责人',
  `contract_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '合同金额',
  `work_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程地点',
  `start_date` date NULL DEFAULT NULL COMMENT '开工时间',
  `end_date` date NULL DEFAULT NULL COMMENT '竣工时间',
  `valid_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '验证状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业交通业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_water_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_water_achievement`;
CREATE TABLE `t_comp_water_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业水利业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程名称',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目负责人',
  `contract_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '合同金额',
  `start_date` date NULL DEFAULT NULL COMMENT '开工时间',
  `end_date` date NULL DEFAULT NULL COMMENT '竣工时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业水利业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_water_devise_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_water_devise_achievement`;
CREATE TABLE `t_comp_water_devise_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业水利勘查设计业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标段(包)名称',
  `tendering_comp` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目类型',
  `build_comp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '招标(单位)人',
  `mark_date` date NULL DEFAULT NULL COMMENT '中标时间',
  `contract_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '合同金额',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目负责人',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业水利勘查设计业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comp_water_monitor_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_comp_water_monitor_achievement`;
CREATE TABLE `t_comp_water_monitor_achievement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业水利监理业绩编号',
  `comp_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '企业编号',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工程名称',
  `project_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目类型',
  `build_comp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '建设单位',
  `contract_amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '合同金额',
  `contract_date` date NULL DEFAULT NULL COMMENT '合同签订日期',
  `start_date` date NULL DEFAULT NULL COMMENT '开工时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业水利监理业绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业编号',
  `jurisdiction_type` tinyint(4) NULL DEFAULT 0 COMMENT '辖区类别',
  `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '市区',
  `comp_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '企业类型',
  `industry_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '行业分类',
  `comp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '企业名称',
  `legal_person` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '法人',
  `legal_person_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '法人电话',
  `reg_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '注册地区',
  `responsible` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '负责人',
  `responsible_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '负责人电话',
  `comp_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '单位电话',
  `comp_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '联系地址',
  `reg_capital` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '注册资本',
  `business_scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '经营范围',
  `affordable_business` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '可承担业务',
  `source_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '源地址',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_consult
-- ----------------------------
DROP TABLE IF EXISTS `t_consult`;
CREATE TABLE `t_consult`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '咨询编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `question_type_id` bigint(20) NULL DEFAULT 0 COMMENT '问题类别编号',
  `consult_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '问题说明',
  `reply_user_id` bigint(20) NULL DEFAULT 0 COMMENT '回复人编号',
  `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '回复内容',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '咨询表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抵扣券编号',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '抵用券类别',
  `money` bigint(10) NULL DEFAULT 0 COMMENT '金额',
  `coupon_count` int(10) NULL DEFAULT 0 COMMENT '数量',
  `valid_time` date NULL DEFAULT NULL COMMENT '有效期至',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '抵扣券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_coupon_record
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon_record`;
CREATE TABLE `t_coupon_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抵扣券使用记录编号',
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户编号',
  `coupon_id` bigint(20) NULL DEFAULT 0 COMMENT '抵扣券编号',
  `old_price` bigint(10) NULL DEFAULT 0 COMMENT '原价',
  `coupon_price` bigint(10) NULL DEFAULT 0 COMMENT '优惠价',
  `price` bigint(10) NULL DEFAULT 0 COMMENT '价格',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '抵扣券使用记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_expert_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_subscribe`;
CREATE TABLE `t_expert_subscribe`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专家预约编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `expert_user_id` bigint(20) NULL DEFAULT 0 COMMENT '预约专家编号',
  `question_type_id` bigint(20) NULL DEFAULT 0 COMMENT '问题类别编号',
  `question_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '问题说明',
  `reply_user_id` bigint(20) NULL DEFAULT 0 COMMENT '回复用户编号',
  `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '回复内容',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `subscribe_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '未处理' COMMENT '预约状态',
  `price` bigint(10) NULL DEFAULT 0 COMMENT '预约价格',
  `pay_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '待支付' COMMENT '支付状态',
  `pay_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '微信' COMMENT '支付方式',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专家预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_expert_question_type
-- ----------------------------
DROP TABLE IF EXISTS `t_expert_question_type`;
CREATE TABLE `t_expert_question_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专家问题分类编号',
  `name` varchar(30) DEFAULT '' COMMENT '类别名称',
  `memo` varchar(200) DEFAULT '' COMMENT '备注',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='专家问题分类表';

-- ----------------------------
-- Records of t_expert_question_type
-- ----------------------------
BEGIN;
INSERT INTO `t_expert_question_type` VALUES (1, '系统注册登录', '系统注册登录', 1, '2019-05-08 17:30:24', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (2, 'CA锁办理及绑定激活', 'CA锁办理及绑定激活', 1, '2019-05-08 17:30:53', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (3, '招标文件制作', '招标文件制作', 1, '2019-05-08 17:30:57', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (4, '投标文件制作', '投标文件制作', 1, '2019-05-08 17:31:05', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (5, '工程量清单编制', '工程量清单编制', 1, '2019-05-08 17:31:14', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (6, '工程造价', '工程造价', 1, '2019-05-08 17:31:22', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (7, '电子虚拟保证金缴纳', '电子虚拟保证金缴纳', 1, '2019-05-08 17:31:30', NULL, 0);
INSERT INTO `t_expert_question_type` VALUES (8, '其他', '其他', 1, '2019-05-08 17:31:36', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_frezee
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_frezee`;
CREATE TABLE `t_funds_frezee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '冻结编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `frezee_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `frezee_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金冻结与解冻记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_recharge
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_recharge`;
CREATE TABLE `t_funds_recharge`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '充值金额',
  `recharge_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值类型',
  `is_success` tinyint(4) NULL DEFAULT 0 COMMENT '是否成功',
  `out_trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付系统订单号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金充值记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_transfer`;
CREATE TABLE `t_funds_transfer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转账编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `from_user_id` bigint(20) NULL DEFAULT NULL COMMENT 'FROM',
  `to_user_id` bigint(20) NULL DEFAULT NULL COMMENT 'TO',
  `transfer_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `transfer_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金转入与转出记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw`;
CREATE TABLE `t_funds_withdraw`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `amount` bigint(20) NOT NULL COMMENT '提现金额',
  `bankcard_id` bigint(20) NOT NULL COMMENT '提现银行卡',
  `withdraw_status` tinyint(4) NULL DEFAULT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) NULL DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `complete_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金提现记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_withdraw_check
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw_check`;
CREATE TABLE `t_funds_withdraw_check`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现审核编号',
  `withdraw_id` bigint(20) NOT NULL COMMENT '提现编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `withdraw_status` tinyint(4) NOT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) NOT NULL COMMENT '审核人编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金提现审核历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute`;
CREATE TABLE `t_goods_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性编号',
  `attr_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `attr_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性代码',
  `attr_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据类型',
  `attr_length` int(11) NOT NULL COMMENT '数据长度',
  `attr_required` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否必填',
  `attr_display` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否前端显示',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_value`;
CREATE TABLE `t_goods_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性值编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU属性及属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车信息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类目描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category_attribute`;
CREATE TABLE `t_goods_category_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目属性编号',
  `category_id` bigint(20) NOT NULL COMMENT '商品类目编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_order` int(11) NOT NULL DEFAULT 1000 COMMENT '属性排序',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类目属性信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment`;
CREATE TABLE `t_goods_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品评论编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `comments` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论详情',
  `append_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '追加评论',
  `reply` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复详情',
  `stick_status` tinyint(4) NULL DEFAULT 0 COMMENT '置顶状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_comment_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment_pic`;
CREATE TABLE `t_goods_comment_pic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论图片编号',
  `comment_id` bigint(20) NOT NULL COMMENT '评论编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论图片表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_coupon`;
CREATE TABLE `t_goods_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠券编号',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品类目编号',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品SKU编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '优惠券标题',
  `use_min_amount` bigint(20) NULL DEFAULT NULL COMMENT '最小消费金额',
  `discount_amount` bigint(20) NULL DEFAULT NULL COMMENT '满减优惠金额',
  `discount_percent` double(3, 0) NULL DEFAULT NULL COMMENT '满减折扣',
  `integral_amount` int(11) NULL DEFAULT NULL COMMENT '赠送积分',
  `total_count` int(11) NOT NULL COMMENT '优惠券总量',
  `coupon_usable_range` tinyint(4) NOT NULL COMMENT '优惠券使用范围',
  `coupon_type` tinyint(4) NOT NULL COMMENT '优惠券类型',
  `start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `due_time` datetime(0) NULL DEFAULT NULL COMMENT '到期时间',
  `valid_days` int(11) NULL DEFAULT NULL COMMENT '有效时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品优惠券信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_info`;
CREATE TABLE `t_goods_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图文详情',
  `shelf_status` tinyint(4) NULL DEFAULT 0 COMMENT '上架状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品记录表，包含多个商品SKU' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order`;
CREATE TABLE `t_goods_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `total_amount` bigint(20) NOT NULL COMMENT '订单金额',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '赠送积分',
  `express_fee` bigint(20) NULL DEFAULT 0 COMMENT '运费',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` tinyint(4) NULL DEFAULT NULL COMMENT '支付方式',
  `transaction_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付订单号',
  `pay_success` tinyint(4) NULL DEFAULT NULL COMMENT '是否支付成功',
  `deliver_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `deal_time` datetime(0) NULL DEFAULT NULL COMMENT '成交时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表，一个订单包含多个订单条目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_coupon`;
CREATE TABLE `t_goods_order_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用券编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单优惠券使用记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_item`;
CREATE TABLE `t_goods_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `sku_pic_id` bigint(20) NOT NULL COMMENT 'SKU图片编号',
  `sku_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '售卖标题',
  `sku_info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SKU属性JSON',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '赠送积分',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单详情信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_logistics
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_logistics`;
CREATE TABLE `t_goods_order_logistics`  (
  `id` bigint(20) NOT NULL COMMENT '订单编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_deliver` tinyint(4) NULL DEFAULT 0 COMMENT '是否已发货',
  `logistics_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流公司名称',
  `logistics_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流公司编码',
  `logistics_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单物流信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_pic`;
CREATE TABLE `t_goods_pic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品图片编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `pic_order` int(11) NULL DEFAULT 1000 COMMENT '图片顺序',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品图片信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop`;
CREATE TABLE `t_goods_shop`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `subject_type` tinyint(4) NOT NULL COMMENT '主体类型',
  `logo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺Logo',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺标题',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺简介',
  `level` tinyint(4) NULL DEFAULT 1 COMMENT '店铺等级',
  `check_status` tinyint(4) NULL DEFAULT 0 COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) NULL DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_certification`;
CREATE TABLE `t_goods_shop_certification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺认证编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `detail` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '认证详情JSON',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺认证信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop_check
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_check`;
CREATE TABLE `t_goods_shop_check`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺审核编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `check_status` tinyint(4) NULL DEFAULT 0 COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) NULL DEFAULT NULL COMMENT '审核人编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺审核历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'SKU编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `pic_id` bigint(20) NULL DEFAULT NULL COMMENT '商品图片编号',
  `shelf_status` tinyint(4) NULL DEFAULT 0 COMMENT '上架状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_user_coupon`;
CREATE TABLE `t_goods_user_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `coupon_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '优惠券状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品优惠券用户领券信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_headlines
-- ----------------------------
DROP TABLE IF EXISTS `t_headlines`;
CREATE TABLE `t_headlines`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '头条编号',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '内容',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '头条表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_mark_carpool
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_carpool`;
CREATE TABLE `t_mark_carpool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开标拼车编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `project_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '项目编号',
  `start_city` varchar(20) DEFAULT '' COMMENT '出发城市',
  `start_addr` varchar(20) DEFAULT '' COMMENT '出发地点',
  `end_city` varchar(20) DEFAULT NULL COMMENT '目的地城市',
  `end_addr` varchar(10) DEFAULT '' COMMENT '目的地',
  `start_time` datetime DEFAULT NULL COMMENT '出发时间',
  `car_type` varchar(10) DEFAULT '' COMMENT '汽车类型',
  `people_count` int(2) DEFAULT '0' COMMENT '搭载人数',
  `record_count` int(2) DEFAULT '0' COMMENT '申请人数',
  `price` bigint(20) DEFAULT '0' COMMENT '价格',
  `name` varchar(10) DEFAULT '' COMMENT '联系人姓名',
  `phone` varchar(11) DEFAULT '' COMMENT '联系人电话',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开标拼车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_mark_carpool_record
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_carpool_record`;
CREATE TABLE `t_mark_carpool_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '拼车记录编号',
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户编号',
  `mark_carpool_id` bigint(20) DEFAULT NULL COMMENT '拼车编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开标拼车申请记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_mark_seekcar
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_seekcar`;
CREATE TABLE `t_mark_seekcar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开标找车编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `project_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '项目编号',
  `start_city` varchar(20) DEFAULT '' COMMENT '出发城市',
  `start_addr` varchar(20) DEFAULT '' COMMENT '出发地点',
  `end_city` varchar(20) DEFAULT NULL COMMENT '目的地城市',
  `end_addr` varchar(10) DEFAULT '' COMMENT '目的地',
  `start_time` datetime DEFAULT NULL COMMENT '出发时间',
  `name` varchar(10) DEFAULT '' COMMENT '联系人姓名',
  `phone` varchar(11) DEFAULT '' COMMENT '联系人电话',
  `memo` varchar(255) DEFAULT '' COMMENT '备注',
  `record_count` int(2) DEFAULT '0' COMMENT '申请人数',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开标找车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_mark_seekcar_record
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_seekcar_record`;
CREATE TABLE `t_mark_seekcar_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '拼车记录编号',
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户编号',
  `mark_seekcar_id` bigint(20) DEFAULT NULL COMMENT '找车编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开标找车申请记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
  `message_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息类型',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '截止时间',
  `stick_status` tinyint(4) NULL DEFAULT 0 COMMENT '置顶状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_often_question
-- ----------------------------
DROP TABLE IF EXISTS `t_often_question`;
CREATE TABLE `t_often_question`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '常见问题编号',
  `question_type_id` bigint(20) DEFAULT NULL COMMENT '问题类别编号',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '问题标题',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '问题解答',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '常见问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '组织名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '组织或部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `module_id` bigint(20) NOT NULL COMMENT '所属模块',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标题',
  `permission` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 261 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_process
-- ----------------------------
DROP TABLE IF EXISTS `t_process`;
CREATE TABLE `t_process`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程编号',
  `process_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程Name',
  `process_key` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程Key',
  `file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程文件路径',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程描述',
  `is_deploy` tinyint(4) NULL DEFAULT 0 COMMENT '是否部署',
  `deploy_time` datetime(0) NULL DEFAULT NULL COMMENT '部署时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '招投标项目编号',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '项目名称',
  `project_type` varchar(10) DEFAULT '' COMMENT '项目类型',
  `city` varchar(10) DEFAULT '' COMMENT '城市',
  `project_detail` text COMMENT '项目详情',
  `release_status` varchar(10) DEFAULT '待审核' COMMENT '发布状态',
  `mark_unit_name` varchar(32) DEFAULT '' COMMENT '招标单位名称',
  `project_invest` varchar(20) DEFAULT '' COMMENT '项目投资',
  `check_pattern` varchar(20) DEFAULT '' COMMENT '审查方式',
  `comp_aptitude_type` varchar(200) DEFAULT '' COMMENT '企业资质类型',
  `builder_level` varchar(200) DEFAULT '' COMMENT '建造师等级',
  `money_to_implement` float(5,2) DEFAULT NULL COMMENT '资金落实(%)',
  `tendering_agent` varchar(20) DEFAULT '' COMMENT '招标代理',
  `phone` varchar(15) DEFAULT '' COMMENT '联系电话',
  `offer_price` bigint(20) DEFAULT '0' COMMENT '要约价(元)',
  `assure_price` bigint(20) DEFAULT '0' COMMENT '保证金(万元)',
  `construction_period` int(10) DEFAULT '0' COMMENT '工期(天)',
  `download_end_time` datetime DEFAULT NULL COMMENT '下载截止时间',
  `other_demand` varchar(500) DEFAULT '' COMMENT '其他要求',
  `open_mark_info` varchar(10) DEFAULT '' COMMENT '开标信息',
  `open_mark_time` datetime DEFAULT NULL COMMENT '开标时间',
  `open_mark_addr` varchar(32) DEFAULT '' COMMENT '开标地点',
  `mark_status` varchar(10) DEFAULT '' COMMENT '开标状态',
  `in_mark_comp` varchar(32) DEFAULT '' COMMENT '中标单位',
  `notice_time` datetime DEFAULT NULL COMMENT '公告时间',
  `click_count` bigint(20) DEFAULT '0' COMMENT '点击次数',
  `is_electronic` tinyint(4) DEFAULT '0' COMMENT '是否电子标',
  `source_url` varchar(300) DEFAULT '' COMMENT '源地址',
  `inward_html_url` varchar(300) DEFAULT '' COMMENT '内部地址',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `index_title` (`title`) USING BTREE COMMENT '招标信息名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '招投标项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_project_announce
-- ----------------------------
DROP TABLE IF EXISTS `t_project_announce`;
CREATE TABLE `t_project_announce` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公示编号',
  `project_id` bigint(20) DEFAULT '0' COMMENT '项目编号',
  `announce_desc` text COMMENT '公示详情',
  `first_candidate` varchar(20) DEFAULT '' COMMENT '第一候选人',
  `second_candidate` varchar(20) DEFAULT '' COMMENT '第二候选人',
  `third_candidate` varchar(20) DEFAULT '' COMMENT '第三候选人',
  `source_url` varchar(300) DEFAULT '' COMMENT '源地址',
  `inword_html_url` varchar(300) DEFAULT '' COMMENT '内部地址',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '招标公示详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_project_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_project_collection`;
CREATE TABLE `t_project_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目收藏编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `project_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '项目编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uni_user_id_project_id` (`user_id`,`project_id`) COMMENT '用户ID和项目ID唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_project_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_project_resource`;
CREATE TABLE `t_project_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目资源表主键',
  `project_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '项目编号',
  `resource_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '资源编号',
  `res_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '资源类别',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_recruit
-- ----------------------------
DROP TABLE IF EXISTS `t_recruit`;
CREATE TABLE `t_recruit`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '招聘编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `job_title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '招聘岗位',
  `is_fulltime` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否全职',
  `work_year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工作时间（年）',
  `education` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '要求学历',
  `salary` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提供月薪',
  `work_addr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工作地',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '职位描述',
  `recruit_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '招聘中' COMMENT '招聘状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '招聘表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `mime_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源类型',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资源地址',
  `extension` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资源扩展名',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_resume
-- ----------------------------
DROP TABLE IF EXISTS `t_resume`;
CREATE TABLE `t_resume`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '简历编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `gender` tinyint(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 0 COMMENT '性别',
  `age` int(10) NULL DEFAULT 0 COMMENT '年龄',
  `is_fulltime` tinyint(4) NULL DEFAULT 0 COMMENT '求职类型',
  `job_title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '求职岗位',
  `work_year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工作时间（年）',
  `education` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '学历',
  `salary` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '要求薪资/月',
  `is_recommend` int(4) NULL DEFAULT 0 COMMENT '是否允许平台推荐',
  `aptitude` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '我的资质',
  `intorduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '个人简介',
  `is_show` int(4) NULL DEFAULT 0 COMMENT '是否开放简历',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '简历表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `is_default` tinyint(4) NULL DEFAULT 0 COMMENT '是否默认角色',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 367 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `t_scheduler`;
CREATE TABLE `t_scheduler`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业名称',
  `class_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '完整类名',
  `cron_expression` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `group_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业组名称',
  `trigger_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '触发器名称',
  `trigger_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '触发器组',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
  `job_status` tinyint(4) NULL DEFAULT 0 COMMENT '作业状态',
  `job_status_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '状态更新时间',
  `auto_start` tinyint(4) NULL DEFAULT 0 COMMENT '自动启动',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_seek_data
-- ----------------------------
DROP TABLE IF EXISTS `t_seek_data`;
CREATE TABLE `t_seek_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '求带资料编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `start_addr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '出发地点',
  `end_addr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '目的地',
  `data_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资料类型',
  `data_count` int(10) NOT NULL DEFAULT 0 COMMENT '资料数量',
  `latest_time` datetime(0) NULL DEFAULT NULL COMMENT '最晚时间',
  `price` bigint(10) NULL DEFAULT 0 COMMENT '赏金',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_urgent` int(4) NULL DEFAULT 0 COMMENT '是否加急',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '求带资料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `t_shipping_address`;
CREATE TABLE `t_shipping_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_default` tinyint(4) NULL DEFAULT 0 COMMENT '是否默认',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_statistics_dau
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_dau`;
CREATE TABLE `t_statistics_dau`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'DAU编号',
  `dau` bigint(20) NOT NULL COMMENT 'DAU',
  `statistics_time` datetime(0) NOT NULL COMMENT '统计时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日活用户统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_statistics_day
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_day`;
CREATE TABLE `t_statistics_day`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日期编号',
  `the_date` datetime(0) NOT NULL COMMENT '日期字符串',
  `am_pm` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上午或下午',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用于数据统计的日期信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `t_subscribe`;
CREATE TABLE `t_subscribe`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订阅编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '城市',
  `project_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '项目类型',
  `min_money` bigint(10) NULL DEFAULT 0 COMMENT '最小金额',
  `max_money` bigint(10) NULL DEFAULT NULL COMMENT '最大金额',
  `tenderee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '招标人',
  `aptitude_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '资质类别',
  `keyword` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '关键字',
  `is_subscribe` int(4) NULL DEFAULT 0 COMMENT '是否开通订阅',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订阅表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置名称',
  `value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置内容(JSON)',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中文说明',
  `comment` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置注释',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表，以JSON格式记录常用配置，如阿里云，微信等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `user_account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行说明',
  `user_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'User-Agent',
  `request_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL',
  `request_method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式',
  `request_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `response_code` int(11) NULL DEFAULT NULL COMMENT '响应编码',
  `response_msg` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '响应消息',
  `execute_class` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '完整类名',
  `execute_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名称',
  `execute_time` datetime(0) NULL DEFAULT NULL COMMENT '开始执行时间',
  `execute_cost_time` bigint(20) NULL DEFAULT NULL COMMENT '执行耗时(ms)',
  `has_exception` tinyint(4) NULL DEFAULT 0 COMMENT '是否异常',
  `exception_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '异常消息',
  `execute_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 293 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密盐值',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_bankcard
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bankcard`;
CREATE TABLE `t_user_bankcard`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `account_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '持卡人姓名',
  `bank_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行代码',
  `bank_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行名称',
  `bankcard_no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户银行卡记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_user_certification`;
CREATE TABLE `t_user_certification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '认证编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `identity` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `real_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `valid_date` date NULL DEFAULT NULL COMMENT '身份证有效期',
  `idcard_front` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证正面',
  `idcard_reverse` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证反面',
  `idcard_hand` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手持身份证',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户实名认证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_user_coupon`;
CREATE TABLE `t_user_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户抵扣券编号',
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户编号',
  `coupon_id` bigint(20) NULL DEFAULT 0 COMMENT '抵扣券编号',
  `use_status` int(4) NULL DEFAULT 0 COMMENT '使用状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户抵扣券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail`  (
  `id` bigint(20) NOT NULL COMMENT '用户编号',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `headicon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `gender` tinyint(4) NULL DEFAULT 0 COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `qq_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ二维码',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `wechat_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信二维码',
  `alipay` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝账号',
  `alipay_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝二维码',
  `share_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分享码',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户扩展信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_expert
-- ----------------------------
DROP TABLE IF EXISTS `t_user_expert`;
CREATE TABLE `t_user_expert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专家信息编号',
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户编号',
  `name` varchar(20) DEFAULT '' COMMENT '专家姓名',
  `gender` tinyint(4) DEFAULT '0' COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `is_fulltime` tinyint(4) DEFAULT '0' COMMENT '是否全职',
  `phone` varchar(15) DEFAULT '' COMMENT '联系电话',
  `memo` varchar(300) DEFAULT '' COMMENT '个人情况介绍',
  `examine_status` tinyint(4) DEFAULT '0' COMMENT '审核状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专家信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_expert_question_type
-- ----------------------------
DROP TABLE IF EXISTS `t_user_expert_question_type`;
CREATE TABLE `t_user_expert_question_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专家类别编号',
  `user_expert_id` bigint(20) DEFAULT '0' COMMENT '专家信息编号',
  `question_type_id` bigint(20) DEFAULT NULL COMMENT '问题类别编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专家类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_hierarchy
-- ----------------------------
DROP TABLE IF EXISTS `t_user_hierarchy`;
CREATE TABLE `t_user_hierarchy`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系编号',
  `ancestor_id` bigint(20) NOT NULL COMMENT '祖先编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_level` int(11) NOT NULL COMMENT '用户级别',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_message
-- ----------------------------
DROP TABLE IF EXISTS `t_user_message`;
CREATE TABLE `t_user_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息发送编号',
  `message_id` bigint(20) NOT NULL COMMENT '消息编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `is_read` tinyint(4) NULL DEFAULT 0 COMMENT '是否已读',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_user_organization`;
CREATE TABLE `t_user_organization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户组织编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `organization_id` bigint(20) NOT NULL COMMENT '组织编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户组织部门信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_path
-- ----------------------------
DROP TABLE IF EXISTS `t_user_path`;
CREATE TABLE `t_user_path`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '路径编号',
  `user_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户路径',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `idx_user_path`(`user_path`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关系路径表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_social
-- ----------------------------
DROP TABLE IF EXISTS `t_user_social`;
CREATE TABLE `t_user_social`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '第三方登录编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `openid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'openid',
  `union_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'unionid',
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'AccessToken',
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'SessionKey',
  `refresh_token` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新Token',
  `social_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方登录类型',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '第三方登录绑定时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户第三方登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_wallet`;
CREATE TABLE `t_user_wallet`  (
  `id` bigint(20) NOT NULL COMMENT '钱包编号',
  `pay_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '支付密码',
  `rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '人民币余额',
  `usable_rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '可用余额',
  `frozen_rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '冻结余额',
  `integral` bigint(20) NULL DEFAULT 0 COMMENT '总积分',
  `usable_integral` bigint(20) NULL DEFAULT 0 COMMENT '可用积分',
  `frozen_integral` bigint(20) NULL DEFAULT 0 COMMENT '冻结积分',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户钱包表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_work
-- ----------------------------
DROP TABLE IF EXISTS `t_user_work`;
CREATE TABLE `t_user_work`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作信息编号',
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户编号',
  `id_num` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '身份证号',
  `work_unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工作单位',
  `job_title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '职务',
  `work_addr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '工作地点',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '工作信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for initStatisticsDay
-- ----------------------------
DROP PROCEDURE IF EXISTS `initStatisticsDay`;
delimiter ;;
CREATE PROCEDURE `initStatisticsDay`(in beginDate datetime, in totalDays int)
BEGIN
	declare days int default 0;
	declare theDate datetime;
	declare hasError integer default 0;
	declare continue handler for sqlexception set hasError = 1;
	start transaction;
		truncate table t_statistics_day;
		while days < totalDays
			do
				set theDate = date_add(beginDate, interval days day);
				insert into t_statistics_day(the_date, am_pm) values(theDate, 'am');
				insert into t_statistics_day(the_date, am_pm) values(theDate, 'pm');
				set days = days + 1;
		end while;
	if hasError = 1 then
		rollback;
	else
		commit;
  end if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for invite_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `invite_user`;
delimiter ;;
CREATE PROCEDURE `invite_user`(in pid bigint, in uid bigint)
BEGIN
    -- 如果uid等于pid，表示某个用户自己成为顶级经销商
	declare ancestorId bigint;
	declare num int default 0;
	declare userLevel int default 2;
	declare currentTime datetime default CURRENT_TIMESTAMP;
	declare userPath text;
	declare hasError integer default 0;
	-- 根据直接父id获取其所有祖先id，祖先id按倒序排列，方便得出用户id与祖先id间是多少级关系
	declare ancestorList cursor for
	select t_user_hierarchy.ancestor_id from t_user_hierarchy where t_user_hierarchy.user_id = pid
	order by t_user_hierarchy.user_level asc;
	declare continue handler for sqlexception set hasError = 1;
	declare continue handler for not found set num = 1;
	start transaction;
		if uid != pid then
			open ancestorList;
				fetch ancestorList into ancestorId;
				while num != 1 do
					insert into t_user_hierarchy (ancestor_id, user_id, user_level, create_time) values(ancestorId, uid, userLevel, currentTime);
					-- 祖先id每循环一次，等级加1
					set userLevel = userLevel + 1;
					fetch ancestorList into ancestorId;
				end while;
			close ancestorList;
		end if;
		-- 自己与自己的关系，user_level为1
		insert into t_user_hierarchy (ancestor_id, user_id, user_level) values(uid, uid, 1);
		-- 保存用户层级路径
		if uid != pid then
			select t_user_path.user_path into userPath from t_user_path where t_user_path.user_path like concat('%', pid);
			insert into t_user_path (user_path, create_time) values(concat(userPath, '/', uid), currentTime);
		else
			insert into t_user_path (user_path, create_time) values(uid, currentTime);
		end if;
	if hasError = 1 then
		rollback;
	else
		commit;
  end if;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
