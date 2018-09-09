# Host: localhost  (Version: 5.5.27)
# Date: 2018-09-09 10:40:26
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "company"
#

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(15) DEFAULT NULL COMMENT '名称',
  `addr` varchar(50) DEFAULT NULL COMMENT '地址',
  `co` varchar(30) DEFAULT NULL COMMENT '坐标',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `money` float(5,2) DEFAULT NULL COMMENT '均价',
  `wifi` varchar(1) DEFAULT '有' COMMENT 'WIFI',
  `hot` varchar(1) DEFAULT '有' COMMENT '24小时热水',
  `tv` varchar(1) DEFAULT '有' COMMENT '电视',
  `fcar` varchar(1) DEFAULT '有' COMMENT '免费停车',
  `air` varchar(1) DEFAULT '有' COMMENT '空调',
  `pica` varchar(150) DEFAULT NULL COMMENT '图片a',
  `picb` varchar(150) DEFAULT NULL COMMENT '图片B',
  `picc` varchar(150) DEFAULT NULL COMMENT '图片c',
  `picd` varchar(150) DEFAULT NULL COMMENT '图片d',
  `pice` varchar(150) DEFAULT NULL COMMENT '图片e',
  `picf` varchar(150) DEFAULT NULL COMMENT '图片f',
  `info` text COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "company"
#

INSERT INTO `company` VALUES (1,'北戴河如家旅馆','河北省秦皇岛市北戴河区666号','100','1234556','987-4871171',100.00,'有','有','有','有','有','1533286602915.jpg','1533199584216.jpg','1533199584158.jpg','1533199584203.jpg','1533199584188.jpg','1533199584149.jpg','<p>营口仙人岛宾馆位于河北省营口仙人岛国家森林公园之中，是一座集度假、会议、住宿、餐饮、娱乐、温泉洗浴等多功能为一体的园林别墅式酒店。曾多次接待中央及省、市领导。是您迎春踏青、消夏避暑、金秋赏月、冬觅清幽的上佳之选。<br/><strong>酒店环境</strong>——仙人岛宾馆依林傍海，景色怡人，万亩槐林环抱之中，形成了天然氧吧，漫步林间，享受大自然带给您的清幽与恬淡。<br/><strong>酒店餐饮</strong>——宾馆设大小包房7间，大厅可同时容纳100人就餐。融合多年接待国家首长经验，使得这里成为品尝本地海鲜、传统辽菜的好去处。 <br/><strong>酒店客房</strong>——宾馆住宿共有大小别墅6栋，别墅内设标准间、单人间、套房、家庭房、豪华标准间及豪华套房。房间设有中央空调、闭路电视及卫星接收装置、宽带上网、国内、国际直播电话、温泉水洗浴，为您提供舒适优雅、宁静温馨的度假环境。<br/><strong>休闲娱乐</strong>——宾馆设桑拿浴、棋牌室、大型户外网球场。桑拿浴区用水为具有医疗保健作用的温泉水，豪华冲浪浴缸，现金的红外线人体干身机，电子遥控休息床，专业技师精湛服务，整体浴室为您提供舒适沐浴环境。<br/><strong>酒店会议</strong>——不同规格的会议室，能满足各种会议所需，多媒体灯光设施，训练有素的服务人员随时提供巨细无遗的殷勤服务。<br/><strong>园林烧烤</strong>——酒店烧烤区位于郁郁葱葱的槐林之中，特色内蒙古烤全羊、烤羊腿，露天烧烤，让您在大自然的清新中享受美味。<br/><strong>园林婚礼</strong>——蓝天、碧草、槐林、别墅，办一场草坪婚礼，让爱情回归纯粹！700平米的草坪，打造您的唯美与浪漫。</p>');

#
# Source for table "kind"
#

