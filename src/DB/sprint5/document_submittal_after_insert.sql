/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 : Database - ontargetbeta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ontargetbeta` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `ontargetbeta`;

/* Trigger structure for table `document_submittal` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `document_submittal_after_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `document_submittal_after_insert` AFTER INSERT ON `document_submittal` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	
	SET projectId		= getProjectIdByDocumentId(NEW.document_id);
	SET documentId 	= NEW.document_id;
	
	IF NEW.assignee_user_id !=NEW.created_by THEN
	
		INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
		VALUES('CREATE','DOCUMENT_SUBMITTAL_ASSIGN',projectId,NOW());
			
		SET notificationId = LAST_INSERT_ID();
				
		INSERT INTO user_notification(STATUS,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.assignee_user_id);
			
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('documentId',documentId,notificationId);
			
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('projectId',projectId,notificationId);
				
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('userId',NEW.created_by,notificationId);
	END IF;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;