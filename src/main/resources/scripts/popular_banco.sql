
-- usuario gestor (senha: admin)
insert into usuario (id, nome, email, senha, tipo)
	values (1, 'Admin', 'admin@admin.com', '$2a$10$z22sJceMuiU8oCyf42MABOUeqk1bKHzLHZ.FwRNq3/HWH2TDd6kGa', 'G')
;

-- usuario aluno (senha: aluno123)
insert into usuario (id, nome, email, senha, tipo)
	values (8, 'Aluno Legal', 'aluno@teste.com', '$2a$10$htqljwlO3OC9AB7AePAUvODfIeZcpsjLpp46DYs9PM74PgmgHRxfK', 'A')
;



--
-- Disciplinas
insert into disciplina (id, nome, descricao)
	values (2, 'Português', 'Disciplina de Português lecionada pela professora Antoniela.')
;
insert into disciplina (id, nome, descricao)
	values (4, 'Matemática', 'Disciplina de Matemática lecionada pelo professor Carlos.')
;
insert into disciplina (id, nome, descricao)
	values (6, 'Física', 'Disciplina de Físcia lecionada pelo professor João.')
;
insert into disciplina (id, nome, descricao)
	values (8, 'Filosofia', 'Disciplina de Filosofia lecionada pelo professor Jorge.')
;

--
-- Atividade
insert into atividade (id, nome, descricao, dataLancamento, disciplina_id)
	values (8, 'Lista de exercicios', 'Responder todas as perguntas da lista', '2024-09-28', '2')
;
insert into atividade (id, nome, descricao, dataLancamento, disciplina_id)
	values (8, 'Seminário II', 'Apresentação em sala de aula', '2024-09-28', '8')
;

--
-- Planos Aula
insert into plano_aula (id, data_criacao, titulo, descricao, disciplina_id)
	values (10, '2024-09-27', 'Funções Logarítimicas', 'Funções logarítmicas são o inverso das funções exponenciais, utilizadas para resolver equações onde a variável está no expoente.',  4)
;
insert into plano_aula (id, data_criacao, titulo, descricao, disciplina_id)
	values (12, '2024-09-27', 'Conjuntos', 'Conjuntos são uma estrutura fundamental em matemática, representando uma coleção de elementos distintos e bem definidos.',  4)
;
insert into plano_aula (id, data_criacao, titulo, descricao, disciplina_id)
	values (14, '2024-09-27', 'Mecânica', 'A mecânica é uma área fundamental da física que estuda o movimento dos corpos e as forças que o afetam. Ela se divide em três principais ramos: mecânica clássica, mecânica relativística e mecânica quântica.',  6)
;

insert into plano_aula (id, data_criacao, titulo, descricao, disciplina_id)
	values (15, '2024-09-28', 'A política segundo Sócrates', 'A mecânica é uma área fundamental da física que estuda o movimento dos corpos e as forças que o afetam. Ela se divide em três principais ramos: mecânica clássica, mecânica relativística e mecânica quântica.',  8)
;

--
-- Disciplinas e usuarios
insert into usuario_disciplina (usuario_id, disciplina_id)
	values (8, 2)
;
insert into usuario_disciplina (usuario_id, disciplina_id)
	values (8, 4)
;
insert into usuario_disciplina (usuario_id, disciplina_id)
	values (8, 6)
;
insert into usuario_disciplina (usuario_id, disciplina_id)
	values (8, 8)
;
