--ALTER TABLE person drop CONSTRAINT IF  EXISTS fk_person_passport;
--ALTER TABLE passport drop CONSTRAINT IF  EXISTS fk_passport_person;

CREATE TABLE if not exists person (
                         id int NOT NULL AUTO_INCREMENT,
                         first_name varchar(45) NOT NULL,
                         last_name varchar(64) NOT NULL,
                         passport_id int DEFAULT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE if not exists  passport (
                         id int NOT NULL AUTO_INCREMENT,
                         number varchar(45) NOT NULL,
                         country varchar(3) NOT NULL,
                         person_id int DEFAULT NULL,
                         PRIMARY KEY (id)
);

--ALTER TABLE person ADD CONSTRAINT IF NOT EXISTS fk_person_passport FOREIGN KEY (passport_id) REFERENCES passport (id);
--ALTER TABLE passport ADD CONSTRAINT IF NOT EXISTS fk_passport_person FOREIGN KEY (person_id) REFERENCES person (id);