CREATE TABLE `kind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `icon` varchar(20) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `kprice` float(7,2) DEFAULT NULL COMMENT '基本价格',
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "kind"
#

INSERT INTO `kind` VALUES (1,'大床房','111','大床房',600.00,1),(2,'标准间','','双人标准间',100.00,1),(3,'家庭房','','家庭房',500.00,1),(4,'套房',NULL,'套房',1000.00,1),(5,'总统套房',NULL,'豪华套房',5000.00,NULL);

#
# Source for table "hprice"
#

CREATE TABLE `hprice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `kid` int(11) DEFAULT NULL COMMENT '房间类型',
  `sdate` date DEFAULT NULL COMMENT '开始日期',
  `edate` date DEFAULT NULL COMMENT '截止日期',
  `price` float(6,2) DEFAULT NULL COMMENT '单价',
  `dis` float(5,2) DEFAULT NULL COMMENT '折扣',
  `status` smallint(6) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `kid` (`kid`),
  CONSTRAINT `hprice_ibfk_1` FOREIGN KEY (`kid`) REFERENCES `kind` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "hprice"
#

INSERT INTO `hprice` VALUES (2,4,'2018-07-01','2018-01-09',800.00,0.90,1),(3,1,'2018-08-02','2018-08-12',300.00,0.80,1),(4,3,'2018-07-12','2018-07-20',500.00,0.50,1),(6,1,'2018-05-26','2018-07-06',100.00,0.90,1);

#
# Source for table "house"
#

CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hname` varchar(20) NOT NULL DEFAULT '' COMMENT '客房编号',
  `kid` int(11) DEFAULT NULL COMMENT '类型',
  `size` int(3) DEFAULT NULL COMMENT '大小',
  `beds` smallint(1) DEFAULT '1' COMMENT '床位数',
  `price` float(7,2) DEFAULT NULL COMMENT '价格',
  `dis` float(5,2) DEFAULT NULL COMMENT '折扣',
  `info` varchar(200) DEFAULT NULL COMMENT '备注',
  `pica` varchar(150) DEFAULT NULL,
  `picb` varchar(150) DEFAULT NULL,
  `picc` varchar(150) DEFAULT NULL,
  `picd` varchar(150) DEFAULT NULL,
  `pice` varchar(150) DEFAULT NULL,
  `picf` varchar(150) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `kid` (`kid`),
  CONSTRAINT `house_ibfk_1` FOREIGN KEY (`kid`) REFERENCES `kind` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

#
# Data for table "house"
#

INSERT INTO `house` VALUES (1,'A103',1,150,3,150.00,NULL,'大床房','1532747944055.jpg','1536197799574.jpg',NULL,NULL,NULL,NULL,1),(2,'A104',4,200,2,200.00,NULL,'套房','1535630057242.jpg','1535630057326.jpg',NULL,NULL,NULL,NULL,1),(3,'A105',2,100,2,100.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(4,'A106',3,200,4,200.00,NULL,'家庭房',NULL,NULL,NULL,NULL,NULL,NULL,1),(11,'A107',2,22,22,22.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(12,'A108',2,100,2,100.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(13,'A109',2,100,2,100.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(14,'A110',1,100,2,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(16,'A201',2,100,2,100.00,NULL,'双人标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(17,'A202',1,100,2,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(18,'A203',2,100,2,100.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(19,'A204',2,200,2,200.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(20,'A205',3,200,5,100.00,NULL,'标准间',NULL,NULL,NULL,NULL,NULL,NULL,1),(21,'A301',1,5,5,5.00,NULL,'大床房',NULL,NULL,NULL,NULL,NULL,NULL,1),(22,'A302',2,100,5,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(23,'A303',1,100,1,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(24,'A304',2,100,2,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(25,'A305',2,100,2,100.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(26,'A306',1,2,2,2.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(27,'A307',3,1,1,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(28,'A308',3,1,1,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(29,'A309',4,1,1,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(30,'A310',1,1,1,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(32,'A401',2,4,4,4.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(33,'A402',3,4,4,4.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(34,'A403',1,1,1,1.00,NULL,'1','1532745670168.jpg',NULL,NULL,NULL,NULL,NULL,1),(35,'207',2,100,2,100.00,NULL,'双人标准间','1532748248127.jpg',NULL,NULL,NULL,NULL,NULL,1),(36,'208',2,1,1,1.00,NULL,NULL,'1532748382365.jpg',NULL,NULL,NULL,NULL,NULL,1),(37,'A101',2,100,2,100.00,NULL,'带热水器','1533136426254.jpg',NULL,NULL,NULL,NULL,NULL,1),(38,'A102',3,1,1,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);

#
# Source for table "msg"
#

CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `rdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg"
#


