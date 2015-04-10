DELIMITER $$

USE `ontarget`$$

DROP FUNCTION IF EXISTS `get_userNameById`$$

CREATE DEFINER=`ontarget`@`localhost` FUNCTION `get_userNameById`(userId INT) RETURNS VARCHAR(100) CHARSET latin1
BEGIN
  DECLARE userName VARCHAR(100);
  SET userName = (SELECT user_name FROM USER WHERE user_id = userId);
  RETURN userName;
END$$

DELIMITER ;




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
