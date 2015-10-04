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

/* Trigger structure for table `dependent_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_dependentTask_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_dependentTask_add` AFTER INSERT ON `dependent_task` FOR EACH ROW BEGIN
	
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Task ",`getProjectTaskTitleById`(NEW.dependent_task_id)," is made dependent on task",
	`getProjectTaskTitleById`(NEW.task_id)),
	NEW.created_by,11, NOW());	
	
 
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_add` AFTER INSERT ON `planned_actuals_cost` FOR EACH ROW BEGIN
    
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New planned cost added for task ",`getProjectTaskTitleById`(NEW.task_id)),
	New.created_by,6, NOW());	
	
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_update` AFTER UPDATE ON `planned_actuals_cost` FOR EACH ROW BEGIN
	
	
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Planned cost updated for task ",`getProjectTaskTitleById`(NEW.task_id)),
	NEW.modified_by,7, NOW());	
	
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_INSERT` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_INSERT` AFTER INSERT ON `project` FOR EACH ROW BEGIN
	
	DECLARE projectType VARCHAR(20);
	DECLARE notificationId BIGINT;
/*	
	DECLARE projectTypeText VARCHAR(100);
	*/
	
	SELECT TYPE INTO projectType FROM  project WHERE project_id= NEW.project_id;    
    
	if projectType != 'MAIN_PROJECT' THEN
		
		/*
		if projectType = 'PROJECT'   THEN
			SET  projectTypeText = 'New Project';
		ELSE
			SET projectTypeText = 'New Activity';
		END IF; 
				
		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(CONCAT(projectTypeText, ' ',NEW.project_name, " added by ", get_userNameById(NEW.project_owner_id)),
		NEW.project_owner_id,2, NOW(),NEW.project_id);
		*/
		
		INSERT INTO notification(action,notification_type,project_id,ts_insert)
		VALUES('CREATE',projectType,NEW.project_id,NOW());
		
		SET notificationId = LAST_INSERT_ID();
			
		INSERT INTO user_notification(status,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.project_owner_id);
				
		IF projectType = 'ACTIVITY'   THEN	
		
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
					
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.project_owner_id,notificationId);
		
		ELSEIF projectType = 'PROJECT' THEN
		
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.project_owner_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',NEW.project_id,notificationId);
		
		END IF;
		
	END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_UPDATE` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_UPDATE` AFTER UPDATE ON `project` FOR EACH ROW BEGIN
		
	DECLARE projectType VARCHAR(20);
	DECLARE notificationId BIGINT;
		
	SELECT TYPE INTO projectType FROM project WHERE project_id= OLD.project_id;    
	
	IF projectType != 'MAIN_PROJECT' THEN
	
		INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
		VALUES('UPDATE',projectType,OLD.project_id,NOW());
		
		SET notificationId = LAST_INSERT_ID();
			
		INSERT INTO user_notification(STATUS,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.modified_by);
				
		SET notificationId = LAST_INSERT_ID(); 
		
				IF projectType = 'ACTIVITY'   THEN	
					
					INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
					VALUES('activityId',OLD.project_id,notificationId);
					
					INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
					VALUES('projectId',getProjectParentIdById(OLD.project_id),notificationId);
			
					INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
					VALUES('userId',NEW.modified_by,notificationId);
				
				ELSEIF projectType = 'PROJECT' THEN
									
					INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
					VALUES('userId',NEW.modified_by,notificationId);
			
					INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
					VALUES('projectId',OLD.project_id,notificationId);
				
				END IF;
		
	END IF;	
	  
  END */$$


DELIMITER ;

/* Trigger structure for table `project_file` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `onsite_file_uploaded` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `onsite_file_uploaded` AFTER INSERT ON `project_file` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE insertId INT;
	declare projectMember bigint;
	declare done int default false;    
	declare projectFileCreator varchar(30);
	declare verbiage text;
	declare projectMemberCursor cursor for select user_id from project_member where member_status='ACTIVE' AND  project_id=NEW.project_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	set projectFileCreator=get_userNameById(NEW.created_by);
	
	set verbiage=CONCAT(projectFileCreator, " has uploaded ", SUBSTRING_INDEX(NEW.file_name,'/',-1));
			
		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(verbiage,NEW.created_by,5, NOW(),NEW.project_id);
            
    -- send it to the assigner as well
    
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','PROJECT_FILE',NEW.project_id,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,NEW.created_by);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileId',NEW.project_file_id,notificationId);
		
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.created_by,notificationId);
    
    -- multiple users assigned. so when update send notification to all users assigned to.
    
	open projectMemberCursor;
    
    cursor_loop:repeat
	fetch projectMemberCursor into projectMember;
		if done then
			leave cursor_loop;
		end if;
	
		if NEW.created_by != projectMember then 
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','PROJECT_FILE',NEW.project_id,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,projectMember);
					
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileId',NEW.project_file_id,notificationId);
		
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.created_by,notificationId);
			
		end if;
	
    until done
    
    end repeat;
    
    close projectMemberCursor;
END */$$


