1) function to get username by user id


DELIMITER $$

USE `ontarget_phase4`$$

DROP FUNCTION IF EXISTS `get_userNameById`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `get_userNameById`(userId INT) RETURNS VARCHAR(100) CHARSET latin1
BEGIN
  DECLARE userName VARCHAR(100);
  SET userName = (SELECT user_name FROM USER WHERE user_id = userId);
  RETURN userName;
END$$

DELIMITER ;



2) trigger for add project

DELIMITER $$

USE `ontarget_phase4`$$

DROP TRIGGER /*!50032 IF EXISTS */ `project_AFTER_INSERT`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `project_AFTER_INSERT` AFTER INSERT ON `project` 
    FOR EACH ROW BEGIN
DECLARE ppId BIGINT;
   SELECT project_parent_id INTO ppId FROM  project WHERE project_id= NEW.project_id;    INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
     (CONCAT("New Activity ", NEW.project_name, " added by ", get_userNameById(NEW.project_owner_id)),
      New.created_by,2, NOW(),ppId);
END;
$$

DELIMITER ;



3) trigger for update project

DELIMITER $$

USE `ontarget_phase4`$$

DROP TRIGGER /*!50032 IF EXISTS */ `project_AFTER_UPDATE`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `project_AFTER_UPDATE` AFTER UPDATE ON `project` 
    FOR EACH ROW BEGIN
DECLARE ppId BIGINT;
SELECT project_parent_id INTO ppId FROM  project WHERE project_id= OLD.project_id;INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
 (CONCAT("Activity ", NEW.project_name, " updated by ", get_userNameById(NEW.project_owner_id)),
  New.created_by,2, NOW(),ppId);
  END;
$$

DELIMITER ;



4) get project task title by id function

DELIMITER $$

USE `ontarget`$$

DROP FUNCTION IF EXISTS `getProjectTaskTtitleById`$$

CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectTaskTtitleById`(projectTaskId INT) RETURNS VARCHAR(100) CHARSET latin1
BEGIN
  DECLARE projectTaskTtitle VARCHAR(100);
  SET projectTaskTtitle = (SELECT title FROM project_task WHERE project_task_id = projectTaskId);
  RETURN projectTaskTtitle;
END$$

DELIMITER ;


5) get activity name by id function

DELIMITER $$

USE `ontarget`$$

DROP FUNCTION IF EXISTS `getActivityNameById`$$

CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getActivityNameById`(projectId INT) RETURNS VARCHAR(100) CHARSET latin1
BEGIN
  DECLARE activityName VARCHAR(100);
  SET activityName = (SELECT project_name FROM project WHERE project_id = projectId);
  RETURN activityName;
END$$

DELIMITER ;
