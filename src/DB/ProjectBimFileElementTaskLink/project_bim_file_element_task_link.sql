CREATE TABLE `project_bim_file_element_task_link` (
  `project_bim_file_element_task_link_id` BIGINT(20) NOT NULL COMMENT '',
  `project_bim_file_id` INT NOT NULL COMMENT '',
  `element_id` BIGINT(20) NOT NULL COMMENT '',
  `task_id` INT NOT NULL COMMENT '',
  `created_by` INT NOT NULL COMMENT '',
  `created_date` TIMESTAMP NOT NULL COMMENT '',
  `modified_by` INT NULL COMMENT '',
  `modified_date` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`project_bim_file_element_task_link_id`)  COMMENT '',
  INDEX `project_bim_file_element_link_fk_idx` (`project_bim_file_id` ASC)  COMMENT '',
  INDEX `task_id_element_link_id_fk_idx` (`task_id` ASC)  COMMENT '',
  INDEX `created_by_element_link_fk_idx` (`created_by` ASC)  COMMENT '',
  INDEX `modified_by_element_link_fk_idx` (`modified_by` ASC)  COMMENT '',
  CONSTRAINT `project_bim_file_element_link_fk`
  FOREIGN KEY (`project_bim_file_id`)
  REFERENCES `project_bim_file` (`project_bim_file_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `task_id_element_link_id_fk`
  FOREIGN KEY (`task_id`)
  REFERENCES `project_task` (`project_task_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `created_by_element_link_fk`
  FOREIGN KEY (`created_by`)
  REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `modified_by_element_link_fk`
  FOREIGN KEY (`modified_by`)
  REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


ALTER TABLE `project_bim_file_element_task_link`
ADD COLUMN `status` VARCHAR(10) NOT NULL COMMENT '' AFTER `modified_date`;

ALTER TABLE `ontargetbeta`.`project_bim_file_element_task_link`
CHANGE COLUMN `project_bim_file_element_task_link_id` `project_bim_file_element_task_link_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;


