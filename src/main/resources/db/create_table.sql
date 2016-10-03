DROP TABLE IF EXISTS AD;
DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS PERSONAD;


CREATE TABLE AD (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(30),
  url         TEXT,
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
