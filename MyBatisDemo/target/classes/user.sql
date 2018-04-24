create database MybatisTest;
use MybatisTest;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32),
  `birthday` date,
  `address` varchar(256),
  PRIMARY KEY (`id`) USING BTREE
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'testUser', '2014-06-30', '123');