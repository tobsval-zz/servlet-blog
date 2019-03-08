/* DROP TABLE USERS; */

CREATE TABLE USERS (
  username VARCHAR(30),
  password VARCHAR(255),
  salt VARCHAR(30),
  admin_flag BOOLEAN,
  post_amount INT,
  last_post_tstamp VARCHAR(16) /* Note: Timestamp follows format: DD/MM/YYYY HH:MM */

);

INSERT INTO USERS (USERNAME, PASSWORD, SALT, ADMIN_FLAG, POST_AMOUNT, LAST_POST_TSTAMP) VALUES
('admin', 'T25KNu0uxb+Hgb2ngVRpqtOzCLo=', 'asD1k6AeoqNmSjr618bk', FALSE, 0, NULL); /* password: password */

SELECT * FROM USERS;
