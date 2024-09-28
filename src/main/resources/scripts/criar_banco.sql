-- Script para criação do banco de dados
--
-- última atualização: 14/09/24


create table usuario(
	id 					serial 			primary key,
	nome 				varchar(500) 	not null,
	email				varchar(500)	not null,
	senha				varchar(128)	not null,
	tipo				varchar(2)		not null,
	data_criacao		timestamp,
	data_nascimento		timestamp	
);

create sequence seq_usuario
	start with 1
	increment by 10
;

-- usuario: email, senha: admin
insert into usuario (id, nome, email, senha, tipo)
	values (1, 'Admin', 'admin@admin.com', '$2a$10$z22sJceMuiU8oCyf42MABOUeqk1bKHzLHZ.FwRNq3/HWH2TDd6kGa', 'G')
;


create table disciplina(
	id 					serial 			primary key,
	nome 				varchar(500) 	not null,
	descricao			varchar(5000)
);

create sequence seq_disciplina
	start with 1
	increment by 10
;

create table nota(
	id 					serial 			primary key,
	valor 				integer		 	not null,
	dataLancamento		timestamp,		
	usuario_id			integer 		REFERENCES usuario(id),
    disciplina_id 		integer 		REFERENCES disciplina(id)	
	);
	
create sequence seq_nota
	start with 1
	increment by 1
;
