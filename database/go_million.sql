/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.32 : Database - go_million
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` varchar(20) NOT NULL COMMENT '文章序号',
  `title` varchar(100) NOT NULL COMMENT '文章名称',
  `read_count` varchar(20) NOT NULL COMMENT '文章浏览量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `article_read` */

DROP TABLE IF EXISTS `article_read`;

CREATE TABLE `article_read` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `article_id` varchar(20) DEFAULT NULL COMMENT '文章序号',
  `original_count` varchar(20) DEFAULT NULL COMMENT '当日起始阅览量',
  `final_count` varchar(20) DEFAULT NULL COMMENT '当日最终阅览量',
  `read_add` varchar(20) DEFAULT NULL COMMENT '当日增加的阅览量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
