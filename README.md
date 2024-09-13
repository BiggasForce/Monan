# Monan

Monan é um sistema educacional desenvolvido para auxiliar educadores, coordenadores e alunos em suas tarefas diárias. Nosso principal objetivo é promover uma educação com acessibilidade e livre para todos.

## Tecnologias utilizadas
- Java SE+11
- Angular v17+
- PostgreSQL
- Springboot 3.3.3+

## Funcionalidades

- ***Controle e Gerenciamento de Notas:*** Permite o acompanhamento e a gestão das notas escolares de forma eficiente.
  
- ***Consulta de Alunos e Pais:*** Disponibiliza acesso às notas e datas das atividades propostas, alem de todo o conteúdo da matéria. Facilitando a comunicação e acompanhamento por parte dos pais e responsáveis.
  
- ***Compartilhamento de Planos de Aula:*** Professores podem compartilhar seus planos de aula com outros colegas.
  
- ***Consultar Planos de Aula:*** Consulta de Planos de Aula: Professores podem acessar e visualizar planos de aula compartilhados por outros educadores, utilizando filtros para buscar planos específicos por tipo de aula, assunto e nível de ensino. A funcionalidade permite a visualização de detalhes dos planos, acesso a recursos compartilhados e a adoção de boas práticas pedagógicas.

## Estrutura do Banco de Dados

### Tabelas

- **Usuários** (`users`)
  - `id` (PK)
  - `nome`
  - `email`
  - `senha`
  - `tipo`
  - `data_criacao`

- **Alunos** (`students`)
  - `id` (PK, FK: `users.id`)
  - `data_nascimento`
  - `turma`
  - `responsavel`

- **Professores** (`teachers`)
  - `id` (PK, FK: `users.id`)
  - `departamento`

- **Notas** (`grades`)
  - `id` (PK)
  - `id_aluno` (FK: `students.id`)
  - `id_disciplina` (FK: `subjects.id`)
  - `nota`
  - `data`
  - `descricao`

- **Disciplinas** (`subjects`)
  - `id` (PK)
  - `nome`
  - `descricao`

- **Atividades** (`activities`)
  - `id` (PK)
  - `id_disciplina` (FK: `subjects.id`)
  - `nome`
  - `data_entrega`
  - `descricao`

- **Planos de Aula** (`lesson_plans`)
  - `id` (PK)
  - `id_professor` (FK: `teachers.id`)
  - `id_disciplina` (FK: `subjects.id`)
  - `data_criacao`
  - `descricao`

- **Planos de Aula Compartilhados** (`shared_lesson_plans`)
  - `id` (PK)
  - `id_plano` (FK: `lesson_plans.id`)
  - `id_professor_destino` (FK: `teachers.id`)
  - `data_compartilhamento`

### Relacionamentos

- **Usuários** pode ser um aluno, professor ou coordenador.
- **Alunos** e **Professores** são tipos específicos de usuários.
- **Notas** está associada a um aluno e a uma disciplina.
- **Atividades** estão associadas a uma disciplina.
- **Planos de Aula** são criados por professores e podem ser compartilhados com outros professores.

## Desenvolvedores
- Gabriel Lucas
  - LinkedIn - https://www.linkedin.com/in/gabriel-lucas-b52620201/
- Gabriel Vitor

