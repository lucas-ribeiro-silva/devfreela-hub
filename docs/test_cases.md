# Casos de Teste - Módulo de Usuários

## Funcionalidade: Cadastro de Usuário

**CT01 - Cadastro de Usuário com Sucesso**
* **Dado** que o usuário informa um nome, um email e uma senha válidos.
* **Quando** ele solicita o cadastro.
* **Então** um novo usuário deve ser criado no sistema com os dados informados.

**CT02 - Tentativa de Cadastro com Nome em Branco**
* **Dado** que o usuário informa email e senha, mas deixa o nome em branco.
* **Quando** ele solicita o cadastro.
* **Então** o sistema deve retornar uma mensagem de erro "Nome é obrigatório".

**CT03 - Tentativa de Cadastro com Email em Branco**
* **Dado** que o usuário informa nome e senha, mas deixa o email em branco.
* **Quando** ele solicita o cadastro.
* **Então** o sistema deve retornar uma mensagem de erro "Email é obrigatório".