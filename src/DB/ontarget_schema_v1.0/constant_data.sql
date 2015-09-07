/*Data for the table `application_menu` */

insert  into `application_menu`(`application_menu_id`,`active`,`menu_key`,`menu_name`) values
  (1,'Y','DASHBOARD','Dashboard'),
  (2,'Y','ONTIME','onTime'),
  (3,'Y','ONSITE','onSITE'),
  (4,'Y','ONFILE','onFILE'),
  (5,'Y','ONTARGET','onTARGET'),
  (6,'Y','ONCONTACT','onCONTACT'),
  (7,'Y','ONREPORT','onREPORT');

/*Table structure for table `application_permission` */


/*Data for the table `application_permission` */

insert  into `application_permission`(`application_permission_id`,`active`,`permission_key`,`permission_name`) values
  (1,'Y','VIEW_DASHBOARD','View Dashboard'),
  (2,'Y','VIEW_ONTIME','View OnTime'),
  (3,'Y','EDIT_ONTIME','Edit OnTime'),
  (4,'Y','ADD_TASK_COMMENT','Add Task Comment'),
  (5,'Y','VIEW_ONSITE','View OnSite'),
  (6,'Y','ONSITE_UPLOAD','OnSite Upload'),
  (7,'Y','ONFILE_FULL_ACCESS','OnFile Full Access');

/*Table structure for table `audit_project_task` */


/*Data for the table `company_type` */

insert  into `company_type`(`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`status`) values
  (1,'GENERAL CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (2,'CONSTRUCTION MANAGER',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (3,'SUB CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (4,'OWNER',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (5,'SPECIALITY CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (6,'ARCHITECT/ENGINEERS',now(),'SYSTEM',now(),'SYSTEM','ACTIVE');

/*Table structure for table `contact` */



/*Data for the table `discipline` */

insert  into `discipline`(`id`,`name`,`info`,`ts_insert`) values
  (1,'masonry','Masonry',now()),
  (2,'plumbing','Plumbing',now()),
  (3,'electrical','Electrical',now()),
  (4,'mechanical','Mechanical',now()),
  (5,'Interiors','Interiors',now()),
  (6,'landscaping','Landscaping',now()),
  (7,'bridges','Bridges',now()),
  (8,'tunnels','Tunnels',now()),
  (9,'design','Design',now());

/*Table structure for table `document` */



/*Data for the table `project_type` */

insert  into `project_type`(`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`status`) values
  (1,'COMMERCIAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (2,'RESIDENTIAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (3,'INFRASTRUCTURE',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (4,'MEDICAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE');

/*Data for the table `task_priority` */

insert  into `task_priority`(`task_priority_id`,`priority`,`code`) values (1,'Critical','CRITICAL'),(2,'High','HIGH'),(3,'Low','LOW');


/*Data for the table `user_type` */

insert  into `user_type`(`user_type_id`,`user_type`,`user_type_desc`,`created_date`,`created_by`,`modified_date`,`modified_by`,`is_expired`) values
  (1,'USER','Regular user',now(),'SYSTEM',now(),'SYSTEM','0'),
  (2,'PROJECT_MANAGER','Project Manager',now(),'SYSTEM',now(),'SYSTEM','0'),
  (3,'SUPER_USER',now(),'Super Admin User','SYSTEM',now(),'SYSTEM','0');


insert  into `project_file_category`(`project_file_category_id`,`active`,`name`) values (1,'Y','Drawing'),(2,'Y','Painting'),(3,'Y','Furnishing');












