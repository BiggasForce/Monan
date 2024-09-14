-- Script para criação do banco de dados
--
-- última atualização: 13/09/24


create table usuario(
	id 					serial 			primary key,
	nome 				varchar(500) 	not null,
	email				varchar(500)	not null,
	senha				varchar(128)	not null,
	tipo				varchar(2)		not null,
	dataCriacao			timestamp 		default CURRENT_TIMESTAMP,
	dataNascimento		timestamp 		default CURRENT_TIMESTAMP
);

insert into usuario (id, nome, email, senha, tipo)
	values (1, 'Admin', 'admin@admin.com', 'admin', 'G')
;
