CREATE TABLE AD(
  id serial primary key,
  imageId serial,
  boundaryId INTEGER,
  clickCount INTEGER,
  impressions INTEGER,
  budget FLOAT,
  amountLeft FLOAT,
  country VARCHAR(10)
);

CREATE TABLE PERSON(
  id  serial primary key,
  age INTEGER,
  name VARCHAR(10),
  city VARCHAR(20)
);


CREATE TABLE BOUNDARY(
  id  serial primary key
);


CREATE TABLE ADBOUNDARY(
  id  serial primary key,
  adId  INTEGER,
  boundaryId  INTEGER
);


CREATE TABLE PERSONAD(
  id  serial primary key,
  adId  INTEGER,
  personId  INTEGER
);
