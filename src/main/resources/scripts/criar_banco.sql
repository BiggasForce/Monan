-- Script para criação do banco de dados
--
-- última atualização: 20/09/24


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

create table disciplina(
	id 					serial 			primary key,
	nome 				varchar(500) 	not null,
	descricao			varchar(5000)
);

create sequence seq_disciplina
	start with 1
	increment by 10
;

-- 28/09
--create table tarefa(
--	id 					serial 			primary key,
--	nome 				varchar(500) 	not null,
--	descricao			varchar(5000)
--	dataInicio			timestamp,
--	dataTermino			timestamp,	
--	disciplina_id		integer			references disciplina(id)	
--    tarefa_id 			integer 		references tarefa(id)	
--	);
--	
--create sequence seq_tarefa
--	start with 1
--	increment by 1
--;

create table nota(
	id 					serial 			primary key,
	valor 				numeric(2,3)	not null,
	dataLancamento		timestamp,		
	usuario_id			integer 		REFERENCES usuario(id),
    atividade_id 		integer 		REFERENCES atividade(id)	
);
	
create sequence seq_nota
	start with 1
	increment by 1
;


create table atividade (
	id 					serial 			primary key,
	nome 				varchar(500)	not null,
	descricao			varchar(5000),
	dataLancamento		timestamp,		
	nota_id				integer			REFERENCES nota(id),
    disciplina_id 		integer 		REFERENCES disciplina(id)	
);
	
create sequence seq_atividade
	start with 1
	increment by 1
;


create table planoAula (
	id 					serial 			primary key,
	titulo 				varchar(500)	not null,
	descricao			varchar(5000),
	dataCriacao			timestamp,		
    disciplina_id 		integer 		REFERENCES disciplina(id)	
);
	
create sequence seq_planoAula
	start with 1
	increment by 1
;

