CREATE TABLE AD(
  id  INTEGER,
  boundaryId INTEGER,
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