DELIMITER ;

/* Trigger structure for table `project_file_comment` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `onsite_file_comment` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `onsite_file_comment` AFTER INSERT ON `project_file_comment` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE insertId INT;
	declare projectMember bigint;
	declare projectFileCreatorId bigint;
	declare done int default false;    
	declare projectFileCommentCreator varchar(30);
	declare projectId int(10);
	declare verbiage text;
	DECLARE fileName varchar(100);
	declare projectMemberCursor cursor for select user_id from project_member where member_status='ACTIVE' AND  project_id=(select project_id from project_file where project_file_id=NEW.project_file_id);
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	set projectFileCommentCreator=get_userNameById(NEW.commented_by);
	set projectFileCreatorId=(select created_by from project_file where project_file_id=NEW.project_file_id);
	set projectId=(select project_id from project_file where project_file_id=NEW.project_file_id);
	set fileName = (select file_name from project_file where project_file_id=NEW.project_file_id);
	
	set verbiage=CONCAT(projectFileCommentCreator, " has commented on ", SUBSTRING_INDEX(fileName,'/',-1));
		
	
		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(verbiage,projectFileCreatorId,5, NOW(),projectId);
            
    -- send it to the assigner as well
    
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','PROJECT_FILE_COMMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,NEW.commented_by);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileCommentId',NEW.project_file_comment_id,notificationId);
							
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileId',NEW.project_file_id,notificationId);
							
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.commented_by,notificationId);
			
    
    -- multiple users assigned. so when update send notification to all users assigned to.
    
	open projectMemberCursor;
    
    cursor_loop:repeat
	fetch projectMemberCursor into projectMember;
		if done then
			leave cursor_loop;
		end if;
	
		if NEW.commented_by != projectMember then 
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','PROJECT_FILE_COMMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,projectMember);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileCommentId',NEW.project_file_comment_id,notificationId);
							
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectFileId',NEW.project_file_id,notificationId);
							
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.commented_by,notificationId);
			
		end if;
	
    until done
    
    end repeat;
    
    close projectMemberCursor;
END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_task_add` AFTER INSERT ON `project_task` FOR EACH ROW BEGIN
	
    DECLARE notificationId BIGINT;
    declare taskAssignedTo int;
    declare done int default false;
        
    /*
    INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
	(verbiage, NEW.created_by,4, NOW(),NEW.project_id);
	*/
	
		INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
		VALUES('CREATE','TASK',NEW.project_id,NOW());
		
		SET notificationId = LAST_INSERT_ID();
		
		INSERT INTO user_notification(STATUS,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.created_by);
					
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('taskId',NEW.project_task_id,notificationId);
		
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('activityId',NEW.project_id,notificationId);
		
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
		
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('userId',NEW.created_by,notificationId);
						
