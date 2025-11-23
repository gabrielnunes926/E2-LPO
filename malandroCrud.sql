CREATE DATABASE malandro_crud;
USE malandro_crud;

CREATE TABLE malandro(
cpf VARCHAR(50)  PRIMARY KEY,
estilo VARCHAR(100) NOT NULL,
penteado VARCHAR(100),
telefone VARCHAR(50)
);