DELIMITER $$
CREATE TRIGGER log_comment AFTER INSERT ON project_task_comments
FOR EACH ROW BEGIN
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("Comment ", NEW.comment , " added on task ", NEW.project_task_id, " by ", NEW.comment_by), NEW.comment_by, 1);
INSERT INTO activity_log (text, category) VALUES (CONCAT("Comment ", NEW.comment , " added on task ", NEW.project_task_id, " by ", NEW.comment_by), 1);
END$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER log_project_add AFTER INSERT ON project
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), 2);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), NEW.project_owner_id, 1);
END$$
DELIMITER ;