END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `before_project_task` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `before_project_task` BEFORE UPDATE ON `project_task` FOR EACH ROW BEGIN
	
	INSERT INTO audit_project_task
        	SET audit_action='UPDATE',
            audit_datetime=NOW(),
            project_task_id=OLD.project_task_id,
            project_id = OLD.project_id,
            title = OLD.title,
            parent_task_id = OLD.parent_task_id,
            status = OLD.status,
            start_date = OLD.start_date,
            end_date = OLD.end_date,
            created_date = OLD.created_date,
            created_by = OLD.created_by,
            modified_date = OLD.modified_date,
            modified_by = OLD.modified_by,
            severity = OLD.severity,
            description = OLD.description,
            task_percentage = OLD.task_percentage;
      END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `after_project_task` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `after_project_task` AFTER UPDATE ON `project_task` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE updatedTaskPercentage INT;
	DECLARE insertId INT;
	declare taskAssignedTo bigint;
	declare done int default false;
	DECLARE taskUpdater varchar(30);
	declare taskCreator varchar(30);
	declare verbiage text;
	declare percentageVerbiage text;
	declare updatedTaskStatus int(1);
	declare taskStatusName varchar(10);
	declare taskAssigneeCursor cursor for select task_assignee from task_assignee where project_task_id=OLD.project_task_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	set taskCreator=get_userNameById(OLD.created_by);
	set taskUpdater=get_userNameById(NEW.modified_by);
	set verbiage=CONCAT(taskUpdater, " has made an update to ", OLD.title);
		
				
	SET updatedTaskPercentage = (SELECT task_percentage FROM  project_task WHERE project_task_id= NEW.project_task_id); 
	IF OLD.task_percentage != updatedTaskPercentage THEN 
			
			INSERT INTO audit_task_percentage_log
				SET audit_action='UPDATE',
				audit_datetime=NOW(),
				task_id=OLD.project_task_id,
				to_date = STR_TO_DATE('31/12/9999', '%d/%m/%Y'),
				created_date = NOW(),
				created_by = OLD.created_by,
				percentage_complete = updatedTaskPercentage;
				
			SET insertId = (SELECT task_percentage_log_id FROM audit_task_percentage_log ORDER BY 1 DESC LIMIT 1);
				
			UPDATE audit_task_percentage_log set to_date=now()  WHERE task_percentage_log_id != insertId and DATE_FORMAT(created_date,'%Y-%m') =DATE_FORMAT(NOW(),'%Y-%m') ;
			
			-- notificatioin and activity log for percentage change
			set percentageVerbiage=CONCAT(taskUpdater, " has changed progress(%) to ", OLD.title);
			
			INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
			(percentageVerbiage,NEW.modified_by,5, NOW(),OLD.project_id);
            
			-- send it to the assigner as well
    
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('UPDATE','TASK_PERCENTAGE',OLD.project_id,NOW());
		 
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,OLD.created_by);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.modified_by,notificationId);
	ELSE
		   
	 	 
	 
		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(verbiage,NEW.modified_by,5, NOW(),OLD.project_id);
            
    		-- send it to the assigner as well
    
    			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('UPDATE','TASK',OLD.project_id,NOW());
		 
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,OLD.created_by);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
							
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.modified_by,notificationId);
    
    
    -- multiple users assigned. so when update send notification to all users assigned to.
    
	open taskAssigneeCursor;
    
    cursor_loop:repeat
	fetch taskAssigneeCursor into taskAssignedTo;
		if done then
			leave cursor_loop;
		end if;
		
		IF taskCreator != taskAssignedTo THEN
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_ASSIGN',OLD.project_id,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskAssignedTo);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.modified_by,notificationId);
			
		END IF;
	
    until done
    
    end repeat;
    
    close taskAssigneeCursor;
    
    
    -- check to see if task status got changed
	 set updatedTaskStatus = (select status from project_task where project_task_id=NEW.project_task_id);
	 IF OLD.status != updatedTaskStatus THEN
	 	
	 	set taskStatusName=(select status_name from task_status where task_status_id=updatedTAskStatus);
	 	set verbiage = CONCAT(taskUpdater, " has changed the status of the task to ", taskStatusName);
	 	
	 	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(verbiage,NEW.modified_by,5, NOW(),OLD.project_id);
            
    -- send it to the assigner as well
    
    			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('UPDATE','TASK_STATUS',OLD.project_id,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,OLD.created_by);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('status',NEW.status,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.modified_by,notificationId);
    
    
    -- multiple users assigned. so when update send notification to all users assigned to.
    
	open taskAssigneeCursor;
    
    cursor_loop:repeat
	fetch taskAssigneeCursor into taskAssignedTo;
		if done then
			leave cursor_loop;
		end if;
		
		IF taskCreator != taskAssignedTo THEN
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_ASSIGN',OLD.project_id,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskAssignedTo);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',NEW.project_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',getProjectParentIdById(NEW.project_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.modified_by,notificationId);
			
		END IF;
	
    until done
    
    end repeat;
    
    close taskAssigneeCursor;
	
	  END IF;
END IF ;
END */$$


DELIMITER ;

