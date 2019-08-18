DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id       INT NOT NULL,
  username VARCHAR(50),
  password VARCHAR(50),
  sex      INT,
  age      INT,
  PRIMARY KEY (id)
)