#
# Source for table "msgset"
#

CREATE TABLE `msgset` (
  `total` int(11) NOT NULL DEFAULT '1',
  `margin` int(11) DEFAULT NULL,
  `tempid` varchar(15) DEFAULT NULL,
  `tempxid` varchar(15) DEFAULT NULL,
  `tempsid` varchar(15) DEFAULT NULL,
  `sign` varchar(20) DEFAULT NULL,
  `appid` varchar(15) DEFAULT NULL,
  `appkey` varchar(32) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msgset"
#

INSERT INTO `msgset` VALUES (100,NULL,'1111','2222','3333','normal\n','15484\n','451212328140259050c8db7f7a0c020b','15033503371');

#
# Source for table "power"
#

CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(11) DEFAULT NULL COMMENT '父类id',
  `name` varchar(15) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(50) DEFAULT NULL COMMENT '地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `xh` smallint(6) DEFAULT NULL COMMENT '排序号',
  `status` smallint(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

#
# Data for table "power"
#

INSERT INTO `power` VALUES (1,0,'首页','index.html','glyphicon glyphicon-home',0,1),(2,0,'客房预订管理','#','glyphicon glyphicon-book',1,1),(3,0,'客房入住管理','#','glyphicon glyphicon-log-in',4,1),(4,0,'客房价格设置','#','glyphicon glyphicon-yen',7,1),(5,0,'客房管理','#','glyphicon glyphicon-th',10,1),(6,0,'客房类型管理','#','glyphicon glyphicon-cog',13,1),(7,0,'旅游攻略管理','#','glyphicon glyphicon-book',16,1),(8,0,'系统短信管理','#','glyphicon glyphicon-envelope',19,1),(9,0,'收付款管理','#','glyphicon glyphicon-yen',22,1),(10,0,'数据统计分析','#',' glyphicon glyphicon-stats',25,1),(11,0,'基本信息设置','#','glyphicon glyphicon-flag',29,1),(12,2,'客房预订','reserve.html','glyphicon glyphicon-plus',2,1),(13,2,'预订查询','reserves.html','glyphicon glyphicon-search',3,1),(14,3,'旅客入住','record.html','glyphicon glyphicon-plus',5,1),(15,3,'客房入住查询','records.html','glyphicon glyphicon-search',6,1),(16,4,'客房价格设置','hprice.html','glyphicon glyphicon-plus',8,1),(17,4,'客房价格列表','hprices.html','glyphicon glyphicon-search',9,1),(18,5,'添加客房','house.html','glyphicon glyphicon-plus',11,1),(19,5,'客房查询','houses.html','glyphicon glyphicon-search',12,1),(20,6,'添加客房类型','kind.html','glyphicon glyphicon-plus',14,1),(21,6,'客房类型管理','kinds.html','glyphicon glyphicon-search',15,1),(22,7,'发布旅游攻略','tour.html','glyphicon glyphicon-plus',17,1),(23,7,'旅游攻略查询','tours.html','glyphicon glyphicon-search',18,1),(24,8,'短信记录查询','msgs,html','glyphicon glyphicon-search',20,1),(25,8,'短信设置参数','msgset.html','glyphicon glyphicon-edit',21,1),(26,9,'收款处理','pays.html','glyphicon glyphicon-yen',23,1),(27,9,'退款处理','paystate.html','glyphicon glyphicon-yen',24,1),(28,10,'客房类型数据统计','houseKind.html','glyphicon glyphicon-stats',26,1),(29,10,'入住数据统计','recordstate.html','glyphicon glyphicon-stats',27,1),(30,10,'收款数据统计','paystate.html','glyphicon glyphicon-stats',28,1),(31,11,'基本信息设置','company.html','glyphicon glyphicon-edit',30,1),(32,11,'修改登陆密码','changepwd.html','glyphicon glyphicon-edit',31,1),(33,0,'系统权限管理','#',' glyphicon glyphicon-asterisk',32,1),(34,33,'添加系统权限','power.html','glyphicon glyphicon-plus',33,1),(35,33,'系统权限列表','powers.html','glyphicon glyphicon-search',34,1),(36,0,'管理员管理用户','#','glyphicon glyphicon-user',35,1),(37,36,'管理员用户列表','users.html','glyphicon glyphicon-search',36,1),(38,36,'添加管理员用户','user.html','glyphicon glyphicon-plus',37,1);

#
# Source for table "record"
#

CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom` varchar(15) DEFAULT NULL,
  `wxnick` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `persons` int(2) DEFAULT NULL,
  `rtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rdate` date DEFAULT NULL,
  `ldate` date DEFAULT NULL,
  `hid` int(11) DEFAULT NULL,
  `price` float(7,2) DEFAULT NULL,
  `total` float(6,2) DEFAULT NULL,
  `res` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `hid` (`hid`),
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`hid`) REFERENCES `house` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "record"
#

INSERT INTO `record` VALUES (1,'张三',NULL,' 15033503378',2,'2018-08-12 14:33:37','2018-09-03','2018-09-30',3,100.00,2700.00,1),(2,'李四',NULL,'12345678911',5,'2018-08-12 14:33:39','2018-08-07','2018-08-10',22,1000.00,3000.00,1),(3,'小倩',NULL,'12345678912',3,'2018-08-12 14:33:41','2018-08-17','2018-08-22',3,100.00,500.00,1),(4,'赵四',NULL,'15033693356',2,'2018-08-12 14:50:55','2018-08-08','2018-08-11',11,240.00,720.00,1),(5,'ccc',NULL,'13931922508',NULL,'2018-08-12 08:07:09','2018-08-15','2018-08-24',19,240.00,2160.00,1),(10,'aaaa',NULL,'15646546',3,'2018-08-12 08:06:11','2018-08-16','2018-08-24',13,240.00,1920.00,1),(11,'dd','','12345678963',NULL,'2018-08-12 14:50:51','2018-08-12','2018-08-31',21,240.00,4560.00,1);

#
# Source for table "reserve"
#

CREATE TABLE `reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom` varchar(15) DEFAULT NULL COMMENT '客人',
  `wxnick` varchar(15) DEFAULT NULL COMMENT '微信昵称',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `persons` int(2) DEFAULT NULL COMMENT '入住人数',
  `rtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间',
  `rdate` date DEFAULT NULL COMMENT '入住日期',
  `ldate` date DEFAULT NULL COMMENT '离店日期',
  `hid` int(11) DEFAULT NULL COMMENT '房间号',
  `price` float(7,2) DEFAULT NULL COMMENT '单价',
  `total` float(6,2) DEFAULT NULL COMMENT '总金额',
  `res` int(1) DEFAULT '1' COMMENT '预定状态',
  PRIMARY KEY (`id`),
  KEY `hid` (`hid`),
  CONSTRAINT `reserve_ibfk_1` FOREIGN KEY (`hid`) REFERENCES `house` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "reserve"
#

INSERT INTO `reserve` VALUES (1,'张三','张三',' 15033503378',2,'2018-08-12 06:04:42','2018-09-03','2018-09-30',3,100.00,2700.00,0),(2,'李四',NULL,'12345678911',5,'2018-08-12 06:09:46','2018-08-07','2018-08-10',22,1000.00,3000.00,0),(3,'王五','王五','98765432100',3,'2018-08-07 10:14:36','2018-08-15','2018-08-30',1,100.00,1500.00,1),(4,'赵四',NULL,'15033693356',2,'2018-08-12 07:44:35','2018-08-08','2018-08-11',11,240.00,720.00,0),(5,'小倩','','12345678912',3,'2018-08-12 07:43:11','2018-08-17','2018-08-22',3,100.00,500.00,0),(6,'aaaa','','15646546456',3,'2018-08-12 08:07:42','2018-08-16','2018-08-24',13,240.00,1920.00,0),(7,'bbbb','','13532677789',3,'2018-08-12 08:07:57','2018-08-16','2018-08-24',16,100.00,800.00,1),(8,'ccc','','13931922508',NULL,'2018-08-12 08:07:00','2018-08-15','2018-08-24',19,240.00,2160.00,1);

#
# Source for table "tour"
#

CREATE TABLE `tour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "tour"
#

INSERT INTO `tour` VALUES (1,'老龙头景区','2018-08-01 00:00:00','<p>老龙头景区位于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B1%B1%E6%B5%B7%E5%85%B3/319595\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">山海关</a>城南五公里处的渤海之滨，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%98%8E%E9%95%BF%E5%9F%8E\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">明长城</a>东部起点。万里长城犹如一条巨龙，走过大漠，跨过群山，从<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%87%95%E5%B1%B1%E5%B1%B1%E8%84%89\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">燕山山脉</a>婉蜒而下，直冲入海，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%80%81%E9%BE%99%E5%A4%B4/1427960\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">老龙头</a>因此得名。19</p><p><a class=\"image-link\" href=\"https://baike.baidu.com/pic/%E8%80%81%E9%BE%99%E5%A4%B4%E6%99%AF%E5%8C%BA/2836067/0/b6045da9d6b459c11f17a275?fr=lemma&ct=single\" target=\"_blank\" title=\"老龙头景区\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 220px; height: 148px;\"><img class=\"\" src=\"https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=c15847f5a786c9170c03553bf93c70c6/0e2442a7d933c89585d13b76d11373f08202000b.jpg\" alt=\"老龙头景区\"/></a><span class=\"description\" style=\"display: block; color: rgb(85, 85, 85); font-size: 12px; text-indent: 0px; font-family: 宋体; word-wrap: break-word; word-break: break-all; line-height: 15px; padding: 8px 7px; min-height: 12px; border-top: 1px solid rgb(224, 224, 224);\">老龙头景区</span></p><p>00年<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%AB%E5%9B%BD%E8%81%94%E5%86%9B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">八国联军</a>入侵，作为清代<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B5%B7%E9%98%B2%E5%89%8D%E5%93%A8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">海防前哨</a>，老龙头毁于战火。自1985年开始，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B1%B1%E6%B5%B7%E5%85%B3%E5%8C%BA\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">山海关区</a>响应<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%82%93%E5%B0%8F%E5%B9%B3\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">邓小平</a>同志的“爱我中华、修我长城”的号召，历时八年，经过四期工程，终于使<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%80%81%E9%BE%99%E5%A4%B4/1427960\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">老龙头</a>再现昔日雄姿。老龙头呈半岛状伸入海中，墙体沿海岸线自然弯曲延伸，由石块垒砌而成，分为入海石城、海神庙、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%96%E5%8D%A4%E5%8F%B0/4841286\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">靖卤台</a>、南海口、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%BE%84%E6%B5%B7%E6%A5%BC/5152742\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">澄海楼</a>、宁海城和滨海长城等七部分。其中入海石城相传为明朝抗倭名将戚继光所筑，高约三丈，有一半位于海平面以下，后来坍塌，现存浸于海水中的花岗岩基石依然可见；澄海楼则是老龙头的最高点，是观海胜地，清朝皇帝康熙、乾隆回奉天祭祖时，曾多次登临此楼，眺海赋诗，其“澄海楼”的额匾为清朝乾隆帝亲笔所书，在东西墙壁之上嵌有清朝皇帝和文人墨客诗作的石碑，楼体为全木质结构，楼内陈列有在老龙头地区出土的文物，以及建国后部分党和<a class=\"lemma-album layout-right nslog:10000206\" title=\"老龙头景区\" href=\"https://baike.baidu.com/pic/%E8%80%81%E9%BE%99%E5%A4%B4%E6%99%AF%E5%8C%BA/2836067/21516809/9213b07eca8065381e48dcee9edda144ac3482a8?fr=lemma&ct=cover\" target=\"_blank\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 222px; border-bottom: 0px; margin: 10px 0px; position: relative; float: right; clear: right;\"></a></p><p><a class=\"lemma-album layout-right nslog:10000206\" title=\"老龙头景区\" href=\"https://baike.baidu.com/pic/%E8%80%81%E9%BE%99%E5%A4%B4%E6%99%AF%E5%8C%BA/2836067/21516809/9213b07eca8065381e48dcee9edda144ac3482a8?fr=lemma&ct=cover\" target=\"_blank\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 222px; border-bottom: 0px; margin: 10px 0px; position: relative; float: right; clear: right;\"><img class=\"picture\" alt=\"老龙头景区\" src=\"https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=a0640edb64224f4a5399741139f69044/9213b07eca8065381e48dcee9edda144ac3482a8.jpg\"/></a></p><p><a class=\"lemma-album layout-right nslog:10000206\" title=\"老龙头景区\" href=\"https://baike.baidu.com/pic/%E8%80%81%E9%BE%99%E5%A4%B4%E6%99%AF%E5%8C%BA/2836067/21516809/9213b07eca8065381e48dcee9edda144ac3482a8?fr=lemma&ct=cover\" target=\"_blank\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 222px; border-bottom: 0px; margin: 10px 0px; position: relative; float: right; clear: right;\">老龙头景区<span class=\"number\" style=\"display: inline; color: gray;\">(5张)</span></a></p><p>&nbsp;国家领导人的题词等。</p><p><br/></p><p>1840年以后，英法等列强的军舰多次游弋于此，并于1900年强占<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B1%B1%E6%B5%B7%E5%85%B3/319595\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">山海关</a>，炮轰<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%80%81%E9%BE%99%E5%A4%B4/1427960\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">老龙头</a>、焚毁<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%BE%84%E6%B5%B7%E6%A5%BC/5152742\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">澄海楼</a>，继而划界盘踞于此，对老龙头进行了严重破坏，建国后，从1985年开始，国家对老龙头进行了修复，历时8年，使老龙头向世人重新展示原有面貌时，肩负起了新时代的历史使命——爱国主义教育。</p><p><br/></p>'),(5,'啊啊啊啊','2018-08-01 00:00:00','<p>啊大苏打VS东方华府不顾</p>');

#
# Source for table "user"
#

CREATE TABLE `user` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (8,'admin','21232F297A57A5A743894A0E4A801FC3','2'),(9,'tomcat','1B359D8753858B55BEFA0441067AAED3','2'),(10,'pihuiyou','8ACCE00823BA2856BA24AA3403E851D7','1');

#
# Source for table "rule"
#

CREATE TABLE `rule` (
  `uid` int(11) NOT NULL DEFAULT '0',
  `pid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`,`pid`),
  KEY `pid` (`pid`),
  CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `rule_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `power` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "rule"
#

INSERT INTO `rule` VALUES (8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7),(8,8),(8,9),(8,10),(8,11),(8,12),(8,13),(8,14),(8,15),(8,16),(8,17),(8,18),(8,19),(8,20),(8,21),(8,22),(8,23),(8,24),(8,25),(8,26),(8,27),(8,28),(8,29),(8,30),(8,31),(8,32),(8,33),(8,34),(8,35),(8,36),(8,37),(8,38),(9,1),(9,2),(9,3),(9,4),(9,5),(9,6),(9,7),(9,8),(9,9),(9,10),(9,11),(9,12),(9,13),(9,14),(9,15),(9,16),(9,17),(9,18),(9,19),(9,20),(9,21),(9,22),(9,23),(9,24),(9,25),(9,26),(9,27),(9,28),(9,29),(9,30),(9,31),(9,32),(9,33),(9,34),(9,35),(10,1),(10,2),(10,3),(10,5),(10,8),(10,9),(10,10),(10,11),(10,12),(10,13),(10,14),(10,15),(10,19),(10,24),(10,26),(10,27),(10,28),(10,29),(10,30),(10,32);

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
