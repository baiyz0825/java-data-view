--创建数据库--
CREATE
DATABASE IF NOT EXISTS bookjava;
--使用数据库
USE
bookjava;
--创建表--
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`           tinyint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `number`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
    `name`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
    `sortBook`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '分类',
    `publisher`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '出版社\r\n',
    `author`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '作者',
    `prices`       double NULL DEFAULT NULL COMMENT '价格',
    `remainNumber` int(0) NULL DEFAULT NULL COMMENT '剩余数量',
    `publishData`  date                                                    NOT NULL COMMENT '出版时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
--插入表--
insert into book (number, name, sortBook, publisher, author, prices, remainNumber, publishData)
values ('201585', '科学中国', '科普', '中国科普出版社', '中新', '55.4', '10', '2021-1-1'),
       ('22165', 'C语言周报', '计算机', '中国新时代计算机出版社', '中新', '112', '2', '2001-8-9'),
       ('88945', '易经', '文学', '文学社', '李品', '19.9', '5', '2017-5-6'),
       ('7548685', '古气候分析', '地理', '中国史诗气候局', '杨勇', '39', '7', '2020-10-1'),
       ('98745632', '大学化学期刊报', '科学', '中国科普出版社', '李毅', '31.2', '1', '2011-7-1'),
       ('88945', '唐诗', '文学', '文学社', '杨欣', '11.9', '2', '2019-2-28');