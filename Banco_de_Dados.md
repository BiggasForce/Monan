## Estrutura do Banco de Dados

A estrutura do banco de dados para o sistema Monan é composta pelas seguintes tabelas e relacionamentos:

### Tabelas

- **Usuários** (`users`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `nome` (VARCHAR, Not Null)
  - `email` (VARCHAR, Unique, Not Null)
  - `senha` (VARCHAR, Not Null)
  - `tipo` (ENUM: 'aluno', 'professor', 'coordenador', Not Null)
  - `data_criacao` (TIMESTAMP, Default: CURRENT_TIMESTAMP)

- **Alunos** (`students`)
  - `id` (INTEGER, Primary Key, Foreign Key: `users.id`)
  - `data_nascimento` (DATE, Not Null)
  - `turma` (VARCHAR, Not Null)
  - `responsavel` (VARCHAR, Not Null)

- **Professores** (`teachers`)
  - `id` (INTEGER, Primary Key, Foreign Key: `users.id`)
  - `departamento` (VARCHAR, Not Null)

- **Notas** (`grades`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `id_aluno` (INTEGER, Foreign Key: `students.id`, Not Null)
  - `id_disciplina` (INTEGER, Foreign Key: `subjects.id`, Not Null)
  - `nota` (DECIMAL, Not Null)
  - `data` (DATE, Not Null)
  - `descricao` (TEXT)

- **Disciplinas** (`subjects`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `nome` (VARCHAR, Not Null)
  - `descricao` (TEXT)

- **Atividades** (`activities`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `id_disciplina` (INTEGER, Foreign Key: `subjects.id`, Not Null)
  - `nome` (VARCHAR, Not Null)
  - `data_entrega` (DATE, Not Null)
  - `descricao` (TEXT)

- **Planos de Aula** (`lesson_plans`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `id_professor` (INTEGER, Foreign Key: `teachers.id`, Not Null)
  - `id_disciplina` (INTEGER, Foreign Key: `subjects.id`, Not Null)
  - `data_criacao` (TIMESTAMP, Default: CURRENT_TIMESTAMP)
  - `descricao` (TEXT)

- **Planos de Aula Compartilhados** (`shared_lesson_plans`)
  - `id` (INTEGER, Primary Key, Auto Increment)
  - `id_plano` (INTEGER, Foreign Key: `lesson_plans.id`, Not Null)
  - `id_professor_destino` (INTEGER, Foreign Key: `teachers.id`, Not Null)
  - `data_compartilhamento` (TIMESTAMP, Default: CURRENT_TIMESTAMP)

### Relacionamentos

- **Usuários** pode ser um aluno, professor ou coordenador.
- **Alunos** e **Professores** são tipos específicos de usuários, com informações adicionais.
- **Notas** está associada a um aluno e a uma disciplina.
- **Atividades** estão associadas a uma disciplina.
- **Planos de Aula** são criados por professores e podem ser compartilhados com outros professores.
