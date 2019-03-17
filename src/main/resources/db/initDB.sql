DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS persons;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE persons
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL
);

CREATE TABLE cars (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  person_id     INTEGER   NOT NULL,
  model         VARCHAR   NOT NULL,
  speed         INT       NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id) ON DELETE CASCADE
);

