DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id       INT NOT NULL,
  username VARCHAR(50),
  password VARCHAR(50),
  sex      INT(1),
  age      INT(2),
  create_date timestamp ,
  create_user int,
  is_delete int(1) default 0,
  PRIMARY KEY (id)
)
