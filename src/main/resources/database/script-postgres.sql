DROP TABLE IF EXISTS professional;

CREATE TABLE professional
(
    id_professional INT GENERATED ALWAYS AS IDENTITY,
    first_name      VARCHAR(150) NOT NULL,
    last_name       VARCHAR(150) NOT NULL,
    email           VARCHAR(150) NOT NULL,
    phone_number    VARCHAR(14)  NOT NULL,
    address         VARCHAR(255) NOT NULL,
    profession      VARCHAR(150) NOT NULL
);

INSERT INTO professional
    (first_name, last_name, email, phone_number, address, profession)
VALUES ('test', 'test', 'email@email.fr', '01245697', 'adresse', 'Chirurgien'),
       ('test2', 'test2', 'email2@email.fr', '01245697', 'adresse2', 'Assistance social'),
       ('test3', 'test3', 'email2@email.fr', '01245697', 'adresse3', 'Chirurgien');


