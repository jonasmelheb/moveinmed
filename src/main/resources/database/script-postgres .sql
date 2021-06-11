DROP TABLE IF EXISTS professional;

CREATE TABLE professional(
  id_professional INT GENERATED ALWAYS AS IDENTITY,
  first_name      VARCHAR (150) NOT NULL ,
  last_name       VARCHAR (150) NOT NULL ,
  email           VARCHAR (150) NOT NULL ,
  phone_number    VARCHAR (14) NOT NULL ,
  address         VARCHAR (255) NOT NULL ,
  profession      VARCHAR (150) NOT NULL
);

