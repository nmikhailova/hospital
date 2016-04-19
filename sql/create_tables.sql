CREATE TABLE person
(
id 		INT NOT NULL AUTO_INCREMENT,
familiya 	CHAR(32) NOT NULL,
imya 		CHAR(32) NOT NULL,
otchestvo 	CHAR(32) NOT NULL,
dateBorn 	INT,
adress 		VARCHAR(255) NOT NULL,
phone 		BIGINT(32),
PRIMARY KEY (id)
)
ENGINE=INNODB DEFAULT CHARACTER SET utf8;

insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('ivanov','ivan','ivanovich','1988','t.Vitebsk','654765');
insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('pupkov','andrey','ivanovich','1998','t.Vitebsk','6567589');
insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('itov','ian','petrovich','1973','t.Vitebsk','21331245');
insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('danov','ruslan','ivanovich','1978','t.Vitebsk','688835');
insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('viv','oleg','iurevich','1990','t.Vitebsk','3333765');
insert into person (familiya,imya,otchestvo,dateBorn,adress,phone) 
	values('yanov','vladislav','pavlovich','1970','t.Vitebsk','89753355');

CREATE TABLE users
(
id 		INT NOT NULL AUTO_INCREMENT,
person_id 	INT,
login 		CHAR(32) NOT NULL,
pass 		CHAR(32) NOT NULL,
rol 		INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (person_id) REFERENCES person(id)
ON UPDATE CASCADE
ON DELETE CASCADE
) 
ENGINE=INNODB DEFAULT CHARACTER SET utf8;

insert into users (login,pass, person_id,rol) values('doctor','E10ADC3949BA59ABBE56E057F20F883E', 1,1);
insert into users (login,pass, person_id,rol) values('medsister','C33367701511B4F6020EC61DED352059', 2,2);
insert into users (login,pass, person_id,rol) values('DOCTOR','C33367701511B4F6020EC61DED352059', 4,1);


CREATE TABLE appointment
(
id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
status 		BOOLEAN NOT NULL,
type 		CHAR(32) NOT NULL,
kart_id 	INT NOT NULL,
opisanie 	VARCHAR(255) 
)
ENGINE=INNODB DEFAULT CHARACTER SET utf8;

insert into appointment (kart_id,status,type,opisanie) values('2','1','remedy','analgin');
insert into appointment (kart_id,status,type,opisanie) values('8','0','procedure','in monday');
insert into appointment (kart_id,status,type,opisanie) values('4','0','operations','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('1','0','remedy','ugol');
insert into appointment (kart_id,status,type,opisanie) values('3','0','operations','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('5','0','remedy','aciklovir');
insert into appointment (kart_id,status,type,opisanie) values('4','0','procedure','in monday');
insert into appointment (kart_id,status,type,opisanie) values('7','0','operations','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('3','0','remedy','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('6','0','operations','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('4','0','operations','tomorrow');
insert into appointment (kart_id,status,type,opisanie) values('1','0','remedy','analgin');
insert into appointment (kart_id,status,type,opisanie) values('2','0','procedure','every day');
insert into appointment (kart_id,status,type,opisanie) values('4','0','operations','tomorrow');


CREATE TABLE diagnoz
(
id 		INT NOT NULL AUTO_INCREMENT,
ishodniy 	CHAR(32) NOT NULL,
id_doctor 	INT,
oconchatelniy 	CHAR(32),
id_doctor2 	INT,
PRIMARY KEY (id)
)
ENGINE=INNODB DEFAULT CHARACTER SET utf8;

insert into diagnoz (ishodniy,id_doctor) values('yazva','2');
insert into diagnoz (ishodniy,id_doctor,oconchatelniy,id_doctor2) values('perelom','1','zdorov','1');
insert into diagnoz (ishodniy,id_doctor,oconchatelniy,id_doctor2) values('gepatit A', '1','gepetit B','1');
insert into diagnoz (ishodniy,id_doctor) values('Îðâè','3');
insert into diagnoz (ishodniy,id_doctor) values('Ãðèïï','3');

CREATE TABLE kartochka
(
id 		INT NOT NULL auto_increment primary key,
person_id 	INT NOT NULL,
diagnoz_id 	INT,
vypiska BOOLEAN default false,
FOREIGN KEY (diagnoz_id) REFERENCES diagnoz(id)
ON UPDATE CASCADE
ON DELETE restrict
)
ENGINE=INNODB DEFAULT CHARACTER SET utf8;

insert into kartochka (person_id,diagnoz_id) values('1','1');
insert into kartochka (person_id,diagnoz_id) values('3','1');
insert into kartochka (person_id,diagnoz_id) values('5','2');
insert into kartochka (person_id,diagnoz_id) values('2','1');
insert into kartochka (person_id,diagnoz_id) values('6','1');
insert into kartochka (person_id,diagnoz_id) values('4','2');










