/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : wjdatabase

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-12-25 12:55:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for g_admin
-- ----------------------------
DROP TABLE IF EXISTS `g_admin`;
CREATE TABLE `g_admin` (
  `id` int(11) NOT NULL auto_increment,
  `login_name` varchar(20) NOT NULL,
  `login_pass` varchar(32) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `add_time` int(10) NOT NULL,
  `last_login_time` int(10) NOT NULL,
  `is_disabled` tinyint(1) NOT NULL default '0' COMMENT '0启用；1禁用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_admin
-- ----------------------------
INSERT INTO `g_admin` VALUES ('1', '16905501', '123', '张万军1', '1451722889@qq.com', '0', '0', '0');
INSERT INTO `g_admin` VALUES ('2', '16905502', '123', '张万军2', '1451722889@qq.com', '0', '0', '1');
INSERT INTO `g_admin` VALUES ('3', '16905503', '123', '外科医生1', '1451722889@qq.com', '0', '0', '0');
INSERT INTO `g_admin` VALUES ('4', '16905504', '123', '药房人员', '1451722889@qq.com', '0', '0', '0');
INSERT INTO `g_admin` VALUES ('5', '16905505', '123', '检查人员', '1451722889@qq.com', '0', '0', '0');
INSERT INTO `g_admin` VALUES ('6', '16905506', '123', '收费人员1', '1451722889@qq.com', '0', '0', '0');

-- ----------------------------
-- Table structure for g_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `g_admin_role`;
CREATE TABLE `g_admin_role` (
  `id` int(10) NOT NULL auto_increment,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `add_time` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_admin_role
-- ----------------------------
INSERT INTO `g_admin_role` VALUES ('1', '1', '1', '0');
INSERT INTO `g_admin_role` VALUES ('2', '2', '2', '0');
INSERT INTO `g_admin_role` VALUES ('3', '3', '3', '0');
INSERT INTO `g_admin_role` VALUES ('4', '4', '4', '0');
INSERT INTO `g_admin_role` VALUES ('5', '5', '5', '0');
INSERT INTO `g_admin_role` VALUES ('6', '6', '7', '0');

-- ----------------------------
-- Table structure for g_dictionarydata
-- ----------------------------
DROP TABLE IF EXISTS `g_dictionarydata`;
CREATE TABLE `g_dictionarydata` (
  `id` int(10) NOT NULL auto_increment,
  `chinese_name` varchar(50) NOT NULL,
  `pid` varchar(10) NOT NULL,
  `sort_id` int(10) NOT NULL,
  `is_show` tinyint(1) NOT NULL default '1' COMMENT '0不显示；1显示',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_dictionarydata
-- ----------------------------

-- ----------------------------
-- Table structure for g_loginfo
-- ----------------------------
DROP TABLE IF EXISTS `g_loginfo`;
CREATE TABLE `g_loginfo` (
  `id` int(10) NOT NULL auto_increment,
  `operation_type` varchar(50) NOT NULL,
  `operation _user` varchar(10) NOT NULL,
  `createdate` int(10) NOT NULL,
  `result` varchar(50) NOT NULL,
  `errormsg` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_loginfo
-- ----------------------------

-- ----------------------------
-- Table structure for g_medicine
-- ----------------------------
DROP TABLE IF EXISTS `g_medicine`;
CREATE TABLE `g_medicine` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `price` double(10,2) NOT NULL,
  `repertory` int(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `function` varchar(255) NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_medicine
-- ----------------------------
INSERT INTO `g_medicine` VALUES ('5', '康森 藿香正气水', '20.00', '100', '家庭常用', '解表化湿，理气和中。用于外感风寒、内伤湿滞或夏伤暑湿所致的感冒，症见头痛昏重、胸膈痞闷、脘腹胀痛、呕吐泄泻；胃肠型感冒见上述证候者。', '口服');
INSERT INTO `g_medicine` VALUES ('7', '消炎利胆片', '13.19', '100', '肝胆用药', '清热,祛湿,利胆', '口服');
INSERT INTO `g_medicine` VALUES ('8', '康恩贝 肠炎宁片', '18.40', '100', '肠胃用药', '清热利湿，行气。用于大肠湿热所致的泄泻，症见大便泄泻、腹痛腹胀；急慢性胃肠炎、腹泻、小儿消化不良见上述证候者。', '口服。一次3～4片，一日3～4次；小儿酌减。');
INSERT INTO `g_medicine` VALUES ('10', '斯达舒 维U颠茄铝分散片', '18.00', '100', '肠胃用药', '用于缓解胃酸过多引起的胃灼热感、胃痛及慢性胃炎。', '口服，成 人一次1粒，一日3次，推荐疗程为2周。');
INSERT INTO `g_medicine` VALUES ('11', '同仁堂 养心安神丸同仁堂 静怡口服液', '16.90', '100', '中西药品', '改善睡眠', '口服，每日2次，每次1支');
INSERT INTO `g_medicine` VALUES ('16', '奥吉弗', '21.30', '100', '去问清楚', 'q\'we', '达瓦达瓦');
INSERT INTO `g_medicine` VALUES ('17', '同 ', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('18', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('19', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('20', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('21', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('22', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('23', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('24', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('25', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('26', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('27', '同', '0.00', '0', '', '', '');
INSERT INTO `g_medicine` VALUES ('28', '同', '0.00', '0', '', '', '');

-- ----------------------------
-- Table structure for g_medicine_allocation
-- ----------------------------
DROP TABLE IF EXISTS `g_medicine_allocation`;
CREATE TABLE `g_medicine_allocation` (
  `id` int(10) NOT NULL auto_increment,
  `patient_id` int(10) NOT NULL,
  `doctor` varchar(50) NOT NULL,
  `medicine_id` int(10) NOT NULL,
  `medicine_num` int(255) NOT NULL,
  `medicine_doctor` varchar(50) default NULL,
  `is_completed` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  `check_date` int(10) default NULL,
  `pay_no` int(255) NOT NULL,
  `medicine_money` double(10,2) NOT NULL default '0.00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_medicine_allocation
-- ----------------------------
INSERT INTO `g_medicine_allocation` VALUES ('1', '20180001', '', '1', '2', '亲亲打', '0', '-529357016', '123456', '0.00');
INSERT INTO `g_medicine_allocation` VALUES ('2', '20180001', '', '2', '2', '亲亲打', '0', '-529357016', '123456', '0.00');
INSERT INTO `g_medicine_allocation` VALUES ('4', '20180001', '', '3', '1', '亲亲打', '0', '-529446510', '123', '0.00');
INSERT INTO `g_medicine_allocation` VALUES ('6', '20180001', '', '1', '1', '亲亲打', '0', '-529446510', '123', '0.00');
INSERT INTO `g_medicine_allocation` VALUES ('7', '20180001', '', '12', '12', '亲亲打', '0', '-529446510', '123', '0.00');

-- ----------------------------
-- Table structure for g_node
-- ----------------------------
DROP TABLE IF EXISTS `g_node`;
CREATE TABLE `g_node` (
  `id` int(10) NOT NULL auto_increment,
  `pid` int(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `url` varchar(255) NOT NULL,
  `sort_id` int(10) NOT NULL,
  `is_show` tinyint(1) NOT NULL default '1' COMMENT '1显示；0不显示',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_node
-- ----------------------------
INSERT INTO `g_node` VALUES ('1', '0', '挂号', '/registration', '1', '1');
INSERT INTO `g_node` VALUES ('2', '0', '就诊', '/visit', '2', '1');
INSERT INTO `g_node` VALUES ('3', '0', '医药管理', '/default', '3', '1');
INSERT INTO `g_node` VALUES ('4', '0', '收费管理', '/pay', '5', '1');
INSERT INTO `g_node` VALUES ('5', '0', '权限管理', '/default', '6', '1');
INSERT INTO `g_node` VALUES ('8', '5', '角色管理', '/admin/role', '1', '1');
INSERT INTO `g_node` VALUES ('9', '5', '节点管理', '/admin/action_node', '2', '1');
INSERT INTO `g_node` VALUES ('10', '0', '检查管理', '/ordinary_cherk', '4', '1');
INSERT INTO `g_node` VALUES ('11', '3', '药库', '/medicine', '1', '1');
INSERT INTO `g_node` VALUES ('12', '3', '销售', '/saleMedicine', '2', '1');

-- ----------------------------
-- Table structure for g_ordinary_cherk
-- ----------------------------
DROP TABLE IF EXISTS `g_ordinary_cherk`;
CREATE TABLE `g_ordinary_cherk` (
  `id` int(10) NOT NULL auto_increment,
  `patient_id` int(10) NOT NULL,
  `doctor` varchar(50) default NULL,
  `check_item` varchar(50) NOT NULL,
  `check_result` varchar(255) default NULL,
  `check_doctor` varchar(50) default NULL,
  `is_completed` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  `check_date` int(10) default NULL,
  `pay_no` int(255) NOT NULL,
  `check_money` int(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_ordinary_cherk
-- ----------------------------
INSERT INTO `g_ordinary_cherk` VALUES ('3', '1', '外科医生1', '血常规', null, null, '0', null, '241141612', '50');
INSERT INTO `g_ordinary_cherk` VALUES ('4', '1', '外科医生1', '大便常规', null, null, '0', null, '241141612', '20');
INSERT INTO `g_ordinary_cherk` VALUES ('5', '1', '外科医生1', '血常规', null, null, '0', null, '241141612', '50');
INSERT INTO `g_ordinary_cherk` VALUES ('6', '1', '外科医生1', '尿常规', null, null, '0', null, '241141612', '20');
INSERT INTO `g_ordinary_cherk` VALUES ('7', '1', '外科医生1', '大便常规', null, null, '0', null, '241141612', '30');
INSERT INTO `g_ordinary_cherk` VALUES ('8', '1', '外科医生1', '肝功能检查', null, null, '0', null, '241141612', '60');
INSERT INTO `g_ordinary_cherk` VALUES ('9', '1', '外科医生1', '血常规', null, null, '0', null, '241141612', '50');
INSERT INTO `g_ordinary_cherk` VALUES ('10', '1', '外科医生1', '大便常规', null, null, '0', null, '241141612', '20');

-- ----------------------------
-- Table structure for g_patient_history
-- ----------------------------
DROP TABLE IF EXISTS `g_patient_history`;
CREATE TABLE `g_patient_history` (
  `id` int(10) NOT NULL auto_increment,
  `patient_identityid` varchar(18) NOT NULL,
  `disease_title` varchar(50) default NULL,
  `disease_content` varchar(255) default NULL,
  `doctor` varchar(50) default NULL,
  `is_completed` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  `date` int(10) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_patient_history
-- ----------------------------
INSERT INTO `g_patient_history` VALUES ('2', '330102199003075670', '骨折', '跟腱断裂。', '医生2', '1', '0');
INSERT INTO `g_patient_history` VALUES ('3', '330102199003075670', '大大', '而大胃王驱动器', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('4', '330102199003075670', '阿斯', '打撒十大', '打撒', '1', '0');
INSERT INTO `g_patient_history` VALUES ('5', '330102199003075670', '大大1', '而大胃王驱动器321', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('6', '330102199003075670', '大阿斯顿', '军方官员', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('7', '330102199003075670', '国际化', '合同发给', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('8', '330102199003075670', '不要', 'v表示方法为啥', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('9', '330102199003075670', '走', '王驱动器', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('10', '330102199003075670', '按市场', '而安说粗话器', '易折', '1', '0');
INSERT INTO `g_patient_history` VALUES ('12', '1101011990030724', '按市场', '企鹅啊恶气', '请勿打', '1', '0');

-- ----------------------------
-- Table structure for g_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `g_patient_info`;
CREATE TABLE `g_patient_info` (
  `id` int(10) NOT NULL auto_increment,
  `patient_name` varchar(10) NOT NULL,
  `patient_sex` varchar(1) NOT NULL,
  `patient_age` tinyint(2) NOT NULL,
  `patientcard_id` int(50) NOT NULL,
  `patient_identityid` varchar(18) NOT NULL,
  `is_preference` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_patient_info
-- ----------------------------
INSERT INTO `g_patient_info` VALUES ('1', '病人1', '男', '20', '20180001', '330102199003075670', '1');
INSERT INTO `g_patient_info` VALUES ('2', '病人2', '女', '18', '20180002', '		1101011990030724', '1');
INSERT INTO `g_patient_info` VALUES ('3', '病人3', '男', '40', '20180003', '	33010219700307367', '0');
INSERT INTO `g_patient_info` VALUES ('4', '病人4', '男', '66', '20180004', '	33010219950307833', '1');
INSERT INTO `g_patient_info` VALUES ('5', '病人5', '女', '32', '20180005', '110101198003076982', '0');
INSERT INTO `g_patient_info` VALUES ('6', '病人6', '男', '10', '20180006', '310101200803079291', '0');
INSERT INTO `g_patient_info` VALUES ('7', '病人7', '男', '45', '20180007', '310101197003077771', '0');

-- ----------------------------
-- Table structure for g_patient_registration
-- ----------------------------
DROP TABLE IF EXISTS `g_patient_registration`;
CREATE TABLE `g_patient_registration` (
  `id` int(10) NOT NULL auto_increment,
  `patient_identityid` varchar(18) NOT NULL,
  `department` varchar(10) NOT NULL,
  `doctor` varchar(10) NOT NULL,
  `is_completed` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  `time` int(10) NOT NULL,
  `pay_no` int(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_patient_registration
-- ----------------------------
INSERT INTO `g_patient_registration` VALUES ('27', '330102199003075670', '外科医生1', '普通外科', '0', '0', '411141414');

-- ----------------------------
-- Table structure for g_pay_record
-- ----------------------------
DROP TABLE IF EXISTS `g_pay_record`;
CREATE TABLE `g_pay_record` (
  `id` int(10) NOT NULL auto_increment,
  `pay_no` int(255) NOT NULL,
  `doctor` varchar(50) default NULL,
  `pay_type` varchar(50) NOT NULL,
  `pay_money` double(10,2) NOT NULL,
  `pay_way` varchar(255) default NULL,
  `pay_time` int(255) default NULL,
  `is_pay` tinyint(1) NOT NULL default '0' COMMENT '1：是：0：不是',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_pay_record
-- ----------------------------
INSERT INTO `g_pay_record` VALUES ('2', '1234567891', '', '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('3', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('4', '1234567891', null, '挂号', '10.00', null, null, '1');
INSERT INTO `g_pay_record` VALUES ('5', '1234567891', null, '挂号', '10.00', null, null, '1');
INSERT INTO `g_pay_record` VALUES ('6', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('7', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('8', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('9', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('10', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('11', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('12', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('13', '1234567891', null, '挂号', '10.00', null, null, '0');
INSERT INTO `g_pay_record` VALUES ('31', '411141414', 'bbbd', '挂号', '8.00', 'zfb', null, '0');

-- ----------------------------
-- Table structure for g_role
-- ----------------------------
DROP TABLE IF EXISTS `g_role`;
CREATE TABLE `g_role` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `remark` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL default '0' COMMENT '1可用；0不可用',
  `add_time` int(10) NOT NULL,
  `level` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_role
-- ----------------------------
INSERT INTO `g_role` VALUES ('1', '超级管理员', '高于一切', '1', '0', '1');
INSERT INTO `g_role` VALUES ('2', '系统管理员', '普通管理', '1', '0', '2');
INSERT INTO `g_role` VALUES ('3', '医生', '就诊', '1', '0', '3');
INSERT INTO `g_role` VALUES ('4', '药房人员', '医药管理', '1', '0', '4');
INSERT INTO `g_role` VALUES ('5', '检查医生', '常规性检查', '1', '0', '5');
INSERT INTO `g_role` VALUES ('6', '病人', '挂号', '1', '0', '6');
INSERT INTO `g_role` VALUES ('7', '收费人员', '收费', '1', '0', '7');

-- ----------------------------
-- Table structure for g_role_node
-- ----------------------------
DROP TABLE IF EXISTS `g_role_node`;
CREATE TABLE `g_role_node` (
  `id` int(10) NOT NULL auto_increment,
  `role_id` int(10) NOT NULL,
  `node_id` int(10) NOT NULL,
  `add_time` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_role_node
-- ----------------------------
INSERT INTO `g_role_node` VALUES ('1', '1', '1', '0');
INSERT INTO `g_role_node` VALUES ('2', '1', '2', '0');
INSERT INTO `g_role_node` VALUES ('3', '1', '3', '0');
INSERT INTO `g_role_node` VALUES ('4', '1', '4', '0');
INSERT INTO `g_role_node` VALUES ('5', '1', '5', '0');
INSERT INTO `g_role_node` VALUES ('8', '1', '8', '0');
INSERT INTO `g_role_node` VALUES ('9', '1', '9', '0');
INSERT INTO `g_role_node` VALUES ('11', '3', '2', '0');
INSERT INTO `g_role_node` VALUES ('12', '4', '3', '0');
INSERT INTO `g_role_node` VALUES ('13', '6', '1', '0');
INSERT INTO `g_role_node` VALUES ('14', '1', '10', '0');
INSERT INTO `g_role_node` VALUES ('15', '5', '10', '0');
INSERT INTO `g_role_node` VALUES ('16', '7', '4', '0');
INSERT INTO `g_role_node` VALUES ('17', '2', '9', '0');
INSERT INTO `g_role_node` VALUES ('18', '4', '11', '0');
INSERT INTO `g_role_node` VALUES ('19', '4', '12', '0');
