CREATE TABLE AD (
  id          SERIAL PRIMARY KEY,
  imageId     SERIAL,
  boundaryId  INTEGER,
  clickCount  INTEGER,
  impressions INTEGER,
  budget      FLOAT,
  amountLeft  FLOAT,
  country     VARCHAR(10)
);

CREATE TABLE PERSON (
  id   SERIAL PRIMARY KEY,
  age  INTEGER,
  name VARCHAR(10),
  city VARCHAR(20)
);


CREATE TABLE BOUNDARY (
  id SERIAL PRIMARY KEY
);


CREATE TABLE ADBOUNDARY (
  id         SERIAL PRIMARY KEY,
  adId       INTEGER,
  boundaryId INTEGER
);


CREATE TABLE PERSONAD (
  id       SERIAL PRIMARY KEY,
  adId     INTEGER,
  personId INTEGER
);
