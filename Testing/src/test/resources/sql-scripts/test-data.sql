DROP TABLE IF EXISTS movies;

CREATE TABLE IF NOT EXISTS movies (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  minutes INT NOT NULL,
  genre VARCHAR(50) NOT NULL
);



INSERT INTO movies(id, name, minutes, genre) values(1, 'Dark Knight', 152, 'ACTION');
INSERT INTO movies(id, name, minutes, genre) values(2, 'Memento', 113, 'THRILLER');
INSERT INTO movies(id, name, minutes, genre) values(3, 'There s Something About Mary', 119, 'COMEDY');