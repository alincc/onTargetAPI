/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 : Database - ontarget
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ontarget` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ontarget`;

/* Function  structure for function  `getActivityNameById` */

/*!50003 DROP FUNCTION IF EXISTS `getActivityNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getActivityNameById`(projectId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE activityName VARCHAR(100);
  SET activityName = (SELECT project_name FROM project WHERE project_id = projectId);
  RETURN activityName;
END */$$
DELIMITER ;

/* Function  structure for function  `getProjectTaskTitleById` */

/*!50003 DROP FUNCTION IF EXISTS `getProjectTaskTitleById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectTaskTitleById`(projectTaskId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE projectTaskTitle VARCHAR(100);
  SET projectTaskTitle = (SELECT title FROM project_task WHERE project_task_id = projectTaskId);
  RETURN projectTaskTitle;
END */$$
DELIMITER ;

/* Function  structure for function  `getProjectTitleById` */

/*!50003 DROP FUNCTION IF EXISTS `getProjectTitleById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectTitleById`(projectId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE projectTitle VARCHAR(100);
  SET projectTitle = (SELECT project_name FROM project WHERE project_id = projectId);
  RETURN projectTitle;
END */$$
DELIMITER ;

/* Function  structure for function  `get_userNameById` */

/*!50003 DROP FUNCTION IF EXISTS `get_userNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `get_userNameById`(userId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE userName VARCHAR(100);
  SET userName = (SELECT user_name FROM ontarget.`user` WHERE user_id = userId);
  RETURN userName;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
