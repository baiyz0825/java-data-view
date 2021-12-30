/*
 Navicat Premium Data Transfer

 Source Server         : MySqlNas
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : nas.spacewarp.tech:33066
 Source Schema         : bookjava

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 30/12/2021 12:07:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Book
-- ----------------------------
DROP TABLE IF EXISTS `Book`;
CREATE TABLE `Book`
(
    `id`           tinyint(0)                                              NOT NULL AUTO_INCREMENT COMMENT '主键',
    `number`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
    `name`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
    `sortBook`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '分类',
    `publisher`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '出版社\r\n',
    `author`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '作者',
    `prices`       double                                                  NULL DEFAULT NULL COMMENT '价格',
    `remainNumber` int(0)                                                  NULL DEFAULT NULL COMMENT '剩余数量',
    `publishData`  date                                                    NOT NULL COMMENT '出版时间',
    `src`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Book
-- ----------------------------
INSERT INTO `Book`
VALUES (1, '1007-161X', '当代亚太', '经济', '中国社会科学院', '李向阳', 240.1, 2, '1992-01-10',
        'BookImg/43aa677ee459496b8d5bb7e38827488c.jpg');
INSERT INTO `Book`
VALUES (2, '14-1021/G8', '搏击', '体育', '山西省体育局', '山西省体育报刊社', 22, 1, '2010-01-11',
        'BookImg/1ef11589588043bba76474cef4c4e2cd.jpg');
INSERT INTO `Book`
VALUES (3, '1002-3488', '冰雪运动', '体育', '国家体育总局', '才琦', 45.1, 19, '2011-03-05',
        'BookImg/bc67671b40014ac8bcd465e75c272c02.jpg');
INSERT INTO `Book`
VALUES (4, '1006-7000', '出版广角', '体育', '广西师范大学', '朱京玮', 33.2, 4, '2021-01-02',
        'BookImg/5a00152107cf4663ad9605225e252709.jpg');
INSERT INTO `Book`
VALUES (5, '1004-7387', '船山学刊', '文学', '湖南省社会科学界联合会', '楚玲', 23.8, 10, '2021-01-10',
        'BookImg/92ce9fcf699b4a20aa6a5a66de2dea1a.jpg');
INSERT INTO `Book`
VALUES (6, '1005-605X', '\n安徽史学', '历史地理', '安徽省社会科学院', '方英', 16, 4, '1998-11-02',
        'BookImg/9ea41360573049eabbe32563d29b9947.jpg');
INSERT INTO `Book`
VALUES (7, '122-754', '北京地方志', '历史地理', '北京科技出版社', '陈玲', 4, 50, '2017-01-02',
        'BookImg/15da2961b973442c94017c4baf97f5e5.jpg');
INSERT INTO `Book`
VALUES (8, '2456-5366', '今古大观', '历史地理', '吉林省地方志编纂委员会', '李云鹤', 45.5, 11, '2016-03-10',
        'BookImg/4138b2ac1dab4ce4b82fe381e7846692.jpg');
INSERT INTO `Book`
VALUES (9, '1003-6555', '文物春秋', '历史地理', '河北省文化和旅游厅', '罗向军', 33.6, 22, '2019-08-01',
        'BookImg/46fc160d6cde44feb32f5cff12a0b773.jpg');
INSERT INTO `Book`
VALUES (10, '1005-6033', '科技情报开发与经济', '科技', '山西省科技厅', '邱娅男', 54.2, 10, '2011-11-03',
        'BookImg/ee81dac27a00411c8d44cb4bef87e5cb.jpg');
INSERT INTO `Book`
VALUES (11, '1674-6708', '科技传播', '科技', '中国科学技术协会', '叶昌盛', 16, 33, '2021-02-06',
        'BookImg/c684617d01e1466fb056f2ef6d6fe2a5.jpg');
INSERT INTO `Book`
VALUES (12, '2096-1936', '智能城市', '科技', '辽宁省重要技术创新与研发基地建设工程中心', '董媛媛', 79, 44, '2021-08-09',
        'BookImg/f116ff50c16e4533bb0796169a59651f.jpg');
INSERT INTO `Book`
VALUES (13, '1000-3045', '中国科学院院刊', '科技', '中国科学院', '白春礼', 32, 1, '2021-12-21',
        'BookImg/8b58257db92c463c89a1f22dc29edca3.jpg');
INSERT INTO `Book`
VALUES (14, '1002-6142', '北京电影学院学报', '艺术', '北京市教育委员会', '吴冠平', 8.9, 4, '2016-05-07',
        'BookImg/444b7bd6937c4938a4efef5dadc67925.jpg');
INSERT INTO `Book`
VALUES (15, '1005-3255', '当代美术家', '艺术', '四川美术学院', '庞茂堒', 55.1, 6, '2017-10-03',
        'BookImg/37572807acd749a8abcbe58558b93267.jpg');
INSERT INTO `Book`
VALUES (16, '1007-4910', '歌海', '艺术', '广西民族文化艺术研究院', '黄文富', 22.3, 9, '2019-03-02',
        'BookImg/2b78f316424042aea07b44d5396e2ebc.jpg');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
    `id`       tinyint(0)                                              NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
    `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '密码',
    `sex`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '性别',
    `number`   varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '电话号码',
    `admin`    int(0)                                                  NULL DEFAULT NULL COMMENT '权限',
    `identity` int(0)                                                  NULL DEFAULT NULL COMMENT '学生0 老师1',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User`
VALUES (1, 'admin', '6a261e7308dfd611b9ed91d627368967', 'M', '18109273856', 1, 0);
INSERT INTO `User`
VALUES (2, 'user', '6a261e7308dfd611b9ed91d627368967', 'M', '15686253002', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
