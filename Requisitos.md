# Requisitos do Sistema Monan

**Autores:** Gabriel Lucas, Gabriel Vitor

## Requisitos Funcionais

### Login

- **Autenticação de Usuário:** O sistema deve permitir o login de usuários com base em suas credenciais (e-mail e senha).
  - Requisito Implementado: [ ] 

### Cadastro de Usuário

- **Cadastro de Usuário:** Permitir o cadastro de novos usuários, incluindo os seguintes tipos:
  - **Professor**
  - **Aluno**
  - **Gestor**
  - **Administrador**
  - Requisito Implementado: [ ] 

### Página Principal

- **Cadastro de Aula:** 
  - Permitir que um **Professor** cadastre uma aula, anexando materiais utilizados e o conteúdo da aula, semelhante a um post de blog.
  - Permitir que outros usuários pesquisem e visualizem as aulas cadastradas.
  - Requisito Implementado: [ ] 

- **Cadastro de Disciplinas e Usuários:**
  - **Gestor** deve cadastrar novas disciplinas.
  - **Gestor** deve associar um **Professor** a uma disciplina.
  - **Gestor** deve cadastrar **Alunos** em disciplinas.
  - Requisito Implementado: [ ] 

### Disciplina

- **Listagem de Usuários:** 
  - Exibir uma lista de usuários associados à disciplina (professores e alunos).
  - Requisito Implementado: [ ] 

- **Listagem de Aulas:**
  - Exibir todas as aulas cadastradas pelo professor responsável pela disciplina.
  - Requisito Implementado: [ ] 

- **Perguntas dos Alunos:**
  - Permitir que **Alunos** cadastrem dúvidas sobre a matéria.
  - Exibir as dúvidas na tela do **Professor** responsável.
  - Requisito Implementado: [ ] 

### Funcionalidades por Tipo de Usuário

- **Professor:**
  - Botão para acessar a tela de aulas cadastradas.
  - Botão para cadastrar novas aulas.
  - Exibir cards das disciplinas das quais o professor faz parte.
  - Permitir que o professor crie e compartilhe seus planos de aula com seus colegas.
  - Permitir que o professor consulte planos de aula criados por outros professores.
  - Requisito Implementado: [ ] 

- **Aluno:**
  - Exibir cards das disciplinas nas quais o aluno está matriculado.
  - Dentro de cada disciplina, permitir a visualização dos usuários da disciplina, aulas cadastradas e um botão para criar perguntas.
  - Requisito Implementado: [ ] 

- **Gestor:**
  - Botão para cadastrar novas disciplinas.
  - Botão para listar todos os usuários cadastrados.
  - Botão para cadastrar novos usuários.
  - Botão para listar todas as disciplinas.
  - Requisito Implementado: [ ] 

## Requisitos Não Funcionais

- **Performance:**
  - O sistema deve ser responsivo e oferecer tempos de resposta rápidos para operações de cadastro, login e consulta.
  - Requisito Implementado: [ ] 

- **Usabilidade:**
  - A interface deve ser intuitiva e de fácil navegação para todos os tipos de usuários (Professores, Alunos, Gestores e Administradores).
  - Requisito Implementado: [ ] 

- **Escalabilidade:**
  - O sistema deve ser projetado para suportar a adição de novos usuários e disciplinas sem degradação significativa do desempenho.
  - Requisito Implementado: [ ] 

- **Manutenabilidade:**
  - O código deve ser modular e bem documentado para facilitar a manutenção e futuras atualizações.
  - Requisito Implementado: [ ] 

- **Compatibilidade:**
  - O sistema deve ser compatível com os principais navegadores web e dispositivos móveis.
  - Requisito Implementado: [ ] 
