/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : webims

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2013-09-08 22:49:41
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `age` int(3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('2', 'Suhao1', '432');
INSERT INTO user VALUES ('3', 'Suhao2', '25');
INSERT INTO user VALUES ('4', 'Suhao3', '25');
INSERT INTO user VALUES ('5', 'Suhao4', '25');
INSERT INTO user VALUES ('6', 'Suhao5', '362');
INSERT INTO user VALUES ('7', 'Suhao6', '407');
INSERT INTO user VALUES ('8', 'Suhao7', '805');
INSERT INTO user VALUES ('9', 'Suhao8', '452');
INSERT INTO user VALUES ('10', 'Suhao9', '894');
INSERT INTO user VALUES ('11', '6Bbt', '203');
INSERT INTO user VALUES ('12', 'laIT', '506');
INSERT INTO user VALUES ('13', 'meHi', '851');
INSERT INTO user VALUES ('14', 'DurZ', '195');
INSERT INTO user VALUES ('15', '2v9N', '821');
INSERT INTO user VALUES ('16', 'EEhH', '85');
INSERT INTO user VALUES ('17', 'X8eq', '178');
INSERT INTO user VALUES ('18', 'test1122', '1122');
INSERT INTO user VALUES ('19', 'test5566', '5566');
INSERT INTO user VALUES ('20', 'test??', '5566');
INSERT INTO user VALUES ('21', 'test8844', '5566');
INSERT INTO user VALUES ('22', 'test8844', '5566');
INSERT INTO user VALUES ('23', 'Wef', '4433');
INSERT INTO user VALUES ('24', '4344', '4444');
INSERT INTO user VALUES ('25', 'yy', '5566');
INSERT INTO user VALUES ('26', '555', '555');
INSERT INTO user VALUES ('27', '555', '555');
INSERT INTO user VALUES ('28', '555', '555');
INSERT INTO user VALUES ('29', '653', '36');
INSERT INTO user VALUES ('30', 'suhao', '4455');
INSERT INTO user VALUES ('31', 'Mima', '789');
INSERT INTO user VALUES ('32', 'Mima', '789');
INSERT INTO user VALUES ('33', 'Re', '789');
INSERT INTO user VALUES ('34', 'UI', '908');
INSERT INTO user VALUES ('35', 'UI', '900');
INSERT INTO user VALUES ('36', 'UI', '900');
INSERT INTO user VALUES ('37', 'UI', '900');
INSERT INTO user VALUES ('38', 'YuI', '8899');
INSERT INTO user VALUES ('39', '5566', '5566');
INSERT INTO user VALUES ('40', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('41', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('42', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('43', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('44', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('45', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('46', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('47', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('48', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('49', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('50', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('51', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('52', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('53', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('54', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('55', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('56', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('57', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('58', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('59', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('60', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('61', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('62', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('63', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('64', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('65', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('66', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('67', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('68', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('69', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('70', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('71', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('72', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('73', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('74', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('75', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('76', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('77', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('78', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('79', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('80', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('81', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('82', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('83', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('84', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('85', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('86', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('87', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('88', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('89', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('90', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('91', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('92', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('93', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('94', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('95', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
INSERT INTO user VALUES ('96', '《中国好声音》导师考核第2场即将于本周五晚21:10分在浙江卫视华丽起航。 中国好声音吧邀您相聚贴吧，畅聊中国好声', '111');
