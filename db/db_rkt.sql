/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : db_rkt

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 09/03/2019 19:43:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `t_knowledge`;
CREATE TABLE `t_knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_knowledge
-- ----------------------------
BEGIN;
INSERT INTO `t_knowledge` VALUES (1, '计算机科学基础', NULL);
INSERT INTO `t_knowledge` VALUES (2, '计算机系统', NULL);
INSERT INTO `t_knowledge` VALUES (3, '系统开发和运行', NULL);
INSERT INTO `t_knowledge` VALUES (4, '面向对象基础', NULL);
INSERT INTO `t_knowledge` VALUES (5, '信息安全', NULL);
INSERT INTO `t_knowledge` VALUES (6, '标准化、信息化和知识产权基础', NULL);
INSERT INTO `t_knowledge` VALUES (7, '计算机专业英语', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper` (
  `id` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `question_type` int(11) DEFAULT NULL COMMENT '试卷题型 1 综合知识 2 案例 ...',
  `paper_type_id` int(11) DEFAULT NULL,
  `questions` text,
  `total` int(11) DEFAULT NULL COMMENT '总分',
  `count` int(11) DEFAULT NULL COMMENT '题数',
  `time` int(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater_id` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_paper
-- ----------------------------
BEGIN;
INSERT INTO `t_paper` VALUES ('0539afe6116be5c8d1a6f085b3525154', '2018年上半年软件设计师真题（测试）', 7, 1, 3, '[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"choiceA\":\"sdfg\",\"key\":\"C\",\"choiceB\":\"dsfg\"},{\"index\":2,\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"choiceA\":\"asgasdf\",\"key\":\"A\",\"choiceB\":\"sadfsadf\"}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"choiceA\":\"asdfsadf\",\"key\":\"A\",\"choiceB\":\"hsfhdf\"},{\"index\":2,\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"choiceA\":\"ahaegwe\",\"key\":\"B\",\"choiceB\":\"awefwe\"}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"choiceA\":\"水电费\",\"key\":\"B\",\"choiceB\":\"发撒地方\"}],\"topic\":\"<p>fasdf&nbsp;</p>\"}]', 75, 75, 150, '2019-03-02 11:27:15', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 1);
INSERT INTO `t_paper` VALUES ('0c1cc74c14124be9c4301ec7df1144dd', '测试试卷3', 7, 1, 3, '[{\"createTime\":1551095187000,\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"sdfg\\\",\\\"choiceB\\\":\\\"dsfg\\\",\\\"choiceC\\\":\\\"sdfg\\\",\\\"choiceD\\\":\\\"sdfgdsfgsd\\\",\\\"index\\\":1,\\\"key\\\":\\\"C\\\"},{\\\"choiceA\\\":\\\"asgasdf\\\",\\\"choiceB\\\":\\\"sadfsadf\\\",\\\"choiceC\\\":\\\"asfdsdf\\\",\\\"choiceD\\\":\\\"asdf\\\",\\\"index\\\":2,\\\"key\\\":\\\"A\\\"}]\",\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":1551076109000,\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"asdfsadf\\\",\\\"choiceB\\\":\\\"hsfhdf\\\",\\\"choiceC\\\":\\\"awegwg\\\",\\\"choiceD\\\":\\\"aerhaerha\\\",\\\"index\\\":1,\\\"key\\\":\\\"A\\\"},{\\\"choiceA\\\":\\\"ahaegwe\\\",\\\"choiceB\\\":\\\"awefwe\\\",\\\"choiceC\\\":\\\"whW\\\",\\\"choiceD\\\":\\\"awegwegweg\\\",\\\"index\\\":2,\\\"key\\\":\\\"B\\\"}]\",\"topic\":\"<p>asdfsadfsadf</p>\"}]', 75, 75, 150, '2019-02-27 21:36:25', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('1d4359fd48498672323f322c41bde138', '测试添加试卷', 7, 1, 2, '[{\"createTime\":1551095187000,\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"sdfg\\\",\\\"choiceB\\\":\\\"dsfg\\\",\\\"choiceC\\\":\\\"sdfg\\\",\\\"choiceD\\\":\\\"sdfgdsfgsd\\\",\\\"index\\\":1,\\\"key\\\":\\\"C\\\"},{\\\"choiceA\\\":\\\"asgasdf\\\",\\\"choiceB\\\":\\\"sadfsadf\\\",\\\"choiceC\\\":\\\"asfdsdf\\\",\\\"choiceD\\\":\\\"asdf\\\",\\\"index\\\":2,\\\"key\\\":\\\"A\\\"}]\",\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":1551076109000,\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"asdfsadf\\\",\\\"choiceB\\\":\\\"hsfhdf\\\",\\\"choiceC\\\":\\\"awegwg\\\",\\\"choiceD\\\":\\\"aerhaerha\\\",\\\"index\\\":1,\\\"key\\\":\\\"A\\\"},{\\\"choiceA\\\":\\\"ahaegwe\\\",\\\"choiceB\\\":\\\"awefwe\\\",\\\"choiceC\\\":\\\"whW\\\",\\\"choiceD\\\":\\\"awegwegweg\\\",\\\"index\\\":2,\\\"key\\\":\\\"B\\\"}]\",\"topic\":\"<p>asdfsadfsadf</p>\"}]', 75, 75, 150, '2019-02-27 20:39:01', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('24d5fc3b169b198b5e9f9a39c0ddc0dd', '2015年上半年软件设计师真题模拟考试（上午）', 7, 1, 3, NULL, 75, 75, 150, '2019-02-28 14:55:35', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('431042f8e7e03b20d17f0f8f7091679c', '2015年下半年软件设计师真题模拟考试（上午）', 7, 1, 3, NULL, 75, 75, 150, '2019-02-28 14:59:47', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('6b4d7fe47eca16647d432eba588f9e4d', '题目的创建时间怎么变成了时间戳', 7, 1, 3, '[{\"createTime\":\"2019-02-25 19:46:27\",\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"sdfg\\\",\\\"choiceB\\\":\\\"dsfg\\\",\\\"choiceC\\\":\\\"sdfg\\\",\\\"choiceD\\\":\\\"sdfgdsfgsd\\\",\\\"index\\\":1,\\\"key\\\":\\\"C\\\"},{\\\"choiceA\\\":\\\"asgasdf\\\",\\\"choiceB\\\":\\\"sadfsadf\\\",\\\"choiceC\\\":\\\"asfdsdf\\\",\\\"choiceD\\\":\\\"asdf\\\",\\\"index\\\":2,\\\"key\\\":\\\"A\\\"}]\",\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":\"[{\\\"choiceA\\\":\\\"asdfsadf\\\",\\\"choiceB\\\":\\\"hsfhdf\\\",\\\"choiceC\\\":\\\"awegwg\\\",\\\"choiceD\\\":\\\"aerhaerha\\\",\\\"index\\\":1,\\\"key\\\":\\\"A\\\"},{\\\"choiceA\\\":\\\"ahaegwe\\\",\\\"choiceB\\\":\\\"awefwe\\\",\\\"choiceC\\\":\\\"whW\\\",\\\"choiceD\\\":\\\"awegwegweg\\\",\\\"index\\\":2,\\\"key\\\":\\\"B\\\"}]\",\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":\"[{\\\"index\\\":1,\\\"choiceA\\\":\\\"水电费\\\",\\\"choiceB\\\":\\\"发撒地方\\\",\\\"choiceC\\\":\\\"未放弃我\\\",\\\"choiceD\\\":\\\"接完饭\\\",\\\"key\\\":\\\"B\\\"}]\",\"topic\":\"<p>fasdf&nbsp;</p>\"}]', 75, 75, 150, '2019-03-01 21:41:56', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('80027fab43051d893755576da787582f', '2016年下半年软件设计师真题模拟考试（上午）', 7, 1, 3, NULL, 75, 75, 150, '2019-02-28 15:00:19', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('8533953845c3a24f51cd5b1ac3faab94', '我的模拟试卷', 7, 1, 2, '[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"choiceA\":\"sdfg\",\"key\":\"C\",\"choiceB\":\"dsfg\"},{\"index\":2,\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"choiceA\":\"asgasdf\",\"key\":\"A\",\"choiceB\":\"sadfsadf\"}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"choiceA\":\"asdfsadf\",\"key\":\"A\",\"choiceB\":\"hsfhdf\"},{\"index\":2,\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"choiceA\":\"ahaegwe\",\"key\":\"B\",\"choiceB\":\"awefwe\"}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"choiceA\":\"水电费\",\"key\":\"B\",\"choiceB\":\"发撒地方\"}],\"topic\":\"<p>fasdf&nbsp;</p>\"}]', 75, 75, 75, '2019-03-02 11:22:34', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('c54672b5cf0cc52639d724c3562ff63a', '2016年上半年软件设计师真题模拟考试（上午）', 7, 1, 3, NULL, 75, 75, 150, '2019-02-28 15:00:03', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 0);
INSERT INTO `t_paper` VALUES ('e4394d7acd409acec4b4b9bff5c5b7c5', '隐辰创建的模拟试卷', 7, 1, 2, '[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"choiceA\":\"sdfg\",\"key\":\"C\",\"choiceB\":\"dsfg\"},{\"index\":2,\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"choiceA\":\"asgasdf\",\"key\":\"A\",\"choiceB\":\"sadfsadf\"}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"choiceA\":\"asdfsadf\",\"key\":\"A\",\"choiceB\":\"hsfhdf\"},{\"index\":2,\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"choiceA\":\"ahaegwe\",\"key\":\"B\",\"choiceB\":\"awefwe\"}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"index\":1,\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"choiceA\":\"水电费\",\"key\":\"B\",\"choiceB\":\"发撒地方\"}],\"topic\":\"<p>fasdf&nbsp;</p>\"}]', 75, 75, 150, '2019-03-02 11:24:48', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_paper_type
-- ----------------------------
DROP TABLE IF EXISTS `t_paper_type`;
CREATE TABLE `t_paper_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` varchar(50) NOT NULL,
  `question_type` varchar(20) DEFAULT NULL,
  `knowledge_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `topic` text,
  `selects` text,
  `answer` text,
  `resolve` text,
  `create_time` datetime DEFAULT NULL,
  `creator_id` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater_id` varchar(50) DEFAULT NULL,
  `is_english` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------
BEGIN;
INSERT INTO `t_question` VALUES ('07a0234ccd685c6b0bd7899205518750', '2', 1, NULL, '<p>sdfgsdgf 。</p>', NULL, NULL, '<p>sdfgdsgf&nbsp;&nbsp;</p>', '2019-02-26 17:08:20', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
INSERT INTO `t_question` VALUES ('07b8e9d6c332612836d619aac5c3d515', '3', NULL, 1, '<p>论文题 题目</p>', NULL, NULL, NULL, '2019-02-26 21:10:48', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
INSERT INTO `t_question` VALUES ('2cecf2ea4eb0152e4aeb256518a44dc9', '1', 1, NULL, '<p>zdfsdfgsg</p>', '[{\"choiceA\":\"sdfg\",\"choiceB\":\"dsfg\",\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"index\":1,\"key\":\"C\"},{\"choiceA\":\"asgasdf\",\"choiceB\":\"sadfsadf\",\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"index\":2,\"key\":\"A\"}]', NULL, '<p>fsdf</p>', '2019-02-25 19:46:27', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
INSERT INTO `t_question` VALUES ('30305fdc73613b321206a9e3f7930b0f', '1', 2, NULL, '<p>asdfsadfsadf</p>', '[{\"choiceA\":\"asdfsadf\",\"choiceB\":\"hsfhdf\",\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"index\":1,\"key\":\"A\"},{\"choiceA\":\"ahaegwe\",\"choiceB\":\"awefwe\",\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"index\":2,\"key\":\"B\"}]', NULL, '<p>aegwae</p>', '2019-02-25 14:28:29', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
INSERT INTO `t_question` VALUES ('834512fd35017770a086013f7ebcc35f', '1', 2, NULL, '<p>fasdf&nbsp;</p>', '[{\"index\":1,\"choiceA\":\"水电费\",\"choiceB\":\"发撒地方\",\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"key\":\"B\"}]', NULL, '<p>asdfsadf&nbsp;</p>', '2019-02-28 21:16:46', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
INSERT INTO `t_question` VALUES ('c4998d5ee0dbe5dd1a53370c3e06c246', '2', 2, NULL, '<p>sdfgsdgf</p>', 'null', NULL, '<p>sdfgdsgf</p>', '2019-02-26 15:51:01', '00610d40-38bf-11e9-a1ec-31d188357094', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `paper_id` varchar(50) DEFAULT NULL,
  `paper` text,
  `score` int(255) DEFAULT NULL,
  `answer` text,
  `limit_time_stamp` mediumtext,
  `used_time` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态 0 未交卷 1 已交卷',
  `submit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_record
-- ----------------------------
BEGIN;
INSERT INTO `t_record` VALUES ('0508692eab955f80bfe719c4d715dff6', '00610d40-38bf-11e9-a1ec-31d188357094', 'e4394d7acd409acec4b4b9bff5c5b7c5', '{\"count\":75,\"createTime\":1551497088000,\"creator\":\"Thornchg丶\",\"id\":\"e4394d7acd409acec4b4b9bff5c5b7c5\",\"paperTypeId\":2,\"questionType\":1,\"questions\":[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"answer\":\"A\",\"choiceA\":\"sdfg\",\"choiceB\":\"dsfg\",\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"index\":1,\"key\":\"C\",\"result\":0},{\"answer\":\"B\",\"choiceA\":\"asgasdf\",\"choiceB\":\"sadfsadf\",\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"index\":2,\"key\":\"A\",\"result\":0}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"answer\":\"C\",\"choiceA\":\"asdfsadf\",\"choiceB\":\"hsfhdf\",\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"index\":1,\"key\":\"A\",\"result\":0},{\"answer\":\"D\",\"choiceA\":\"ahaegwe\",\"choiceB\":\"awefwe\",\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"index\":2,\"key\":\"B\",\"result\":0}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"answer\":\"B\",\"choiceA\":\"水电费\",\"choiceB\":\"发撒地方\",\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"index\":1,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>fasdf&nbsp;</p>\"}],\"status\":1,\"subjectId\":7,\"subjectName\":\"软件设计师\",\"time\":150,\"title\":\"隐辰创建的模拟试卷\",\"total\":75}', 1, NULL, '9000000', 71, '2019-03-02 15:08:35', 2, '2019-03-02 15:10:26');
INSERT INTO `t_record` VALUES ('0f0c6fd35c278516f03b1e99cd29cbc3', '00610d40-38bf-11e9-a1ec-31d188357094', 'e4394d7acd409acec4b4b9bff5c5b7c5', '{\"count\":75,\"createTime\":1551497088000,\"creatorId\":\"00610d40-38bf-11e9-a1ec-31d188357094\",\"id\":\"e4394d7acd409acec4b4b9bff5c5b7c5\",\"paperTypeId\":2,\"questionType\":1,\"questions\":\"[{\\\"createTime\\\":\\\"2019-02-25 19:46:27\\\",\\\"creator\\\":\\\"Thornchg丶\\\",\\\"id\\\":\\\"2cecf2ea4eb0152e4aeb256518a44dc9\\\",\\\"knowledgeId\\\":1,\\\"knowledgeName\\\":\\\"计算机科学基础\\\",\\\"questionType\\\":1,\\\"resolve\\\":\\\"<p>fsdf</p>\\\",\\\"selects\\\":[{\\\"index\\\":1,\\\"choiceC\\\":\\\"sdfg\\\",\\\"choiceD\\\":\\\"sdfgdsfgsd\\\",\\\"choiceA\\\":\\\"sdfg\\\",\\\"key\\\":\\\"C\\\",\\\"choiceB\\\":\\\"dsfg\\\"},{\\\"index\\\":2,\\\"choiceC\\\":\\\"asfdsdf\\\",\\\"choiceD\\\":\\\"asdf\\\",\\\"choiceA\\\":\\\"asgasdf\\\",\\\"key\\\":\\\"A\\\",\\\"choiceB\\\":\\\"sadfsadf\\\"}],\\\"topic\\\":\\\"<p>zdfsdfgsg</p>\\\"},{\\\"createTime\\\":\\\"2019-02-25 14:28:29\\\",\\\"creator\\\":\\\"Thornchg丶\\\",\\\"id\\\":\\\"30305fdc73613b321206a9e3f7930b0f\\\",\\\"knowledgeId\\\":2,\\\"knowledgeName\\\":\\\"计算机系统\\\",\\\"questionType\\\":1,\\\"resolve\\\":\\\"<p>aegwae</p>\\\",\\\"selects\\\":[{\\\"index\\\":1,\\\"choiceC\\\":\\\"awegwg\\\",\\\"choiceD\\\":\\\"aerhaerha\\\",\\\"choiceA\\\":\\\"asdfsadf\\\",\\\"key\\\":\\\"A\\\",\\\"choiceB\\\":\\\"hsfhdf\\\"},{\\\"index\\\":2,\\\"choiceC\\\":\\\"whW\\\",\\\"choiceD\\\":\\\"awegwegweg\\\",\\\"choiceA\\\":\\\"ahaegwe\\\",\\\"key\\\":\\\"B\\\",\\\"choiceB\\\":\\\"awefwe\\\"}],\\\"topic\\\":\\\"<p>asdfsadfsadf</p>\\\"},{\\\"createTime\\\":\\\"2019-02-28 21:16:46\\\",\\\"creator\\\":\\\"Thornchg丶\\\",\\\"id\\\":\\\"834512fd35017770a086013f7ebcc35f\\\",\\\"knowledgeId\\\":2,\\\"knowledgeName\\\":\\\"计算机系统\\\",\\\"questionType\\\":1,\\\"resolve\\\":\\\"<p>asdfsadf&nbsp;</p>\\\",\\\"selects\\\":[{\\\"index\\\":1,\\\"choiceC\\\":\\\"未放弃我\\\",\\\"choiceD\\\":\\\"接完饭\\\",\\\"choiceA\\\":\\\"水电费\\\",\\\"key\\\":\\\"B\\\",\\\"choiceB\\\":\\\"发撒地方\\\"}],\\\"topic\\\":\\\"<p>fasdf&nbsp;</p>\\\"}]\",\"status\":1,\"subjectId\":7,\"time\":150,\"title\":\"隐辰创建的模拟试卷\",\"total\":75}', NULL, NULL, '9000000', NULL, '2019-03-02 22:55:48', 0, NULL);
INSERT INTO `t_record` VALUES ('501311c2cb6e9c07b383b305d7a31c9d', '00610d40-38bf-11e9-a1ec-31d188357094', '0539afe6116be5c8d1a6f085b3525154', '{\"count\":75,\"createTime\":1551497235000,\"creator\":\"Thornchg丶\",\"id\":\"0539afe6116be5c8d1a6f085b3525154\",\"paperTypeId\":3,\"questionType\":1,\"questions\":[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"answer\":\"B\",\"choiceA\":\"sdfg\",\"choiceB\":\"dsfg\",\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"index\":1,\"key\":\"C\",\"result\":0},{\"answer\":\"B\",\"choiceA\":\"asgasdf\",\"choiceB\":\"sadfsadf\",\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"index\":2,\"key\":\"A\",\"result\":0}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"answer\":\"C\",\"choiceA\":\"asdfsadf\",\"choiceB\":\"hsfhdf\",\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"index\":1,\"key\":\"A\",\"result\":0},{\"answer\":\"B\",\"choiceA\":\"ahaegwe\",\"choiceB\":\"awefwe\",\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"index\":2,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"answer\":\"B\",\"choiceA\":\"水电费\",\"choiceB\":\"发撒地方\",\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"index\":1,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>fasdf&nbsp;</p>\"}],\"status\":1,\"subjectId\":7,\"subjectName\":\"软件设计师\",\"time\":150,\"title\":\"2018年上半年软件设计师真题（测试）\",\"total\":75}', 2, NULL, '9000000', 25, '2019-03-09 17:59:45', 2, '2019-03-09 18:00:19');
INSERT INTO `t_record` VALUES ('9d2b89d707de0bbdab0c42718b4e7281', '00610d40-38bf-11e9-a1ec-31d188357094', '0539afe6116be5c8d1a6f085b3525154', '{\"count\":75,\"createTime\":1551497235000,\"creator\":\"Thornchg丶\",\"id\":\"0539afe6116be5c8d1a6f085b3525154\",\"paperTypeId\":3,\"questionType\":1,\"questions\":[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"answer\":\"A\",\"choiceA\":\"sdfg\",\"choiceB\":\"dsfg\",\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"index\":1,\"key\":\"C\",\"result\":0},{\"answer\":\"B\",\"choiceA\":\"asgasdf\",\"choiceB\":\"sadfsadf\",\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"index\":2,\"key\":\"A\",\"result\":0}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"answer\":\"C\",\"choiceA\":\"asdfsadf\",\"choiceB\":\"hsfhdf\",\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"index\":1,\"key\":\"A\",\"result\":0},{\"answer\":\"C\",\"choiceA\":\"ahaegwe\",\"choiceB\":\"awefwe\",\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"index\":2,\"key\":\"B\",\"result\":0}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"answer\":\"B\",\"choiceA\":\"水电费\",\"choiceB\":\"发撒地方\",\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"index\":1,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>fasdf&nbsp;</p>\"}],\"status\":1,\"subjectId\":7,\"subjectName\":\"软件设计师\",\"time\":150,\"title\":\"2018年上半年软件设计师真题（测试）\",\"total\":75}', 1, NULL, '9000000', 11, '2019-03-02 20:06:22', 2, '2019-03-02 20:06:34');
INSERT INTO `t_record` VALUES ('b30b53a50a7959e53cb238b9a5d326d3', '00610d40-38bf-11e9-a1ec-31d188357094', '0539afe6116be5c8d1a6f085b3525154', '{\"count\":75,\"createTime\":1551497235000,\"creator\":\"Thornchg丶\",\"id\":\"0539afe6116be5c8d1a6f085b3525154\",\"paperTypeId\":3,\"questionType\":1,\"questions\":[{\"createTime\":\"2019-02-25 19:46:27\",\"creator\":\"Thornchg丶\",\"id\":\"2cecf2ea4eb0152e4aeb256518a44dc9\",\"knowledgeId\":1,\"knowledgeName\":\"计算机科学基础\",\"questionType\":1,\"resolve\":\"<p>fsdf</p>\",\"selects\":[{\"answer\":\"C\",\"choiceA\":\"sdfg\",\"choiceB\":\"dsfg\",\"choiceC\":\"sdfg\",\"choiceD\":\"sdfgdsfgsd\",\"index\":1,\"key\":\"C\",\"result\":1},{\"answer\":\"A\",\"choiceA\":\"asgasdf\",\"choiceB\":\"sadfsadf\",\"choiceC\":\"asfdsdf\",\"choiceD\":\"asdf\",\"index\":2,\"key\":\"A\",\"result\":1}],\"topic\":\"<p>zdfsdfgsg</p>\"},{\"createTime\":\"2019-02-25 14:28:29\",\"creator\":\"Thornchg丶\",\"id\":\"30305fdc73613b321206a9e3f7930b0f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>aegwae</p>\",\"selects\":[{\"answer\":\"A\",\"choiceA\":\"asdfsadf\",\"choiceB\":\"hsfhdf\",\"choiceC\":\"awegwg\",\"choiceD\":\"aerhaerha\",\"index\":1,\"key\":\"A\",\"result\":1},{\"answer\":\"B\",\"choiceA\":\"ahaegwe\",\"choiceB\":\"awefwe\",\"choiceC\":\"whW\",\"choiceD\":\"awegwegweg\",\"index\":2,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>asdfsadfsadf</p>\"},{\"createTime\":\"2019-02-28 21:16:46\",\"creator\":\"Thornchg丶\",\"id\":\"834512fd35017770a086013f7ebcc35f\",\"knowledgeId\":2,\"knowledgeName\":\"计算机系统\",\"questionType\":1,\"resolve\":\"<p>asdfsadf&nbsp;</p>\",\"selects\":[{\"answer\":\"B\",\"choiceA\":\"水电费\",\"choiceB\":\"发撒地方\",\"choiceC\":\"未放弃我\",\"choiceD\":\"接完饭\",\"index\":1,\"key\":\"B\",\"result\":1}],\"topic\":\"<p>fasdf&nbsp;</p>\"}],\"status\":1,\"subjectId\":7,\"subjectName\":\"软件设计师\",\"time\":150,\"title\":\"2018年上半年软件设计师真题（测试）\",\"total\":75}', 5, NULL, '9000000', 8, '2019-03-02 20:06:57', 2, '2019-03-02 20:07:05');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, '超级管理员', 'superAdmin');
INSERT INTO `t_role` VALUES (2, '管理员', 'admin');
INSERT INTO `t_role` VALUES (3, '会员', 'vip');
INSERT INTO `t_role` VALUES (4, '普通用户', 'user');
COMMIT;

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `level` int(11) DEFAULT NULL COMMENT '等级 1 初级 2 中级 3 高级',
  `code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
BEGIN;
INSERT INTO `t_subject` VALUES (1, '系统分析师', 3, NULL);
INSERT INTO `t_subject` VALUES (2, '信息系统项目管理师', 3, NULL);
INSERT INTO `t_subject` VALUES (3, '网络规划设计师', 3, NULL);
INSERT INTO `t_subject` VALUES (4, '系统架构设计师', 3, NULL);
INSERT INTO `t_subject` VALUES (5, '系统规划与管理师', 3, NULL);
INSERT INTO `t_subject` VALUES (6, '系统集成项目管理工程师', 2, NULL);
INSERT INTO `t_subject` VALUES (7, '软件设计师', 2, NULL);
INSERT INTO `t_subject` VALUES (8, '网络工程师', 2, NULL);
INSERT INTO `t_subject` VALUES (9, '信息系统监理师', 2, NULL);
INSERT INTO `t_subject` VALUES (10, '信息系统管理工程师', 2, NULL);
INSERT INTO `t_subject` VALUES (11, '电子商务设计师', 2, NULL);
INSERT INTO `t_subject` VALUES (12, '软件评测师', 2, NULL);
INSERT INTO `t_subject` VALUES (13, '信息安全工程师', 2, NULL);
INSERT INTO `t_subject` VALUES (14, '数据库系统工程师', 2, NULL);
INSERT INTO `t_subject` VALUES (15, '嵌入式系统设计师', 2, NULL);
INSERT INTO `t_subject` VALUES (16, '程序员', 1, NULL);
INSERT INTO `t_subject` VALUES (17, '网络管理员', 1, NULL);
INSERT INTO `t_subject` VALUES (18, '信息处理技术员', 1, NULL);
INSERT INTO `t_subject` VALUES (19, '信息系统运行管理员', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_subject_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `t_subject_knowledge`;
CREATE TABLE `t_subject_knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `knowledge_id` int(11) DEFAULT NULL,
  `question_type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject_knowledge
-- ----------------------------
BEGIN;
INSERT INTO `t_subject_knowledge` VALUES (1, 7, 1, 1);
INSERT INTO `t_subject_knowledge` VALUES (2, 7, 2, 1);
INSERT INTO `t_subject_knowledge` VALUES (3, 7, 3, 1);
INSERT INTO `t_subject_knowledge` VALUES (4, 7, 4, 1);
INSERT INTO `t_subject_knowledge` VALUES (5, 7, 5, 1);
INSERT INTO `t_subject_knowledge` VALUES (6, 7, 6, 1);
INSERT INTO `t_subject_knowledge` VALUES (7, 7, 7, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('00610d40-38bf-11e9-a1ec-31d188357094', 'Thornchg@163.com', 'Thornchg丶', 'password', NULL, '/1.jpg', 1, 7, '19959528165', '2019-02-25 13:34:20', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
