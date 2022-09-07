CREATE DATABASE IF NOT EXISTS rafamusic;
USE rafamusic;

CREATE TABLE categoria (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE musica (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  id_categoria int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);