/* Trigger structure for table `project_task_files` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_projectTaskFile_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_projectTaskFile_add` AFTER INSERT ON `project_task_files` FOR EACH ROW BEGIN
 
	DECLARE notificationId BIGINT;
	declare activityId BIGINT;
	declare taskAssignedTo bigint;
	declare done int default false;
	declare taskFileCreatorName varchar(30);
	declare taskCreator int(10);
	declare verbiage text;
	declare projectId int(10);
	declare taskAssigneeCursor cursor for select task_assignee from task_assignee where project_task_id=NEW.project_task_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	set taskFileCreatorName=get_userNameById(NEW.created_by);
	set taskCreator = (select created_by from project_task where project_task_id=NEW.project_task_id);
	set verbiage=CONCAT(taskFileCreatorName, " has made an attachment on ", getProjectTaskTitleById(NEW.project_task_id));
	set projectId=getProjectParentIdById(getActivityIdByTaskId(NEW.project_task_id));
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
	(verbiage,NEW.created_by,10, NOW(),project_id);
	
	 -- send it to the assigner as well
    
    			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_ATTACHMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskCreator);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',getActivityIdByTaskId(NEW.project_task_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.created_by,notificationId);
			
	
	-- multiple users assigned. so when update send notification to all users assigned to.
    
	open taskAssigneeCursor;
    
    cursor_loop:repeat
	fetch taskAssigneeCursor into taskAssignedTo;
		if done then
			leave cursor_loop;
		end if;
		
		IF taskCreator != taskAssignedTo THEN
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_ATTACHMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskAssignedTo);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.project_task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',getActivityIdByTaskId(NEW.project_task_id),notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.created_by,notificationId);
		
	End IF;
	
    until done
    
    end repeat;
    
    close taskAssigneeCursor;
          
END */$$


DELIMITER ;

/* Trigger structure for table `task_assignee` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `task_assignee_AFTER_INSERT` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `task_assignee_AFTER_INSERT` AFTER INSERT ON `task_assignee` FOR EACH ROW begin
	DECLARE notificationId BIGINT;
	declare projectId bigint;
	DECLARE assignerName varchar(30);
	DECLARE verbiage text;
    
	set projectId = (select project_id from project_task where project_task_id=NEW.project_task_id);
    
	set assignerName=get_userNameById(NEW.created_by);
    
	set verbiage=CONCAT(assignerName," has assigned ", getProjectTaskTitleById(NEW.project_task_id), " to ", get_userNameById(NEW.task_assignee));
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES (verbiage,NEW.created_by,4, NOW(),projectId);
    
	INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
	VALUES('CREATE','TASK_ASSIGN',project_id,NOW());
		
	SET notificationId = LAST_INSERT_ID();
	
	INSERT INTO user_notification(STATUS,notification_id,user_id)
	VALUES('NEW',notificationId,NEW.created_by);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('taskId',NEW.project_task_id,notificationId);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('activityId',projectId,notificationId);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('projectId',getProjectParentIdById(projectId),notificationId);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('userId',NEW.created_by,notificationId);
	
end */$$


DELIMITER ;

/* Trigger structure for table `task_comment` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_comment_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_comment_add` AFTER INSERT ON `task_comment` FOR EACH ROW BEGIN
 
	DECLARE notificationId BIGINT;
	declare activityId BIGINT;
	declare taskAssignedTo bigint;
	declare done int default false;
	declare commentedByName varchar(30);
	declare taskCreator int(10);
	declare verbiage text;
	declare projectId int(10);
	declare taskAssigneeCursor cursor for select task_assignee from task_assignee where project_task_id=NEW.task_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	set commentedByName=get_userNameById(NEW.commented_by);	
	set verbiage=CONCAT(commentedByName, " has commented on ", getProjectTaskTitleById(NEW.task_id));
	
	set taskCreator=(select created_by from project_task where project_task_id=NEW.task_id);
	set projectId=getProjectParentIdById(getActivityIdByTaskId(NEW.task_id));
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
	(verbiage,NEW.commented_by,1, NOW(),projectId);
	
	 -- send it to the assigner as well
    
    			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_COMMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskCreator);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',getActivityIdByTaskId(NEW.task_id),notificationId);
						
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.commented_by,notificationId);
		
	-- multiple users assigned. so when update send notification to all users assigned to.
    
	open taskAssigneeCursor;
    
    cursor_loop:repeat
	fetch taskAssigneeCursor into taskAssignedTo;
		if done then
			leave cursor_loop;
		end if;
	
		IF taskCreator != taskAssignedTo THEN
	
			INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
			VALUES('CREATE','TASK_COMMENT',projectId,NOW());
		
			SET notificationId = LAST_INSERT_ID();
			
			INSERT INTO user_notification(STATUS,notification_id,user_id)
			VALUES('NEW',notificationId,taskAssignedTo);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('taskId',NEW.task_id,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('activityId',getActivityIdByTaskId(NEW.task_id),notificationId);
						
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('projectId',projectId,notificationId);
			
			INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
			VALUES('userId',NEW.commented_by,notificationId);
		END IF;
	
    until done
    
    end repeat;
    
    close taskAssigneeCursor;
          
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
