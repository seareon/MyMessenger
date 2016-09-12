DROP database IF EXISTS users_db;

CREATE database users_db DEFAULT CHARACTER SET utf8;

use users_db;

DROP TABLE IF EXISTS users_db.profile;

CREATE TABLE users_db.profile (
  id serial PRIMARY KEY,
  user_id INT references users(id) ON UPDATE CASCADE ON DELETE CASCADE,
  firstName VARCHAR(45),
  lastName VARCHAR(45),
  age VARCHAR(45),
  gender VARCHAR(45),
  city VARCHAR(45),
  country VARCHAR(45)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS users_db.messages;

CREATE TABLE users_db.messages (
	id serial PRIMARY KEY,
	profile_id INT references profile(id) ON UPDATE CASCADE ON DELETE CASCADE,
	message VARCHAR(255) NOT NULL,
	date date
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS users_db.users;

CREATE TABLE users_db.users (
  id serial PRIMARY KEY,
  login VARCHAR(20) NOT NULL UNIQUE,
  password VARCHAR(8) NOT NULL,
  email VARCHAR(45) NOT NULL
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

INSERT INTO users_db.messages (message, profile_id, date) VALUES
	('Message one', 2, '2009-06-04 13:58:00'),
	('Message two', 1, '2010-10-08 08:54:00');

INSERT INTO users_db.users (login, password, email) VALUES 
	('mishka_@1', '123321qq', 'bla@mail.ru'),
	('vadim_@2', '234432qq', 'blabla@mail.ru'),
	('vlad_@3', '345543qq', 'blabla@mail.ru'),
	('mikhail_@4', '456654qq', 'blablablabla@mail.ru');
	
INSERT INTO users_db.profile (user_id, firstName, lastName, age, gender, city, country) VALUES
	(1, 'Mishka', 'Ro', '', '', 'Minsk', ''),
	(3, 'Vlad', 'Tretiak', '', '', 'Minsk', ''),
	(2, 'Vadim', 'Jeimov', '', '', 'Minsk', ''),
	(4, 'Mikhail', 'Shturo', '', '', '', '');