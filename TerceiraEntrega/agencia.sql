create database agencia; 

show databases;

use  agencia;

create table cliente(
idcli int primary key auto_increment,
nome varchar(50) not null,
cpf varchar(15) not null,
email varchar(50)
);

drop table contatos;

show tables;

desc cliente;

select * from cliente;