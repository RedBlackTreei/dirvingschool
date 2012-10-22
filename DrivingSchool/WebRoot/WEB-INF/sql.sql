/*
SQLyog Ultimate v9.62 
MySQL - 5.5.27 : Database - drivingschool
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drivingschool` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `drivingschool`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plateNum` varchar(255) DEFAULT NULL,
  `regDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `coachId` bigint(20) DEFAULT NULL,
  `stuId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK107B4124A84FB` (`stuId`),
  KEY `FK107B4D44B480` (`coachId`),
  CONSTRAINT `FK107B4D44B480` FOREIGN KEY (`coachId`) REFERENCES `person` (`personId`),
  CONSTRAINT `FK107B4124A84FB` FOREIGN KEY (`stuId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`id`,`plateNum`,`regDate`,`remark`,`type`,`coachId`,`stuId`) values (1,'闽H354300','Sat Oct 2','好车！','奥迪A6',1,2);

/*Table structure for table `item_coach` */

DROP TABLE IF EXISTS `item_coach`;

CREATE TABLE `item_coach` (
  `itemId` bigint(20) NOT NULL,
  `coachId` bigint(20) NOT NULL,
  PRIMARY KEY (`itemId`,`coachId`),
  KEY `FK8AC3086EF7AB18D4` (`itemId`),
  KEY `FK8AC3086ED44B480` (`coachId`),
  CONSTRAINT `FK8AC3086ED44B480` FOREIGN KEY (`coachId`) REFERENCES `person` (`personId`),
  CONSTRAINT `FK8AC3086EF7AB18D4` FOREIGN KEY (`itemId`) REFERENCES `studyitems` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_coach` */

insert  into `item_coach`(`itemId`,`coachId`) values (1,1);

/*Table structure for table `localofsign` */

DROP TABLE IF EXISTS `localofsign`;

CREATE TABLE `localofsign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `localofsign` */

insert  into `localofsign`(`id`,`Address`,`name`,`tel`) values (1,'武夷学院','武夷驾校','15280756453');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(6000) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`newsId`,`content`,`date`,`title`) values (1,'据日本媒体报道，美国和日本取消了原定于11月5日起举行的联合夺岛军事实弹演习，据称是为了避免刺激中国。日本新闻网10月19日报道援引消息人士的话说，为了避免刺激中国，日美两国政府决定取消原定于11月5日起举行的联合夺岛军事实弹演习。同时，美国政府担心，这一次的联合夺岛军事演习将会给日中紧张关系增添危机。日本政府内部也出现了对此表示慎重的声音。此外，而近日发生的美军士兵轮奸冲绳女性的问题，也让冲绳县民对于日美两军在冲绳县的入砂岛实施实弹夺岛演习感到反感。该消息人士称，综合因素导致日美两国政府决定取消这一次联合军事演习。','2012-10-20','传日美取消联合夺岛演习 被指为避免刺激中国');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `discriminator` varchar(31) NOT NULL,
  `personId` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `idNum` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `isStuFull` tinyint(1) DEFAULT NULL,
  `stuNum` varchar(255) DEFAULT NULL,
  `teachSubject` varchar(255) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `fee` double DEFAULT NULL,
  `finshedSub` int(11) DEFAULT NULL,
  `isPayfee` tinyint(1) DEFAULT NULL,
  `schoolTime` varchar(255) DEFAULT NULL,
  `coachId` bigint(20) DEFAULT NULL,
  `localId` bigint(20) DEFAULT NULL,
  `stuFull` tinyint(1) DEFAULT NULL,
  `payfee` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `FK8C768F55715BFD36` (`localId`),
  KEY `FK8C768F55D44B480` (`coachId`),
  CONSTRAINT `FK8C768F55715BFD36` FOREIGN KEY (`localId`) REFERENCES `localofsign` (`id`),
  CONSTRAINT `FK8C768F55D44B480` FOREIGN KEY (`coachId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`discriminator`,`personId`,`address`,`idNum`,`name`,`password`,`sex`,`tel`,`username`,`isStuFull`,`stuNum`,`teachSubject`,`dateOfEntry`,`fee`,`finshedSub`,`isPayfee`,`schoolTime`,`coachId`,`localId`,`stuFull`,`payfee`) values ('coach',1,'2-4#101','341227198701282634','纪森','8053263',1,'15280774223','jishen521',0,NULL,'item3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('student',2,'2-3#301','2138412384081203498','墨水','101',1,'12388347876','ji',NULL,NULL,NULL,'2012-10-20 15:45:05',0,3,1,'8',1,1,NULL,NULL);

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `questionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `question` */

insert  into `question`(`questionId`,`title`) values (4,'驾驶机动车看到这种标志需要注意什么？');

/*Table structure for table `questionitem` */

DROP TABLE IF EXISTS `questionitem`;

CREATE TABLE `questionitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFF841C39D9C2BD16` (`questionId`),
  CONSTRAINT `FKFF841C39D9C2BD16` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `questionitem` */

insert  into `questionitem`(`id`,`item`,`questionId`) values (1,'减速、观察、慢行',4),(2,'鸣喇叭驱赶牲畜',4),(3,'从牲畜的空隙中穿过',4),(4,'低速行驶冲开牲畜群',4);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `stockId` bigint(20) NOT NULL AUTO_INCREMENT,
  `currentNum` int(11) NOT NULL,
  `minNum` int(11) NOT NULL,
  `price` double NOT NULL,
  `storesId` varchar(255) DEFAULT NULL,
  `storesName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

insert  into `stock`(`stockId`,`currentNum`,`minNum`,`price`,`storesId`,`storesName`) values (1,31,50,3679,'367-9842-86395','台式电脑');

/*Table structure for table `studyitems` */

DROP TABLE IF EXISTS `studyitems`;

CREATE TABLE `studyitems` (
  `itemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `classHour` varchar(255) DEFAULT NULL,
  `itemName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `studyitems` */

insert  into `studyitems`(`itemId`,`classHour`,`itemName`) values (1,'48','项目1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
