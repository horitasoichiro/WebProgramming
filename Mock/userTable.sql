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
  1,'admin','管理者','1985/11/06/','5F4DCC3B5AA765D61D8327DEB882CF99',now(),now()
);

-- test
INSERT INTO user (login_id ,name ,birth_date, password ,create_date, update_date)VALUES(
  'satoo','佐藤花子','1990/10/05/','password',now(),now()
);

SELECT* FROM user where login_id = 'taro' OR password = null OR birth_date >= '' OR birth_date <= null and id <> 1;

SELECT* FROM user where login_id = 'taro' OR password = '' OR birth_date >= null OR birth_date <= null;

SELECT* FROM user where login_id = 'taro' and password = null and birth_date >= '' and birth_date <= null and id <> 1;

UPDATE user SET password = '5F4DCC3B5AA765D61D8327DEB882CF99' WHERE id = '1'

SELECT * FROM user WHERE  name LIKE '%田%' AND

INSERT INTO t_user ( id,name, address, login_id, login_password, create_date )VALUES (
  1,'管理者','tokyo','admin','password',now()
);
