DROP TABLE IF EXISTS AD;
DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS PERSONAD;


CREATE TABLE AD (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(30),
  videourl    TEXT,
  clickurl    TEXT,
  type        VARCHAR(10),
  imageId     SERIAL,
  clickCount  INTEGER DEFAULT 0,
  impressions INTEGER DEFAULT 0,
  budget      FLOAT,
  amountLeft  FLOAT,
  country     VARCHAR(10),
  fence       POLYGON
);

CREATE TABLE PERSON (
  id   SERIAL PRIMARY KEY,
  age  INTEGER,
  name VARCHAR(30),
  city VARCHAR(30)
);


CREATE TABLE PERSONAD (
  id       SERIAL PRIMARY KEY,
  adId     INTEGER,
  personId INTEGER
);


INSERT INTO ad VALUES (1, 'Made in India', '', 'video', 1, 0, 9, 10000, 9991, 'USA', '((0,0),(0,10),(10,10),(0,0))');
INSERT INTO ad VALUES (3, 'Harry Potter', '', 'video', 3, 0, 6, 10000, 9994, 'USA', '((0,0),(0,10),(10,10),(0,0))');
INSERT INTO ad VALUES (2, 'Swades', '', 'video', 2, 0, 7, 10000, 9993, 'USA', '((0,0),(0,10),(10,10),(0,0))');
INSERT INTO ad
VALUES (4, 'Secret Life of Pets', '', 'video', 4, 0, 6, 10000, 9994, 'USA', '((0,0),(0,10),(10,10),(0,0))');

INSERT INTO person VALUES (1, 21, 'Karanjeet Singh Sarna', 'USA');
INSERT INTO person VALUES (2, 25, 'Abhishek Patro', 'USA');
INSERT INTO person VALUES (3, 24, 'Shiven Saiwal', 'USA');


INSERT INTO personad VALUES (1, 1, 1);
INSERT INTO personad VALUES (2, 2, 1);
INSERT INTO personad VALUES (3, 3, 2);
INSERT INTO personad VALUES (4, 4, 2);

