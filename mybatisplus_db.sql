/*
SQLyog Enterprise v12.14 (64 bit)
MySQL - 5.7.28-log : Database - mybatisplus_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisplus_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatisplus_db`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `age` int(3) NOT NULL,
  `tel` varchar(32) NOT NULL,
  `delete` int(1) DEFAULT '0',
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`pwd`,`age`,`tel`,`delete`,`version`) values 
(2,'崔永红','jerry',4,'16688886666',0,2),
(3,'Jock','123456',41,'18812345678',0,1),
(4,'传智播客','itcast',15,'4006184000',0,1),
(5,'崔巍','123456',20,'888888',0,1),
(6,'胡斌','123456',21,'333333',0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
