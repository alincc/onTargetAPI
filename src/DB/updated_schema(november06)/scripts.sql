ALTER TABLE document_key_value
ADD COLUMN STATUS VARCHAR(10);

UPDATE document_key_value SET STATUS='ACTIVE';

ALTER TABLE document_grid_key_value
ADD COLUMN STATUS VARCHAR(10);

UPDATE document_grid_key_value SET STATUS='ACTIVE';

ALTER TABLE company_info
ADD COLUMN logo_path VARCHAR(255);

ALTER TABLE company_info
ADD COLUMN added_by INT(11);

ALTER TABLE company_info
ADD COLUMN added_date DATETIME;

ALTER TABLE company_info
ADD COLUMN modified_by INT(11);

ALTER TABLE company_info
ADD COLUMN modified_date DATETIME;

ALTER TABLE company_info
ADD FOREIGN KEY (added_by)
REFERENCES USER(user_id);

ALTER TABLE company_info
ADD FOREIGN KEY (modified_by)
REFERENCES USER(user_id);

ALTER TABLE registration_request
ADD COLUMN company_logo_path VARCHAR(255);