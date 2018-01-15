create database taskdb;

use taskdb;

CREATE TABLE user(
  id SERIAL,
  login_id varchar(255) UNIQUE NOT NULL,
  name varchar(255) NOT NULL,
  birth_date DATE NOT NULL,
  password varchar(255) NOT NULL,
  create_date DATETIME NOT NULL,
  update_date DATETIME NOT NULL
);

INSERT INTO user VALUES (
  1,'admin','管理者','1985/11/06/','password',now(),now()
);
